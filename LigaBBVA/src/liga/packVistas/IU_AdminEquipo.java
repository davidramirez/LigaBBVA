package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import liga.packControladoras.C_GestionEquipo;
import liga.packControladoras.C_Usuario;

@SuppressWarnings("serial")
public class IU_AdminEquipo extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IU_AdminEquipo(String usuario) {
		String equipo = C_Usuario.getMiUsuario().obtenerEquipoDe(usuario);
		C_GestionEquipo.getC_GestionEquipo().setEquipo(equipo); // Lo guardamos en el controlador para no tener que preocuparnos más.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestionarJugadores = new JButton("Gestionar Jugadores");
		btnGestionarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_GestionEquipo ge = new IU_GestionEquipo(C_GestionEquipo.getC_GestionEquipo());
				ge.setVisible(true);
				dispose();
			}
		});
		btnGestionarJugadores.setBounds(125, 12, 211, 25);
		contentPane.add(btnGestionarJugadores);
		
		JButton btnGestionarCalendario = new JButton("Gestionar Calendario");
		btnGestionarCalendario.setBounds(125, 49, 211, 25);
		contentPane.add(btnGestionarCalendario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		btnSalir.setBounds(169, 237, 117, 25);
		contentPane.add(btnSalir);
	}
}
