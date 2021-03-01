

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
import javax.swing.SwingConstants;

public class golatEkipiStats {

	private JFrame frmEkipiMeMe;
	private JTextField txtekipi;
	private JTextField txtpozita;
	private JTextField txtpiket;
	private JTextField txtgolat;
	private JTextField txtg1;
	private JTextField txtg2;
	private JTextField txtg3;
	private JTextField txta1;
	private JTextField txta2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					golatEkipiStats window = new golatEkipiStats();
					window.frmEkipiMeMe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public golatEkipiStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEkipiMeMe = new JFrame();
		frmEkipiMeMe.getContentPane().setBackground(new Color(255, 255, 255));
		frmEkipiMeMe.setTitle("EKIPI ME ME SE SHUMTI GOLA");
		frmEkipiMeMe.setBounds(100, 100, 401, 434);
		frmEkipiMeMe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEkipiMeMe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(golatEkipiStats.class.getResource("/img/addteam.png")));
		lblNewLabel.setBounds(10, 47, 90, 90);
		frmEkipiMeMe.getContentPane().add(lblNewLabel);

		txtekipi = new JTextField();
		txtekipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtekipi.setColumns(10);
		txtekipi.setBounds(221, 22, 134, 29);
		frmEkipiMeMe.getContentPane().add(txtekipi);

		JLabel lblNewLabel_1 = new JLabel("Pozita ne tabele");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(110, 76, 105, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1);

		txtpozita = new JTextField();
		txtpozita.setHorizontalAlignment(SwingConstants.CENTER);
		txtpozita.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtpozita.setColumns(10);
		txtpozita.setBounds(221, 69, 134, 29);
		frmEkipiMeMe.getContentPane().add(txtpozita);

		txtpiket = new JTextField();
		txtpiket.setHorizontalAlignment(SwingConstants.CENTER);
		txtpiket.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtpiket.setColumns(10);
		txtpiket.setBounds(221, 113, 134, 29);
		frmEkipiMeMe.getContentPane().add(txtpiket);

		JLabel lblNewLabel_1_1_1 = new JLabel("Piket ne Tabel");
		lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(110, 120, 105, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Golat ne total");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(110, 163, 105, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_2);

		txtgolat = new JTextField();
		txtgolat.setHorizontalAlignment(SwingConstants.CENTER);
		txtgolat.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtgolat.setColumns(10);
		txtgolat.setBounds(221, 157, 134, 29);
		frmEkipiMeMe.getContentPane().add(txtgolat);

		JLabel lblNewLabel_1_3 = new JLabel("Top 3 Golashenuesit e ekipit:");
		lblNewLabel_1_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(10, 215, 192, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("1.");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(10, 245, 12, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_4);

		txtg1 = new JTextField();
		txtg1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtg1.setColumns(10);
		txtg1.setBounds(27, 243, 152, 29);
		frmEkipiMeMe.getContentPane().add(txtg1);

		JLabel lblNewLabel_1_4_1 = new JLabel("2. ");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4_1.setBounds(10, 286, 17, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_4_1);

		txtg2 = new JTextField();
		txtg2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtg2.setColumns(10);
		txtg2.setBounds(27, 280, 152, 29);
		frmEkipiMeMe.getContentPane().add(txtg2);

		JLabel lblNewLabel_1_4_2 = new JLabel("3.");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4_2.setBounds(10, 323, 12, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_4_2);

		txtg3 = new JTextField();
		txtg3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtg3.setColumns(10);
		txtg3.setBounds(27, 317, 152, 29);
		frmEkipiMeMe.getContentPane().add(txtg3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Top 2 Asistuesit e ekipit:");
		lblNewLabel_1_3_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(208, 215, 185, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_4_3 = new JLabel("1. ");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4_3.setBounds(208, 249, 17, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_4_3);

		txta1 = new JTextField();
		txta1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txta1.setColumns(10);
		txta1.setBounds(221, 244, 133, 28);
		frmEkipiMeMe.getContentPane().add(txta1);

		JLabel lblNewLabel_1_4_1_1 = new JLabel("2.");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4_1_1.setBounds(208, 286, 12, 17);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_4_1_1);

		txta2 = new JTextField();
		txta2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txta2.setColumns(10);
		txta2.setBounds(221, 280, 133, 29);
		frmEkipiMeMe.getContentPane().add(txta2);
		
		JLabel lblEmriIEkipit = new JLabel("Emri i Ekipit");
		lblEmriIEkipit.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblEmriIEkipit.setBounds(110, 28, 105, 19);
		frmEkipiMeMe.getContentPane().add(lblEmriIEkipit);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga", "root", "");
			Statement stmt = conn.createStatement();
			String query = "select gEkipi,gPozita,gPiket,gGolat,gGolashenuesi1,gGolashenuesi2,gGolashenuesi3,gAsistuesi1,gAsistuesi2 from mostGoals order by gGolat desc limit 1";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String ekipi = rs.getString("gEkipi");
				int pozita = rs.getInt("gPozita");
				int piket = rs.getInt("gPiket");
				int golat = rs.getInt("gGolat");
				String golashenuesi1 = rs.getString("gGolashenuesi1");
				String golashenuesi2 = rs.getString("gGolashenuesi2");
				String golashenuesi3 = rs.getString("gGolashenuesi3");
				String asistuesi1 = rs.getString("gAsistuesi1");
				String asistuesi2 = rs.getString("gAsistuesi2");

				txtekipi.setText(ekipi);
				txtpozita.setText(Integer.toString(pozita));
				txtpiket.setText(Integer.toString(piket));
				txtgolat.setText(Integer.toString(golat));
				txtg1.setText(golashenuesi1);
				txtg2.setText(golashenuesi2);
				txtg3.setText(golashenuesi3);
				txta1.setText(asistuesi1);
				txta2.setText(asistuesi2);

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public JFrame getFrame() {
		return frmEkipiMeMe;
	}

	public void setFrame(JFrame frame) {
		this.frmEkipiMeMe = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
