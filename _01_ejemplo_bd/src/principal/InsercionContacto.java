package principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InsercionContacto {

	public static void main(String[] args) {
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		//Establecer conexión con base de datos
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			//Envío de instrucción SQL
			String sql="insert into contactos(nombre,email,edad) values('Irene','pruebas@gmail.com',19)";
			Statement st=con.createStatement(); //objeto para envío de instrucción SQL
			st.execute(sql); //envío de instrucción
			System.out.println("contacto añadido!");
		}//cerrar conexión
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
