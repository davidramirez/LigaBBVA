package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Box;

public class IU_Estadistica extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldClasificacionEq;
	private JTextField textFieldGoles;
	private JTextField textFieldSanciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Estadistica frame = new IU_Estadistica();
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
	public IU_Estadistica() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(487, 335, 117, 25);
		contentPane.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(361, 335, 117, 25);
		contentPane.add(btnAceptar);
		
		JRadioButton rdbtnEquipo = new JRadioButton("Equipo");
		rdbtnEquipo.setBounds(27, 21, 149, 23);
		contentPane.add(rdbtnEquipo);
		
		JRadioButton rdbtnJugador = new JRadioButton("Jugador");
		rdbtnJugador.setBounds(318, 21, 149, 23);
		contentPane.add(rdbtnJugador);
		
		ButtonGroup grupo =new ButtonGroup();
		grupo.add(rdbtnJugador);
		grupo.add(rdbtnEquipo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(300, 24, 28, 173);
		contentPane.add(separator);
		
		JLabel lblNombreEq = new JLabel("Nombre");
		lblNombreEq.setBounds(37, 59, 70, 15);
		contentPane.add(lblNombreEq);
		
		JComboBox comboBoxNombreEq = new JComboBox();
		comboBoxNombreEq.setBounds(114, 54, 174, 24);
		contentPane.add(comboBoxNombreEq);
		
		JLabel lblClasificacinEq = new JLabel("Clasificación");
		lblClasificacinEq.setBounds(37, 127, 117, 15);
		contentPane.add(lblClasificacinEq);
		
		textFieldClasificacionEq = new JTextField();
		textFieldClasificacionEq.setBounds(174, 125, 114, 19);
		contentPane.add(textFieldClasificacionEq);
		textFieldClasificacionEq.setColumns(10);
		
		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setBounds(27, 247, 107, 15);
		contentPane.add(lblTemporada);
		
		JLabel lblJornada = new JLabel("Jornada");
		lblJornada.setBounds(342, 247, 70, 15);
		contentPane.add(lblJornada);
		
		JComboBox comboBoxTemporada = new JComboBox();
		comboBoxTemporada.setBounds(138, 242, 174, 24);
		contentPane.add(comboBoxTemporada);
		
		JComboBox comboBoxJornada = new JComboBox();
		comboBoxJornada.setBounds(430, 242, 174, 24);
		contentPane.add(comboBoxJornada);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(318, 59, 70, 15);
		contentPane.add(lblEquipo);
		
		JComboBox comboBoxEquipo = new JComboBox();
		comboBoxEquipo.setBounds(406, 52, 179, 24);
		contentPane.add(comboBoxEquipo);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(318, 101, 70, 15);
		contentPane.add(lblJugador);
		
		JComboBox comboBoxJugador = new JComboBox();
		comboBoxJugador.setBounds(406, 96, 179, 24);
		contentPane.add(comboBoxJugador);
		
		JLabel lblGoles = new JLabel("Goles");
		lblGoles.setBounds(318, 141, 70, 15);
		contentPane.add(lblGoles);
		
		JLabel lblSanciones = new JLabel("Sanciones");
		lblSanciones.setBounds(318, 168, 94, 15);
		contentPane.add(lblSanciones);
		
		textFieldGoles = new JTextField();
		textFieldGoles.setBounds(471, 139, 114, 19);
		contentPane.add(textFieldGoles);
		textFieldGoles.setColumns(10);
		
		textFieldSanciones = new JTextField();
		textFieldSanciones.setBounds(471, 166, 114, 19);
		contentPane.add(textFieldSanciones);
		textFieldSanciones.setColumns(10);
	}
}
