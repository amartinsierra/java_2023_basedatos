package service;

public class PedidosTiendasServiceFactory {
	public static PedidosTiendasService getPedidosTiendasService() {
		return new PedidosTiendasServiceImpl();
	}
}
