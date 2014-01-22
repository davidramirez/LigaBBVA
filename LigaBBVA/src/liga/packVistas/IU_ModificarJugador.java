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
public class IU_ModificarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblDorsal;
	private JTextField textFieldNombre;
	private JTextField textFieldDorsal;
	@SuppressWarnings("unused")
	private String codJug;

	/**
	 * Create the dialog.
	 */
	public IU_ModificarJugador(final String codJug, String nombre, String dorsal) {
		this.codJug = codJug;
		this.setModal(true);
		setBounds(100, 100, 450, 300);
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
		contentPanel.add(getTextFieldNombre(nombre));
		contentPanel.add(getTextFieldDorsal(dorsal));
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
							if (C_GestionEquipo.getC_GestionEquipo().modificarJugador(codJug, nombre, dorsal))
								dispose();
							else
								JOptionPane.showMessageDialog(null, "Ha habido un error.");
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
	private JTextField getTextFieldNombre(String nombre) {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(74, 39, 114, 19);
			textFieldNombre.setColumns(10);
			textFieldNombre.setText(nombre);
		}
		return textFieldNombre;
	}
	private JTextField getTextFieldDorsal(String dorsal) {
		if (textFieldDorsal == null) {
			textFieldDorsal = new JTextField();
			textFieldDorsal.setColumns(10);
			textFieldDorsal.setBounds(74, 66, 114, 19);
			textFieldDorsal.setText(dorsal);
		}
		return textFieldDorsal;
	}
}
