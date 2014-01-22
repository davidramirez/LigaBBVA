package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import liga.packControladoras.*;
import javax.swing.JPasswordField;

public class IU_Inicial extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	public IU_Inicial() {
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(27, 74, 70, 15);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(27, 101, 96, 15);
		getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(146, 72, 114, 19);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesión");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(txtPass.getPassword());
				if(C_Usuario.getMiUsuario().identificarse(txtUsuario.getText(), pass))
				{
					switch(C_Usuario.getMiUsuario().obtenerTipo(txtUsuario.getText()))
					{
					case "arbitro":
						//TODO abrir interfaz árbitro
					case "equipo":
						IU_GestionEquipo IU_GE = new IU_GestionEquipo(txtUsuario.getText());
						IU_GE.setVisible(true);
					case "admin":
						//TODO abrir interfaz admin
				
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos.");
				}
			}
		});
		btnIniciarSesin.setBounds(44, 141, 196, 25);
		getContentPane().add(btnIniciarSesin);
		
		JButton btnCambiarContrasea = new JButton("Cambiar contraseña");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_CambiarPass IU_CP = new IU_CambiarPass();
				IU_CP.setVisible(true);
			}
		});
		btnCambiarContrasea.setBounds(44, 177, 196, 25);
		getContentPane().add(btnCambiarContrasea);
		
		JButton btnRecuperarContrasea = new JButton("Recuperar contraseña");
		btnRecuperarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_RecPass IU_RP = new IU_RecPass(txtUsuario.getText());
				IU_RP.setVisible(true);
			}
		});
		btnRecuperarContrasea.setBounds(44, 214, 196, 25);
		getContentPane().add(btnRecuperarContrasea);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(315, 240, 117, 25);
		getContentPane().add(btnSalir);
		
		JButton btnAccesoSinRegistro = new JButton("Acceso sin registro");
		btnAccesoSinRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_Usuario IU_US = new IU_Usuario();
				IU_US.setVisible(true);
				
			}
		});
		btnAccesoSinRegistro.setBounds(301, 67, 117, 49);
		getContentPane().add(btnAccesoSinRegistro);
		
		JLabel lblBienvenidoALa = new JLabel("Bienvenido a la liga BBVA");
		lblBienvenidoALa.setBounds(137, 12, 207, 15);
		getContentPane().add(lblBienvenidoALa);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(141, 99, 122, 19);
		getContentPane().add(txtPass);
	}
}
