

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class mostSaves {

	private JFrame frmPortjeriMeMe;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtPritjet;
	private JTextField txtNdeshjetPaPesuar;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet res = null;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mostSaves window = new mostSaves();
					window.frmPortjeriMeMe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mostSaves() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPortjeriMeMe = new JFrame();
		frmPortjeriMeMe.setTitle("Portjeri Me Me Se Shumti Pritje");
		frmPortjeriMeMe.setBounds(330, 375, 335, 336);
		frmPortjeriMeMe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPortjeriMeMe.getContentPane().setLayout(null);

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
		btnNewButton.setIcon(new ImageIcon(mostSaves.class.getResource("/img/saves.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 24, 108, 95);
		frmPortjeriMeMe.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Emri:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(128, 22, 62, 26);
		frmPortjeriMeMe.getContentPane().add(lblNewLabel);

		textField = new JTextField("lojtari...");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(189, 24, 96, 26);
		frmPortjeriMeMe.getContentPane().add(textField);
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

		JLabel lblEkipi = new JLabel("Ekipi:");
		lblEkipi.setForeground(Color.BLACK);
		lblEkipi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEkipi.setBounds(128, 60, 62, 26);
		frmPortjeriMeMe.getContentPane().add(lblEkipi);

		textField_2 = new JTextField("ekipi...");
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(189, 61, 96, 27);
		frmPortjeriMeMe.getContentPane().add(textField_2);
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
		lblMosha.setBounds(128, 99, 62, 26);
		frmPortjeriMeMe.getContentPane().add(lblMosha);

		textField_3 = new JTextField("");
		textField_3.setForeground(Color.GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(190, 96, 95, 27);
		frmPortjeriMeMe.getContentPane().add(textField_3);
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

		JButton btnNewButton_1 = new JButton("Shto te dhenat");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DatabaseConnection.startConnection();
//					//Insertimi i te dhenave per rreshtin 1
					String sEmri = textField.getText();
					String sEkipi = textField_2.getText();
					int sMosha = Integer.parseInt(textField_3.getText());
					int sPritjet = Integer.parseInt(txtPritjet.getText());
					int sGolatPranuar = Integer.parseInt(textField_1.getText());
					int sPortaPaprekur = Integer.parseInt(txtNdeshjetPaPesuar.getText());

					String sql = "insert into mostSaves(sEmri, sEkipi, sMosha, sPritjet, sGolatPranuar, sPortaPaprekur) values"
							+ "('" + sEmri + "','" + sEkipi + "'," + sMosha + "," + sPritjet + "," + sGolatPranuar + ","
							+ sPortaPaprekur + ")";
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
		btnNewButton_1.setBounds(94, 235, 119, 30);
		frmPortjeriMeMe.getContentPane().add(btnNewButton_1);

		JLabel lblPritjet = new JLabel("Pritjet:");
		lblPritjet.setForeground(Color.BLACK);
		lblPritjet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPritjet.setBounds(10, 140, 62, 26);
		frmPortjeriMeMe.getContentPane().add(lblPritjet);

		txtPritjet = new JTextField("pritjet...");
		txtPritjet.setForeground(Color.BLACK);
		txtPritjet.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPritjet.setColumns(10);
		txtPritjet.setBounds(60, 141, 45, 27);
		frmPortjeriMeMe.getContentPane().add(txtPritjet);
		txtPritjet.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPritjet.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblGolaTePranuar = new JLabel("Gola te pranuar: ");
		lblGolaTePranuar.setForeground(Color.BLACK);
		lblGolaTePranuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGolaTePranuar.setBounds(115, 140, 118, 26);
		frmPortjeriMeMe.getContentPane().add(lblGolaTePranuar);

		JLabel lblPortaTePaprekura = new JLabel("Porta te paprekura: ");
		lblPortaTePaprekura.setForeground(Color.BLACK);
		lblPortaTePaprekura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPortaTePaprekura.setBounds(10, 187, 146, 26);
		frmPortjeriMeMe.getContentPane().add(lblPortaTePaprekura);

		txtNdeshjetPaPesuar = new JTextField("ndeshjet pa pesuar gola...");
		txtNdeshjetPaPesuar.setForeground(Color.BLACK);
		txtNdeshjetPaPesuar.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtNdeshjetPaPesuar.setColumns(10);
		txtNdeshjetPaPesuar.setBounds(139, 187, 146, 26);
		frmPortjeriMeMe.getContentPane().add(txtNdeshjetPaPesuar);

		textField_1 = new JTextField();
		textField_1.setBounds(226, 142, 59, 26);
		frmPortjeriMeMe.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		txtNdeshjetPaPesuar.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNdeshjetPaPesuar.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	public JFrame getFrame() {
		return frmPortjeriMeMe;
	}

	public void setFrame(JFrame frame) {
		this.frmPortjeriMeMe = frame;
		frame.setTitle("Portjeri Me Me Se Shumti Pritje");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}

}
