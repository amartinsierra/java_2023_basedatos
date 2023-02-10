package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow extends JFrame {
	public MyWindow() {
		//le damos el título a través del constructor de la superclase
		super("Primera ventana");
		//posición y tamaño
		this.setBounds(100, 50, 700, 500);
		//configurar botón de cierre de la ventana
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//cambiar color de fondo
		this.getContentPane().setBackground(Color.YELLOW);
		inicializarComponentes();
		//hace la ventana visible
		this.setVisible(true);
	}
	void inicializarComponentes() {
		//anular el gestor de organización (Layout)
		this.setLayout(null);
		JButton bt=new JButton("Pulsar aquí");
		bt.setBounds(50, 50, 200, 30);
		//añadir el control a la ventana
		this.add(bt);
	}
}
