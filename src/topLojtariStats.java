

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

public class topLojtariStats {

	private JFrame frmLojtariMeI;
	private JTextField txtemri;
	private JTextField txtpozita;
	private JTextField txtekipi;
	private JTextField txtmosha;
	private JTextField txtparaqitjet;
	private JTextField txtgolat;
	private JTextField txtkv;
	private JLabel lblNewLabel_4_1;
	private JTextField txtkk;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					topLojtariStats window = new topLojtariStats();
					window.frmLojtariMeI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public topLojtariStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLojtariMeI = new JFrame();
		frmLojtariMeI.setTitle("Lojtari Me I Mire");
		frmLojtariMeI.setBounds(100, 100, 510, 178);
		frmLojtariMeI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLojtariMeI.getContentPane().setLayout(null);

		txtemri = new JTextField();
		txtemri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtemri.setBounds(100, 22, 106, 18);
		frmLojtariMeI.getContentPane().add(txtemri);
		txtemri.setColumns(10);

		txtpozita = new JTextField();
		txtpozita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpozita.setColumns(10);
		txtpozita.setBounds(367, 22, 28, 18);
		frmLojtariMeI.getContentPane().add(txtpozita);

		txtekipi = new JTextField();
		txtekipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtekipi.setColumns(10);
		txtekipi.setBounds(227, 22, 120, 18);
		frmLojtariMeI.getContentPane().add(txtekipi);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(topLojtariStats.class.getResource("/img/add.png")));
		lblNewLabel_2.setBounds(31, 34, 72, 72);
		frmLojtariMeI.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(214, 21, 28, 19);
		frmLojtariMeI.getContentPane().add(lblNewLabel);

		txtmosha = new JTextField();
		txtmosha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmosha.setBounds(129, 50, 22, 19);
		frmLojtariMeI.getContentPane().add(txtmosha);
		txtmosha.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("vje\u00E7");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(161, 53, 45, 13);
		frmLojtariMeI.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("gola");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(161, 88, 51, 18);
		frmLojtariMeI.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("paraqitje");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(272, 88, 75, 18);
		frmLojtariMeI.getContentPane().add(lblNewLabel_3_1);

		txtparaqitjet = new JTextField();
		txtparaqitjet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtparaqitjet.setColumns(10);
		txtparaqitjet.setBounds(240, 90, 28, 19);
		frmLojtariMeI.getContentPane().add(txtparaqitjet);

		JLabel lblNewLabel_3_3 = new JLabel("(       )");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(357, 20, 72, 18);
		frmLojtariMeI.getContentPane().add(lblNewLabel_3_3);

		txtgolat = new JTextField();
		txtgolat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtgolat.setColumns(10);
		txtgolat.setBounds(129, 90, 22, 19);
		frmLojtariMeI.getContentPane().add(txtgolat);

		txtkv = new JTextField();
		txtkv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtkv.setColumns(10);
		txtkv.setBounds(367, 90, 22, 19);
		frmLojtariMeI.getContentPane().add(txtkv);

		lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(topLojtariStats.class.getResource("/img/yellowcard.png")));
		lblNewLabel_4_1.setBounds(393, 91, 14, 18);
		frmLojtariMeI.getContentPane().add(lblNewLabel_4_1);

		txtkk = new JTextField();
		txtkk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtkk.setColumns(10);
		txtkk.setBounds(427, 90, 22, 19);
		frmLojtariMeI.getContentPane().add(txtkk);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(topLojtariStats.class.getResource("/img/red card.png")));
		lblNewLabel_4.setBounds(451, 91, 14, 18);
		frmLojtariMeI.getContentPane().add(lblNewLabel_4);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga", "root", "");
			Statement stmt = conn.createStatement();
			String query = "select Pemri,Ppozita,Pekipi,Pmosha,Pgolat,Pparaqitjet,Pkv,Pkk from addPlayer order by Pgolat desc limit 1";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String emri = rs.getString("Pemri");
				String pozita = rs.getString("Ppozita");
				String ekipi = rs.getString("Pekipi");
				int mosha = rs.getInt("Pmosha");
				int golat = rs.getInt("Pgolat");
				int paraqitjet = rs.getInt("Pparaqitjet");
				int kv = rs.getInt("Pkv");
				int kk = rs.getInt("Pkk");

//				
//				model.addRow(new Object[] {emri,golat});

				txtemri.setText(emri);
				txtekipi.setText(ekipi);
				txtpozita.setText(pozita);
				txtmosha.setText(Integer.toString(mosha));
				txtgolat.setText(Integer.toString(golat));
				txtparaqitjet.setText(Integer.toString(paraqitjet));
				txtkv.setText(Integer.toString(kv));
				txtkk.setText(Integer.toString(kk));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public JFrame getFrame() {
		return frmLojtariMeI;
	}

	public void setFrame(JFrame frame) {
		this.frmLojtariMeI = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}

}
