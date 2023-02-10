package service;

public class ItemsServiceFactory {

	public static ItemsService getItemService() {
		return new ItemsServiceImpl();
	}
}
