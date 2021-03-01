

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class addPlayer {
	Connection conn = null;
	private JFrame frmAddBestPlayer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtGolat;
	private JTextField textField_3;
	private JTextField txtParaqitjet;
	private JTextField txtKartonaTeVerdhe;
	private JTextField txtKartonaTeKuq;
	PreparedStatement pst = null;
	ResultSet res = null;
	private JTextField txtPozita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addPlayer window = new addPlayer();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addPlayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(300, 350, 373, 379);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(addPlayer.class.getResource("/img/add.png")));
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 76, 108, 95);
		getFrame().getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Emri:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(128, 69, 62, 26);
		getFrame().getContentPane().add(lblNewLabel);

		JLabel lblEkipi = new JLabel("Ekipi:");
		lblEkipi.setForeground(Color.BLACK);
		lblEkipi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEkipi.setBounds(128, 145, 62, 26);
		getFrame().getContentPane().add(lblEkipi);

		JLabel lblNrGolave = new JLabel("");
		lblNrGolave.setIcon(new ImageIcon(addPlayer.class.getResource("/img/topi.png")));
		lblNrGolave.setForeground(Color.BLACK);
		lblNrGolave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNrGolave.setBounds(10, 232, 24, 24);
		getFrame().getContentPane().add(lblNrGolave);

		JButton btnNewButton_1 = new JButton("Shto te dhenat");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DatabaseConnection.startConnection();
//					//Insertimi i te dhenave per rreshtin 1
					String pemri = textField.getText();
					String ppozita = txtPozita.getText();
					String pekipi = textField_1.getText();
					int pmosha = Integer.parseInt(textField_3.getText());
					String pfoto = btnNewButton.getText();
					int pgolat = Integer.parseInt(txtGolat.getText());
					int pparaqitjet = Integer.parseInt(txtParaqitjet.getText());
					int pkv = Integer.parseInt(txtKartonaTeVerdhe.getText());
					int pkk = Integer.parseInt(txtKartonaTeKuq.getText());

					String sql = "insert into addPlayer(Pemri,Ppozita,Pekipi,Pmosha,Pgolat,Pparaqitjet,Pkv,Pkk) values"
							+ "('" + pemri + "','" + ppozita + "','" + pekipi + "'," + pmosha + "," + pgolat + ","
							+ pparaqitjet + "," + pkv + "," + pkk + ")";
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
		btnNewButton_1.setBounds(210, 276, 122, 36);
		getFrame().getContentPane().add(btnNewButton_1);

		textField = new JTextField("lojtari...");
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
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

		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(178, 71, 154, 26);
		frmAddBestPlayer.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField("ekipi...");
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
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setColumns(10);
		textField_1.setBounds(178, 143, 154, 26);
		frmAddBestPlayer.getContentPane().add(textField_1);

		txtGolat = new JTextField("golat...");
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
		txtGolat.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtGolat.setForeground(new Color(0, 0, 0));
		txtGolat.setColumns(10);
		txtGolat.setBounds(44, 230, 101, 26);
		frmAddBestPlayer.getContentPane().add(txtGolat);

		JLabel lblMosha = new JLabel("Mosha:");
		lblMosha.setForeground(Color.BLACK);
		lblMosha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMosha.setBounds(128, 182, 62, 26);
		frmAddBestPlayer.getContentPane().add(lblMosha);

		textField_3 = new JTextField("");
		textField_3.setForeground(Color.GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(178, 180, 154, 26);
		frmAddBestPlayer.getContentPane().add(textField_3);

		JLabel lblParaqitjet = new JLabel("");
		lblParaqitjet.setIcon(new ImageIcon(addPlayer.class.getResource("/img/paraqitjet.png")));
		lblParaqitjet.setForeground(Color.BLACK);
		lblParaqitjet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParaqitjet.setBounds(179, 232, 24, 24);
		frmAddBestPlayer.getContentPane().add(lblParaqitjet);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(addPlayer.class.getResource("/img/yellowcard.png")));
		lblNewLabel_1.setBounds(10, 278, 24, 34);
		frmAddBestPlayer.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(addPlayer.class.getResource("/img/red card.png")));
		lblNewLabel_1_1.setBounds(110, 276, 24, 36);
		frmAddBestPlayer.getContentPane().add(lblNewLabel_1_1);

		txtParaqitjet = new JTextField("paraqitjet...");
		txtParaqitjet.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtParaqitjet.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtParaqitjet.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtParaqitjet.setForeground(new Color(0, 0, 0));
		txtParaqitjet.setColumns(10);
		txtParaqitjet.setBounds(213, 232, 119, 26);
		frmAddBestPlayer.getContentPane().add(txtParaqitjet);

		txtKartonaTeVerdhe = new JTextField("kartona te verdhe");
		txtKartonaTeVerdhe.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtKartonaTeVerdhe.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtKartonaTeVerdhe.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtKartonaTeVerdhe.setForeground(new Color(0, 0, 0));
		txtKartonaTeVerdhe.setColumns(10);
		txtKartonaTeVerdhe.setBounds(44, 283, 56, 24);
		frmAddBestPlayer.getContentPane().add(txtKartonaTeVerdhe);

		txtKartonaTeKuq = new JTextField("kartona te kuq...");
		txtKartonaTeKuq.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtKartonaTeKuq.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtKartonaTeKuq.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtKartonaTeKuq.setForeground(new Color(0, 0, 0));
		txtKartonaTeKuq.setColumns(10);
		txtKartonaTeKuq.setBounds(144, 282, 56, 26);
		frmAddBestPlayer.getContentPane().add(txtKartonaTeKuq);

		txtPozita = new JTextField("pozita...");
		txtPozita.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPozita.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPozita.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtPozita.setForeground(new Color(0, 0, 0));
		txtPozita.setColumns(10);
		txtPozita.setBounds(178, 108, 154, 26);
		frmAddBestPlayer.getContentPane().add(txtPozita);
		
		JLabel lblPozita = new JLabel("Pozita");
		lblPozita.setForeground(Color.BLACK);
		lblPozita.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPozita.setBounds(128, 108, 62, 26);
		frmAddBestPlayer.getContentPane().add(lblPozita);
		
		JLabel lblLojtariMI = new JLabel("Lojtari m\u00EB i mir\u00EB");
		lblLojtariMI.setForeground(Color.BLACK);
		lblLojtariMI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLojtariMI.setBounds(94, 21, 176, 26);
		frmAddBestPlayer.getContentPane().add(lblLojtariMI);

	}

	public JFrame getFrame() {
		return frmAddBestPlayer;
	}

	public void setFrame(JFrame frame) {
		this.frmAddBestPlayer = frame;
		frmAddBestPlayer.setTitle("Lojtari Me I Mire");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}
