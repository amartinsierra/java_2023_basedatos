package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tareas.SumaNumeros;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor=Executors.newCachedThreadPool();
		//pone la tarea de suma de números en ejecución concurrente
		Future<Integer> future=executor.submit(new SumaNumeros());
		for(int i=1;i<=100;i++) {
			System.out.println("haciendo algo");
			Thread.sleep(100);
			//vamos preguntando si la terea a finalizado o no.
			//cuando finaliza, obtenemos el resultado y lo mostramos
			if(future.isDone()) {
				System.out.println("**********************************************************La suma vale: "+future.get());
			}
		}
		executor.shutdown();
	}

}
