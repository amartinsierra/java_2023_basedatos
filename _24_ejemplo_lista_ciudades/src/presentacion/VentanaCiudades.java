package presentacion;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Ciudad;
import presentacion.datamodel.AdaptadorListaCiudades;
import service.CiudadesService;

public class VentanaCiudades extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCiudades frame = new VentanaCiudades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCiudades() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 28, 79, 68);
		contentPane.add(scrollPane);
		
		JList<Ciudad> listCiudades = new JList<>();
		listCiudades.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//obtenemos el elemento seleccionado y mostramos sus datos
				/*Ciudad c=listCiudades.getSelectedValue();
				JOptionPane.showMessageDialog(VentanaCiudades.this, c.getNombre()+":"+c.getPoblacion());*/
				
				//preguntar si queremos eliminar esa ciudad y si dice que sí, se eliminará
				if(JOptionPane.showConfirmDialog(VentanaCiudades.this, "¿Desea eliminar la ciudad?")==JOptionPane.YES_OPTION) {
					Ciudad c=listCiudades.getSelectedValue();
					CiudadesService service=new CiudadesService();
					service.eliminarCiudad(c.getNombre());
					//reasignar adaptador a la lista
					regenerarLista(listCiudades);
				}
				
				
			}
		});
		scrollPane.setViewportView(listCiudades);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//crear el adaptador con el modelo de datos y asignar
				//al JList
				regenerarLista(listCiudades);
			}
		});
	}

	public void regenerarLista(JList<Ciudad> lista) {
		var adapter=new AdaptadorListaCiudades();
		lista.setModel(adapter);
	}
}
