import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TabelaRezultateve {

	private JFrame frame;
	public JTable table;	
	public JComboBox cmb_largoek = new JComboBox();
	public String largoek;
	Connection conn=null;
	ResultSet res=null;
	PreparedStatement pst=null;
	private JTextField txt_emriek;
	private JTextField txt_ndeshjet;
	private JTextField txt_fitoret;
	private JTextField txt_barazimet;
	private JTextField txt_humbjet;
	private JTextField txt_goldallimi;
	private JTextField txt_piket;
	private JLabel lbl_emriek;
	private JLabel lbl_ndeshjet;
	private JLabel lbl_fitoret;
	private JLabel lbl_barazimet;
	private JLabel lbl_humbjet;
	private JLabel lbl_goldallimi;
	private JLabel lbl_piket;
	private JLabel lblNewLabel_2;
	private JLabel lblSelektoEkipin;
	private JLabel lblNewLabel_3;
	private JLabel lblLargoEkipinNga;
	private JLabel lblstatus;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaRezultateve window = new TabelaRezultateve();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TabelaRezultateve() {
		initialize();
	}

	private void initialize() {
		cmb_largoek.setBounds(610,446,126,26);
		txt_piket = new JTextField();
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 806, 678);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 782, 327);
		getFrame().getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.setFont(new Font("Segoe UI",Font.BOLD,12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(27, 170, 178));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setSelectionBackground(new Color(232,57,95));
		table.setSelectionForeground(Color.white);
		table.setIntercellSpacing(new Dimension(0,0));
		
		

		
		FillTable();
		FillCmbLargoEk();

		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JButton btnShto = new JButton("Shto");
		btnShto.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btnShto.setForeground(new Color(255, 255, 255));
		btnShto.setBackground(new Color(51, 102, 0));
		btnShto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String emriek = txt_emriek.getText();
				int ndeshjet = Integer.parseInt(txt_ndeshjet.getText());
				int fitoret = Integer.parseInt(txt_fitoret.getText());
				int barazimet = Integer.parseInt(txt_barazimet.getText());
				int humbjet = Integer.parseInt(txt_humbjet.getText());
				int goldallimi=Integer.parseInt(txt_goldallimi.getText());
				int piket = Integer.parseInt(txt_piket.getText());				
				try {
					conn=DatabaseConnection.startConnection();
				String sql; 
				sql="insert into tabela(eID, ekipi, ndeshjet, fitoret, barazimet, humbjet, goldallimi, piket) values("
						+"null,'"+emriek+"',"+ndeshjet+","+fitoret+","+barazimet+","+humbjet+","+goldallimi+","+piket+")";
				
				pst = conn.prepareStatement(sql);
				pst.execute();
				pst.close();
				lblstatus.setText("Ekipi eshte shtuar me sukses");
				lblstatus.setForeground(new Color(51, 102, 0));
			}
			catch(Exception e2) {
				System.out.println(e2);
				System.out.println("inserti tabela");
			}
				finally {
					try {
						conn.close();
					} catch (SQLException e1) {						
						System.out.println("largo btn");
					}
				}
						
			FillTable();
			FillCmbLargoEk();
			txt_emriek.setText("");
			txt_ndeshjet.setText("");
			txt_fitoret.setText("");
			txt_barazimet.setText("");
			txt_humbjet.setText("");
			txt_goldallimi.setText("");
			txt_piket.setText("");
				
			}
		});
		btnShto.setBounds(298, 583, 96, 33);
		getFrame().getContentPane().add(btnShto);
		
		txt_emriek = new JTextField();
		txt_emriek.setBounds(91, 446, 120, 26);
		getFrame().getContentPane().add(txt_emriek);
		txt_emriek.setColumns(10);
		
		txt_ndeshjet = new JTextField();
		txt_ndeshjet.setBounds(328, 446, 120, 26);
		getFrame().getContentPane().add(txt_ndeshjet);
		txt_ndeshjet.setColumns(10);
		
		txt_fitoret = new JTextField();
		txt_fitoret.setBounds(91, 493, 120, 26);
		getFrame().getContentPane().add(txt_fitoret);
		txt_fitoret.setColumns(10);
		
		txt_barazimet = new JTextField();
		txt_barazimet.setBounds(91, 583, 120, 26);
		getFrame().getContentPane().add(txt_barazimet);
		txt_barazimet.setColumns(10);
		
		txt_humbjet = new JTextField();
		txt_humbjet.setBounds(91, 538, 120, 26);
		
		Action action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {				
				int fitoret = Integer.parseInt(txt_fitoret.getText());
				int barazimet = Integer.parseInt(txt_barazimet.getText());
				int humbjet = Integer.parseInt(txt_humbjet.getText());
				int piket =(fitoret*3)+barazimet;
		    	txt_piket.setText(""+piket+"");
		    }
		};
	
		txt_humbjet.addActionListener( action );
		getFrame().getContentPane().add(txt_humbjet);
		txt_humbjet.setColumns(10);
		
		txt_goldallimi = new JTextField();
		txt_goldallimi.setBounds(328, 493, 120, 26);
		getFrame().getContentPane().add(txt_goldallimi);
		txt_goldallimi.setColumns(10);
		
		
		txt_piket.setBounds(328, 538, 120, 26);	
		getFrame().getContentPane().add(txt_piket);
		txt_piket.setColumns(10);
		
		lbl_emriek = new JLabel("Emri:");
		lbl_emriek.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_emriek.setBounds(10, 447, 73, 21);
		getFrame().getContentPane().add(lbl_emriek);
		
		lbl_ndeshjet = new JLabel("Ndeshjet:");
		lbl_ndeshjet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ndeshjet.setBounds(235, 447, 73, 21);
		getFrame().getContentPane().add(lbl_ndeshjet);
		
		lbl_fitoret = new JLabel("Fitoret:");
		lbl_fitoret.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_fitoret.setBounds(10, 494, 73, 21);
		getFrame().getContentPane().add(lbl_fitoret);
		
		lbl_barazimet = new JLabel("Barazimet:");
		lbl_barazimet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_barazimet.setBounds(10, 588, 96, 21);
		getFrame().getContentPane().add(lbl_barazimet);
		
		lbl_humbjet = new JLabel("Humbjet:");
		lbl_humbjet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_humbjet.setBounds(10, 539, 73, 21);
		getFrame().getContentPane().add(lbl_humbjet);
		
		lbl_goldallimi = new JLabel("Goldallimi:");
		lbl_goldallimi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_goldallimi.setBounds(235, 494, 85, 21);
		getFrame().getContentPane().add(lbl_goldallimi);
		
		lbl_piket = new JLabel("Piket:");
		lbl_piket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_piket.setBounds(235, 539, 73, 21);
		getFrame().getContentPane().add(lbl_piket);
		
		JLabel lblNewLabel = new JLabel("Avancimi ne Champions League");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel.setBounds(65, 357, 243, 13);
		getFrame().getContentPane().add(lblNewLabel);
		
	    JLabel label = new JLabel("");
	    label.setBackground(new Color(77, 228, 186));
		label.setBounds(10, 357, 45, 13);
		label.setOpaque(true);
		getFrame().getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(220, 89, 121));
		lblNewLabel_1.setBounds(10, 380, 45, 13);
		lblNewLabel_1.setOpaque(true);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Largimi nga Liga");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(65, 380, 126, 13);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		JButton btn_largo = new JButton("Largo");
		btn_largo.setBackground(new Color(153, 51, 0));
		btn_largo.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btn_largo.setForeground(new Color(255, 255, 255));
	    btn_largo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//cmb_largoek.setVisible(false);
			
			JComboBox cmb_largoek1 = cmb_largoek;
			//cmb_largoek1.setBounds(70,638,110,21);
			
			largoek =String.valueOf(cmb_largoek1.getSelectedItem());
			Largoek(largoek);
			FillTable();
			FillCmbLargoEk();
			//cmb_largoek.setVisible(true);
			lblstatus.setText("Ekipi eshte larguar nga tabela");
			lblstatus.setForeground(new Color(220, 89, 121));
		}
	});
	btn_largo.setBounds(572, 496, 96, 33);
	getFrame().getContentPane().add(btn_largo);
	
	lblSelektoEkipin = new JLabel("Selekto Ekipin:");
	lblSelektoEkipin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblSelektoEkipin.setBounds(488, 447, 129, 21);
	frame.getContentPane().add(lblSelektoEkipin);
	
	lblNewLabel_3 = new JLabel("Shto ekip ne tabel");
	lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
	lblNewLabel_3.setBounds(190, 404, 118, 14);
	frame.getContentPane().add(lblNewLabel_3);
	
	lblLargoEkipinNga = new JLabel("Largo ekipin nga tabela");
	lblLargoEkipinNga.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
	lblLargoEkipinNga.setBounds(556, 404, 153, 14);
	frame.getContentPane().add(lblLargoEkipinNga);
	
	lblstatus = new JLabel("");
	lblstatus.setAlignmentX(Component.RIGHT_ALIGNMENT);
	lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblstatus.setBounds(586, 348, 194, 21);
	frame.getContentPane().add(lblstatus);

		
	
		
			
	}
	
	public void  FillTable() { 	
		
		DefaultTableModel model;
		model = new DefaultTableModel(); 
		table.setModel(model);

		
	model.addColumn("Pozita");
		model.addColumn("Ekipi");
		model.addColumn("Ndeshjet");
		model.addColumn("Fitoret");
		model.addColumn("Barazimet");
		model.addColumn("Humbjet");
		model.addColumn("Goldallimi");
		model.addColumn("Piket");

		try {		
			conn=DatabaseConnection.startConnection();
			String sql="select * from tabela order by piket desc";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			while(res.next())  
			{
			      
			    int po = res.getRow();			   			    
			    String ek = res.getString(2);  
			    int nd= res.getInt(3);  
			    int fi= res.getInt(4);  
			    int ba= res.getInt(5);  
			    int hu= res.getInt(6);  
			    int go= res.getInt(7);  
			    int pi= res.getInt(8);  
			    
			    model.addRow(new Object[]{po,ek,nd,fi,ba,hu,go,pi});

			}
			
			
			
			// texti ne center
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for(int x=0;x<model.getColumnCount();x++){
		         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		        }
			
			table.getColumnModel().getColumn(0).setCellRenderer(new CellColor());
					
			
//			while(res.next()) {//shikon per rreshtin e radhes te fituar nga databaza
//				//nese ska, false
//				if(res.getString("pid").equals("")) {
//					System.out.println("keq");
//				}
//				//nese po, true
//				else {
//					System.out.println("ok");
//				}
//			}
			pst.close();
			

		}
		catch(Exception e1) {
			System.out.println(e1);	
			System.out.println("FillTable");
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("largo btn");
			}
		}

	}
    public void FillCmbLargoEk () {
	
		cmb_largoek.removeAllItems();

		try {		
			conn=DatabaseConnection.startConnection();
			String sql="select ekipi from tabela order by piket asc limit 2";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			while(res.next())  
			{
			      //System.out.println(res.getString(1));
				cmb_largoek.addItem(res.getString(1));
			  
			}
			

			
			getFrame().getContentPane().add(cmb_largoek);
			

					
			
//			while(res.next()) {//shikon per rreshtin e radhes te fituar nga databaza
//				//nese ska, false
//				if(res.getString("pid").equals("")) {
//					System.out.println("keq");
//				}
//				//nese po, true
//				else {
//					System.out.println("ok");
//				}
//			}
			pst.close();
			

		}
		catch(Exception e1) {
			System.out.println(e1);	
			System.out.println("FillCmbLargoEk");
		}
		
		finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("largo btn");
			}
		}

    }
    
    public void FillCmbLargoEk1 () {
    	
		cmb_largoek = new JComboBox();
		cmb_largoek.setBounds(70,638,110,21);
		cmb_largoek.removeAllItems();
		System.out.println(cmb_largoek.getItemAt(0));
		try {		
			conn=DatabaseConnection.startConnection();
			String sql="select ekipi from tabela order by piket asc limit 2";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			while(res.next())  
			{
			      //System.out.println(res.getString(1));
				cmb_largoek.addItem(res.getString(1));
			  
			}
			
			System.out.println(cmb_largoek.getItemAt(0));
			
			getFrame().getContentPane().add(cmb_largoek);
			

					
			
//			while(res.next()) {//shikon per rreshtin e radhes te fituar nga databaza
//				//nese ska, false
//				if(res.getString("pid").equals("")) {
//					System.out.println("keq");
//				}
//				//nese po, true
//				else {
//					System.out.println("ok");
//				}
//			}
			pst.close();
			

		}
		catch(Exception e1) {
			System.out.println(e1);	
			System.out.println("FillCmbLargoEk");
		}
		
		finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("largo btn");
			}
		}

    }
    
    public void Largoek(String ek) {
    	 	
		try {
		conn=DatabaseConnection.startConnection();
		String sql; 
		
		sql="delete from tabela where ekipi='"+ek+"'";
		
		pst = conn.prepareStatement(sql);
		pst.execute();
		pst.close();
	    
	}
	catch(Exception e2) {
		System.out.println(e2);
		System.out.println("largo ek");
	}
		finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("largo btn");
			}
		}
    	
    }

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
    
}

 

    class CellColor extends DefaultTableCellRenderer {
	  @Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

	    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	    
	    if(isSelected) {
	    	
	    	l.setBackground(new Color(232,57,95));
		    l.setForeground(Color.white);
	    }
	    else
	    if (row<1) {
	    l.setBackground(new Color(77, 228, 186));
	    l.setForeground(Color.white);
	    }
	    else
	    if (row>table.getRowCount()-3) {
	    l.setBackground(new Color(220, 89, 121));
	    l.setForeground(Color.white);
	    }
	    else {
	    l.setBackground(Color.white);
	    l.setForeground(Color.black);
	    }
	    l.setHorizontalAlignment(SwingConstants.CENTER);
	    //l.setVerticalAlignment(SwingConstants.CENTER);
	  return l;

	  }}
