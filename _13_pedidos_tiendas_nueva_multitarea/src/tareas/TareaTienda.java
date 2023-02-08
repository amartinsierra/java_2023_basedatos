package tareas;

import java.util.List;

import model.Pedido;
import service.PedidosTiendasService;
import service.PedidosTiendasServiceFactory;

public class TareaTienda implements Runnable {
	
	private String ruta;
	public TareaTienda(String ruta) {
		this.ruta=ruta;
	}

	@Override
	public void run() {
		PedidosTiendasService service=PedidosTiendasServiceFactory.getPedidosTiendasService();
		//recupera los pedidos de la tienda
		List<Pedido> pedidos=service.pedidosTienda(ruta);
		//guarda los pedidos recuperados en la base de datos
		service.guardarPedidos(pedidos);
	}

}
