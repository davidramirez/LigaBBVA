package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class IU_GestionEquipo extends JFrame {

	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnBajaJugador;
	private JButton btnMercado;
	private JButton btnAnadirJugador;
	private JButton btnGestionarFichajes;
	private JList listJugadores;
	private String idAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_GestionEquipo frame = new IU_GestionEquipo("");
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
	public IU_GestionEquipo(String id) {
		idAdmin=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getBtnSalir());
		contentPane.add(getBtnBajaJugador());
		contentPane.add(getBtnMercado());
		contentPane.add(getBtnAnadirJugador());
		contentPane.add(getBtnGestionarFichajes());
		
		JLabel lblListaJugadores = new JLabel("Lista de jugadores");
		lblListaJugadores.setBounds(12, 29, 169, 15);
		contentPane.add(lblListaJugadores);
		
		JLabel lblNombreEquipo = new JLabel("Equipo");
		lblNombreEquipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreEquipo.setBounds(478, 29, 139, 15);
		contentPane.add(lblNombreEquipo);
		contentPane.add(getListJugadores());
		setResizable(false);
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(428, 420, 189, 25);
		}
		return btnSalir;
	}
	private JButton getBtnBajaJugador() {
		if (btnBajaJugador == null) {
			btnBajaJugador = new JButton("Dar de baja jugador");
			btnBajaJugador.setEnabled(false);
			btnBajaJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnBajaJugador.setBounds(428, 347, 189, 25);
		}
		return btnBajaJugador;
	}
	private JButton getBtnMercado() {
		if (btnMercado == null) {
			btnMercado = new JButton("Poner en el mercado");
			btnMercado.setEnabled(false);
			btnMercado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnMercado.setBounds(428, 310, 189, 25);
		}
		return btnMercado;
	}
	private JButton getBtnAnadirJugador() {
		if (btnAnadirJugador == null) {
			btnAnadirJugador = new JButton("Añadir jugador");
			btnAnadirJugador.setBounds(428, 273, 189, 25);
		}
		return btnAnadirJugador;
	}
	private JButton getBtnGestionarFichajes() {
		if (btnGestionarFichajes == null) {
			btnGestionarFichajes = new JButton("Gestionar fichajes");
			btnGestionarFichajes.setBounds(428, 383, 189, 25);
		}
		return btnGestionarFichajes;
	}
	private JList getListJugadores() {
		if (listJugadores == null) {
			listJugadores = new JList();
			listJugadores.setBounds(12, 56, 300, 389);
		}
		return listJugadores;
	}
}
