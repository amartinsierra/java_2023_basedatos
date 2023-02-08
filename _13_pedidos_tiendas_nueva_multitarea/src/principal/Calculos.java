package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.PedidosTiendasServiceFactory;

public class Calculos {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		//de manera concurrente, nos mostrará el total de unidades pedidas 
		//y el nombre el último producto pedido
		executor.submit(()->System.out.println(
				PedidosTiendasServiceFactory
				.getPedidosTiendasService()
				.totalUnidades()));
		executor.submit(()->System.out.println(
				PedidosTiendasServiceFactory
				.getPedidosTiendasService()
				.productoUltimoPedido()));
		executor.shutdown();
	}

}
