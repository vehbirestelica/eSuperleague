

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class topEkipiStats {

	private JFrame frmEkipiMeI;
	private JTextField txtekipi;
	private JTextField txtpozita;
	private JTextField txtpiket;
	private JTextField txtgolat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					topEkipiStats window = new topEkipiStats();
					window.frmEkipiMeI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public topEkipiStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEkipiMeI = new JFrame();
		frmEkipiMeI.setTitle("EKIPI ME I MIRE");
		frmEkipiMeI.setBounds(100, 100, 503, 163);
		frmEkipiMeI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEkipiMeI.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(topEkipiStats.class.getResource("/img/addteam.png")));
		lblNewLabel.setBounds(23, 10, 90, 90);
		frmEkipiMeI.getContentPane().add(lblNewLabel);

		txtekipi = new JTextField();
		txtekipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtekipi.setBounds(116, 10, 113, 19);
		frmEkipiMeI.getContentPane().add(txtekipi);
		txtekipi.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pozita ne tabele");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(123, 39, 105, 17);
		frmEkipiMeI.getContentPane().add(lblNewLabel_1);

		txtpozita = new JTextField();
		txtpozita.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtpozita.setBounds(224, 39, 26, 19);
		frmEkipiMeI.getContentPane().add(txtpozita);
		txtpozita.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("me gjithsejt ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(252, 39, 79, 17);
		frmEkipiMeI.getContentPane().add(lblNewLabel_1_1);

		txtpiket = new JTextField();
		txtpiket.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtpiket.setColumns(10);
		txtpiket.setBounds(328, 40, 31, 19);
		frmEkipiMeI.getContentPane().add(txtpiket);

		JLabel lblNewLabel_1_1_1 = new JLabel("pike");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(362, 39, 26, 17);
		frmEkipiMeI.getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Golat ne total");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(123, 68, 105, 17);
		frmEkipiMeI.getContentPane().add(lblNewLabel_1_2);

		txtgolat = new JTextField();
		txtgolat.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtgolat.setColumns(10);
		txtgolat.setBounds(213, 68, 37, 19);
		frmEkipiMeI.getContentPane().add(txtgolat);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga", "root", "");
			Statement stmt = conn.createStatement();
			String query = "select tEkipi,tPozitaTabele,tPiket,tGolat from addBestTeam order by tPiket desc limit 1";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String ekipi = rs.getString("tEkipi");
				int pozita = rs.getInt("tPozitaTabele");
				int piket = rs.getInt("tPiket");
				int golat = rs.getInt("tGolat");

				txtekipi.setText(ekipi);
				txtpozita.setText(Integer.toString(pozita));
				txtpiket.setText(Integer.toString(piket));
				txtgolat.setText(Integer.toString(golat));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public JFrame getFrame() {
		return frmEkipiMeI;
	}

	public void setFrame(JFrame frame) {
		this.frmEkipiMeI = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
