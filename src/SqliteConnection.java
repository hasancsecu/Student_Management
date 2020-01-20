import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class SqliteConnection {

	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("JDBC:sqlite:D:\\Java-Workspace\\StudentManagement\\ResultSheet.sqlite");
			return con;
		
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
