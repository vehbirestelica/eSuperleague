

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class statistikat {

	private JFrame frame;
	private JLabel lblNewLabel;
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statistikat window = new statistikat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public statistikat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		frame.setBounds(90, 20, 945, 638);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(statistikat.class.getResource("/img/ffk_logo.jpg")));
		lblNewLabel.setBounds(10, 67, 138, 169);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Rangu i Liges:");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(158, 74, 214, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ekipe gjithsejt:");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(158, 115, 173, 30);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Lojtar gjithsejt:");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setBounds(158, 156, 163, 25);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Lojtar te huaj:");
		lblNewLabel_1_3.setForeground(Color.GRAY);
		lblNewLabel_1_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(158, 191, 198, 30);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("80(25.8%)");
		lblNewLabel_1_3_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setToolTipText("");
		lblNewLabel_1_3_1.setBounds(267, 191, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("310");
		lblNewLabel_1_2_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(267, 156, 153, 25);
		frame.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("12");
		lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(267, 116, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Liga 1 - Superliga");
		lblNewLabel_1_3_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1.setBounds(265, 74, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_1_4 = new JLabel("Rangimi ne UEFA:");
		lblNewLabel_1_4.setForeground(Color.GRAY);
		lblNewLabel_1_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(393, 74, 151, 30);
		frame.getContentPane().add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_1_2 = new JLabel("Me se shumti tituj:");
		lblNewLabel_1_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(393, 116, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Kampionet Aktual:");
		lblNewLabel_1_2_2.setForeground(Color.GRAY);
		lblNewLabel_1_2_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(393, 156, 153, 25);
		frame.getContentPane().add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_3_2 = new JLabel("Mosha mesatare:");
		lblNewLabel_1_3_2.setForeground(Color.GRAY);
		lblNewLabel_1_3_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_3_2.setBounds(393, 191, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_3_2);

		JLabel lblNewLabel_1_3_1_2 = new JLabel("25.1 Vjet");
		lblNewLabel_1_3_1_2.setToolTipText("");
		lblNewLabel_1_3_1_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_3_1_2.setBounds(504, 191, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_3_1_2);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("KF Feronikeli");
		lblNewLabel_1_2_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(504, 156, 153, 25);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("FC Prishtina - 16 tituj");
		lblNewLabel_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(504, 116, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("52 (4,000 pike)");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1_1.setBounds(502, 74, 153, 30);
		frame.getContentPane().add(lblNewLabel_1_3_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("Vlera totale ne market:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(677, 67, 224, 30);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u20AC20.18M");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Candara Light", Font.BOLD, 60));
		lblNewLabel_3.setBounds(670, 91, 231, 105);
		frame.getContentPane().add(lblNewLabel_3);

		conn = DatabaseConnection.startConnection();
		JButton btnNewButton = new JButton("Add Best Player");
		btnNewButton.setBackground(new Color(0, 51, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addPlayer addpl = new addPlayer();
				addpl.getFrame().setVisible(true);

			}
		});
		btnNewButton.setBounds(795, 390, 120, 37);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add Best Team");
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addBestTeam bestTeam = new addBestTeam();
				bestTeam.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(530, 537, 120, 37);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_8 = new JLabel("Statistikat 2019/2020");
		lblNewLabel_8.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(377, 11, 205, 37);
		frame.getContentPane().add(lblNewLabel_8);

		JButton btnAddTopScorer = new JButton("Top Scorer");
		btnAddTopScorer.setForeground(new Color(255, 255, 255));
		btnAddTopScorer.setBackground(new Color(0, 51, 51));
		btnAddTopScorer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlayer addpl = new addPlayer();
				addpl.getFrame().setVisible(true);
			}
		});
		btnAddTopScorer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddTopScorer.setBounds(413, 390, 120, 37);
		frame.getContentPane().add(btnAddTopScorer);

		JButton btnAddTopAsister = new JButton("Top Asister");
		btnAddTopAsister.setBackground(new Color(0, 51, 51));
		btnAddTopAsister.setForeground(new Color(255, 255, 255));
		btnAddTopAsister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addAssister addAssister = new addAssister();
				addAssister.getFrame().setVisible(true);
			}
		});
		btnAddTopAsister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddTopAsister.setBounds(799, 537, 109, 37);
		frame.getContentPane().add(btnAddTopAsister);

		JButton btnNewButton_1_1 = new JButton("Most Goals");
		btnNewButton_1_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostGoals mostGoals = new mostGoals();
				mostGoals.getFrame().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(546, 390, 109, 37);
		frame.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2_1 = new JButton("Most Saves");
		btnNewButton_1_2_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1_2_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostSaves mostsaves = new mostSaves();
				mostsaves.getFrame().setVisible(true);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_2_1.setBounds(667, 537, 120, 37);
		frame.getContentPane().add(btnNewButton_1_2_1);

		JButton btnNewButton_1_2_2 = new JButton("Most Red Cards");
		btnNewButton_1_2_2.setBackground(new Color(0, 51, 51));
		btnNewButton_1_2_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				redCards redcards = new redCards();
				redcards.getFrame().setVisible(true);
			}
		});
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_2_2.setBounds(665, 390, 120, 37);
		frame.getContentPane().add(btnNewButton_1_2_2);

		JLabel lblNewLabel_11_1 = new JLabel("10 Superliga, 6 Kupa");
		lblNewLabel_11_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_11_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_11_1.setBounds(126, 295, 180, 37);
		frame.getContentPane().add(lblNewLabel_11_1);

		JLabel lblNewLabel_12 = new JLabel("3 Superliga, 3 Kupa");
		lblNewLabel_12.setForeground(new Color(112, 128, 144));
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_12.setBounds(10, 343, 153, 30);
		frame.getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_7 = new JLabel("Skuadrat me m\u00EB se shumti tituj te fituar:");
		lblNewLabel_7.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(20, 247, 452, 32);
		frame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setIcon(new ImageIcon(statistikat.class.getResource("/img/add.png")));
		lblNewLabel_13.setBounds(805, 291, 103, 95);
		frame.getContentPane().add(lblNewLabel_13);

		JLabel lblNewLabel_13_1 = new JLabel("");
		lblNewLabel_13_1.setIcon(new ImageIcon(statistikat.class.getResource("/img/add.png")));
		lblNewLabel_13_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13_1.setBounds(419, 295, 103, 95);
		frame.getContentPane().add(lblNewLabel_13_1);

		JLabel lblNewLabel_13_2 = new JLabel("");
		lblNewLabel_13_2.setIcon(new ImageIcon(statistikat.class.getResource("/img/add.png")));
		lblNewLabel_13_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13_2.setBounds(798, 443, 103, 95);
		frame.getContentPane().add(lblNewLabel_13_2);

		JLabel lblNewLabel_10 = new JLabel("2 Superliga, 1 Kupe");
		lblNewLabel_10.setForeground(new Color(210, 105, 30));
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_10.setBounds(249, 343, 169, 37);
		frame.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(statistikat.class.getResource("/img/rangkimi.jpg")));
		lblNewLabel_6.setBounds(36, 305, 370, 243);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(statistikat.class.getResource("/img/addteam.png")));
		lblNewLabel_11.setBounds(542, 438, 90, 95);
		frame.getContentPane().add(lblNewLabel_11);

		JLabel lblNewLabel_11_2 = new JLabel("");
		lblNewLabel_11_2.setIcon(new ImageIcon(statistikat.class.getResource("/img/addteam.png")));
		lblNewLabel_11_2.setBounds(556, 295, 90, 95);
		frame.getContentPane().add(lblNewLabel_11_2);

		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(statistikat.class.getResource("/img/saves.png")));
		lblNewLabel_14.setBounds(677, 443, 90, 95);
		frame.getContentPane().add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(statistikat.class.getResource("/img/redcard.png")));
		lblNewLabel_15.setBounds(679, 291, 95, 95);
		frame.getContentPane().add(lblNewLabel_15);

		JButton btnNewButton_2 = new JButton("Shfaq Statistikat");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 102, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStats showstats = new showStats();
				showstats.getFrame().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(706, 183, 169, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblShtoniTDhnat = new JLabel("Shtoni t\u00EB dh\u00EBnat e reja :");
		lblShtoniTDhnat.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblShtoniTDhnat.setBounds(413, 245, 247, 37);
		frame.getContentPane().add(lblShtoniTDhnat);

//		JLabel lblNewLabel_6 = new JLabel("1");
//		lblNewLabel_6.setForeground(Color.DARK_GRAY);
//		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
//		lblNewLabel_6.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
//		lblNewLabel_6.setLocation(10, 10);
//		lblNewLabel_6.setSize(lblNewLabel_6.getPreferredSize());
//		btnNewButton_2.add(lblNewLabel_6);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
