package presentacion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaFactorial extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFactorial frame = new VentanaFactorial();
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
	public VentanaFactorial() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//cerramos la ventana si dice SI
				int res=JOptionPane.showConfirmDialog(VentanaFactorial.this, "¿Desea salir?");
				if(res==JOptionPane.YES_OPTION) {
					VentanaFactorial.this.dispose();
				}
			}
			@Override
			public void windowActivated(WindowEvent e) {
				//cambia fondo de la ventana con un color aleatorio
				Color color=new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
				VentanaFactorial.this.getContentPane().setBackground(color);
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lbRes = new JLabel("");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 30, 76, 21);
		contentPane.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(131, 32, 86, 20);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton bt = new JButton("Factorial");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbRes.setText("Factorial: "+factorial(Integer.parseInt(tf.getText())));
			}
		});
		bt.setBounds(87, 85, 89, 23);
		contentPane.add(bt);
		
		
		lbRes.setBounds(51, 146, 70, 21);
		contentPane.add(lbRes);
	}
	int factorial(int n) {
		
		return IntStream.rangeClosed(1, n).reduce(1, (a,b)->a*b);
	}
}
