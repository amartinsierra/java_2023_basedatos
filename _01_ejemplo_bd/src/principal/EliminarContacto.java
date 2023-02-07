package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EliminarContacto {

	public static void main(String[] args) {
		// Pide por teclado la introducción de un nombre y elimina el contacto con dicho nombre
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del contacto que quieres eliminar:");
		String nombre=sc.nextLine();
		//el acceso a datos
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			/*String sql="delete from contactos where nombre='"+nombre+"'";
			Statement st=con.createStatement();
			st.execute(sql);*/
			//otra alternativa: instrucciones SQL parametrizadas
			String sql="delete from contactos where nombre=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituir parámetros por sus valores
			ps.setString(1, nombre);
			//ejecución de la consulta
			ps.execute();
			System.out.println("Contacto eliminado!");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
