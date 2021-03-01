import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JButton;

public class frmregister {

	private  JFrame frame;
	private  JPasswordField txtpassword;
	 Connection conn=null;
	 ResultSet res=null;
	  PreparedStatement pst=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmregister window = new frmregister();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmregister() {
		initialize();
	}

	/**
	 * Initialize the contents of the getframe().
	 */
	public  void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(255, 255, 255));
		getFrame().setBounds(100, 100, 665, 625);
		getFrame().setDefaultCloseOperation(getFrame().DISPOSE_ON_CLOSE);
		

		getFrame().getContentPane().setLayout(null);
		getFrame().setBackground(Color.WHITE);
		Label iconlabel = new Label("E - SUPER LIGA - 2020. All right reserved");
		iconlabel.setForeground(new Color(0, 102, 0));
		iconlabel.setFont(new Font("Eras Light ITC", Font.PLAIN, 10));
		iconlabel.setBounds(10, 554, 210, 22);
		getFrame().getContentPane().add(iconlabel);
		
	
		
		TextField txtemri = new TextField();
		txtemri.setForeground(new Color(0, 51, 0));
		txtemri.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtemri.setBounds(222, 128, 228, 29);
		getFrame().getContentPane().add(txtemri);

		Label label_1 = new Label("Password");
		label_1.setForeground(new Color(0, 102, 0));
		label_1.setBounds(222, 337, 62, 16);
		getFrame().getContentPane().add(label_1);
		
		Label label_2 = new Label(" Emri ");
		label_2.setForeground(new Color(0, 102, 0));
		label_2.setBounds(222, 105, 62, 22);
		getFrame().getContentPane().add(label_2);
		
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(222, 359, 228, 29);
		getFrame().getContentPane().add(txtpassword);
		
		TextField txtmbiemri = new TextField();
		txtmbiemri.setForeground(new Color(0, 51, 0));
		txtmbiemri.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtmbiemri.setBounds(222, 186, 228, 29);
		getFrame().getContentPane().add(txtmbiemri);
		
		Label label = new Label("Mbiemri");
		label.setForeground(new Color(0, 102, 0));
		label.setBounds(222, 163, 62, 22);
		getFrame().getContentPane().add(label);
		
		TextField txtemail = new TextField();
		txtemail.setForeground(new Color(0, 51, 0));
		txtemail.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtemail.setBounds(222, 244, 228, 29);
		getFrame().getContentPane().add(txtemail);
		
		Label label_3 = new Label("Email");
		label_3.setForeground(new Color(0, 102, 0));
		label_3.setBounds(222, 221, 62, 22);
		getFrame().getContentPane().add(label_3);
		
		TextField txtusername = new TextField();
		txtusername.setForeground(new Color(0, 51, 0));
		txtusername.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtusername.setBounds(222, 302, 228, 29);
		getFrame().getContentPane().add(txtusername);
		
		Label label_4 = new Label("Username");
		label_4.setForeground(new Color(0, 102, 0));
		label_4.setBounds(222, 279, 62, 22);
		getFrame().getContentPane().add(label_4);
		
		Label label_5 = new Label("Regjistrohu");
		label_5.setForeground(new Color(0, 102, 0));
		label_5.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		label_5.setBounds(288, 47, 103, 22);
		getFrame().getContentPane().add(label_5);
		
		JButton kthehubtn = new JButton("Kthenu");
		kthehubtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tabela login = new Tabela();
				login.getFrame().setVisible(true);
			}
		});
		kthehubtn.setForeground(new Color(255, 255, 255));
		kthehubtn.setBackground(new Color(0, 51, 51));
		kthehubtn.setBounds(302, 485, 89, 23);
		kthehubtn.setVisible(false);
		frame.getContentPane().add(kthehubtn);
		
		JLabel iconregister = new JLabel("");
		
		iconregister.setBounds(122, 11, 194, 109);
		ImageIcon logo=new ImageIcon(Tabela.class.getResource("/img/registericon.png"));
		Image logoImg=logo.getImage();
		
		iconregister.setIcon(new ImageIcon(logoImg));
		
		JLabel statuslbl = new JLabel("");
		statuslbl.setBounds(245, 452, 228, 22);
		frame.getContentPane().add(statuslbl);
		
		Button btnregjistrohu = new Button("Regjistrohu");
		btnregjistrohu.setBounds(new Rectangle(16, 16, 8, 7));
		
		btnregjistrohu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String passtext= new String(txtpassword.getPassword());
				    conn=DatabaseConnection.startConnection();
               
				    String sql; 
		
				    sql="insert into regjistrohu(userid,emri,mbiemri, email, username, passwordi) values(null,'"
						+txtemri.getText()+"','"+txtmbiemri.getText() +"','"+txtemail.getText()+"','"+txtusername.getText()+"','"+passtext+"')";
			//	sql="insert into regjistrohu(userid,emri,mbiemri, email, username, passwordi) values(null,'dde','ddd','dddd','dddd','ddd')";
				
				pst = conn.prepareStatement(sql);
				pst.execute();
				pst.close();
				
				statuslbl.setText("Jeni regjistruar me sukses");
				statuslbl.setForeground(new Color(51, 102, 0));
				kthehubtn.setVisible(true);
			}
			catch(Exception e2) {
			
				statuslbl.setText("Ju lutemi Perdoreni nje Username tjeter ");
				statuslbl.setForeground(new Color(220,89, 121));
			}
				finally {
					try {
						conn.close();
					} catch (SQLException e1) {						
					
					}
				}
					

			}
		});
		
		btnregjistrohu.setForeground(new Color(255, 255, 255));
		btnregjistrohu.setFont(new Font("Dialog", Font.BOLD, 13));
		btnregjistrohu.setBackground(new Color(0, 102, 0));
		btnregjistrohu.setBounds(287, 402, 103, 29);
		getFrame().getContentPane().add(btnregjistrohu);
		
	
		
	
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setType(Type.POPUP);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frmregister.class.getResource("/img/server.png")));
	}
}


