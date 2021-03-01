

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

public class redCardsStats {

	private JFrame frmLojtariMeMe;
	private JTextField txtemri;
	private JTextField txtekipi;
	private JTextField txtmosha;
	private JTextField txtparaqitjet;
	private JTextField txtpozita;
	private JTextField txtkk;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					redCardsStats window = new redCardsStats();
					window.frmLojtariMeMe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public redCardsStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLojtariMeMe = new JFrame();
		frmLojtariMeMe.setTitle("LOJTARI ME ME SE SHUMTI KARTONA TE KUQ");
		frmLojtariMeMe.setBounds(100, 100, 524, 224);
		frmLojtariMeMe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLojtariMeMe.getContentPane().setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				redCardsStats.class.getResource("/img/football-soccer-hand-yellow-red-card-512.png")));
		lblNewLabel_2.setBounds(25, 24, 110, 149);
		frmLojtariMeMe.getContentPane().add(lblNewLabel_2);

		txtemri = new JTextField();
		txtemri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtemri.setColumns(10);
		txtemri.setBounds(145, 24, 124, 18);
		frmLojtariMeMe.getContentPane().add(txtemri);

		txtekipi = new JTextField();
		txtekipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtekipi.setColumns(10);
		txtekipi.setBounds(290, 24, 120, 18);
		frmLojtariMeMe.getContentPane().add(txtekipi);

		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(277, 23, 28, 19);
		frmLojtariMeMe.getContentPane().add(lblNewLabel);

		txtmosha = new JTextField();
		txtmosha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmosha.setColumns(10);
		txtmosha.setBounds(173, 52, 22, 19);
		frmLojtariMeMe.getContentPane().add(txtmosha);

		JLabel lblNewLabel_1 = new JLabel("vje\u00E7");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(199, 52, 45, 13);
		frmLojtariMeMe.getContentPane().add(lblNewLabel_1);

		txtparaqitjet = new JTextField();
		txtparaqitjet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtparaqitjet.setColumns(10);
		txtparaqitjet.setBounds(277, 98, 22, 19);
		frmLojtariMeMe.getContentPane().add(txtparaqitjet);

		JLabel lblNewLabel_3_1 = new JLabel("paraqitje");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(303, 96, 75, 18);
		frmLojtariMeMe.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_4 = new JLabel("(        )");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(413, 24, 54, 17);
		frmLojtariMeMe.getContentPane().add(lblNewLabel_4);

		txtpozita = new JTextField();
		txtpozita.setBounds(420, 25, 28, 19);
		frmLojtariMeMe.getContentPane().add(txtpozita);
		txtpozita.setColumns(10);

		txtkk = new JTextField();
		txtkk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtkk.setColumns(10);
		txtkk.setBounds(223, 98, 14, 19);
		frmLojtariMeMe.getContentPane().add(txtkk);

		lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(redCardsStats.class.getResource("/img/red card.png")));
		lblNewLabel_4_1.setBounds(239, 99, 14, 18);
		frmLojtariMeMe.getContentPane().add(lblNewLabel_4_1);

		lblNewLabel_3 = new JLabel("Gjithsejt        ne");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(164, 98, 110, 19);
		frmLojtariMeMe.getContentPane().add(lblNewLabel_3);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga", "root", "");
			Statement stmt = conn.createStatement();
			String query = "select rEmri,rPozita,rEkipi,rMosha,rParaqitjet,rkk from mostRedCards order by rkk desc limit 1";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String emri = rs.getString("rEmri");
				String pozita = rs.getString("rPozita");
				String ekipi = rs.getString("rEkipi");
				int mosha = rs.getInt("rMosha");
				int paraqitjet = rs.getInt("rParaqitjet");
				int kk = rs.getInt("rkk");

				txtemri.setText(emri);
				txtekipi.setText(ekipi);
				txtpozita.setText(pozita);
				txtmosha.setText(Integer.toString(mosha));
				txtparaqitjet.setText(Integer.toString(paraqitjet));
				txtkk.setText(Integer.toString(kk));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public JFrame getFrame() {
		return frmLojtariMeMe;
	}

	public void setFrame(JFrame frame) {
		this.frmLojtariMeMe = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
