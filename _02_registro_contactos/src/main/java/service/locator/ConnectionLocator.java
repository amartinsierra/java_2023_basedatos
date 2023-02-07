package service.locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLocator {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		return DriverManager.getConnection(cadenaCon,user,pwd);
	}
}
