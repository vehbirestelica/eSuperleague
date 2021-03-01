import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.w3c.dom.events.EventException;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmmain {

	private JFrame frmESuperLiga;
	private final Action action = new SwingAction_1();
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frmmain window = new frmmain();
//					window.getFrame().setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public frmmain() {
		initialize();
	}

	/**
	 * Initialize the contents of the getFrame().
	 */
	public void initialize() {
		
		setFrame(new JFrame());
		getFrame().setBackground(new Color(255, 255, 255));
		getFrame().getContentPane().setBackground(new Color(255, 255, 255));
		getFrame().setBounds(100, 100, 665, 626);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon avatarimg = new ImageIcon("../img/avatar.png");
		getFrame().setIconImage(Toolkit.getDefaultToolkit().getImage(frmmain.class.getResource("/img/topi.png")));
		
		Image avatar = Toolkit.getDefaultToolkit().getImage("/img/avatar.png");
		getFrame().setIconImage(avatar); 
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(1, 1, 1, 1));
		menuBar.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(51, 102, 102));
		getFrame().setJMenuBar(menuBar);
		
		JMenu Kryefaqjamenu = new JMenu("Kryefaqja");
		Kryefaqjamenu.setForeground(Color.WHITE);
		Kryefaqjamenu.setLayout(new FlowLayout());
		Kryefaqjamenu.setPreferredSize(new Dimension(95, 40));
		Kryefaqjamenu.setHorizontalAlignment(SwingConstants.CENTER);
		Kryefaqjamenu.setIcon(new ImageIcon(frmmain.class.getResource("/img/home.png")));

		menuBar.add(Kryefaqjamenu);
		
		JMenu rezultatetmenu = new JMenu("Rezultatet");
		rezultatetmenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lojet sts2 = new lojet();
				sts2.getFrame().setVisible(true);
			}
		});
		rezultatetmenu.setForeground(Color.WHITE);
		rezultatetmenu.setLayout(new FlowLayout()); // set FlowLayout for item
		rezultatetmenu.setPreferredSize(new Dimension(95, 40));
		rezultatetmenu.setHorizontalAlignment(SwingConstants.CENTER);
		rezultatetmenu.setVerticalAlignment(SwingConstants.CENTER);
		rezultatetmenu.setIcon(new ImageIcon(frmmain.class.getResource("/img/window.png")));
		menuBar.add(rezultatetmenu);
		
		JMenu statististikatmenu = new JMenu("Statistikat");
		statististikatmenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				statistikat sts = new statistikat();
				sts.getFrame().setVisible(true);
			}
		});
		statististikatmenu.setForeground(Color.WHITE);
		statististikatmenu.setLayout(new FlowLayout()); // set FlowLayout for item
		statististikatmenu.setPreferredSize(new Dimension(95, 40));
		statististikatmenu.setHorizontalAlignment(SwingConstants.CENTER);
		statististikatmenu.setIcon(new ImageIcon(frmmain.class.getResource("/img/statistic.png")));
		menuBar.add(statististikatmenu);
		
		JMenu tabelamenu = new JMenu("Tabela");
		tabelamenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  TabelaRezultateve   tabela = new  TabelaRezultateve();
					tabela.getFrame().setVisible(true);
					
			}
		});
		tabelamenu.setForeground(Color.WHITE);
		tabelamenu.setLayout(new FlowLayout()); // set FlowLayout for item
		//tabelamenu.setPreferredSize(new Dimension(80, 40));
		tabelamenu.setHorizontalAlignment(SwingConstants.CENTER);
		tabelamenu.setIcon(new ImageIcon(frmmain.class.getResource("/img/trophy.png")));
		menuBar.add(tabelamenu);
		

		

		
		JMenu chatmenu = new JMenu(" Chat");
		chatmenu.setForeground(Color.WHITE);
		chatmenu.setLayout(new FlowLayout()); // set FlowLayout for item
		chatmenu.setPreferredSize(new Dimension(80, 40));
		chatmenu.setHorizontalAlignment(SwingConstants.CENTER);
		chatmenu.setIcon(new ImageIcon(frmmain.class.getResource("/img/arrow.png")));
		
		JMenu menuBiletat = new JMenu("Biletat");
		menuBiletat.setIcon(new ImageIcon(frmmain.class.getResource("/img/avatar.png")));
		menuBiletat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBiletat.setForeground(Color.WHITE);
		menuBiletat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  Biletat  tabelaB = new  Biletat();
					tabelaB.getFrame().setVisible(true);
					
			}
		});
		menuBar.add(menuBiletat);
		
		
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(chatmenu);
		
		JMenuItem mntmServeri = new JMenuItem("Serveri");
		mntmServeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   mainS.Main server = new mainS.Main();
					server.setVisible(true);
					server.setLocationRelativeTo(null);
				
			}
		});
	
		mntmServeri.setLayout(new FlowLayout()); // set FlowLayout for item
		mntmServeri.setPreferredSize(new Dimension(80, 40));
		mntmServeri.setIcon(new ImageIcon(frmmain.class.getResource("/img/server.png")));
		chatmenu.add(mntmServeri);
		
		JMenuItem mntmKlineti = new JMenuItem("Klineti");
		mntmKlineti.setLayout(new FlowLayout()); // set FlowLayout for item
		mntmKlineti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    mainC.Login chat = new mainC.Login();
					
						chat.setVisible(true);
						chat.setLocationRelativeTo(null);
				
			}
		});

		mntmKlineti.setPreferredSize(new Dimension(80, 40));
		mntmKlineti.setIcon(new ImageIcon(frmmain.class.getResource("/img/client.png")));
		
		chatmenu.add(mntmKlineti);
		
		JMenu Logoutmenu = new JMenu("\u00C7ky\u00E7u");
		Logoutmenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  
				try {

					JOptionPane.showMessageDialog(null,"A jeni i sigurt ?");
			
					  frmESuperLiga.dispose();
					
				}catch(EventException e){
					
					 JOptionPane.showMessageDialog(null,"Ka gabime gjate egzekutimit te komandes");
				}
				
				
				
				
			}
		});
		Logoutmenu.setForeground(Color.WHITE);
		Logoutmenu.setLayout(new FlowLayout()); // set FlowLayout for item
		Logoutmenu.setPreferredSize(new Dimension(80, 40));
		Logoutmenu.setHorizontalAlignment(SwingConstants.CENTER);
		Logoutmenu.setIcon(new ImageIcon(frmmain.class.getResource("/img/logout.png")));
	
		
		menuBar.add(Logoutmenu);
		
		
		getFrame().getContentPane().setLayout(null);
		
		JLabel logolbl = new JLabel("");
		logolbl.setBounds(328, 11, 283, 179);
		getFrame().getContentPane().add(logolbl);
		ImageIcon logo=new ImageIcon(Tabela.class.getResource("/img/logoicon.png"));
		Image logoImg=logo.getImage();
		logoImg=logoImg.getScaledInstance(logolbl.getWidth(),logolbl.getHeight(), Image.SCALE_SMOOTH);
		logolbl.setIcon(new ImageIcon(logoImg));
		
		JLabel lblNewLabel = new JLabel("E-SUPERLIGA");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(30f));
		lblNewLabel.setBounds(62, 76, 241, 37);
		getFrame().getContentPane().add(lblNewLabel);
		
		
		JLabel menaxhorezultatetlbl = new JLabel("Menaxho Rezultatet");
		menaxhorezultatetlbl.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		menaxhorezultatetlbl.setBounds(72, 318, 178, 24);
		getFrame().getContentPane().add(menaxhorezultatetlbl);
		
		JLabel menaxhoicon = new JLabel("");
		menaxhoicon.setToolTipText("");
		menaxhoicon.setBounds(62, 192, 130, 115);
		ImageIcon menaxhoicona=new ImageIcon(frmmain.class.getResource("/img/menaxho.png"));
		Image menaxhoiconaImg=menaxhoicona.getImage();
		menaxhoiconaImg=menaxhoiconaImg.getScaledInstance(menaxhoicon.getWidth(),menaxhoicon.getHeight(), Image.SCALE_SMOOTH);
		menaxhoicon.setIcon(new ImageIcon(menaxhoiconaImg));
		getFrame().getContentPane().add(menaxhoicon);
		
		
		JLabel lblKontakto = new JLabel("Kontakto ");
		lblKontakto.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblKontakto.setBounds(305, 318, 101, 24);
		getFrame().getContentPane().add(lblKontakto);
		
		JLabel Regjistroekiplbl = new JLabel("Regjistro Ekipe");
		Regjistroekiplbl.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		Regjistroekiplbl.setBounds(469, 318, 125, 24);
		getFrame().getContentPane().add(Regjistroekiplbl);
		
		JLabel kontaktoicon = new JLabel("");
		kontaktoicon.setBounds(261, 201, 152, 106);
		ImageIcon kontaktoicona=new ImageIcon(frmmain.class.getResource("/img/kontakto.png"));
		Image kontaktoiconaImg=kontaktoicona.getImage();
		kontaktoiconaImg=kontaktoiconaImg.getScaledInstance(kontaktoicon.getWidth(),kontaktoicon.getHeight(), Image.SCALE_SMOOTH);
		kontaktoicon.setIcon(new ImageIcon(kontaktoiconaImg));
		getFrame().getContentPane().add(kontaktoicon);
		
		JLabel Regjistroicon = new JLabel("");
		Regjistroicon.setBounds(459, 192, 124, 115);
		ImageIcon Regjistroicona=new ImageIcon(frmmain.class.getResource("/img/add1.png"));
		Image RegjistroiconaImg=Regjistroicona.getImage();
		RegjistroiconaImg=RegjistroiconaImg.getScaledInstance(Regjistroicon.getWidth(),Regjistroicon.getHeight(), Image.SCALE_SMOOTH);
		Regjistroicon.setIcon(new ImageIcon(RegjistroiconaImg));
		getFrame().getContentPane().add(Regjistroicon);
		
		JLabel lblShikoStatisikat = new JLabel("Menaxho Statisikat");
		lblShikoStatisikat.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblShikoStatisikat.setBounds(70, 464, 138, 24);
		getFrame().getContentPane().add(lblShikoStatisikat);
		
		JLabel statistikaicon = new JLabel("");
		statistikaicon.setBounds(78, 343, 130, 110);
		ImageIcon statistikaicona=new ImageIcon(frmmain.class.getResource("/img/statistikat.png"));
		Image statistikaiconaImg=statistikaicona.getImage();
		statistikaiconaImg=statistikaiconaImg.getScaledInstance(statistikaicon.getWidth(),statistikaicon.getHeight(), Image.SCALE_SMOOTH);
		statistikaicon.setIcon(new ImageIcon(statistikaiconaImg));
		getFrame().getContentPane().add(statistikaicon);
		
		JLabel lblkerkoekipe = new JLabel("");
		lblkerkoekipe.setBounds(274, 343, 129, 110);
		ImageIcon lblkerkoekipet=new ImageIcon(frmmain.class.getResource("/img/kerko.png"));
		Image lblkerkoekipetImg=lblkerkoekipet.getImage();
		lblkerkoekipetImg=lblkerkoekipetImg.getScaledInstance(lblkerkoekipe.getWidth(),lblkerkoekipe.getHeight(), Image.SCALE_SMOOTH);
		lblkerkoekipe.setIcon(new ImageIcon(lblkerkoekipetImg));
		getFrame().getContentPane().add(lblkerkoekipe);
		
		JLabel kerkoekipeicon = new JLabel("Kerko Ekipe dhe Lojtare");
		kerkoekipeicon.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		kerkoekipeicon.setBounds(261, 464, 178, 24);
		getFrame().getContentPane().add(kerkoekipeicon);
		
		JLabel ndihmaicon = new JLabel("");
		ndihmaicon.setBounds(459, 353, 130, 110);
		ImageIcon ndihmaicona=new ImageIcon(frmmain.class.getResource("/img/ndihma.png"));
		Image ndihmaiconaImg=ndihmaicona.getImage();
		ndihmaiconaImg=ndihmaiconaImg.getScaledInstance(ndihmaicon.getWidth(),ndihmaicon.getHeight(), Image.SCALE_SMOOTH);
		ndihmaicon.setIcon(new ImageIcon(ndihmaiconaImg));
		getFrame().getContentPane().add(ndihmaicon);
		
		JLabel lblNdihma = new JLabel("Biletat");
		lblNdihma.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblNdihma.setBounds(503, 464, 59, 24);
		getFrame().getContentPane().add(lblNdihma);
		
		JLabel lblEsuperliga = new JLabel("E-Superliga 2020 - All right reserved");
		lblEsuperliga.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		lblEsuperliga.setForeground(new Color(51, 102, 0));
		lblEsuperliga.setBounds(10, 520, 198, 14);
		getFrame().getContentPane().add(lblEsuperliga);
		
	}

	public JFrame getFrame() {
		return frmESuperLiga;
	}

	public void setFrame(JFrame frame) {
		this.frmESuperLiga = frame;
		frmESuperLiga.setTitle("E-Super liga");
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
