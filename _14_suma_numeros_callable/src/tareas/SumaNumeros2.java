package tareas;

import java.util.function.Supplier;

public class SumaNumeros2 implements Supplier<Integer> {

	@Override
	public Integer get() {
		int suma=0;
		for(int i=1;i<10;i++) {
			suma+=i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return suma;
	}

}
