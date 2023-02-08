package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import tareas.Ascendente;
import tareas.Descendente;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException {
		//List<String> textos=new ArrayList<>();  //no thread safe
		List<String> textos=new CopyOnWriteArrayList<>();
		Ascendente t1=new Ascendente(textos);
		Descendente t2=new Descendente(textos);
		//se ponen en ejecución concurrente
		t1.start();
		t2.start();
		Thread.sleep(5000);
		//¿cuantas cadenas habrá en la lista tras ejecutarse las dos tareas?
		System.out.println(textos.size());
		
	}

}
