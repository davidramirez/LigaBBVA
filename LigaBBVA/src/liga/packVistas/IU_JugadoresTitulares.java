package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import liga.packControladoras.C_GestionEquipo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_JugadoresTitulares extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPoner;
	private JButton btnQuitar;
	private JList<String> listConvocados;
	private JList<String> listTitulares;
	
	private Date fecha;
	private String[][] jugadoresConvocados;
	private DefaultListModel<String> modeloConvocados = new DefaultListModel<String>();
	private DefaultListModel<String> modeloTitulares = new DefaultListModel<String>();

	/**
	 * Create the dialog.
	 */
	public IU_JugadoresTitulares(final Date fecha) {
		this.modeloConvocados.clear();
		this.modeloTitulares.clear();
		
		this.setModal(true);
		
		this.fecha = fecha;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			listConvocados = new JList<String>();
			listConvocados.setBounds(12, 47, 156, 180);
			this.actualizarModeloConvocados();
			listConvocados.setModel(this.modeloConvocados);
			listConvocados.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					/* Si hay algún jugador seleccionado, se activarán los botones. */
					if (!e.getValueIsAdjusting()) {
						if (listConvocados.getSelectedIndex() == -1) {
							btnPoner.setEnabled(false);
						} else {
							btnPoner.setEnabled(true);
							btnQuitar.setEnabled(false);
						}
				    }
				}
			});
			contentPanel.add(listConvocados);
		}
		{
			listTitulares = new JList<String>();
			listTitulares.setBounds(278, 47, 156, 180);
			listTitulares.setModel(this.modeloTitulares);
			listTitulares.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					/* Si hay algún jugador seleccionado, se activarán los botones. */
					if (!e.getValueIsAdjusting()) {
						if (listTitulares.getSelectedIndex() == -1) {
							btnQuitar.setEnabled(false);
						} else {
							btnPoner.setEnabled(false);
							btnQuitar.setEnabled(true);
						}
				    }
				}
			});
			contentPanel.add(listTitulares);
		}
		{
			JLabel lblJugadoresConvocados = new JLabel("Jugadores convocados");
			lblJugadoresConvocados.setBounds(12, 20, 191, 15);
			contentPanel.add(lblJugadoresConvocados);
		}
		{
			JLabel lblJugadoresTitulares = new JLabel("Jugadores titulares");
			lblJugadoresTitulares.setHorizontalAlignment(SwingConstants.RIGHT);
			lblJugadoresTitulares.setBounds(243, 20, 191, 15);
			contentPanel.add(lblJugadoresTitulares);
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
					public void actionPerformed(ActionEvent e) {
						int jugadoresSeleccionados = modeloTitulares.getSize();
						if (jugadoresSeleccionados == 11) {
							String[] jugadoresTitulares = new String[jugadoresSeleccionados];
							for (int i = 0; i < jugadoresSeleccionados; i++) {
								String[] fields = modeloTitulares.get(i).split(" "); 
								jugadoresTitulares[i] = fields[0];
							}
							C_GestionEquipo.getC_GestionEquipo().anadirJugadoresTitulares(jugadoresTitulares, fecha);
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
			btnPoner.setEnabled(false);
			btnPoner.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = listConvocados.getSelectedIndex();
					modeloTitulares.addElement(modeloConvocados.elementAt(indice));
					modeloConvocados.removeElementAt(indice);
				}
			});
			btnPoner.setBounds(200, 70, 44, 25);
		}
		return btnPoner;
	}
	private JButton getBtnQuitar() {
		if (btnQuitar == null) {
			btnQuitar = new JButton("<");
			btnQuitar.setEnabled(false);
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = listTitulares.getSelectedIndex();
					modeloConvocados.addElement(modeloTitulares.elementAt(indice));
					modeloTitulares.removeElementAt(indice);
				}
			});
			btnQuitar.setBounds(200, 107, 44, 25);
		}
		return btnQuitar;
	}

	private void actualizarModeloConvocados() {
		this.jugadoresConvocados = C_GestionEquipo.getC_GestionEquipo().getJugadoresConvocados(this.fecha);
		for (int i = 0; i < this.jugadoresConvocados.length; i++) {
			if (this.jugadoresConvocados[i][0] != null)
				this.modeloConvocados.addElement(this.jugadoresConvocados[i][0] + " " + this.jugadoresConvocados[i][1]);
		}
	}
}