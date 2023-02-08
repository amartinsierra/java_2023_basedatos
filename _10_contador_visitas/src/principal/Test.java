package principal;

import model.Contador;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		//para probar el contador, creamos un objeto contador y tres tareas 
		//concurrentes que llaman a incrementar. Después mostramos el valor del contador
		
		Contador contador=new Contador();
		new Thread(()->contador.incrementar()).start();
		new Thread(()->contador.incrementar()).start();
		new Thread(()->contador.incrementar()).start();
		Thread.sleep(5000);
		System.out.println(contador.getValor());
	}

}
