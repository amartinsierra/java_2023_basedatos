package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.ClientesService;
import service.LibreriaServiceFactory;
import service.LibrosService;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 45, 83, 20);
		contentPane.add(lblNewLabel);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(160, 47, 86, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(47, 109, 86, 20);
		contentPane.add(lblNewLabel_1);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(160, 111, 86, 20);
		contentPane.add(pfPassword);
		
		JButton btAutenticar = new JButton("Autenticar");
		btAutenticar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesService clientesService=LibreriaServiceFactory.getClientesService();
				LibrosService librosService=LibreriaServiceFactory.getLibrosService(); 
				String mensaje;
				if(clientesService.existe(tfUsuario.getText(), pfPassword.getText())) {
					//creamos la ventana de libros y le pasamos la lista de libros
					//para que los muestre
					new VentanaLibros(librosService.libros());
				}else {
					JOptionPane.showMessageDialog(VentanaLogin.this, "Usuario no válido");
				}
				
			}
		});
		btAutenticar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btAutenticar.setBounds(134, 191, 112, 23);
		contentPane.add(btAutenticar);
	}
}
