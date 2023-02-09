package tareas;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumaNumeros implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		//suma números del 1 al 100
		int suma=0;
		for(int i=1;i<10;i++) {
			suma+=i;
			Thread.sleep(100);
		}
		return suma;
		
		//return IntStream.rangeClosed(1, 80).sum();
	}

}
