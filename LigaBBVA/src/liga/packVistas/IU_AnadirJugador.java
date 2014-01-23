package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import liga.packControladoras.C_GestionEquipo;

@SuppressWarnings("serial")
public class IU_AnadirJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblDorsal;
	private JTextField textFieldNombre;
	private JTextField textFieldDorsal;

	/**
	 * Create the dialog.
	 */
	public IU_AnadirJugador() {
		setBounds(100, 100, 450, 300);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDatosDelJugador = new JLabel("Datos del jugador");
			lblDatosDelJugador.setBounds(12, 12, 127, 15);
			contentPanel.add(lblDatosDelJugador);
		}
		contentPanel.add(getLblNombre());
		contentPanel.add(getLblDorsal());
		contentPanel.add(getTextFieldNombre());
		contentPanel.add(getTextFieldDorsal());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = textFieldNombre.getText(), dorsal = textFieldDorsal.getText();
						if (nombre.isEmpty() || dorsal.isEmpty())
							JOptionPane.showMessageDialog(null, "Hay algún campo sin rellenar.");
						else {
							if (!dorsal.matches("[0-9]{1,2}")) {
								JOptionPane.showMessageDialog(null, "El dorsal debe ser un número de máximo 2 cifras.");
							} else if (!nombre.matches("[A-Za-z ]*")) {
								JOptionPane.showMessageDialog(null, "El nombre sólo puede contener caracteres y espacios.");
							} else {
								if (C_GestionEquipo.getC_GestionEquipo().anadirJugador(nombre, dorsal))
									dispose();
								else
									JOptionPane.showMessageDialog(null, "Ha habido un error.");
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(12, 39, 70, 15);
		}
		return lblNombre;
	}
	private JLabel getLblDorsal() {
		if (lblDorsal == null) {
			lblDorsal = new JLabel("Dorsal");
			lblDorsal.setBounds(12, 68, 70, 15);
		}
		return lblDorsal;
	}
	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(74, 39, 114, 19);
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}
	private JTextField getTextFieldDorsal() {
		if (textFieldDorsal == null) {
			textFieldDorsal = new JTextField();
			textFieldDorsal.setColumns(10);
			textFieldDorsal.setBounds(74, 66, 114, 19);
		}
		return textFieldDorsal;
	}
}
