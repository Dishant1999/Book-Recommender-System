import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JButton;
import java.util.Locale;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TrialUI2 extends javax.swing.JFrame {
	static String recomendations[][];
	String bookId=null;
    public TrialUI2(String [][]recommendations) {
    	setPreferredSize(new Dimension(1600, 1000));
    	setLocation(new Point(100, 0));	
    	this.recomendations = recommendations;
    	for (String[] strings : recommendations) {
			System.out.println("Title : "+strings[0]);
			System.out.println("Rating : "+strings[1]);
			System.out.println("imageURL : "+strings[2]);
			System.out.println();
		}
    	initComponents();
    	jLabel1.setVisible(false);
    	jLabel2.setVisible(false);
    	jLabel3.setVisible(false);
    	jLabel4.setVisible(false);
    	jLabel5.setVisible(false);
    	
		textArea.setVisible(false);
    	textArea_1.setVisible(false);
		textArea_2.setVisible(false);
		textArea_3.setVisible(false);
		textArea_4.setVisible(false);
}
                          
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jLabel1 = new JButton();
        jLabel1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		BkInfo b;
				try {
					b = new BkInfo(recomendations[0][0],recomendations[0][3]);
	        		b.setVisible(true);
	        		bookId=b.BookInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
     
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel1.setBounds(217, 403, 137, 166);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setMinimumSize(new Dimension(50, 50));
        jLabel1.setPreferredSize(new Dimension(50, 50));
        jLabel1.setMaximumSize(new Dimension(50, 50));
        jLabel1.setForeground(Color.RED);
        jLabel1.setBackground(Color.BLACK);
        jButton1 = new javax.swing.JButton();
        jButton1.setBounds(710, 104, 194, 157);
        jButton1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        jButton1.setIcon(new ImageIcon("C:\\Users\\Owner\\Documents\\NetBeansProjects\\GUI\\images\\books-that-matter-book-review.png"));
        jButton1.setForeground(Color.WHITE);
        jButton1.setBackground(Color.WHITE);
        jLabel3 = new JButton();
        jLabel3.setBounds(476, 403, 137, 166);
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setForeground(Color.RED);
        jLabel3.setBackground(Color.BLACK);
        jLabel3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		BkInfo b;
				try {
					b = new BkInfo(recomendations[1][0],recomendations[1][3]);
	        		b.setVisible(true);
	        		bookId=b.BookInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        
        jLabel2 = new JButton();
        jLabel2.setBounds(735, 403, 137, 166);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setForeground(Color.RED);
        jLabel2.setBackground(Color.BLACK);
        jLabel2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		BkInfo b;
				try {
					b = new BkInfo(recomendations[2][0],recomendations[2][3]);
	        		b.setVisible(true);
	        		bookId=b.BookInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        
        jLabel4 = new JButton();
        jLabel4.setBounds(994, 403, 137, 166);
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setForeground(Color.RED);
        jLabel4.setBackground(Color.BLACK);
        jLabel4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		BkInfo b;
				try {
					b = new BkInfo(recomendations[3][0],recomendations[3][3]);
	        		b.setVisible(true);
	        		bookId=b.BookInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        
        jLabel5 = new JButton();
        jLabel5.setBounds(1253, 403, 137, 166);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setForeground(Color.RED);
        jLabel5.setBackground(Color.BLACK);
        jLabel5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		BkInfo b;
				try {
					b = new BkInfo(recomendations[4][0],recomendations[4][3]);
	        		b.setVisible(true);
	        		bookId=b.BookInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(1600, 1000));
        System.out.println("Hello");
        jLabel1.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL(recomendations[0][2])
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        jLabel3.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL(recomendations[2][2])
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        jLabel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        jLabel2.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL(recomendations[1][2])
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        jLabel4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        jLabel4.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL(recomendations[3][2])
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        
        jLabel5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        jLabel5.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL(recomendations[4][2])
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
        lblNewLabel.setBackground(Color.LIGHT_GRAY);
        lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        lblNewLabel.setBounds(0, 0, 1582, 924);
        lblNewLabel.setOpaque(true);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Owner\\Documents\\NetBeansProjects\\GUI\\images\\127348-popular-books-background-2560x1600-free-download.jpg"));
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        getContentPane().add(jLabel5);
        getContentPane().add(jButton1);
        getContentPane().add(jLabel4);
        getContentPane().add(jLabel2);
        getContentPane().add(jLabel3);
        
        textArea = new JLabel();
        textArea.setForeground(Color.WHITE);
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setHorizontalTextPosition(SwingConstants.CENTER);
        textArea.setHorizontalAlignment(SwingConstants.CENTER);
        textArea.setToolTipText("");
        textArea.setOpaque(false);
        textArea.setLocale(new Locale("en", "IN"));
        textArea.setFont(new Font("Segoe Print", Font.BOLD, 14));
        textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setBounds(217, 621, 137, 103);
        getContentPane().add(textArea);
        textArea.setText("<html>"+recomendations[0][0] +"</html>");
        
        textArea_1 = new JLabel();
        textArea_1.setForeground(Color.WHITE);
        textArea_1.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea_1.setHorizontalTextPosition(SwingConstants.CENTER);
        textArea_1.setHorizontalAlignment(SwingConstants.CENTER);
        textArea_1.setToolTipText("");
        textArea_1.setOpaque(false);
        textArea_1.setLocale(new Locale("en", "IN"));
        textArea_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
        textArea_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textArea_1.setBackground(Color.LIGHT_GRAY);
        textArea_1.setBounds(476, 621, 137, 103);
        getContentPane().add(textArea_1);
        textArea_1.setText("<html>"+recomendations[2][0] +"</html>");
     
        textArea_2 = new JLabel();
        textArea_2.setForeground(Color.WHITE);
        textArea_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea_2.setHorizontalTextPosition(SwingConstants.CENTER);
        textArea_2.setHorizontalAlignment(SwingConstants.CENTER);
        textArea_2.setToolTipText("");
        textArea_2.setOpaque(false);
        textArea_2.setLocale(new Locale("en", "IN"));
        textArea_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
        textArea_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textArea_2.setBackground(Color.LIGHT_GRAY);
        textArea_2.setBounds(735, 621, 137, 103);
        getContentPane().add(textArea_2);
        textArea_2.setText("<html>"+recomendations[1][0] +"</html>");
        
        textArea_3 = new JLabel();
        textArea_3.setForeground(Color.WHITE);
        textArea_3.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea_3.setHorizontalTextPosition(SwingConstants.CENTER);
        textArea_3.setHorizontalAlignment(SwingConstants.CENTER);
        textArea_3.setToolTipText("");
        textArea_3.setOpaque(false);
        textArea_3.setLocale(new Locale("en", "IN"));
        textArea_3.setFont(new Font("Segoe Print", Font.BOLD, 14));
        textArea_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textArea_3.setBackground(Color.LIGHT_GRAY);
        textArea_3.setBounds(994, 622, 137, 102);
        getContentPane().add(textArea_3);
        textArea_3.setText("<html>"+recomendations[3][0] +"</html>");
        
        textArea_4 = new JLabel();
        textArea_4.setForeground(Color.WHITE);
        textArea_4.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea_4.setHorizontalTextPosition(SwingConstants.CENTER);
        textArea_4.setHorizontalAlignment(SwingConstants.CENTER);
        textArea_4.setToolTipText("");
        textArea_4.setOpaque(false);
        textArea_4.setLocale(new Locale("en", "IN"));
        textArea_4.setFont(new Font("Segoe Print", Font.BOLD, 14));
        textArea_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textArea_4.setBackground(Color.LIGHT_GRAY);
        textArea_4.setBounds(1253, 622, 137, 102);
        getContentPane().add(textArea_4);
        textArea_4.setText("<html>"+recomendations[4][0] +"</html>");
        getContentPane().add(lblNewLabel);

        pack();
        menuBar = new JMenuBar();
        menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        menuBar.setBackground(SystemColor.activeCaptionBorder);
        menuBar.locate(50, 0);
        setJMenuBar(menuBar);
        
        mnMenu = new JMenu("Menu");
        mnMenu.setFont(new Font("Viner Hand ITC", Font.PLAIN, 15));
        mnMenu.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        mnMenu.setBackground(new Color(102, 153, 204));
        mnMenu.setLocation(new Point(100, 0));
        mnMenu.setAlignmentX(Component.RIGHT_ALIGNMENT);
        menuBar.add(mnMenu);
        
        mntmSignOut = new JMenuItem("Sign out");
        mntmSignOut.setBackground(new Color(0, 0, 0));
        mntmSignOut.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mntmSignOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 TrialUI t=new TrialUI();
        		 dispose();
                t.setVisible(true);//to take to next window
                
        	}
        });
        mnMenu.add(mntmSignOut);
        
        mntmUserDetails = new JMenuItem("User Details");
        mntmUserDetails.setBackground(new Color(0, 0, 0));
        mnMenu.add(mntmUserDetails);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jLabel1.setVisible(true);
        jLabel3.setVisible(true);
        jLabel2.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        textArea.setVisible(true);
    	textArea_1.setVisible(true);
		textArea_2.setVisible(true);
		textArea_3.setVisible(true);
		textArea_4.setVisible(true);
	        
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrialUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrialUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrialUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrialUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrialUI2(recomendations).setVisible(true);
            }
        });
    }
    public String BookId() {
    	return bookId;
    }
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private JButton jLabel1;
    private JButton jLabel2;
    private JButton jLabel3;
    private JButton jLabel4;
    private JButton jLabel5;
    private JMenu mnMenu;
    private JMenuItem mntmSignOut;
    private JMenuItem mntmUserDetails;
    private JMenuBar menuBar;
    private JButton jButton1;
    private JLabel textArea_1;
    private JLabel textArea_2;
    private JLabel textArea_3;
    private JLabel textArea_4;
    private JLabel textArea;
    // End of variables declaration                   
	public JButton getJLabel4() {
		return jLabel4;
	}
	public JButton getJLabel5() {
		return jLabel5;
	}
	public JButton getJLabel3() {
		return jLabel3;
	}
	public JButton getJLabel1() {
		return jLabel1;
	}
	public JButton getJLabel2() {
		return jLabel2;
	}
}
