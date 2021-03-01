

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class addBestTeam {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet res = null;
	private JFrame frmAddBestTeam;
	private JTextField textField;
	private JTextField txtGolat;
	private JTextField textField_1;
	private JTextField txtPiket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBestTeam window = new addBestTeam();
					window.frmAddBestTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addBestTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddBestTeam = new JFrame();
		frmAddBestTeam.getContentPane().setBackground(new Color(255, 255, 255));
		frmAddBestTeam.setTitle("Ekipi Me I Mire");
		frmAddBestTeam.setBounds(320, 370, 579, 241);
		frmAddBestTeam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		frmAddBestTeam.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(new Color(255, 255, 255));
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
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(addBestTeam.class.getResource("/img/addteam.png")));
		btnNewButton.setBounds(10, 27, 123, 99);
		frmAddBestTeam.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Ekipi: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(150, 31, 42, 23);
		frmAddBestTeam.getContentPane().add(lblNewLabel);

		textField = new JTextField("ekipi...");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(202, 27, 96, 33);
		frmAddBestTeam.getContentPane().add(textField);
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
		lblGolat.setBounds(150, 69, 42, 23);
		frmAddBestTeam.getContentPane().add(lblGolat);

		txtGolat = new JTextField("golat...");
		txtGolat.setForeground(Color.BLACK);
		txtGolat.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtGolat.setColumns(10);
		txtGolat.setBounds(202, 65, 96, 33);
		frmAddBestTeam.getContentPane().add(txtGolat);
		txtGolat.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtGolat.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblMoshaMesatare = new JLabel("Mosha mesatare:");
		lblMoshaMesatare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMoshaMesatare.setBounds(308, 31, 132, 23);
		frmAddBestTeam.getContentPane().add(lblMoshaMesatare);

		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(448, 27, 45, 33);
		frmAddBestTeam.getContentPane().add(comboBox);
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
		lblVleraTotaleEkipit.setBounds(308, 69, 123, 23);
		frmAddBestTeam.getContentPane().add(lblVleraTotaleEkipit);

		textField_1 = new JTextField("");
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(441, 68, 77, 28);
		frmAddBestTeam.getContentPane().add(textField_1);

		JLabel lblPiket = new JLabel("Piket:");
		lblPiket.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPiket.setBounds(150, 103, 42, 23);
		frmAddBestTeam.getContentPane().add(lblPiket);

		txtPiket = new JTextField("piket...");
		txtPiket.setForeground(Color.BLACK);
		txtPiket.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPiket.setColumns(10);
		txtPiket.setBounds(202, 103, 96, 33);
		frmAddBestTeam.getContentPane().add(txtPiket);
		txtPiket.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPiket.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(addBestTeam.class.getResource("/img/yellowcard.png")));
		lblNewLabel_1.setBounds(180, 143, 24, 33);
		frmAddBestTeam.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(addBestTeam.class.getResource("/img/red card.png")));
		lblNewLabel_1_1.setBounds(264, 143, 24, 33);
		frmAddBestTeam.getContentPane().add(lblNewLabel_1_1);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setBounds(212, 143, 42, 33);
		frmAddBestTeam.getContentPane().add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_1.setBounds(298, 143, 42, 33);
		frmAddBestTeam.getContentPane().add(spinner_1);

		JLabel lblNewLabel_2 = new JLabel("mln");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(518, 74, 45, 13);
		frmAddBestTeam.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(425, 74, 24, 13);
		frmAddBestTeam.getContentPane().add(lblNewLabel_3);

		JLabel lblPozitaNeTabele = new JLabel("Pozita ne tabele:");
		lblPozitaNeTabele.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPozitaNeTabele.setBounds(10, 153, 123, 23);
		frmAddBestTeam.getContentPane().add(lblPozitaNeTabele);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_2.setBounds(128, 146, 42, 30);
		frmAddBestTeam.getContentPane().add(spinner_2);

		JButton btnNewButton_1 = new JButton("Shto te dhenat");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DatabaseConnection.startConnection();
//					//Insertimi i te dhenave per rreshtin 1
					String tEkipi = textField.getText();
					int tGolat = Integer.parseInt(txtGolat.getText());
					int tPiket = Integer.parseInt(txtPiket.getText());
					String tMoshaMes = comboBox.getSelectedItem().toString();
					float tVleraTot = Float.parseFloat(textField_1.getText());
					Integer tPozitaTabele = (Integer) spinner_2.getValue();
					Integer tkv = (Integer) spinner.getValue();
					Integer tkk = (Integer) spinner_1.getValue();

					String sql = "insert into addBestTeam(tEkipi, tGolat, tPiket, tMoshaMes, tVleraTot, tPozitaTabele, tkv, tkk) values"
							+ "('" + tEkipi + "','" + tGolat + "','" + tPiket + "'," + tMoshaMes + "," + tVleraTot + ","
							+ tPozitaTabele + "," + tkv + "," + tkk + ")";
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(378, 140, 153, 36);
		frmAddBestTeam.getContentPane().add(btnNewButton_1);

	}

	public JFrame getFrame() {
		return frmAddBestTeam;
	}

	public void setFrame(JFrame frame) {
		this.frmAddBestTeam = frame;
		frmAddBestTeam.setTitle("Add Best Player");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
