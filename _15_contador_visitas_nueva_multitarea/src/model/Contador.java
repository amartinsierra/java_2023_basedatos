package model;

public class Contador {
	private int valor=0;
	public void incrementar() {
		int a=valor;
		a++;		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valor=a;
	}
	public void decrementar() {		
			int a=valor;
			a--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valor=a;
	}
	public int getValor() {
		return valor;
	}
}
