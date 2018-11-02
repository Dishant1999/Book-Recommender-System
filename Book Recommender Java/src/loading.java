import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class loading extends JDialog {
	
	public static void main(String[] args) {
		try {
			
			loading dialog = new loading();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public loading() {
		setUndecorated(true);
		setVisible(true);
		getContentPane().setPreferredSize(new Dimension(250, 120));
	//	getContentPane().setSize(new Dimension(250, 120));
		//setBounds(new Rectangle(0, 0, 200, 150));
		getContentPane().setMinimumSize(new Dimension(280, 50));
		getContentPane().setLayout(null);
		
		JLabel lblLoading = new JLabel("Loading...");
		lblLoading.setBackground(new Color(240, 240, 240));
		lblLoading.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 17));
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoading.setBounds(160, 75, 108, 38);
		getContentPane().add(lblLoading);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLACK));
		label.setIcon(new ImageIcon("C:\\Users\\Owner\\Desktop\\380_display-book-shelfsmall.jpg"));
		label.setBounds(0, 0, 443, 126);
		getContentPane().add(label);
		setLocationRelativeTo(null);
	//	setUndecorated(true);
		//setMinimumSize(new Dimension(200, 100));
//		setBounds(100, 100, 466, 170);
		setBounds(600, 400, 443, 126);
		{	
			
		}
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Owner\\Desktop\\380_display-book-shelfsmall.jpg"));
//		lblNewLabel.setBounds(199, 196, 373, 165);
//		getContentPane().add(lblNewLabel);
	}
}
