package tareas;

import java.util.List;

public class Ascendente extends Thread {
	
	private List<String> lista;
	public Ascendente(List<String> lista) {
		this.lista=lista;
	}

	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			lista.add("Ascendente: "+i);			
		}
	}

}
