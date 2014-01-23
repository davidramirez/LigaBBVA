package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

import liga.packControladoras.C_GestionEquipo;

@SuppressWarnings("serial")
public class IU_ConvocarJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPoner;
	private JButton btnQuitar;
	private String[][] jugadoresConvocables;
	private String[][] jugadoresConvocados = new String[18][3];
	private DefaultListModel<String> modeloConvocables = new DefaultListModel<String>();
	private DefaultListModel<String> modeloConvocados = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IU_ConvocarJugadores dialog = new IU_ConvocarJugadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IU_ConvocarJugadores() {
		this.setModal(true);
		C_GestionEquipo.getC_GestionEquipo().setEquipo("Athletic"); // Parche.
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JList<String> listConvocables = new JList<String>();
			listConvocables.setBounds(12, 47, 156, 180);
			this.actualizarModeloConvocables();
			listConvocables.setModel(this.modeloConvocables);
			contentPanel.add(listConvocables);
		}
		{
			JList<String> listAConvocar = new JList<String>();
			listAConvocar.setBounds(278, 47, 156, 180);
			contentPanel.add(listAConvocar);
		}
		{
			JLabel lblJugadoresConvocables = new JLabel("Jugadores convocables");
			lblJugadoresConvocables.setBounds(12, 20, 191, 15);
			contentPanel.add(lblJugadoresConvocables);
		}
		{
			JLabel lblJugadoresAConvocar = new JLabel("Jugadores a convocar");
			lblJugadoresAConvocar.setHorizontalAlignment(SwingConstants.RIGHT);
			lblJugadoresAConvocar.setBounds(243, 20, 191, 15);
			contentPanel.add(lblJugadoresAConvocar);
		}
		contentPanel.add(getBtnPoner());
		contentPanel.add(getBtnQuitar());
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
	private JButton getBtnPoner() {
		if (btnPoner == null) {
			btnPoner = new JButton(">");
			btnPoner.setBounds(200, 70, 44, 25);
		}
		return btnPoner;
	}
	private JButton getBtnQuitar() {
		if (btnQuitar == null) {
			btnQuitar = new JButton("<");
			btnQuitar.setBounds(200, 107, 44, 25);
		}
		return btnQuitar;
	}
	
	private void actualizarModeloConvocables() {
		java.util.Date aux = new java.util.Date();
		Date fecha = new Date(aux.getTime());
		this.jugadoresConvocables = C_GestionEquipo.getC_GestionEquipo().getJugadoresConvocables(fecha);
		for (int i = 0; i < this.jugadoresConvocables.length; i++)
			this.modeloConvocables.addElement(this.jugadoresConvocables[i][1]);
	}
	
	private void actualizarModeloConvocados() {
		java.util.Date aux = new java.util.Date();
		Date fecha = new Date(aux.getTime());
		this.jugadoresConvocables = C_GestionEquipo.getC_GestionEquipo().getJugadoresConvocables(fecha);
		for (int i = 0; i < this.jugadoresConvocables.length; i++)
			this.modeloConvocables.addElement(this.jugadoresConvocables[i][1]);
	}
}
