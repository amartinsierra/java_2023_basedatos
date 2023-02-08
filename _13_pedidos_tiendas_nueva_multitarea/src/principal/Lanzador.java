package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.TareaTienda;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		TareaTienda t1=new TareaTienda("c:\\ficheros\\tienda1.csv");
		TareaTienda t2=new TareaTienda("c:\\ficheros\\tienda2.csv");
		TareaTienda t3=new TareaTienda("c:\\ficheros\\tienda3.csv");
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);		
		System.out.println("tareas en proceso!");
		executor.shutdown();//vacíar el pool
	}

}
