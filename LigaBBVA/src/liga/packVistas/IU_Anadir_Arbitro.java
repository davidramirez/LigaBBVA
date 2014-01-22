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

import liga.packControladoras.C_Conf_Temp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Anadir_Arbitro extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JScrollPane scrollPane;
	private JButton btnAadirAlCatlogo;
	private JButton btnAadirrbitro;
	private JButton btnAtras;
	
	//esto lo hacemos para poder dar esta ventana como parametro,
	//dentro de un ActionListener
	private IU_Anadir_Arbitro ventana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Anadir_Arbitro frame = new IU_Anadir_Arbitro();
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
	public IU_Anadir_Arbitro() {
		ventana = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnAadirAlCatlogo());
		contentPane.add(getBtnAadirrbitro());
		contentPane.add(getBtnAtras());
		
		
		//obtenemos los arbitros no seleccionados para listarlos
		this.getList().setListData(C_Conf_Temp.getMiC_Conf_Temp().obtenerArbitrosNoSeleccionados());
		
		
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
	private JButton getBtnAadirrbitro() {
		if (btnAadirrbitro == null) {
			btnAadirrbitro = new JButton("Añadir Árbitro");
			btnAadirrbitro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//si le pasaramos this, seria el actionListener
					C_Conf_Temp.getMiC_Conf_Temp().anadirArbitrosSeleccionados(ventana);
				}
			});
			btnAadirrbitro.setBounds(253, 12, 133, 25);
		}
		return btnAadirrbitro;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					C_Conf_Temp.getMiC_Conf_Temp().restaurarVentanaConf();
					dispose();
				}
			});
			btnAtras.setBounds(253, 49, 133, 25);
		}
		return btnAtras;
	}
}
