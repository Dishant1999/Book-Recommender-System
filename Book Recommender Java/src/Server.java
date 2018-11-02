import java.sql.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.sql.PreparedStatement;
import java.util.Arrays;

import org.rosuda.REngine.Rserve.RConnection;

import com.ibm.icu.text.MessageFormat;

public class Server {
	
	Connection con = null;
	PreparedStatement pst = null;
	ServerSocket ss = null;
	int userId;
	int user;
	boolean verify;
	
	public static void main(String[] args) {
		Server s = new Server();
		s.connectToDatabase();
		s.validate(); // verify user
	}
	public Server() {
		try {
			ss = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void connectToDatabase() {
		
		String username ="root";
		String password ="2309";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/recommender",username,password);
			System.out.println("Connection Established");
			Statement smt = null;
			smt = con.createStatement();
			String createTableBooks = "CREATE TABLE IF NOT EXISTS books(bookID INT NOT NULL,title VARCHAR(100),authors VARCHAR(300),ratings DECIMAL(3,2),imageURL VARCHAR(500),PRIMARY KEY(bookID))";
			smt.execute(createTableBooks);
			String createTableUsers = "CREATE TABLE IF NOT EXISTS users(userID INT NOT NULL,frequency INT,auth_key VARCHAR(20) NOT NULL,PRIMARY KEY(userID))";
			smt.execute(createTableUsers);			
			System.out.println("Tables Created");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public Socket connectToCLient() { // opens socket for communication
		
		Socket s = null;
		try {
			System.out.println("Server is Starting");
			s = ss.accept();
			System.out.println("Server ready to accept connection");
			return s;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return s;
	}

	public int[] getRecommendation(int userID) {
		user=userID;
		int bookids[] = new int[10];
		// Run Script and get Recommendations
		System.out.println("User ID : "+userID);
		try{
			RConnection  rcon = new RConnection();
			System.out.println("R Connection Established");
			//  set path
			rcon.eval("source('E:\\\\Book Recommender Script R\\\\recommender.R')");
			System.out.println("File opened successfully");
			
			bookids = rcon.eval("getRecommendations("+userID+")").asIntegers();
			for (int i : bookids) {
				System.out.println("Book id : "+i);
			}
			return bookids;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookids;
	}

	public String[][] arrangeRecommendations(int userID) {
		// after getting recommendations by running R script and than send to client
		int bookids[] = new int[10];
		// get bookids 
		bookids = getRecommendation(userID);
		// after getting bookids fetch from database
		ResultSet res = null;
		String searchBook = " SELECT bookID,title,authors,ratings,imageURL FROM recommender.books WHERE bookID = ?"; 
		String readBook = " SELECT bookID FROM recommender.readB WHERE user = ?"; 
		ResultSet res1 = null;
		String recommedations[][] = new String[10][4];
		int Rbook[]=new int[10];
		boolean flag=false;
       try {
		pst=con.prepareStatement(readBook);
		pst.setInt(1,userID);
		res1=pst.executeQuery();
		
		int j=0;
		while(res1.next()) 
			Rbook[j++]=res1.getInt("bookID");
		for(int i:Rbook)
		System.out.println(i);
	} catch (Exception e) {
		// TODO: handle exception
	}
		int l=0;
		// Title , authors , Image URL
		for (int i = 0; i < 10 ; i++) {
			try {
				pst=con.prepareStatement(searchBook);
				pst.setInt(1, bookids[i]);
				res = pst.executeQuery();
				while(res.next()) {
					int BId=res.getInt("bookID");
						for(int k:Rbook) {
							if(k==BId) {
								flag=true;
								break;
							}
					}
					if(flag) {}
					else {
					String title = res.getString("title");
					float ratings = res.getFloat("ratings");
					String imageURL = res.getString("imageURL");
					
					// get title , ratings , imageURL
					recommedations[l][0] = title;
					recommedations[l][1] = Float.toString(ratings);
					recommedations[l][2] = imageURL;
					recommedations[l][3] = Integer.toString(bookids[i]);
                    l++;
					}
					flag=false;
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}		
		return recommedations;
	}
	public boolean verifyUser(int user,String auth) { // verify userid and password
		
		try {
			ResultSet res = null;
			int userid=0;
			String auth_key=null;
			String checkUser = "SELECT userID,auth_key FROM recommender.users WHERE userID = ? ";
			pst = con.prepareStatement(checkUser);
			pst.setInt(1, user);
			res = pst.executeQuery();
			if(res.isBeforeFirst())
			{
				while(res.next()) {
					userid = res.getInt(1);
					auth_key = res.getString(2);
				}
				if(auth_key.equals(auth)) {
					return true;
				}
				else {
					System.out.println("Invalid password");
					return false;
				}
			}
			if(! res.isBeforeFirst())
			{
				System.out.println("Invalid Userid");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void validate() {
		Socket s = connectToCLient();
		try {
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			userId = din.readInt();
			String auth = (String)din.readUTF();
			System.out.println("user id recieved from client : "+userId);
			System.out.println("Password from client : "+auth);
			if(verifyUser(userId, auth)) {
				System.out.println("User Authenticated");
				dout.writeInt(1);
				this.verify = true;
				sendRecommendationsToClient(s);
				s.close();
			}
			else {
				System.out.println("Invalid Users");
				dout.writeInt(0);
				//call validate again
				connectToDatabase();
				validate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void sendRecommendationsToClient(Socket s) {
		if(verify) {
			try {
				// send recommendations 
				String recommendations[][] = new String[5][3];
				recommendations = arrangeRecommendations(userId);
				ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
				os.writeObject(recommendations);
				System.out.println("Sent to client");
				reconnect();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		else
			System.out.println("User not verified");
	}
	public void reconnect() throws IOException, SQLException {
		Socket s=connectToCLient();
		String username ="root";
		String password ="2309";
		DataInputStream din = new DataInputStream(s.getInputStream());
		int bookid=Integer.parseInt(din.readUTF());
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/recommender",username,password);
			System.out.println("Connection Established");
			Statement smt = null;
			smt = con.createStatement();
			String createTableBooks = "CREATE TABLE IF NOT EXISTS readB(user int not null, bookID int not null)";
			smt.execute(createTableBooks);	
			System.out.println("Book status Table Created for user");
			String insertTableBooks ="INSERT INTO readB(user,bookID) VALUES (?,?)";
			pst = con.prepareStatement(insertTableBooks);
			pst.setInt(1, user);
			pst.setInt(2, bookid);
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}