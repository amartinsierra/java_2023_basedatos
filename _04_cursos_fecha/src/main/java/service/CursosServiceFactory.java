package service;

public class CursosServiceFactory {
	public static CursosService getCursosService() {
		return new CursosServiceImpl();
	}
}
