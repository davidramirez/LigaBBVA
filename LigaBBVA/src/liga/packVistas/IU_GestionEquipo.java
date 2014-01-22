package liga.packVistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;
import javax.swing.JList;

import liga.packControladoras.C_GestionEquipo;
import liga.packControladoras.C_Usuario;

import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class IU_GestionEquipo extends JFrame implements Observer {

	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnBajaJugador;
	private JButton btnMercado;
	private JButton btnAnadirJugador;
	private JButton btnGestionarFichajes;
	private JList<String> listJugadores;
	private JButton btnModificarJugador;
	private String[][] jugadores;

	/**
	 * Create the frame.
	 */
	public IU_GestionEquipo(C_GestionEquipo model, String user) {
		String equipo = C_Usuario.getMiUsuario().obtenerEquipoDe(user);
		C_GestionEquipo.getC_GestionEquipo().setEquipo(equipo); // Lo guardamos en el controlador para no tener que preocuparnos más.
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
		contentPane.add(getBtnModificarJugador());
		
		JLabel lblListaJugadores = new JLabel("Lista de jugadores");
		lblListaJugadores.setBounds(12, 29, 169, 15);
		contentPane.add(lblListaJugadores);
		
		JLabel lblNombreEquipo = new JLabel(equipo);
		lblNombreEquipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreEquipo.setBounds(478, 29, 139, 15);
		contentPane.add(lblNombreEquipo);
		contentPane.add(getListJugadores());
		setResizable(false);
		
		/* Esta clase será observadora del modelo pasado, es decir, el controlador de la gestión del equipo. */
		model.addObserver(this);
		
		/* Serie de comprobaciones para mostrar o no ciertos botones. */
		comprobaciones();
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
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
					int indice = listJugadores.getSelectedIndex();
					C_GestionEquipo.getC_GestionEquipo().darDeBajaJugador(jugadores[indice][0]);
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
			btnAnadirJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/* Llamamos a la nueva interfaz. */
					IU_AnadirJugador aj = new IU_AnadirJugador();
					aj.setVisible(true); 
				}
			});
			btnAnadirJugador.setBounds(428, 236, 189, 25);
		}
		return btnAnadirJugador;
	}
	private JButton getBtnGestionarFichajes() {
		if (btnGestionarFichajes == null) {
			btnGestionarFichajes = new JButton("Gestionar fichajes");
			btnGestionarFichajes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnGestionarFichajes.setBounds(428, 383, 189, 25);
		}
		return btnGestionarFichajes;
	}
	private JList<String> getListJugadores() {
		if (listJugadores == null) {
			listJugadores = new JList<String>();
			listJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listJugadores.setBounds(12, 56, 300, 389);
			actualizarLista();
			listJugadores.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					/* Si hay algún jugador seleccionado, se activará el botón de modificar. */
					if (!arg0.getValueIsAdjusting()) {
						if (listJugadores.getSelectedIndex() == -1) {
							btnModificarJugador.setEnabled(false);
							comprobaciones();
						} else {
				        	btnModificarJugador.setEnabled(true);
				        	comprobaciones();
						}
				    }
				}
			});
		}
		return listJugadores;
	}
	
	/* Comprobaciones para activar y desactivar botones dependiendo del número total de jugadores que tenga el equipo. */
	private void comprobaciones() {
		int numJugadores = this.jugadores.length;
		if (numJugadores < 19)
			this.btnBajaJugador.setEnabled(false);
		else if (numJugadores > 25) {
			this.btnAnadirJugador.setEnabled(false);
			this.btnGestionarFichajes.setEnabled(false);
		}
	}
	
	/* Llenamos la lista de jugadores. */
	private void actualizarLista() {
		jugadores = C_GestionEquipo.getC_GestionEquipo().getJugadores();
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i][3].equals("1"))
				modelo.addElement(jugadores[i][1] + " (en venta)");
			else
				modelo.addElement(jugadores[i][1]);
		}
		listJugadores.setModel(modelo);
	}
	
	private JButton getBtnModificarJugador() {
		if (btnModificarJugador == null) {
			btnModificarJugador = new JButton("ModificarJugador");
			btnModificarJugador.setEnabled(false);
			btnModificarJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/* Llamamos a la nueva interfaz. */
					int indice = listJugadores.getSelectedIndex();
					IU_ModificarJugador mj = new IU_ModificarJugador(jugadores[indice][0], jugadores[indice][1], jugadores[indice][2]);
					mj.setVisible(true);
				}
			});
			btnModificarJugador.setBounds(428, 273, 189, 25);
		}
		return btnModificarJugador;
	}

	/* Cuando se añade o modifica un jugador, se entrará a este método. */
	public void update(Observable arg0, Object arg1) {
		this.actualizarLista(); // Actualizamos el JList.
		this.comprobaciones();
	}
}
