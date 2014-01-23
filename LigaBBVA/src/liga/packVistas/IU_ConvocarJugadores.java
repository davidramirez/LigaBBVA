package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JList<String> listConvocables;
	private JList<String> listAConvocar;
	
	private Date fecha;
	private String[][] jugadoresConvocables;
	private DefaultListModel<String> modeloConvocables = new DefaultListModel<String>();
	private DefaultListModel<String> modeloAConvocar = new DefaultListModel<String>();

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
		this.modeloConvocables.clear();
		this.modeloAConvocar.clear();
		
		this.setModal(true);
		
		C_GestionEquipo.getC_GestionEquipo().setEquipo("Athletic"); // Parche.
		java.util.Date aux = new java.util.Date();
		this.fecha = new Date(aux.getTime()); // Parche.
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			listConvocables = new JList<String>();
			listConvocables.setBounds(12, 47, 156, 180);
			this.actualizarModeloConvocables();
			listConvocables.setModel(this.modeloConvocables);
			listConvocables.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					/* Si hay algún jugador seleccionado, se activarán los botones. */
					if (!e.getValueIsAdjusting()) {
						if (listConvocables.getSelectedIndex() == -1) {
							btnPoner.setEnabled(false);
						} else {
							btnPoner.setEnabled(true);
							btnQuitar.setEnabled(false);
						}
				    }
				}
			});
			contentPanel.add(listConvocables);
		}
		{
			listAConvocar = new JList<String>();
			listAConvocar.setBounds(278, 47, 156, 180);
			listAConvocar.setModel(this.modeloAConvocar);
			listAConvocar.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					/* Si hay algún jugador seleccionado, se activarán los botones. */
					if (!e.getValueIsAdjusting()) {
						if (listAConvocar.getSelectedIndex() == -1) {
							btnQuitar.setEnabled(false);
						} else {
							btnPoner.setEnabled(false);
							btnQuitar.setEnabled(true);
						}
				    }
				}
			});
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int jugadoresSeleccionados = modeloAConvocar.getSize();
						if (jugadoresSeleccionados > 10 && jugadoresSeleccionados < 19) {
							String[] jugadoresAConvocar = new String[jugadoresSeleccionados];
							for (int i = 0; i < jugadoresSeleccionados; i++) {
								String[] fields = modeloAConvocar.get(i).split(" "); 
								jugadoresAConvocar[i] = fields[0];
							}
							C_GestionEquipo.getC_GestionEquipo().anadirJugadoresConvocados(jugadoresAConvocar, fecha);
							dispose();
						} else
							JOptionPane.showMessageDialog(null, "Todavía no se puede realizar la operación.");
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
	private JButton getBtnPoner() {
		if (btnPoner == null) {
			btnPoner = new JButton(">");
			btnPoner.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = listConvocables.getSelectedIndex();
					modeloAConvocar.addElement(modeloConvocables.elementAt(indice));
					modeloConvocables.removeElementAt(indice);
				}
			});
			btnPoner.setEnabled(false);
			btnPoner.setBounds(200, 70, 44, 25);
		}
		return btnPoner;
	}
	private JButton getBtnQuitar() {
		if (btnQuitar == null) {
			btnQuitar = new JButton("<");
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = listAConvocar.getSelectedIndex();
					modeloConvocables.addElement(modeloAConvocar.elementAt(indice));
					modeloAConvocar.removeElementAt(indice);
				}
			});
			btnQuitar.setEnabled(false);
			btnQuitar.setBounds(200, 107, 44, 25);
		}
		return btnQuitar;
	}
	
	private void actualizarModeloConvocables() {
		this.jugadoresConvocables = C_GestionEquipo.getC_GestionEquipo().getJugadoresConvocables(this.fecha);
		for (int i = 0; i < this.jugadoresConvocables.length; i++) {
			if (this.jugadoresConvocables[i][0] != null)
				this.modeloConvocables.addElement(this.jugadoresConvocables[i][0] + " " + this.jugadoresConvocables[i][1]);
		}
	}
}
