package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import model.Contador;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		//para probar el contador, creamos un objeto contador y tres tareas 
		//concurrentes que llaman a incrementar. Después mostramos el valor del contador
		
		Contador contador=new Contador();
		Lock lk=new ReentrantLock();
		ExecutorService executor=Executors.newCachedThreadPool();
		Runnable r=()->{
			lk.lock();
			contador.incrementar();
			lk.unlock();
		};
		//lanzamos las tareas
		executor.submit(r);
		executor.submit(r);
		executor.submit(r);

		Thread.sleep(5000);
		System.out.println(contador.getValor());
	}

}
