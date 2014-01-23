package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

@SuppressWarnings("serial")
public class IU_Calendario extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IU_Calendario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConvocarJugadores = new JButton("Convocar jugadores");
		btnConvocarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date aux = new java.util.Date();
				Date fecha = new Date(aux.getTime()); // Parche.
				IU_ConvocarJugadores cj = new IU_ConvocarJugadores(fecha);
				cj.setVisible(true);
				dispose();
			}
		});
		btnConvocarJugadores.setBounds(242, 12, 192, 25);
		contentPane.add(btnConvocarJugadores);
		
		JButton btnJugadoresTitulares = new JButton("Jugadores titulares");
		btnJugadoresTitulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date aux = new java.util.Date();
				Date fecha = new Date(aux.getTime()); // Parche.
				IU_JugadoresTitulares jt = new IU_JugadoresTitulares(fecha);
				jt.setVisible(true);
				dispose();
			}
		});
		btnJugadoresTitulares.setBounds(242, 49, 192, 25);
		contentPane.add(btnJugadoresTitulares);
		
		JLabel lblNota = new JLabel("Nota: la fecha pasada es la actual.");
		lblNota.setBounds(12, 247, 265, 15);
		contentPane.add(lblNota);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(317, 237, 117, 25);
		contentPane.add(btnSalir);
	}
}
