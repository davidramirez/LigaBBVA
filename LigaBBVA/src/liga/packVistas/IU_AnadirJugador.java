package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IU_AnadirJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblDorsal;
	private JTextField textFieldNombre;
	private JTextField textFieldDorsal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IU_AnadirJugador dialog = new IU_AnadirJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IU_AnadirJugador() {
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
		contentPanel.add(getTextFieldNombre());
		contentPanel.add(getTextFieldDorsal());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
