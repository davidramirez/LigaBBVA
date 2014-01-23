package liga.packVistas;

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
import java.util.ArrayList;
import java.util.Iterator;

import liga.packControladoras.Liga;

@SuppressWarnings("serial")
public class IU_FairPlay extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldNombre;
	private JTextField textFieldEquipo;
	private static JTextField textFieldSanciones;
	private static JTextField textFieldNomEq;
	private static JTextField textFieldSancionesEq;
	private ArrayList<String>jugFair;
	private ArrayList<String>eqFair;
	private int codTemp;
	private String nomjug;
	private String nomEq;
	private String numsan;
	private String equipo;
	private String sancionesEq;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public IU_FairPlay() {
		
		codTemp=Liga.getMiLiga().obtenerUltimaTemporada();
		jugFair=Liga.getMiLiga().obtenerJugadorFairplay(codTemp);
		Iterator<String> itr=jugFair.iterator();
		
		if(itr.hasNext())nomjug=itr.next();
		if(itr.hasNext())nomEq=itr.next();
		if(itr.hasNext())numsan=itr.next();
		
		eqFair=Liga.getMiLiga().obtenerEquipoFairPlay(codTemp);
		Iterator<String> itr1=eqFair.iterator();
		
		if(itr1.hasNext())equipo=itr1.next();
		if(itr1.hasNext())sancionesEq=itr1.next();
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(12, 80, 70, 15);
		contentPane.add(lblEquipo);
		
		JLabel lblSanciones = new JLabel("Sanciones");
		lblSanciones.setBounds(12, 111, 97, 15);
		contentPane.add(lblSanciones);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textFieldNombre.setBounds(100, 51, 127, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(nomjug);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setBounds(100, 78, 127, 19);
		contentPane.add(textFieldEquipo);
		textFieldEquipo.setColumns(10);
		textFieldEquipo.setText(nomEq);
		
		textFieldSanciones = new JTextField();
		textFieldSanciones.setBounds(100, 109, 127, 19);
		contentPane.add(textFieldSanciones);
		textFieldSanciones.setColumns(10);
		textFieldSanciones.setText(numsan);
		
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
		textFieldNomEq.setText(equipo);
		
		textFieldSancionesEq = new JTextField();
		textFieldSancionesEq.setBounds(353, 78, 114, 19);
		contentPane.add(textFieldSancionesEq);
		textFieldSancionesEq.setColumns(10);
		textFieldSancionesEq.setText(sancionesEq);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOK.setBounds(350, 211, 117, 25);
		contentPane.add(btnOK);		

	}
	
	
	
}
