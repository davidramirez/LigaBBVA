package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import liga.packControladoras.*;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class IU_Inicial extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Inicial frame = new IU_Inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public IU_Inicial() {
		setResizable(false);
		getContentPane().setLayout(null);
	
		this.setSize(470, 300);
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
		
		final JButton btnIniciarSesin = new JButton("Iniciar sesión");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnIniciarSesin)
				{
					String pass = new String(txtPass.getPassword());
					if(C_Usuario.getMiUsuario().identificarse(txtUsuario.getText(), pass))
					{
						switch(C_Usuario.getMiUsuario().obtenerTipo(txtUsuario.getText()))
						{
						case "arbitro":
							//TODO abrir interfaz árbitro
						case "equipo":
							String nombreEq=C_Usuario.getMiUsuario().obtenerEquipoDe(txtUsuario.getText());
							IU_GestionEquipo IU_GE = new IU_GestionEquipo(txtUsuario.getText(),nombreEq);
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
			}
		});
		btnIniciarSesin.setBounds(44, 141, 196, 25);
		getContentPane().add(btnIniciarSesin);
		
		final JButton btnCambiarContrasea = new JButton("Cambiar contraseña");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCambiarContrasea)
				{
					IU_CambiarPass IU_CP = new IU_CambiarPass();
					IU_CP.setVisible(true);
				}
			}
		});
		btnCambiarContrasea.setBounds(44, 177, 196, 25);
		getContentPane().add(btnCambiarContrasea);
		
		final JButton btnRecuperarContrasea = new JButton("Recuperar contraseña");
		btnRecuperarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRecuperarContrasea)
				{
					IU_RecPass IU_RP = new IU_RecPass(txtUsuario.getText());
					IU_RP.setVisible(true);
				}
			}
		});
		btnRecuperarContrasea.setBounds(44, 214, 196, 25);
		getContentPane().add(btnRecuperarContrasea);
		
		final JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSalir)
					dispose();
				
				
	
			}
		});
		btnSalir.setBounds(335, 236, 117, 25);
		getContentPane().add(btnSalir);
		
		final JButton btnAccesoSinRegistro = new JButton("Acceso sin registro");
		btnAccesoSinRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAccesoSinRegistro)
				{
					IU_Usuario IU_US = new IU_Usuario();
					IU_US.setVisible(true);
				}
				
			}
		});
		btnAccesoSinRegistro.setBounds(335, 67, 117, 49);
		getContentPane().add(btnAccesoSinRegistro);
		
		JLabel lblBienvenidoALa = new JLabel("Bienvenido a la liga BBVA");
		lblBienvenidoALa.setBounds(137, 12, 207, 15);
		getContentPane().add(lblBienvenidoALa);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(141, 99, 122, 19);
		getContentPane().add(txtPass);
	}
}
