package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.locator.ConnectionLocator;

public class ClientesServiceImpl implements ClientesService {

	@Override
	public boolean existe(String usuario, String password) {
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			return rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
