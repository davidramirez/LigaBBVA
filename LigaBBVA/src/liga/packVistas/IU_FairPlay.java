package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_FairPlay extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEquipo;
	private JTextField textFieldSanciones;
	private JTextField textFieldNomEq;
	private JTextField textFieldSancionesEq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_FairPlay frame = new IU_FairPlay();
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
	public IU_FairPlay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 275);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(239, 12, 17, 180);
		contentPane.add(separator);
		
		JLabel lblDatosDeJugador = new JLabel("Datos de jugador Fairplay");
		lblDatosDeJugador.setBounds(12, 12, 209, 15);
		contentPane.add(lblDatosDeJugador);
		
		JLabel lblDatosDeEquipo = new JLabel("Datos de equipo FairPlay");
		lblDatosDeEquipo.setBounds(250, 12, 245, 15);
		contentPane.add(lblDatosDeEquipo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 53, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 80, 70, 15);
		contentPane.add(lblApellidos);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(12, 107, 70, 15);
		contentPane.add(lblEquipo);
		
		JLabel lblSanciones = new JLabel("Sanciones");
		lblSanciones.setBounds(12, 134, 97, 15);
		contentPane.add(lblSanciones);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(107, 51, 114, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(107, 78, 114, 19);
		contentPane.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setBounds(107, 107, 114, 19);
		contentPane.add(textFieldEquipo);
		textFieldEquipo.setColumns(10);
		
		textFieldSanciones = new JTextField();
		textFieldSanciones.setBounds(107, 132, 114, 19);
		contentPane.add(textFieldSanciones);
		textFieldSanciones.setColumns(10);
		
		JLabel lblNombreEq = new JLabel("Nombre");
		lblNombreEq.setBounds(250, 53, 70, 15);
		contentPane.add(lblNombreEq);
		
		JLabel lblSancionesEq = new JLabel("Sanciones");
		lblSancionesEq.setBounds(250, 80, 80, 15);
		contentPane.add(lblSancionesEq);
		
		textFieldNomEq = new JTextField();
		textFieldNomEq.setBounds(353, 51, 114, 19);
		contentPane.add(textFieldNomEq);
		textFieldNomEq.setColumns(10);
		
		textFieldSancionesEq = new JTextField();
		textFieldSancionesEq.setBounds(353, 78, 114, 19);
		contentPane.add(textFieldSancionesEq);
		textFieldSancionesEq.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOK.setBounds(350, 211, 117, 25);
		contentPane.add(btnOK);
	}
}