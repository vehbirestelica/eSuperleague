

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;

public class mostSavesStats {

	private JFrame frmPortjeriMeMe;
	private JTextField txtemri;
	private JTextField txtekipi;
	private JTextField txtmosha;
	private JTextField txtpritjet;
	private JTextField txtporta;
	private JLabel lblNewLabel_4;
	private JTextField txtgolapranuar;
	private JLabel lblNewLabel_5;
	private JLabel lblEmri;
	private JLabel lblEkipi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mostSavesStats window = new mostSavesStats();
					window.frmPortjeriMeMe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mostSavesStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPortjeriMeMe = new JFrame();
		frmPortjeriMeMe.getContentPane().setBackground(new Color(255, 255, 255));
		frmPortjeriMeMe.setTitle("PORTJERI ME ME SE SHUMTI PRITJE");
		frmPortjeriMeMe.setBounds(100, 100, 327, 310);
		frmPortjeriMeMe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPortjeriMeMe.getContentPane().setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(mostSavesStats.class.getResource("/img/saves.png")));
		lblNewLabel_2.setBounds(10, 30, 90, 98);
		frmPortjeriMeMe.getContentPane().add(lblNewLabel_2);

		txtemri = new JTextField();
		txtemri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtemri.setColumns(10);
		txtemri.setBounds(163, 30, 120, 28);
		frmPortjeriMeMe.getContentPane().add(txtemri);

		txtekipi = new JTextField();
		txtekipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtekipi.setColumns(10);
		txtekipi.setBounds(163, 69, 120, 28);
		frmPortjeriMeMe.getContentPane().add(txtekipi);

		txtmosha = new JTextField();
		txtmosha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmosha.setColumns(10);
		txtmosha.setBounds(163, 108, 120, 28);
		frmPortjeriMeMe.getContentPane().add(txtmosha);

		JLabel lblNewLabel_1 = new JLabel("Mosha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(110, 113, 45, 17);
		frmPortjeriMeMe.getContentPane().add(lblNewLabel_1);

		txtpritjet = new JTextField();
		txtpritjet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpritjet.setColumns(10);
		txtpritjet.setBounds(54, 166, 50, 28);
		frmPortjeriMeMe.getContentPane().add(txtpritjet);

		JLabel lblNewLabel_3 = new JLabel("Pritje");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 166, 34, 28);
		frmPortjeriMeMe.getContentPane().add(lblNewLabel_3);

		txtporta = new JTextField();
		txtporta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtporta.setColumns(10);
		txtporta.setBounds(153, 215, 66, 25);
		frmPortjeriMeMe.getContentPane().add(txtporta);

		lblNewLabel_4 = new JLabel("Porta Te Paprekura");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(14, 215, 129, 19);
		frmPortjeriMeMe.getContentPane().add(lblNewLabel_4);

		txtgolapranuar = new JTextField();
		txtgolapranuar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtgolapranuar.setColumns(10);
		txtgolapranuar.setBounds(227, 166, 50, 28);
		frmPortjeriMeMe.getContentPane().add(txtgolapranuar);

		lblNewLabel_5 = new JLabel("Gola Te Pranuar");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(114, 170, 109, 19);
		frmPortjeriMeMe.getContentPane().add(lblNewLabel_5);
		
		lblEmri = new JLabel("Emri");
		lblEmri.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblEmri.setBounds(114, 29, 34, 28);
		frmPortjeriMeMe.getContentPane().add(lblEmri);
		
		lblEkipi = new JLabel("Ekipi");
		lblEkipi.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblEkipi.setBounds(110, 68, 34, 28);
		frmPortjeriMeMe.getContentPane().add(lblEkipi);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga", "root", "");
			Statement stmt = conn.createStatement();
			String query = "select sEmri,sEkipi,sMosha,sPritjet,sGolatPranuar,sPortaPaprekur from mostSaves order by sPritjet desc limit 1";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String emri = rs.getString("sEmri");
				String ekipi = rs.getString("sEkipi");
				int mosha = rs.getInt("sMosha");
				int pritjet = rs.getInt("sPritjet");
				int golatPranuar = rs.getInt("sGolatPranuar");
				int portaPaprekur = rs.getInt("sPortaPaprekur");

//				
//				model.addRow(new Object[] {emri,golat});

				txtemri.setText(emri);
				txtekipi.setText(ekipi);
				txtmosha.setText(Integer.toString(mosha));
				txtpritjet.setText(Integer.toString(pritjet));
				txtporta.setText(Integer.toString(portaPaprekur));
				txtgolapranuar.setText(Integer.toString(golatPranuar));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public JFrame getFrame() {
		return frmPortjeriMeMe;
	}

	public void setFrame(JFrame frame) {
		this.frmPortjeriMeMe = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
