package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

import liga.packControladoras.C_Conf_Temp;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Conf_Temp extends JFrame {

	private JPanel contentPane;
	private JLabel lblEquiposElegidos;
	private JList listEquipos;
	private JScrollPane scrollEquipos;
	private JLabel lblrbitrosElegidos;
	private JList listArbitros;
	private JScrollPane scrollArbitros;
	private JButton btnAnadirEquipo;
	private JButton btnEliminarEquipo;
	private JButton btnAnadirArbitro;
	private JButton btnEliminarArbitro;
	private JButton btnRealizarSorteo;
	private JButton btnCancelar;
	private JLabel lblFechaDeInicio;
	private JDateChooser comboFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Conf_Temp frame = new IU_Conf_Temp();
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
	public IU_Conf_Temp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblEquiposElegidos());
		contentPane.add(getScrollEquipos());
		contentPane.add(getLblrbitrosElegidos());
		contentPane.add(getScrollArbitros());
		contentPane.add(getBtnAnadirEquipo());
		contentPane.add(getBtnEliminarEquipo());
		contentPane.add(getBtnAnadirArbitro());
		contentPane.add(getBtnEliminarArbitro());
		contentPane.add(getBtnRealizarSorteo());
		contentPane.add(getBtnCancelar());
		contentPane.add(getLblFechaDeInicio());
		contentPane.add(getComboFecha());
		
		//registramos la ventana en el ccontrolador
		C_Conf_Temp.getMiC_Conf_Temp().setIU_Conf_Temp(this);
		
		//Comprobamos y obtenemos la fecha de fin de la ultima temporada
		Date fecha = C_Conf_Temp.getMiC_Conf_Temp().obtenerFechaFinUltimaTemporada();
		Date fechaActual = new Date();
		//suponemos que la temporada anterior ha finalizado
		boolean temporadaFinalizada = true;
		//comprobamos si habia temporada anterior
		if(fecha != null)
		{//y miramos si se ha acabado
			if(fechaActual.before(fecha))
			{
				//si llega aqui es que todavia no se ha acabado la temporada anterior
				temporadaFinalizada = false;
			}
		}
		
		if(temporadaFinalizada)
		{
			//en caso de que haya una temporada anterior (terminada)
			if(fecha != null)
			{
				//establecemos como fecha de inicio la de fin de la anterior
				comboFecha.setDate(fecha);
				//cargamos los arbitros de la temporada anterior y los equipos que pasan
				C_Conf_Temp.getMiC_Conf_Temp().obtenerEquiposQuePasan();
				C_Conf_Temp.getMiC_Conf_Temp().obtenerArbitrosTemporada();
			}
			
			
		}
		else
		{
			//si la temporada no ha finalizado, desactivamos los botones
			btnRealizarSorteo.setEnabled(false);
			btnAnadirArbitro.setEnabled(false);
			btnAnadirEquipo.setEnabled(false);
			btnEliminarArbitro.setEnabled(false);
			btnEliminarEquipo.setEnabled(false);
			comboFecha.setEnabled(false);
			JOptionPane.showMessageDialog(null, "La temporada anterior no ha finalizado", "Error", JOptionPane.ERROR_MESSAGE);
			//solo podra dar a cancelar
		}
	}
	

	private JLabel getLblEquiposElegidos() {
		if (lblEquiposElegidos == null) {
			lblEquiposElegidos = new JLabel("Equipos elegidos:");
			lblEquiposElegidos.setBounds(12, 12, 126, 15);
		}
		return lblEquiposElegidos;
	}
	private JList getListEquipos() {
		if (listEquipos == null) {
			listEquipos = new JList();
		}
		return listEquipos;
	}
	private JScrollPane getScrollEquipos() {
		if (scrollEquipos == null) {
			scrollEquipos = new JScrollPane();
			scrollEquipos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollEquipos.setBounds(10, 39, 164, 262);
			scrollEquipos.setViewportView(getListEquipos());
		}
		return scrollEquipos;
	}
	private JLabel getLblrbitrosElegidos() {
		if (lblrbitrosElegidos == null) {
			lblrbitrosElegidos = new JLabel("Árbitros elegidos:");
			lblrbitrosElegidos.setBounds(195, 12, 146, 15);
		}
		return lblrbitrosElegidos;
	}
	private JList getListArbitros() {
		if (listArbitros == null) {
			listArbitros = new JList();
		}
		return listArbitros;
	}
	private JScrollPane getScrollArbitros() {
		if (scrollArbitros == null) {
			scrollArbitros = new JScrollPane();
			scrollArbitros.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollArbitros.setBounds(195, 39, 162, 264);
			scrollArbitros.setViewportView(getListArbitros());
		}
		return scrollArbitros;
	}
	private JButton getBtnAnadirEquipo() {
		if (btnAnadirEquipo == null) {
			btnAnadirEquipo = new JButton("Añadir");
			btnAnadirEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//hacemos esta ventana no visibe y abrimos la interfaz nueva
					setVisible(false);
					IU_Anadir_Equipo ventana = new IU_Anadir_Equipo();
					ventana.setVisible(true);
				}
			});
			btnAnadirEquipo.setBounds(12, 317, 164, 25);
		}
		return btnAnadirEquipo;
	}
	private JButton getBtnEliminarEquipo() {
		if (btnEliminarEquipo == null) {
			btnEliminarEquipo = new JButton("Eliminar");
			btnEliminarEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					C_Conf_Temp.getMiC_Conf_Temp().eliminarEquipo();
				}
			});
			btnEliminarEquipo.setBounds(12, 354, 164, 25);
		}
		return btnEliminarEquipo;
	}
	private JButton getBtnAnadirArbitro() {
		if (btnAnadirArbitro == null) {
			btnAnadirArbitro = new JButton("Añadir");
			btnAnadirArbitro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//hacemos esta ventana no visible y abrimos la interfaz nueva
					setVisible(false);
					IU_Anadir_Equipo ventana = new IU_Anadir_Equipo();
					ventana.setVisible(true);
				}
			});
			btnAnadirArbitro.setBounds(195, 317, 164, 25);
		}
		return btnAnadirArbitro;
	}
	private JButton getBtnEliminarArbitro() {
		if (btnEliminarArbitro == null) {
			btnEliminarArbitro = new JButton("Eliminar");
			btnEliminarArbitro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					C_Conf_Temp.getMiC_Conf_Temp().eliminarArbitro();
				}
			});
			btnEliminarArbitro.setBounds(195, 354, 164, 25);
		}
		return btnEliminarArbitro;
	}
	private JButton getBtnRealizarSorteo() {
		if (btnRealizarSorteo == null) {
			btnRealizarSorteo = new JButton("Realizar sorteo");
			btnRealizarSorteo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					C_Conf_Temp.getMiC_Conf_Temp().inicializarTemporada();
				}
			});
			btnRealizarSorteo.setBounds(428, 191, 164, 68);
		}
		return btnRealizarSorteo;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//reiniciamos la informacion guardada en el controlador
					C_Conf_Temp.getMiC_Conf_Temp().resetear();
					
					//cerramos esta ventana
					dispose();
				}
			});
			btnCancelar.setBounds(428, 271, 164, 25);
		}
		return btnCancelar;
	}
	private JLabel getLblFechaDeInicio() {
		if (lblFechaDeInicio == null) {
			lblFechaDeInicio = new JLabel("Fecha de inicio:");
			lblFechaDeInicio.setBounds(428, 12, 126, 15);
		}
		return lblFechaDeInicio;
	}
	public JDateChooser getComboFecha() {
		if (comboFecha == null) {
			comboFecha = new JDateChooser();
			comboFecha.setDateFormatString("yyyy-MM-dd");
			comboFecha.setBounds(428, 39, 164, 24);
		}
		return comboFecha;
	}

	public void setEquipos(String[] nombres) {
		this.listEquipos.setListData(nombres);
		
	}
	
	public void setArbitros(String[] nombres) {
		this.listArbitros.setListData(nombres);
		
	}
	
}
