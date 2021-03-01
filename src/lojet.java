import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class lojet {

	private JFrame frame;
	public JTable table;
	Connection conn=null;
	ResultSet res=null;
	PreparedStatement pst=null;
	public String[] str_array;
	public int nrekipeve = 0;
	private JTextField txt_golatek1;
	private JTextField txt_golatek2;
	public JComboBox cmb_ekipi1;
	public JComboBox cmb_ekipi2;
	public JComboBox cmb_javashto;
	public JComboBox cmb_java;
	private JLabel lblSelektoJavenPer;
	private JLabel lblShtoRezultatetE;
	private JLabel label;
	private JLabel lblEkipiVendas;
	private JLabel lblEkipiMysafir;
	private JLabel lblRezultati;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lojet window = new lojet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public lojet() {
		initialize();
	}

	private void initialize() {
		cmb_ekipi1 = new JComboBox();
		cmb_ekipi2 = new JComboBox();
		
		setFrame(new JFrame());
		frame.setBounds(100, 100, 703, 692);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 687, 327);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(27, 170, 178));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setSelectionBackground(new Color(51, 153, 204));
		table.setSelectionForeground(Color.white);
		table.setIntercellSpacing(new Dimension(0,0));
		
		table.setRowHeight(25);
		scrollPane.setViewportView(table);

		
		try {		
			conn=DatabaseConnection.startConnection();
			String sql="select ekipi from tabela order by piket desc";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			
			while (res.next()) {
				nrekipeve++;
				
			}
			
			
			pst.close();
			

		}
		catch(Exception e1) {
			System.out.println(e1);	
			System.out.println("nrekipeve");
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("largo btn");
			}
		}
		
		fillcmbek();
				
		cmb_ekipi1.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    			        
			    String[] str_array1 = str_array;
		        List<String> list = new ArrayList<String>(Arrays.asList(str_array1));
		        
		        list.remove(cmb_ekipi1.getSelectedIndex());
		        str_array1 = list.toArray(new String[1]);
		        cmb_ekipi2.setModel(new DefaultComboBoxModel(str_array1));
		        
		    }
		});
		cmb_ekipi1.setBounds(80, 498, 151, 32);
		frame.getContentPane().add(cmb_ekipi1);
		
		cmb_ekipi2.setBounds(440, 498, 151, 32);
		frame.getContentPane().add(cmb_ekipi2);
		
		txt_golatek1 = new JTextField();
		txt_golatek1.setBounds(253, 498, 68, 32);
		frame.getContentPane().add(txt_golatek1);
		txt_golatek1.setColumns(10);
		
		txt_golatek2 = new JTextField();
		txt_golatek2.setBounds(347, 498, 68, 32);
		frame.getContentPane().add(txt_golatek2);
		txt_golatek2.setColumns(10);
		
		JButton btn_shto = new JButton("Shto");
		btn_shto.setForeground(new Color(255, 255, 255));
		btn_shto.setBackground(new Color(51, 102, 0));
		btn_shto.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btn_shto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String.valueOf(cmb_ekipi1.getSelectedItem()).equals("") || String.valueOf(cmb_ekipi2.getSelectedItem()).equals(""))==false) {
					
				int golatek1 = -33;
				int golatek2 = -33;
				try {
				golatek1 = Integer.parseInt(txt_golatek1.getText());
				golatek2 = Integer.parseInt(txt_golatek2.getText());
				}
				
				catch(Exception e1) {
					
					System.out.println("update tabela"+e1);
					JOptionPane.showMessageDialog(new JFrame(), "Golat duhet te jene numra te plote");
				}
				
				if (golatek1 !=-33 && golatek1 >-1 ) {	
					if (golatek2 !=-33 && golatek2 >-1 ) {	
				int goldallimiek1 =golatek1-golatek2;
				int goldallimiek2 =golatek2-golatek1;
				try {
					conn=DatabaseConnection.startConnection();
					String sql,sql1; 
					if (golatek1>golatek2) {
					sql="update tabela set piket = piket+"+3+", goldallimi=goldallimi+"+goldallimiek1+",ndeshjet=ndeshjet+1,fitoret=fitoret+1 where ekipi='"+String.valueOf(cmb_ekipi1.getSelectedItem())+"'";
							sql1="update tabela set goldallimi=goldallimi+"+goldallimiek2+",ndeshjet=ndeshjet+1, humbjet=humbjet+1 where ekipi='"+String.valueOf(cmb_ekipi2.getSelectedItem())+"'";
					
					}
					else 
						if(golatek1<golatek2)
					{
				    sql="update tabela set piket = piket+"+3+", goldallimi=goldallimi+"+goldallimiek2+",ndeshjet=ndeshjet+1,fitoret=fitoret+1 where ekipi='"+String.valueOf(cmb_ekipi2.getSelectedItem())+"'";
				    sql1="update tabela set goldallimi=goldallimi+"+goldallimiek1+",ndeshjet=ndeshjet+1,humbjet=humbjet+1 where ekipi='"+String.valueOf(cmb_ekipi1.getSelectedItem())+"'";
					}
					else 
					
					{
						sql="update tabela set piket = piket+"+1+", goldallimi=goldallimi+"+goldallimiek1+",ndeshjet=ndeshjet+1,barazimet=barazimet+1 where ekipi='"+String.valueOf(cmb_ekipi1.getSelectedItem())+"'";
						sql1="update tabela set piket = piket+"+1+", goldallimi=goldallimi+"+goldallimiek2+",ndeshjet=ndeshjet+1,barazimet=barazimet+1 where ekipi='"+String.valueOf(cmb_ekipi2.getSelectedItem())+"'";
					}
					

					pst = conn.prepareStatement(sql);
					pst.executeUpdate();
					pst = conn.prepareStatement(sql1);
					pst.executeUpdate();
					pst.close();
				    //JOptionPane.showMessageDialog(new Jframe(), "Sukses");
				}
				catch(Exception e2) {
					System.out.println("update tabela"+e2);
				}
				
				finally {
					try {
						conn.close();
					} catch (SQLException e1) {						
						System.out.println("update tabela con close btn");
					}
				}
				
				try {
					conn=DatabaseConnection.startConnection();
				String sql; 
				sql="insert into lojet(lojaID, ekipi1, ekipi1_golat, ekipi2, ekipi2_golat,java) values("
				+"null,'"+String.valueOf(cmb_ekipi1.getSelectedItem())+"',"+golatek1+",'"+String.valueOf(cmb_ekipi2.getSelectedItem())+"',"+golatek2+","+Integer.parseInt(String.valueOf(cmb_javashto.getSelectedItem()))+")";
				
						
				
				pst = conn.prepareStatement(sql);
				pst.execute();
				pst.close();
			    JOptionPane.showMessageDialog(new JFrame(), "Sukses");
			}
			catch(Exception e2) {
				System.out.println(e2);
				System.out.println("inserti lojet");
			}
				finally {
					try {
						conn.close();
					} catch (SQLException e1) {						
						System.out.println("largo btn");
					}
				}
				
						
				TabelaRezultateve obj = new TabelaRezultateve();
				obj.getFrame().setVisible(true);
				obj.getFrame().setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				
			}}
				
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Golat duhet te jene numra pozitiv");
				}
			}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Selekto ekipet!");
				}
				
				FillTable();
			}								
		});
		btn_shto.setBounds(283, 557, 97, 32);
		frame.getContentPane().add(btn_shto);
		
		cmb_javashto = new JComboBox();
		cmb_javashto.setBackground(new Color(255, 255, 255));
		cmb_javashto.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cmb_javashto.setBounds(169, 415, 52, 32);
		frame.getContentPane().add(cmb_javashto);
		
		cmb_java = new JComboBox();
		cmb_java.setBackground(new Color(255, 255, 255));
		cmb_java.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cmb_java.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	FillTable();
		    }
		});
		cmb_java.setBounds(269, 10, 52, 32);
		frame.getContentPane().add(cmb_java);
		
		lblSelektoJavenPer = new JLabel("Selekto javen per ti paraqitur reziltatet");
		lblSelektoJavenPer.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblSelektoJavenPer.setBounds(10, 11, 264, 28);
		frame.getContentPane().add(lblSelektoJavenPer);
		
		lblShtoRezultatetE = new JLabel("Shto rezultatet e javes :");
		lblShtoRezultatetE.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblShtoRezultatetE.setBounds(10, 418, 149, 25);
		frame.getContentPane().add(lblShtoRezultatetE);
		
		label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(331, 496, 6, 30);
		frame.getContentPane().add(label);
		
		lblEkipiVendas = new JLabel("Ekipi Vendas");
		lblEkipiVendas.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblEkipiVendas.setBounds(115, 469, 106, 18);
		frame.getContentPane().add(lblEkipiVendas);
		
		lblEkipiMysafir = new JLabel("Ekipi Mysafir");
		lblEkipiMysafir.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblEkipiMysafir.setBounds(459, 469, 106, 18);
		frame.getContentPane().add(lblEkipiMysafir);
		
		lblRezultati = new JLabel("Rezultati");
		lblRezultati.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblRezultati.setBounds(309, 469, 106, 18);
		frame.getContentPane().add(lblRezultati);
		
		FillTable();
	}
	
	public void  FillTable() { 	
		
		DefaultTableModel model;
		model = new DefaultTableModel(); 
		table.setModel(model);

		

		model.addColumn("Vendas");
		model.addColumn("");
		model.addColumn("");
		model.addColumn("Musafir");

		try {		
			conn=DatabaseConnection.startConnection();
			String sql="select * from lojet where java ="+Integer.parseInt(String.valueOf(cmb_java.getSelectedItem()))+";";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			while(res.next())  
			{
			      
			    //int po = res.getRow();			   			    
			    String Vendas = res.getString(2);  
			    int golatvd= res.getInt(3);  
			    String Musafir = res.getString(4);  
			    int golatmf= res.getInt(5);  

			    
			    model.addRow(new Object[]{Vendas,golatvd,golatmf,Musafir});

			}
			
			
			
			// texti ne center
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for(int x=0;x<model.getColumnCount();x++){
		         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		        }
			
			//table.getColumnModel().getColumn(0).setCellRenderer(new CellColor());
							

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
	
	public void fillcmbek() {
		DefaultComboBoxModel model;
		model = new DefaultComboBoxModel(); 
		str_array = null;
		
		try {		
			conn=DatabaseConnection.startConnection();
			String sql="select ekipi from tabela order by piket desc";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			model.addElement("");
			str_array =new String [nrekipeve+1];
			str_array[0]="";
			while(res.next())  
			{		      			   			    
			    String ek = res.getString(1);			   
			    
			    str_array[res.getRow()] =res.getString(1);			    
			    model.addElement(ek);
			

			}		
					
			pst.close();
			

		}
		catch(Exception e1) {
			System.out.println(e1);	
			System.out.println("fill cmb");
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("conn close model cmb_ekipi1");
			}
		}
		cmb_ekipi1.setModel(model);
	}


	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setTitle("");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}


	
}
