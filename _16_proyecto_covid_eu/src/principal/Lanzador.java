package principal;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.ItemsService;
import service.ItemsServiceFactory;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		ItemsService itemsService=ItemsServiceFactory.getItemService();
		
		List<String> paises=itemsService.paises();
		//lanzamos la tarea secuendaria
		CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->itemsService.totalAcumulados(), executor);
		future.whenCompleteAsync((r,e)->System.out.println("El total acumulado en Europa es: "+r));
		//paises.forEach(p->System.out.println("Incidencia de "+p+" es: "+itemsService.incidenciaPais(p)));
		//lanzamos el calculo de cada paiscomo tarea independiente
		paises.forEach(p->executor.submit(()->System.out.println("Incidencia de "+p+" es: "+itemsService.incidenciaPais(p))));		
		executor.shutdown();
		
	}

}
