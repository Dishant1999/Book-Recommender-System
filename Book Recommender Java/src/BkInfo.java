import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class BkInfo extends JFrame {
	String name,bookId;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	public BkInfo(String name,String BookId) throws IOException {
		this.name=name;
		this.bookId=BookId;
		Client c=new Client();
		c.book=bookId;
		c.BOOK();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 350, 495, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setBounds(61, 40, 108, 20);
		lblBookName.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		contentPane.add(lblBookName);
		
		JLabel BookName = new JLabel("<html>"+name+"</html>");
		BookName.setVerticalTextPosition(SwingConstants.TOP);
		BookName.setVerticalAlignment(SwingConstants.TOP);
		BookName.setHorizontalTextPosition(SwingConstants.CENTER);
		BookName.setForeground(Color.WHITE);
		BookName.setBounds(178, 40, 269, 63);
		BookName.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(BookName);
		
		JLabel lblBookStatus = new JLabel("Book Status:");
		lblBookStatus.setForeground(Color.WHITE);
		lblBookStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookStatus.setBounds(61, 133, 108, 20);
		lblBookStatus.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		contentPane.add(lblBookStatus);
		
		JRadioButton rdbtnRead = new JRadioButton("Select if read");
		rdbtnRead.setOpaque(false);
		rdbtnRead.setForeground(Color.WHITE);
		rdbtnRead.setBounds(178, 126, 203, 35);
		rdbtnRead.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(rdbtnRead);
		
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(rdbtnRead.isSelected()) {
					BookInfo();
					
				}
				dispose();
			}
		});
		btnDone.setBorder(new LineBorder(Color.WHITE));
		btnDone.setBounds(383, 255, 97, 25);
		contentPane.add(btnDone);
		
		JLabel BckIcon = new JLabel("");
		BckIcon.setBorder(new LineBorder(Color.WHITE, 2, true));
		BckIcon.setIcon(new ImageIcon("C:\\Users\\Owner\\Documents\\NetBeansProjects\\GUI\\images\\read.jpg"));
		BckIcon.setBounds(0, 0, 495, 315);
		contentPane.add(BckIcon);
	}
	public String BookInfo() {
		return bookId;
		
	}
}
