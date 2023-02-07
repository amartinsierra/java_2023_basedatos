package principal;

import tareas.Ascendente;
import tareas.Descendente;

public class Lanzador {

	public static void main(String[] args) {
		Ascendente t1=new Ascendente();
		Descendente t2=new Descendente();
		//se ponen en ejecución concurrente
		//t1.start();
		//t2.start();
		new Thread(t1).start();
		new Thread(t2).start();
		for(int i=1;i<=100;i++) {
			System.out.println("haciendo cosas el main....");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
