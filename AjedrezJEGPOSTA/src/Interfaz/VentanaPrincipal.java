package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjedrez = new JLabel("Ajedrez");
		lblAjedrez.setBounds(196, 11, 46, 14);
		contentPane.add(lblAjedrez);
		
		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IngresoJugadores ij=new IngresoJugadores();
				ij.show();
			}
		});
		btnNuevaPartida.setBounds(156, 47, 125, 23);
		contentPane.add(btnNuevaPartida);
		
		JButton btnContinuarPartida = new JButton("Continuar Partida");
		btnContinuarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el id de la partida que desea continuar: ",JOptionPane.INFORMATION_MESSAGE));
				TableroInterfaz ti= new TableroInterfaz(idSeleccionada);
				ti.show();
			}
		});
		btnContinuarPartida.setBounds(156, 81, 125, 23);
		contentPane.add(btnContinuarPartida);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(336, 152, 89, 23);
		contentPane.add(btnSalir);
	}
}
