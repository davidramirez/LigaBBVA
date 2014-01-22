package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import liga.packControladoras.C_Usuario;

public class IU_CambiarPass extends JFrame {
	private JTextField txtUsuario;
	private JTextField txtPreg;
	private JTextField txtResp;
	private JPasswordField txtPassAnt;
	private JPasswordField txtPassN;
	private JPasswordField txtPassRep;
	public IU_CambiarPass() {
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 57, 181, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblAntiguaContrasea = new JLabel("Antigua contraseña");
		lblAntiguaContrasea.setBounds(40, 87, 181, 15);
		getContentPane().add(lblAntiguaContrasea);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contraseña");
		lblNuevaContrasea.setBounds(40, 123, 181, 15);
		getContentPane().add(lblNuevaContrasea);
		
		JLabel lblRepiteLaContrasea = new JLabel("Repite la contraseña:");
		lblRepiteLaContrasea.setBounds(40, 159, 181, 15);
		getContentPane().add(lblRepiteLaContrasea);
		
		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de seguridad:");
		lblPreguntaDeSeguridad.setBounds(40, 192, 181, 15);
		getContentPane().add(lblPreguntaDeSeguridad);
		
		JLabel lblRespuestaDeSeguridad = new JLabel("Respuesta de seguridad:");
		lblRespuestaDeSeguridad.setBounds(40, 230, 181, 15);
		getContentPane().add(lblRespuestaDeSeguridad);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(239, 55, 114, 19);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPreg = new JTextField();
		txtPreg.setBounds(239, 190, 114, 19);
		getContentPane().add(txtPreg);
		txtPreg.setColumns(10);
		
		txtResp = new JTextField();
		txtResp.setText("");
		txtResp.setBounds(239, 228, 114, 19);
		getContentPane().add(txtResp);
		txtResp.setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==this)
				{
					String passAnt = new String(txtPassAnt.getPassword());
					String passN = new String(txtPassN.getPassword());
					String passRep = new String(txtPassRep.getPassword());
					if (passN.equals(passRep))
					{
						if(C_Usuario.getMiUsuario().cambiarPass(txtUsuario.getText(), passAnt, passN, txtPreg.getText(), txtResp.getText()))
							JOptionPane.showMessageDialog(null,"Se han actualizado tus datos correctamente.");
						else
							JOptionPane.showMessageDialog(null,"El usuario y la contraseña no coinciden.");
					}
					else
					JOptionPane.showMessageDialog(null,"Las nuevas contraseñas no coinciden.");
				}
			}
		});
		btnValidar.setBounds(365, 199, 117, 25);
		getContentPane().add(btnValidar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==this)
				dispose();
			}
		});
		btnVolver.setBounds(365, 236, 117, 25);
		getContentPane().add(btnVolver);
		
		txtPassAnt = new JPasswordField();
		txtPassAnt.setBounds(239, 86, 114, 21);
		getContentPane().add(txtPassAnt);
		
		txtPassN = new JPasswordField();
		txtPassN.setBounds(239, 119, 114, 19);
		getContentPane().add(txtPassN);
		
		txtPassRep = new JPasswordField();
		txtPassRep.setBounds(239, 156, 114, 19);
		getContentPane().add(txtPassRep);
	}
}
