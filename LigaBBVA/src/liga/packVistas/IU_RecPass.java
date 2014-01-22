package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_RecPass extends JFrame {
	private JTextField txtResp;
	public IU_RecPass() {
		getContentPane().setLayout(null);
		
		JLabel lblPregunta = new JLabel("New label");
		lblPregunta.setBounds(178, 62, 70, 15);
		getContentPane().add(lblPregunta);
		
		txtResp = new JTextField();
		txtResp.setBounds(160, 139, 114, 19);
		getContentPane().add(txtResp);
		txtResp.setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValidar.setBounds(160, 180, 117, 25);
		getContentPane().add(btnValidar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setBounds(304, 226, 117, 25);
		getContentPane().add(btnVolver);
	}

}
