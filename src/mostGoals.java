

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class mostGoals {

	private JFrame frmEkipiMeMe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField golashenuesi1;
	private JTextField golashenuesi2;
	private JTextField golashenuesi3;
	private JTextField asistuesi1;
	private JTextField asistuesi2;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet res = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mostGoals window = new mostGoals();
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
	public mostGoals() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEkipiMeMe = new JFrame();
		frmEkipiMeMe.setTitle("Ekipi Me Me Se Shumti Gola");
		frmEkipiMeMe.setBounds(330, 375, 605, 373);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEkipiMeMe.getContentPane().setLayout(null);
		frmEkipiMeMe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(mostGoals.class.getResource("/img/addteam.png")));
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 15, 123, 99);
		frmEkipiMeMe.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Ekipi: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(154, 21, 42, 23);
		frmEkipiMeMe.getContentPane().add(lblNewLabel);

		textField = new JTextField("ekipi...");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(202, 24, 96, 25);
		frmEkipiMeMe.getContentPane().add(textField);
		textField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblGolat = new JLabel("Golat:");
		lblGolat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGolat.setBounds(154, 54, 42, 23);
		frmEkipiMeMe.getContentPane().add(lblGolat);

		textField_1 = new JTextField("golat...");
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(202, 57, 96, 25);
		frmEkipiMeMe.getContentPane().add(textField_1);
		textField_1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField_1.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblPiket = new JLabel("Piket:");
		lblPiket.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPiket.setBounds(154, 87, 42, 23);
		frmEkipiMeMe.getContentPane().add(lblPiket);

		textField_2 = new JTextField("piket...");
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(202, 90, 96, 25);
		frmEkipiMeMe.getContentPane().add(textField_2);
		textField_2.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField_2.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblPozitaNeTabele = new JLabel("Pozita ne tabele:");
		lblPozitaNeTabele.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPozitaNeTabele.setBounds(337, 21, 123, 23);
		frmEkipiMeMe.getContentPane().add(lblPozitaNeTabele);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_2.setBounds(452, 23, 42, 25);
		frmEkipiMeMe.getContentPane().add(spinner_2);

		JLabel lblMoshaMesatare = new JLabel("Mosha mesatare:");
		lblMoshaMesatare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMoshaMesatare.setBounds(337, 87, 132, 23);
		frmEkipiMeMe.getContentPane().add(lblMoshaMesatare);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setEditable(true);
		comboBox.setBounds(462, 90, 42, 25);
		frmEkipiMeMe.getContentPane().add(comboBox);
		comboBox.addItem("22");
		comboBox.addItem("23");
		comboBox.addItem("24");
		comboBox.addItem("25");
		comboBox.addItem("26");
		comboBox.addItem("27");
		comboBox.addItem("28");
		comboBox.addItem("29");
		comboBox.addItem("30");

		JLabel lblVleraTotaleEkipit = new JLabel("Vlera totale ekipit:");
		lblVleraTotaleEkipit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVleraTotaleEkipit.setBounds(337, 54, 123, 23);
		frmEkipiMeMe.getContentPane().add(lblVleraTotaleEkipit);

		textField_3 = new JTextField("");
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(469, 57, 77, 25);
		frmEkipiMeMe.getContentPane().add(textField_3);

		JLabel lblNewLabel_3 = new JLabel("$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(459, 59, 24, 13);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("mln");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(547, 59, 36, 13);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("1.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 177, 36, 25);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("2.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 223, 36, 25);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("3.");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 264, 36, 25);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_4 = new JLabel("Top 3 golashenuesit ne ekip:");
		lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 143, 221, 23);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_4);

		golashenuesi1 = new JTextField();
		golashenuesi1.setBounds(41, 177, 132, 30);
		frmEkipiMeMe.getContentPane().add(golashenuesi1);
		golashenuesi1.setColumns(10);

		golashenuesi2 = new JTextField();
		golashenuesi2.setColumns(10);
		golashenuesi2.setBounds(41, 218, 132, 30);
		frmEkipiMeMe.getContentPane().add(golashenuesi2);

		golashenuesi3 = new JTextField();
		golashenuesi3.setColumns(10);
		golashenuesi3.setBounds(41, 259, 132, 30);
		frmEkipiMeMe.getContentPane().add(golashenuesi3);

		JLabel lblNewLabel_4_1 = new JLabel("Top 2 asistuesit ne ekip:");
		lblNewLabel_4_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(230, 142, 221, 23);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_1_3 = new JLabel("1.");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(230, 178, 36, 25);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_3);

		asistuesi1 = new JTextField();
		asistuesi1.setColumns(10);
		asistuesi1.setBounds(261, 177, 132, 30);
		frmEkipiMeMe.getContentPane().add(asistuesi1);

		JLabel lblNewLabel_1_1_1 = new JLabel("2.");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(230, 219, 36, 25);
		frmEkipiMeMe.getContentPane().add(lblNewLabel_1_1_1);

		asistuesi2 = new JTextField();
		asistuesi2.setColumns(10);
		asistuesi2.setBounds(261, 218, 132, 30);
		frmEkipiMeMe.getContentPane().add(asistuesi2);

		JButton btnNewButton_1 = new JButton("Shto te dhenat");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DatabaseConnection.startConnection();
//					//Insertimi i te dhenave per rreshtin 1
					String gEkipi = textField.getText();
					int gGolat = Integer.parseInt(textField_1.getText());
					Integer gPozita = (Integer) spinner_2.getValue();
					int gPiket = Integer.parseInt(textField_2.getText());
					float gVleraTotEkipit = Float.parseFloat(textField_3.getText());
					String gMoshaMes = comboBox.getSelectedItem().toString();
					// String pfoto=btnNewButton.getText();
					String gGolashenuesi1 = golashenuesi1.getText();
					String gGolashenuesi2 = golashenuesi2.getText();
					String gGolashenuesi3 = golashenuesi3.getText();
					String gAsistuesi1 = asistuesi1.getText();
					String gAsistuesi2 = asistuesi2.getText();

					String sql = "insert into mostGoals(gEkipi, gGolat, gPozita, gPiket, gVleraTotEkipit, gMoshaMes, gGolashenuesi1, gGolashenuesi2, gGolashenuesi3, gAsistuesi1, gAsistuesi2) values"
							+ "('" + gEkipi + "'," + gGolat + ",'" + gPozita + "'," + gPiket + "," + gVleraTotEkipit
							+ "," + gMoshaMes + ",'" + gGolashenuesi1 + "','" + gGolashenuesi2 + "','" + gGolashenuesi3
							+ "','" + gAsistuesi1 + "','" + gAsistuesi2 + "')";
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Te dhenat jane insertuar me sukses!");

					pst.close();
				} catch (Exception e1) {
					System.out.println(e1);
				} finally { // me dit qe ka perfundu cikli i inserimit
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btnNewButton_1.setBounds(261, 276, 132, 37);
		frmEkipiMeMe.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrame() {
		return frmEkipiMeMe;
	}

	public void setFrame(JFrame frame) {
		this.frmEkipiMeMe = frame;
		frame.setTitle("Add Best Player");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}

}
