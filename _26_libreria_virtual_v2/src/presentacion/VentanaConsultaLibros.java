package presentacion;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Tema;
import presentacion.datamodel.AdaptadorListaTemas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaConsultaLibros extends JFrame {

	private JPanel contentPane;
	private List<Tema> temas;
	

	/**
	 * Create the frame.
	 */
	public VentanaConsultaLibros(List<Tema> temas) {
		
		this.temas=temas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione tema:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(70, 11, 140, 19);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(70, 57, 275, 40);
		contentPane.add(scrollLista);
		
		JComboBox<Tema> comboTemas = new JComboBox<>();
		scrollLista.setViewportView(comboTemas);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//asignamos al combobox el adaptador de los temas
				var adapter=new AdaptadorListaTemas();
				comboTemas.setModel(adapter);
			}
		});
		this.setVisible(true);
	}
}
