package principal;

import tareas.TareaTienda;

public class Lanzador {

	public static void main(String[] args) {
		TareaTienda t1=new TareaTienda("c:\\ficheros\\tienda1.csv");
		TareaTienda t2=new TareaTienda("c:\\ficheros\\tienda2.csv");
		TareaTienda t3=new TareaTienda("c:\\ficheros\\tienda3.csv");
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();		
		System.out.println("tareas en proceso!");
	}

}
