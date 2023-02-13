package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libro;
import service.locator.ConnectionLocator;

public class LibrosServiceImpl implements LibrosService {

	@Override
	public List<Libro> libros() {
		List<Libro> libros= new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from libros";
			PreparedStatement ps=con.prepareStatement(sql); //Lanzar consultas a la base de datos
			ResultSet rs=ps.executeQuery(); //forwardonly
			while(rs.next()) {
				libros.add(new Libro(rs.getInt("isbn"), 
										rs.getString("titulo"),
										rs.getString("autor"), 
										rs.getDouble("precio"),
										rs.getInt("paginas"),
										rs.getInt("idTema")));			
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return libros;
	}

}
