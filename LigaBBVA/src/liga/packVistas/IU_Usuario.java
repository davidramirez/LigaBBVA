package liga.packVistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import liga.packControladoras.C_Clasificacion;
import liga.packControladoras.C_Usuario;

@SuppressWarnings("serial")
public class IU_Usuario extends JFrame {

	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnPichichi;
	private JButton btnClasificacin;
	private JButton btnEstadsticas;
	private JButton btnFairplay;
	private JButton btnQuiniela;
	private JButton btnDatos;
	private JScrollPane scrollPaneJornadas;
	private JLabel lblPartidosDeLa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Usuario frame = new IU_Usuario();
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
	public IU_Usuario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getBtnSalir());
		contentPane.add(getBtnPichichi());
		contentPane.add(getBtnClasificacin());
		contentPane.add(getBtnEstadsticas());
		contentPane.add(getBtnFairplay());
		contentPane.add(getBtnQuiniela());
		contentPane.add(getBtnDatos());
		contentPane.add(getScrollPaneJornadas());
		
		JScrollPane scrollPanePartidos = new JScrollPane();
		scrollPanePartidos.setBounds(216, 146, 329, 132);
		contentPane.add(scrollPanePartidos);
		
		JTextPane textPanePartidos = new JTextPane();
		scrollPanePartidos.setViewportView(textPanePartidos);
		
		JLabel lblCalendarioDeLa = new JLabel("Calendario de la liga");
		lblCalendarioDeLa.setBounds(12, 29, 169, 15);
		contentPane.add(lblCalendarioDeLa);
		
		JLabel lblListaDeEquipos = new JLabel("Lista de equipos");
		lblListaDeEquipos.setBounds(216, 29, 139, 15);
		contentPane.add(lblListaDeEquipos);
		
		JLabel lblListaDeJugadores = new JLabel("Lista de jugadores");
		lblListaDeJugadores.setBounds(216, 66, 139, 15);
		contentPane.add(lblListaDeJugadores);
		contentPane.add(getLblPartidosDeLa());
		
		JComboBox comboBoxEquipos = new JComboBox();
		comboBoxEquipos.setBounds(408, 24, 139, 24);
		contentPane.add(comboBoxEquipos);
		
		JComboBox comboBoxJugadores = new JComboBox();
		comboBoxJugadores.setBounds(408, 66, 139, 24);
		contentPane.add(comboBoxJugadores);
		setResizable(false);
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(12, 379, 117, 25);
		}
		return btnSalir;
	}
	private JButton getBtnPichichi() {
		if (btnPichichi == null) {
			btnPichichi = new JButton("Pichichi");
			btnPichichi.setEnabled(false);
			btnPichichi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnPichichi.setBounds(216, 305, 139, 25);
		}
		return btnPichichi;
	}
	private JButton getBtnClasificacin() {
		if (btnClasificacin == null) {
			btnClasificacin = new JButton("Clasificación");
			btnClasificacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int pTemp=C_Clasificacion.getMiClasificacion().obtenerUltimaTemporada();
					int pJor=C_Clasificacion.getMiClasificacion().obtenerUltimaJornadaDe(pTemp);
					new IU_Clasificacion(pTemp,pJor).setVisible(true);
				}
			});
			btnClasificacin.setBounds(216, 342, 139, 25);
		}
		return btnClasificacin;
	}
	private JButton getBtnEstadsticas() {
		if (btnEstadsticas == null) {
			btnEstadsticas = new JButton("Estadísticas");
			btnEstadsticas.setBounds(216, 379, 139, 25);
		}
		return btnEstadsticas;
	}
	private JButton getBtnFairplay() {
		if (btnFairplay == null) {
			btnFairplay = new JButton("FairPlay");
			btnFairplay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if(event.getSource()==btnFairplay)
					{
						new IU_FairPlay().setVisible(true);
					}
				}
			});
			btnFairplay.setBounds(408, 305, 139, 25);
		}
		return btnFairplay;
	}
	private JButton getBtnQuiniela() {
		if (btnQuiniela == null) {
			btnQuiniela = new JButton("Quiniela");
			btnQuiniela.setBounds(408, 342, 139, 25);
		}
		return btnQuiniela;
	}
	private JButton getBtnDatos() {
		if (btnDatos == null) {
			btnDatos = new JButton("Datos");
			btnDatos.setBounds(408, 379, 139, 25);
		}
		return btnDatos;
	}
	private JScrollPane getScrollPaneJornadas() {
		if (scrollPaneJornadas == null) {
			scrollPaneJornadas = new JScrollPane();
			scrollPaneJornadas.setBounds(12, 66, 145, 276);
			
			JTextPane textPaneJornadas = new JTextPane();
			scrollPaneJornadas.setViewportView(textPaneJornadas);
		}
		return scrollPaneJornadas;
	}
	private JLabel getLblPartidosDeLa() {
		if (lblPartidosDeLa == null) {
			lblPartidosDeLa = new JLabel("Partidos de la jornada");
			lblPartidosDeLa.setBounds(216, 119, 193, 15);
		}
		return lblPartidosDeLa;
	}
}
