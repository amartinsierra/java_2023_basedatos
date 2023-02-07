package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Curso;
import service.locator.ConnectionLocator;

public class CursosServiceImpl implements CursosService {

	@Override
	public List<Curso> cursosPorFechaInicioMax(LocalDate fechaLimite) {
		List<Curso> cursos=new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from cursos where fechaInicio<=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//debemos convertir el LocalDate en java.sql.Date
			ps.setDate(1, Date.valueOf(fechaLimite));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cursos.add(new Curso(rs.getInt("idCurso"),
						rs.getString("nombre"),
						rs.getDouble("precio"),
						rs.getInt("duracion"),
						rs.getDate("fechaInicio").toLocalDate() //convertimos java.sql.Date a LocalDate
						));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return cursos;
	}

}
