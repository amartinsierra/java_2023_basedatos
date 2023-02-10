package principal;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		//tarea que cada segundo muestre la hora
		ScheduledExecutorService executor=Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(()->System.out.println(LocalTime.now()), 0, 1, TimeUnit.SECONDS);
		Thread.sleep(5000);
		executor.shutdownNow();
	}

}
