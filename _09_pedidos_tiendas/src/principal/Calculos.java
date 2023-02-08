package principal;

import service.PedidosTiendasServiceFactory;

public class Calculos {

	public static void main(String[] args) {
		//de manera concurrente, nos mostrará el total de unidades pedidas 
		//y el nombre el último producto pedido
		new Thread(()->System.out.println(
				PedidosTiendasServiceFactory
				.getPedidosTiendasService()
				.totalUnidades())).start();
		new Thread(()->System.out.println(
				PedidosTiendasServiceFactory
				.getPedidosTiendasService()
				.productoUltimoPedido())).start();
	}

}
