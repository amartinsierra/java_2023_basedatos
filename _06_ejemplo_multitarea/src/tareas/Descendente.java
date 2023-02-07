package tareas;

public class Descendente extends Thread {

	@Override
	public void run() {
		for(int i=100;i>=1;i--) {
			System.out.println("Descendente: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
