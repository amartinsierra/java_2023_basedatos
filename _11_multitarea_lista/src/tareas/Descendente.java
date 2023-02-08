package tareas;

import java.util.List;

public class Descendente extends Thread {
	private List<String> lista;
	public Descendente(List<String> lista) {
		this.lista=lista;
	}
	@Override
	public void run() {
		for(int i=100;i>=1;i--) {
			lista.add("Descendente: "+i);
		}
	}

}
