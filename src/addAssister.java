

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class addAssister {

	private JFrame frmTopAsistuesi;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtAsistat;
	private JLabel lblNrGolave_1;
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
					addAssister window = new addAssister();
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
	public addAssister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTopAsistuesi = new JFrame();
		frmTopAsistuesi.setTitle("Top Asistuesi");
		frmTopAsistuesi.setBounds(330, 375, 400, 350);
		// frmTopAsistuesi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTopAsistuesi.getContentPane().setLayout(null);
		frmTopAsistuesi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
		btnNewButton.setIcon(new ImageIcon(addAssister.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 22, 108, 95);
		frmTopAsistuesi.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Emri:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(128, 22, 62, 26);
		frmTopAsistuesi.getContentPane().add(lblNewLabel);

		textField = new JTextField("lojtari...");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(187, 22, 167, 26);
		frmTopAsistuesi.getContentPane().add(textField);
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

		textField_1 = new JTextField("pozita...");
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(187, 56, 167, 26);
		frmTopAsistuesi.getContentPane().add(textField_1);
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

		JLabel lblEkipi = new JLabel("Ekipi:");
		lblEkipi.setForeground(Color.BLACK);
		lblEkipi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEkipi.setBounds(128, 91, 46, 26);
		frmTopAsistuesi.getContentPane().add(lblEkipi);

		textField_2 = new JTextField("ekipi...");
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(187, 93, 167, 26);
		frmTopAsistuesi.getContentPane().add(textField_2);
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

		JLabel lblMosha = new JLabel("Mosha:");
		lblMosha.setForeground(Color.BLACK);
		lblMosha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMosha.setBounds(128, 128, 62, 27);
		frmTopAsistuesi.getContentPane().add(lblMosha);

		textField_3 = new JTextField("");
		textField_3.setForeground(Color.GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(187, 131, 167, 24);
		frmTopAsistuesi.getContentPane().add(textField_3);
		textField_3.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField_3.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblNrGolave = new JLabel("");
		lblNrGolave.setIcon(new ImageIcon(addAssister.class.getResource("/img/topi.png")));
		lblNrGolave.setForeground(Color.BLACK);
		lblNrGolave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNrGolave.setBounds(249, 189, 32, 24);
		frmTopAsistuesi.getContentPane().add(lblNrGolave);

		textField_4 = new JTextField("golat...");
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(284, 189, 70, 26);
		frmTopAsistuesi.getContentPane().add(textField_4);
		textField_4.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField_4.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblParaqitjet = new JLabel("");
		lblParaqitjet.setIcon(new ImageIcon(addAssister.class.getResource("/img/paraqitjet.png")));
		lblParaqitjet.setForeground(Color.BLACK);
		lblParaqitjet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParaqitjet.setBounds(9, 191, 24, 24);
		frmTopAsistuesi.getContentPane().add(lblParaqitjet);

		textField_5 = new JTextField("paraqitjet...");
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(43, 189, 70, 26);
		frmTopAsistuesi.getContentPane().add(textField_5);
		textField_5.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField_5.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(addAssister.class.getResource("/img/yellowcard.png")));
		lblNewLabel_1.setBounds(10, 239, 14, 30);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(addAssister.class.getResource("/img/red card.png")));
		lblNewLabel_1_1.setBounds(99, 239, 14, 30);
		frmTopAsistuesi.getContentPane().add(lblNewLabel_1_1);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(34, 239, 45, 30);
		frmTopAsistuesi.getContentPane().add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_1.setBounds(118, 239, 45, 30);
		frmTopAsistuesi.getContentPane().add(spinner_1);

		JButton btnNewButton_1 = new JButton("Shto te dhenat");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DatabaseConnection.startConnection();
//						//Insertimi i te dhenave per rreshtin 1
					String aEmri = textField.getText();
					String aPozita = textField_1.getText();
					String aEkipi = textField_2.getText();
					int aMosha = Integer.parseInt(textField_3.getText());
					// String pfoto=btnNewButton.getText();
					int aGolat = Integer.parseInt(textField_4.getText());
					int aParaqitjet = Integer.parseInt(textField_5.getText());
					int aAsistet = Integer.parseInt(txtAsistat.getText());
					Integer akv = (Integer) spinner.getValue();
					Integer akk = (Integer) spinner_1.getValue();

					String sql = "insert into addAssister(aEmri, aPozita, aEkipi, aMosha, aGolat, aParaqitjet, aAsistet, akv,akk) values"
							+ "('" + aEmri + "','" + aPozita + "','" + aEkipi + "'," + aMosha + "," + aGolat + ","
							+ aParaqitjet + "," + aAsistet + "," + akv + "," + akk + ")";
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(203, 234, 119, 40);
		frmTopAsistuesi.getContentPane().add(btnNewButton_1);

		txtAsistat = new JTextField("asistet...");
		txtAsistat.setForeground(Color.BLACK);
		txtAsistat.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtAsistat.setColumns(10);
		txtAsistat.setBounds(159, 187, 80, 26);
		frmTopAsistuesi.getContentPane().add(txtAsistat);
		txtAsistat.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtAsistat.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		lblNrGolave_1 = new JLabel("");
		lblNrGolave_1.setIcon(new ImageIcon(addAssister.class.getResource("/img/assists.png")));
		lblNrGolave_1.setForeground(Color.BLACK);
		lblNrGolave_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNrGolave_1.setBounds(117, 183, 32, 32);
		frmTopAsistuesi.getContentPane().add(lblNrGolave_1);
		
		JLabel lblPozita = new JLabel("Pozita:");
		lblPozita.setForeground(Color.BLACK);
		lblPozita.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPozita.setBounds(128, 59, 62, 26);
		frmTopAsistuesi.getContentPane().add(lblPozita);

	}

	public JFrame getFrame() {
		return frmTopAsistuesi;
	}

	public void setFrame(JFrame frame) {
		this.frmTopAsistuesi = frame;
		frmTopAsistuesi.setTitle("Add Best Player");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
