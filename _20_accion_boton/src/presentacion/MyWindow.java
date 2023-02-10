package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		JButton btSalir=new JButton("Salir");
		JLabel lb=new JLabel("");
		bt.setBounds(50, 50, 200, 30);
		btSalir.setBounds(200, 150, 200, 30);
		lb.setBounds(200, 250, 200, 30);
		//bt.addActionListener(e->JOptionPane.showConfirmDialog(MyWindow.this, "Bienvenido a swing"));
		bt.addActionListener(e->lb.setText("Bienvenido a swing"));
		btSalir.addActionListener(e->MyWindow.this.dispose());
		//añadir el control a la ventana
		this.add(bt);
		this.add(btSalir);
		this.add(lb);
	}
}
