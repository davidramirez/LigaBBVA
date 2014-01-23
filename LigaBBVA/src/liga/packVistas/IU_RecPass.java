package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import liga.packControladoras.C_Usuario;

public class IU_RecPass extends JFrame {
	private JTextField txtResp;
	private String idUsuario;
	public IU_RecPass(String id, String preg) {
		setResizable(false);
		
		idUsuario=id;
		getContentPane().setLayout(null);
		setSize(450,300);
		JLabel lblPregunta = new JLabel("New label");
		lblPregunta.setBounds(26, 62, 395, 65);
		getContentPane().add(lblPregunta);
		lblPregunta.setText(preg);
		txtResp = new JTextField();
		txtResp.setBounds(160, 139, 114, 19);
		getContentPane().add(txtResp);
		txtResp.setColumns(10);
		
		final JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnValidar)
				{
					String rdo=C_Usuario.getMiUsuario().recuperarPass(idUsuario, txtResp.getText());
					if(rdo!=null)
					JOptionPane.showMessageDialog(null,"Tu contraseña es "+rdo+"");
					else
					JOptionPane.showMessageDialog(null,"La respuesta es incorrecta.");
				}
			}
		});
		btnValidar.setBounds(160, 180, 117, 25);
		getContentPane().add(btnValidar);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver)
				dispose();
			}
		});
		btnVolver.setBounds(304, 226, 117, 25);
		getContentPane().add(btnVolver);
	}

}
