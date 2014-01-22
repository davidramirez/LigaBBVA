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
	private String idAdmin;
	private JButton btnModificarJugador;
	private String[][] jugadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_GestionEquipo frame = new IU_GestionEquipo(C_GestionEquipo.getC_GestionEquipo(), "", "Athletic");
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
	public IU_GestionEquipo(C_GestionEquipo model, String id, String equipo) {
		idAdmin=id;
		C_GestionEquipo.getC_GestionEquipo().setEquipo(equipo);
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
		
		model.addObserver(this);
		
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
					if (!arg0.getValueIsAdjusting()) {
						if (listJugadores.getSelectedIndex() == -1)
							btnModificarJugador.setEnabled(false);
				        else
				        	btnModificarJugador.setEnabled(true);
				    }
				}
			});
		}
		return listJugadores;
	}
	
	private void comprobaciones() {
		int numJugadores = C_GestionEquipo.getC_GestionEquipo().getJugadores().length;
		if (numJugadores < 19)
			this.btnBajaJugador.setEnabled(false);
		else if (numJugadores > 25) {
			this.btnAnadirJugador.setEnabled(false);
			this.btnGestionarFichajes.setEnabled(false);
		}
	}
	
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
					int indice = listJugadores.getSelectedIndex();
					IU_ModificarJugador mj = new IU_ModificarJugador(jugadores[indice][0], jugadores[indice][1], jugadores[indice][2]);
					mj.setVisible(true);
				}
			});
			btnModificarJugador.setBounds(428, 273, 189, 25);
		}
		return btnModificarJugador;
	}

	public void update(Observable arg0, Object arg1) {
		System.out.println("yeeeeeeeeeeeeeeeha!");
		this.actualizarLista();
	}
}
