

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class showStats {

	private JFrame frmLojtariMeI;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet res = null;
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	static final String CONN_STRING = "jdbc:mysql://localhost:3307/esuperliga?useSSL=false";
	private JButton btnNewButton;
	private JButton btnTopEkipi;
	private JButton btnTopGolashenuesi;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JLabel lblStatisikat;
	private JLabel lblKlikoniMbiButona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showStats window = new showStats();
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
	public showStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLojtariMeI = new JFrame();
		frmLojtariMeI.getContentPane().setBackground(new Color(255, 255, 255));
		frmLojtariMeI.setTitle("Statistikat");
		frmLojtariMeI.setBounds(100, 100, 666, 263);
		frmLojtariMeI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLojtariMeI.getContentPane().setLayout(null);

		btnNewButton = new JButton("Top Lojtari");
		btnNewButton.setBackground(new Color(0, 51, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topLojtariStats topLojtarii = new topLojtariStats();
				topLojtarii.getFrame().setVisible(true);

			}
		});
		btnNewButton.setBounds(10, 112, 134, 33);
		frmLojtariMeI.getContentPane().add(btnNewButton);

		btnTopEkipi = new JButton("Top Ekipi");
		btnTopEkipi.setBackground(new Color(0, 51, 51));
		btnTopEkipi.setForeground(new Color(255, 255, 255));
		btnTopEkipi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topEkipiStats topEkipi = new topEkipiStats();
				topEkipi.getFrame().setVisible(true);
			}
		});
		btnTopEkipi.setBounds(177, 112, 134, 33);
		frmLojtariMeI.getContentPane().add(btnTopEkipi);

		btnTopGolashenuesi = new JButton("Top Golashenuesi");
		btnTopGolashenuesi.setBackground(new Color(0, 51, 51));
		btnTopGolashenuesi.setForeground(new Color(255, 255, 255));
		btnTopGolashenuesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topLojtariStats topLojtarii = new topLojtariStats();
				topLojtarii.getFrame().setVisible(true);
			}
		});
		btnTopGolashenuesi.setBounds(338, 112, 134, 33);
		frmLojtariMeI.getContentPane().add(btnTopGolashenuesi);

		btnNewButton_3 = new JButton("Top Asistuesi");
		btnNewButton_3.setBackground(new Color(0, 51, 51));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topAsistuesiStats topAsistuesi = new topAsistuesiStats();
				topAsistuesi.getFrame().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(496, 112, 134, 33);
		frmLojtariMeI.getContentPane().add(btnNewButton_3);

		btnNewButton_4 = new JButton("Ekipi Golat");
		btnNewButton_4.setBackground(new Color(0, 51, 51));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				golatEkipiStats golatEkipi = new golatEkipiStats();
				golatEkipi.getFrame().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(10, 160, 134, 30);
		frmLojtariMeI.getContentPane().add(btnNewButton_4);

		btnNewButton_5 = new JButton("Pritjet");
		btnNewButton_5.setBackground(new Color(0, 51, 51));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostSavesStats pritjet = new mostSavesStats();
				pritjet.getFrame().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(177, 160, 134, 30);
		frmLojtariMeI.getContentPane().add(btnNewButton_5);

		btnNewButton_6 = new JButton("Kartona te kuq");
		btnNewButton_6.setBackground(new Color(0, 51, 51));
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redCardsStats redCards = new redCardsStats();
				redCards.getFrame().setVisible(true);
			}
		});
		btnNewButton_6.setBounds(338, 160, 134, 30);
		frmLojtariMeI.getContentPane().add(btnNewButton_6);
		
		lblStatisikat = new JLabel("Statisikat 2019/2020");
		lblStatisikat.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblStatisikat.setBounds(252, 11, 184, 28);
		frmLojtariMeI.getContentPane().add(lblStatisikat);
		
		lblKlikoniMbiButona = new JLabel("Klikoni mbi butona per ti paraqitur te dhenat");
		lblKlikoniMbiButona.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblKlikoniMbiButona.setBounds(10, 73, 363, 28);
		frmLojtariMeI.getContentPane().add(lblKlikoniMbiButona);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga", "root", "");
			Statement stmt = conn.createStatement();
			String query = "select Pemri,Pgolat from addPlayer order by Pgolat desc limit 1";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String emri = rs.getString("Pemri");
				int golat = rs.getInt("Pgolat");

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
		frame.setTitle("Lojtari Me I Mire");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
