import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Tabela {

	private JFrame frmLogin;
	private JPasswordField txtpassword;
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
					Tabela window = new Tabela();
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
	public Tabela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmLogin.getContentPane().setForeground(new Color(0, 102, 0));
		frmLogin.setBounds(100, 100, 665, 626);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setBackground(Color.WHITE);
		Label iconlabel = new Label("E - SUPER LIGA");
		iconlabel.setFont(new Font("Eras Light ITC", Font.PLAIN, 9));
		iconlabel.setBounds(10, 558, 85, 19);
		frmLogin.getContentPane().add(iconlabel);
		
		Button btnkyqu = new Button("Kyqu");
		btnkyqu.setForeground(new Color(255, 255, 255));
		btnkyqu.setFont(new Font("Dialog", Font.BOLD, 13));
		btnkyqu.setBackground(new Color(0, 102, 0));
		btnkyqu.setBounds(289, 384, 115, 38);
		btnkyqu.setFocusable(false);
		
		frmLogin.getContentPane().add(btnkyqu);
		
		TextField txtusername = new TextField();
		txtusername.setForeground(new Color(0, 51, 0));
		txtusername.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtusername.setBounds(228, 240, 228, 29);
		frmLogin.getContentPane().add(txtusername);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(228, 327, 228, 29);
		frmLogin.getContentPane().add(txtpassword);
		
		Label label_1 = new Label("Password");
		label_1.setBounds(228, 305, 62, 16);
		frmLogin.getContentPane().add(label_1);
		
		Label label_2 = new Label("Username");
		label_2.setBounds(228, 212, 62, 22);
		frmLogin.getContentPane().add(label_2);
		
		JLabel lblOseRegjistrohuni = new JLabel("Ose ");
		lblOseRegjistrohuni.setBounds(300, 440, 27, 22);
		frmLogin.getContentPane().add(lblOseRegjistrohuni);
		
		JLabel statuslbl = new JLabel("");
		statuslbl.setBounds(241, 491, 215, 29);
		frmLogin.getContentPane().add(statuslbl);

		btnkyqu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String passtext= new String(txtpassword.getPassword());
			    
		        conn = DatabaseConnection.startConnection();
		        String sql = "select username,passwordi from regjistrohu where username='"+ txtusername.getText()+"'and passwordi='"+passtext+"'";
		        pst = conn.prepareStatement(sql);
		        res=pst.executeQuery(sql);
		        int count = 0;
		        while(res.next()){
		            count = count+1;
		        }
		        if (count==1){
		   
				
					frmmain obj = new frmmain();
		            obj.getFrame().setVisible(true);
		            
		        	Tabela window = new Tabela();
					window.getFrame().dispose();
			
	
		   		            		           
		        }
		        else if (count>1){
		        	
		        	statuslbl.setText("Keni shtypur gabim ");
					statuslbl.setForeground(new Color(220,89, 121));
		           
		        } 
		            else {
		            	statuslbl.setText("Perdoruesi nuk egzistion ");
						statuslbl.setForeground(new Color(220,89, 121));
		             }

		        } catch (Exception ex){
		        	
		        	statuslbl.setText("Kemi probleme me casje ");
					statuslbl.setForeground(new Color(220,89, 121));
		        }

		    
		    }   
		});
		Button btnregjistrohu = new Button("Regjistrohu");
		btnregjistrohu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			      frmregister register = new frmregister();
			      register.getFrame().setVisible(true);
			
                  	Tabela window = new Tabela();
					window.frmLogin.dispose();
					
					Tabela window1 = new Tabela();
					window1.frmLogin.setVisible(false);
					
			
			}
		});
		btnregjistrohu.setBounds(334, 440, 70, 22);
		frmLogin.getContentPane().add(btnregjistrohu);
		
		JLabel backgroundlabel = new JLabel("");
		backgroundlabel.setBounds(208, 38, 248, 152);
		frmLogin.getContentPane().add(backgroundlabel);
		ImageIcon logo=new ImageIcon(Tabela.class.getResource("/img/loginback.png"));
		Image logoImg=logo.getImage();
		logoImg=logoImg.getScaledInstance(backgroundlabel.getWidth(),backgroundlabel.getHeight(), Image.SCALE_SMOOTH);

		
	}
	
	public JFrame getFrame() {
		return frmLogin;
	}

	public void setFrame(JFrame frame) {
		this.frmLogin = frame;
		frame.setType(Type.POPUP);

	}
}

