import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

public class Biletat {

	private static String key;
	private JFrame frame;
	public static JTable table;
	public static DefaultTableModel model;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biletat window = new Biletat();
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
	public Biletat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 425);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 540, 325);
		frame.getContentPane().add(scrollPane);
		
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
		
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Biletat ne disposicion per ndeshjet");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 245, 27);
		frame.getContentPane().add(lblNewLabel);
			
		Apiconnection();
	}
  public void Apiconnection() {
	  HttpClient client = HttpClient.newHttpClient();
	

	  HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/getLojet")).build();
	  client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
	  	.thenApply(HttpResponse::body)
	  	.thenAccept(Biletat::parse)
	  	.join();
	  
  };
  
  public static String parse (String responseBody) {
		model = new DefaultTableModel(); 
		table.setModel(model);

		
		model.addColumn("Vendas");
		model.addColumn("Musafir");
		model.addColumn("Nr. Biletave");
		
	  JSONArray lojet = new JSONArray (responseBody);
	  for  (int i = 0; i< lojet.length();i++) {
		  JSONObject loja = lojet.getJSONObject(i);
		 
		  String vendas = loja.getString("vendas");
		  String musafir = loja.getString("musafir");
		  int nrbiletave = loja.getInt("nrbiletave");
		  //System.out.println(id + "  "+ vendas +" " + musafir +" " + nrbiletave);

		  model.addRow(new Object[]{vendas,musafir,nrbiletave});
	  }
	  return null;
  };
  
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setTitle("");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
  
}