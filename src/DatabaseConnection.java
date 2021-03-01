import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class DatabaseConnection {	
	static Locale currentLang=new Locale("AL");
	static ResourceBundle lang=ResourceBundle.getBundle("Language", currentLang);
	public static Connection startConnection() {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/esuperliga?characterEncoding=UTF-8&useSSL=false", "root", "");
		
			return conn;
		} 
		catch (SQLException e) {
			
			
			JOptionPane.showMessageDialog(null, lang.getString("ConnectionError"),lang.getString("Info"),JOptionPane.ERROR_MESSAGE);
			return null;
		}
		catch (ClassNotFoundException e) {	
			JOptionPane.showMessageDialog(null, lang.getString("DBClassNotFound"),lang.getString("Info"),JOptionPane.ERROR_MESSAGE);			
			return null;
		} 
	}
}

