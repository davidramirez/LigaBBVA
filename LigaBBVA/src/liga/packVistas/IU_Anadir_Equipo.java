package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import liga.packControladoras.C_Conf_Temp;

public class IU_Anadir_Equipo extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JScrollPane scrollPane;
	private JButton btnAadirAlCatlogo;
	private JButton btnAadirEquipo;
	private JButton btnAtrs;
	
	//esto lo hacemos para poder dar esta ventana como parametro,
	//dentro de un ActionListener
	private IU_Anadir_Equipo ventana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Anadir_Equipo frame = new IU_Anadir_Equipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_Anadir_Equipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnAadirAlCatlogo());
		contentPane.add(getBtnAadirEquipo());
		contentPane.add(getBtnAtrs());
		
		//obtenemos los equipos no seleccionados para listarlos
		this.getList().setListData(C_Conf_Temp.getMiC_Conf_Temp().obtenerEquiposNoSeleccionados());
	}

	public JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(12, 12, 220, 278);
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JButton getBtnAadirAlCatlogo() {
		if (btnAadirAlCatlogo == null) {
			btnAadirAlCatlogo = new JButton("Añadir al catálogo");
			btnAadirAlCatlogo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//temporal hasta que se haga la otra interfaz
					getBtnAadirAlCatlogo().setEnabled(false);
				}
			});
			btnAadirAlCatlogo.setBounds(12, 321, 202, 25);
		}
		return btnAadirAlCatlogo;
	}
	private JButton getBtnAadirEquipo() {
		if (btnAadirEquipo == null) {
			btnAadirEquipo = new JButton("Añadir Equipo");
			btnAadirEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					C_Conf_Temp.getMiC_Conf_Temp().anadirEquiposSeleccinados(ventana);
				}
			});
			btnAadirEquipo.setBounds(256, 12, 133, 25);
		}
		return btnAadirEquipo;
	}
	private JButton getBtnAtrs() {
		if (btnAtrs == null) {
			btnAtrs = new JButton("Atrás");
			btnAtrs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					C_Conf_Temp.getMiC_Conf_Temp().restaurarVentanaConf();
					dispose();
				}
			});
			btnAtrs.setBounds(256, 49, 133, 25);
		}
		return btnAtrs;
	}
}