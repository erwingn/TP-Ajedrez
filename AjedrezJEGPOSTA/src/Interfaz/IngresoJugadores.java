package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Entidades.Jugador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresoJugadores extends JFrame {

	private JPanel contentPane;
	private JTextField textJugador1;
	private JTextField textJugador2;
	Negocio.JugadorLogic juglogic=new Negocio.JugadorLogic();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoJugadores frame = new IngresoJugadores();
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
	public IngresoJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDniJugador = new JLabel("DNI Jugador1");
		lblDniJugador.setBounds(61, 11, 76, 14);
		contentPane.add(lblDniJugador);
		
		JLabel lblDniJugador_1 = new JLabel("DNI Jugador 2");
		lblDniJugador_1.setBounds(294, 11, 76, 14);
		contentPane.add(lblDniJugador_1);
		
		textJugador1 = new JTextField();
		textJugador1.setBounds(51, 36, 86, 20);
		contentPane.add(textJugador1);
		textJugador1.setColumns(10);
		
		textJugador2 = new JTextField();
		textJugador2.setBounds(284, 36, 86, 20);
		contentPane.add(textJugador2);
		textJugador2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(306, 149, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textJugador1.getText().equalsIgnoreCase("") || textJugador2.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Complete todos los campos","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				Jugador j1,j2=new Jugador();
				//boolean ban_tipo=true;
				
				j1=juglogic.getJugador(Integer.parseInt(textJugador1.getText()));
				j2=juglogic.getJugador(Integer.parseInt(textJugador2.getText()));
				TableroInterfaz ti=new TableroInterfaz(j1, j2);
				
				
			}
		});
		btnAceptar.setBounds(207, 149, 89, 23);
		contentPane.add(btnAceptar);
	}
}
