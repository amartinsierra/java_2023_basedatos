package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;
import service.locator.ConnectionLocator;

public class ContactosServiceImpl implements ContactosService {	
	@Override
	public void agregarContacto(Contacto contacto) {
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void eliminarContacto(String nombre) {
		try(Connection con=ConnectionLocator.getConnection();){
			//Establecer conexión con base de datos
			String sql="delete from contactos where nombre=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void modificarEmail(String nombre, String nuevoEmail) {
		try(Connection con=ConnectionLocator.getConnection();){
			//Establecer conexión con base de datos
			String sql="update contactos set email=? where nombre=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, nuevoEmail);
			ps.setString(2, nombre);
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Contacto> contactos() {
		List<Contacto> contactos=new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from contactos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql); //forwardonly
			while(rs.next()) {
				contactos.add(new Contacto(rs.getInt("idContacto"),
										rs.getString("nombre"),
										rs.getString("email"),
										rs.getInt("edad")));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
}
