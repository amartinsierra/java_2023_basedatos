package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		//autocommit
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			int edad=30;
			String sql="delete from contactos where edad<?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, edad);
			//autocommit: si falla la eliminación de uno de los contactos, se deshacen
			//las eliminaciones anteriores. Si no falla, se confirma la transacción
			ps.execute();			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
