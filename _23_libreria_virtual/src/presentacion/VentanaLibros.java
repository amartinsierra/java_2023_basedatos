package presentacion;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Libro;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLibros extends JFrame {

	private JPanel contentPane;
	private List<Libro> libros;
	


	/**
	 * Create the frame.
	 */
	public VentanaLibros(List<Libro> libros) {
		
		this.libros=libros;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea taLibros = new JTextArea();
		taLibros.setBounds(170, 39, 131, 118);
		contentPane.add(taLibros);
		
		JButton btSalir = new JButton("Salir");
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLibros.this.dispose();
			}
		});
		btSalir.setBounds(190, 203, 89, 23);
		contentPane.add(btSalir);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//recogemos la lista de libros y la volcamos en el TextArea
				libros.forEach(l->taLibros.setText(taLibros.getText()+l.getTitulo()+"<br>"));
			}
		});
		this.setVisible(true);
	}
}
