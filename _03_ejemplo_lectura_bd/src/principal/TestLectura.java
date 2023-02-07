package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestLectura {

	public static void main(String[] args) {
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		//Establecer conexión con base de datos
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			String sql="select * from contactos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql); //forwardonly
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
