package principal;

import tareas.TareaMultiplicar;

public class Lanzador {

	public static void main(String[] args) {
		TareaMultiplicar t1=new TareaMultiplicar(4);
		TareaMultiplicar t2=new TareaMultiplicar(6);
		TareaMultiplicar t3=new TareaMultiplicar(9);
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
	}

}
