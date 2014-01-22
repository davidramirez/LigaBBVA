package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_CambiarPass extends JFrame {
	private JTextField txtUsuario;
	private JTextField txtPassAnt;
	private JTextField txtPassN;
	private JTextField txtTxtpassrep;
	private JTextField txtPreg;
	private JTextField txtResp;
	public IU_CambiarPass() {
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 43, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblAntiguaContrasea = new JLabel("Antigua contraseña");
		lblAntiguaContrasea.setBounds(40, 87, 70, 15);
		getContentPane().add(lblAntiguaContrasea);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contraseña");
		lblNuevaContrasea.setBounds(40, 123, 70, 15);
		getContentPane().add(lblNuevaContrasea);
		
		JLabel lblRepiteLaContrasea = new JLabel("Repite la contraseña:");
		lblRepiteLaContrasea.setBounds(40, 159, 70, 15);
		getContentPane().add(lblRepiteLaContrasea);
		
		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de seguridad:");
		lblPreguntaDeSeguridad.setBounds(40, 192, 70, 15);
		getContentPane().add(lblPreguntaDeSeguridad);
		
		JLabel lblRespuestaDeSeguridad = new JLabel("Respuesta de seguridad:");
		lblRespuestaDeSeguridad.setBounds(40, 230, 70, 15);
		getContentPane().add(lblRespuestaDeSeguridad);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(158, 41, 114, 19);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassAnt = new JTextField();
		txtPassAnt.setText("");
		txtPassAnt.setBounds(158, 85, 114, 19);
		getContentPane().add(txtPassAnt);
		txtPassAnt.setColumns(10);
		
		txtPassN = new JTextField();
		txtPassN.setText("");
		txtPassN.setBounds(158, 121, 114, 19);
		getContentPane().add(txtPassN);
		txtPassN.setColumns(10);
		
		txtTxtpassrep = new JTextField();
		txtTxtpassrep.setBounds(158, 157, 114, 19);
		getContentPane().add(txtTxtpassrep);
		txtTxtpassrep.setColumns(10);
		
		txtPreg = new JTextField();
		txtPreg.setBounds(158, 190, 114, 19);
		getContentPane().add(txtPreg);
		txtPreg.setColumns(10);
		
		txtResp = new JTextField();
		txtResp.setText("");
		txtResp.setBounds(158, 228, 114, 19);
		getContentPane().add(txtResp);
		txtResp.setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValidar.setBounds(304, 192, 117, 25);
		getContentPane().add(btnValidar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setBounds(304, 230, 117, 25);
		getContentPane().add(btnVolver);
	}
}
