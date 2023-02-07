package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.Pedido;
import service.locator.ConnectionLocator;

public class PedidosTiendasServiceImpl implements PedidosTiendasService {

	@Override
	public List<Pedido> pedidosTienda(String dirFichero) {
		Path pt=Path.of(dirFichero);
		try{
			return Files.lines(pt)//Stream<String>
			.map(s->{
				String[] datos=s.split("[,]");
				return new Pedido(0,datos[0],Integer.parseInt(datos[1]),LocalDate.parse(datos[2]));
			})
			.toList();
		}catch(IOException ex) {
			ex.printStackTrace();
			return List.of(); //lista vacía
		}
	}

	@Override
	public void guardarPedido(Pedido pedido) {
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="insert into pedidos(producto,unidades,fecha) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, pedido.getProducto());
			ps.setInt(2, pedido.getUnidades());
			ps.setDate(3, Date.valueOf(pedido.getFecha()));
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void guardarPedidos(List<Pedido> pedidos) {
		try(Connection con=ConnectionLocator.getConnection();){
			//desactivamos autocommit para que todos los insert estén en
			//la misma tx
			con.setAutoCommit(false);
			String sql="insert into pedidos(producto,unidades,fecha) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			for(Pedido p:pedidos) {
				ps.setString(1, p.getProducto());
				ps.setInt(2, p.getUnidades());
				ps.setDate(3, Date.valueOf(p.getFecha()));
				ps.execute();
			}
			con.commit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
