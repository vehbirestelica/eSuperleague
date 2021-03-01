

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

public class topAsistuesiStats {

	private JFrame frmTopAsistuesi;
	private JTextField txtemri;
	private JTextField txtekipi;
	private JTextField txtpozita;
	private JTextField txtmosha;
	private JTextField txtasistet;
	private JTextField txtparaqitjet;
	private JTextField txtkv;
	private JTextField txtkk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					topAsistuesiStats window = new topAsistuesiStats();
					window.frmTopAsistuesi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public topAsistuesiStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTopAsistuesi = new JFrame();
		frmTopAsistuesi.setTitle("TOP ASISTUESI");
		frmTopAsistuesi.setBounds(100, 100, 563, 163);
		frmTopAsistuesi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTopAsistuesi.getContentPane().setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(topAsistuesiStats.class.getResource("/img/add.png")));
		lblNewLabel_2.setBounds(20, 24, 72, 72);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_2);

		txtemri = new JTextField();
		txtemri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtemri.setColumns(10);
		txtemri.setBounds(89, 12, 106, 18);
		frmTopAsistuesi.getContentPane().add(txtemri);

		txtekipi = new JTextField();
		txtekipi.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtekipi.setColumns(10);
		txtekipi.setBounds(216, 12, 120, 18);
		frmTopAsistuesi.getContentPane().add(txtekipi);

		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(203, 11, 28, 19);
		frmTopAsistuesi.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_3_3 = new JLabel("(       )");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(346, 12, 72, 18);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_3_3);

		txtpozita = new JTextField();
		txtpozita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpozita.setColumns(10);
		txtpozita.setBounds(356, 12, 28, 18);
		frmTopAsistuesi.getContentPane().add(txtpozita);

		txtmosha = new JTextField();
		txtmosha.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtmosha.setColumns(10);
		txtmosha.setBounds(118, 40, 22, 19);
		frmTopAsistuesi.getContentPane().add(txtmosha);

		JLabel lblNewLabel_1 = new JLabel("vje\u00E7");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(144, 40, 45, 13);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_1);

		txtasistet = new JTextField();
		txtasistet.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtasistet.setColumns(10);
		txtasistet.setBounds(118, 77, 22, 19);
		frmTopAsistuesi.getContentPane().add(txtasistet);

		JLabel lblNewLabel_3 = new JLabel("asistime ne        paraqitje");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(144, 77, 177, 19);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_3);

		txtparaqitjet = new JTextField();
		txtparaqitjet.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtparaqitjet.setColumns(10);
		txtparaqitjet.setBounds(223, 77, 28, 19);
		frmTopAsistuesi.getContentPane().add(txtparaqitjet);

		txtkv = new JTextField();
		txtkv.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtkv.setBounds(404, 81, 14, 19);
		frmTopAsistuesi.getContentPane().add(txtkv);
		txtkv.setColumns(10);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(topAsistuesiStats.class.getResource("/img/red card.png")));
		lblNewLabel_4_1.setBounds(480, 82, 14, 18);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_4_1);

		txtkk = new JTextField();
		txtkk.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtkk.setColumns(10);
		txtkk.setBounds(464, 81, 14, 19);
		frmTopAsistuesi.getContentPane().add(txtkk);

		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setIcon(new ImageIcon(topAsistuesiStats.class.getResource("/img/yellowcard.png")));
		lblNewLabel_4_1_1.setBounds(422, 82, 14, 18);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_4_1_1);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga", "root", "");
			Statement stmt = conn.createStatement();
			String query = "select aEmri,aEkipi,aPozita,aMosha,aAsistet,aParaqitjet,akv,akk from addAssister order by aAsistet desc limit 1";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String emri = rs.getString("aEmri");
				String ekipi = rs.getString("aEkipi");
				String pozita = rs.getString("aPozita");
				int mosha = rs.getInt("aMosha");
				int asistet = rs.getInt("aAsistet");
				int paraqitjet = rs.getInt("aParaqitjet");
				int kv = rs.getInt("akv");
				int kk = rs.getInt("akk");

				txtemri.setText(emri);
				txtekipi.setText(ekipi);
				txtpozita.setText(pozita);
				txtmosha.setText(Integer.toString(mosha));
				txtasistet.setText(Integer.toString(asistet));
				txtparaqitjet.setText(Integer.toString(paraqitjet));
				txtkv.setText(Integer.toString(kv));
				txtkk.setText(Integer.toString(kk));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public JFrame getFrame() {
		return frmTopAsistuesi;
	}

	public void setFrame(JFrame frame) {
		this.frmTopAsistuesi = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
