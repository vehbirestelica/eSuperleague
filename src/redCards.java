

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class redCards {

	private JFrame frmLojtariMeMe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
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
					redCards window = new redCards();
					window.frmLojtariMeMe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public redCards() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLojtariMeMe = new JFrame();
		frmLojtariMeMe.getContentPane().setBackground(new Color(255, 255, 255));
		frmLojtariMeMe.setTitle("Lojtari Me Me Se Shumti Kartona Te Kuq");
		frmLojtariMeMe.setBounds(330, 375, 374, 327);
		frmLojtariMeMe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frmLojtariMeMe.addWindowListener(new java.awt.event.WindowAdapter() {
//		    @Override
//		    public void windowClosing(java.awt.event.WindowEvent e) {
//		        System.out.println("Uncomment following to open another window!");
//		        //MainPage m = new MainPage();
//		        //m.setVisible(true);
//		        e.getWindow().dispose();
//		        System.out.println("JFrame Closed!");
//		    }
//		});
//		frmLojtariMeMe.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(21, 20, 112, 131);
		btnNewButton.setIcon(
				new ImageIcon(redCards.class.getResource("/img/football-soccer-hand-yellow-red-card-512.png")));
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
		frmLojtariMeMe.getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmLojtariMeMe.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Emri:");
		lblNewLabel.setBounds(143, 23, 62, 26);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmLojtariMeMe.getContentPane().add(lblNewLabel);

		textField = new JTextField("lojtari...");
		textField.setBounds(210, 25, 130, 26);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField.setColumns(10);
		frmLojtariMeMe.getContentPane().add(textField);
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
		textField_1.setBounds(210, 62, 130, 24);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		frmLojtariMeMe.getContentPane().add(textField_1);
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
		lblEkipi.setBounds(143, 94, 62, 26);
		lblEkipi.setForeground(Color.BLACK);
		lblEkipi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmLojtariMeMe.getContentPane().add(lblEkipi);

		textField_2 = new JTextField("ekipi...");
		textField_2.setBounds(210, 97, 130, 24);
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_2.setColumns(10);
		frmLojtariMeMe.getContentPane().add(textField_2);
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
		lblMosha.setBounds(143, 128, 62, 26);
		lblMosha.setForeground(Color.BLACK);
		lblMosha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmLojtariMeMe.getContentPane().add(lblMosha);

		textField_3 = new JTextField("");
		textField_3.setBounds(210, 132, 130, 23);
		textField_3.setForeground(Color.GRAY);
		textField_3.setColumns(10);
		frmLojtariMeMe.getContentPane().add(textField_3);

		JSpinner kk = new JSpinner();
		kk.setBounds(196, 173, 50, 26);
		kk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmLojtariMeMe.getContentPane().add(kk);

		JSpinner kv = new JSpinner();
		kv.setBounds(290, 173, 50, 26);
		kv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmLojtariMeMe.getContentPane().add(kv);

		JButton btnNewButton_1 = new JButton("Shto te dhenat");
		btnNewButton_1.setBackground(new Color(0, 51, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(143, 225, 119, 39);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DatabaseConnection.startConnection();
//					//Insertimi i te dhenave per rreshtin 1
					String rEmri = textField.getText();
					String rPozita = textField_1.getText();
					String rEkipi = textField_2.getText();
					int rMosha = Integer.parseInt(textField_3.getText());
					String pfoto = btnNewButton.getText();
					int rParaqitjet = Integer.parseInt(textField_5.getText());
					Integer rkk = (Integer) kk.getValue();
					Integer rkv = (Integer) kv.getValue();

					String sql = "insert into mostRedCards(rEmri, rPozita, rEkipi, rMosha, rParaqitjet, rkk,rkv) values"
							+ "('" + rEmri + "','" + rPozita + "','" + rEkipi + "'," + rMosha + "," + rParaqitjet + ","
							+ rkk + "," + rkv + ")";
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
		frmLojtariMeMe.getContentPane().add(btnNewButton_1);

		JLabel lblParaqitjet = new JLabel("");
		lblParaqitjet.setBounds(21, 175, 24, 24);
		lblParaqitjet.setIcon(new ImageIcon(redCards.class.getResource("/img/paraqitjet.png")));
		lblParaqitjet.setForeground(Color.BLACK);
		lblParaqitjet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmLojtariMeMe.getContentPane().add(lblParaqitjet);

		textField_5 = new JTextField("paraqitjet...");
		textField_5.setBounds(49, 173, 96, 26);
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textField_5.setColumns(10);
		frmLojtariMeMe.getContentPane().add(textField_5);
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
		lblNewLabel_1.setBounds(262, 175, 18, 24);
		lblNewLabel_1.setIcon(new ImageIcon(redCards.class.getResource("/img/yellowcard.png")));
		frmLojtariMeMe.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(166, 175, 18, 24);
		lblNewLabel_1_1.setIcon(new ImageIcon(redCards.class.getResource("/img/red card.png")));
		frmLojtariMeMe.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblPozita = new JLabel("Pozita");
		lblPozita.setForeground(Color.BLACK);
		lblPozita.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPozita.setBounds(143, 60, 62, 26);
		frmLojtariMeMe.getContentPane().add(lblPozita);

	}

	public JFrame getFrame() {
		return frmLojtariMeMe;
	}

	public void setFrame(JFrame frame) {
		this.frmLojtariMeMe = frame;
		frame.setTitle("Lojtari Me Me Se Shumti Kartona Te Kuq");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}

}
