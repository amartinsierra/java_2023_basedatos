package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) {
		String cadenaCon="jdbc:mysql://localhost:3306/banco";
		String user="root";
		String pwd="root";
		//autocommit
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			con.setAutoCommit(false); //desactiva autocommit: todas operaciones en la misma tx
			String sql="update cuentas set saldo=saldo-100 where cuenta=21459";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.execute();	
			sql="update cuentas set saldo=saldo+100 where cuenta=9990";
			ps=con.prepareStatement(sql);
			ps.execute();
			con.commit(); //confirmamos tx para que las operaciones se realicen
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
