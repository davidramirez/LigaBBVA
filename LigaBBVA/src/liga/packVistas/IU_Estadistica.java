package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Box;

import net.sf.jga.fn.arithmetic.ValueOf;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import liga.packControladoras.C_Estadisticas;
import liga.packControladoras.CatalogoJugadores;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class IU_Estadistica extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldClasificacionEq;
	private JTextField textFieldGoles;
	private JTextField textFieldSanciones;
	private JComboBox<Integer> comboBoxTemporadas;
	private JComboBox <Integer> comboJornadas;
	private JRadioButton rdbtnEquipo;
	private JRadioButton rdbtnJugador;
	private ArrayList<Integer> temporadas;
	private ArrayList<Integer> jornadas;
	private String[][] jugadores;
	private String[]equipos;
	private int[] estJug;
	private JComboBox<String> comboBoxNombreEq;
	private JComboBox<String> comboboxEquipo;
	private JComboBox<String> comboBoxJugador;
	private int tempSelect;
	private int jorSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Estadistica frame = new IU_Estadistica();
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
	public IU_Estadistica() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					dispose();
				}
			}
		});
		btnVolver.setBounds(487, 335, 117, 25);
		contentPane.add(btnVolver);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar){
					dispose();
				}
			}
		});
		btnAceptar.setBounds(361, 335, 117, 25);
		contentPane.add(btnAceptar);
		
		rdbtnEquipo = new JRadioButton("Equipo");
		rdbtnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnEquipo )
				{
					comboBoxTemporadas.removeAllItems();
					temporadas=C_Estadisticas.getMisEstadisticas().obtenerTemporadas();
					Iterator<Integer> itr =temporadas.iterator();
					while(itr.hasNext())
					{
						int item=itr.next();
						comboBoxTemporadas.addItem(item);
						
					}	
					
				}
			}
		});
		rdbtnEquipo.setBounds(27, 21, 149, 23);
		contentPane.add(rdbtnEquipo);
		
		rdbtnJugador = new JRadioButton("Jugador");
		rdbtnJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnJugador){
					comboBoxTemporadas.removeAllItems();
					comboBoxNombreEq.removeAllItems();
					textFieldClasificacionEq.setText("");
					temporadas=C_Estadisticas.getMisEstadisticas().obtenerTemporadas();
					Iterator<Integer> itr =temporadas.iterator();
					while(itr.hasNext())
					{
						int item=itr.next();
						comboBoxTemporadas.addItem(item);
					}					
				}
			}
		});
		rdbtnJugador.setBounds(318, 21, 149, 23);
		contentPane.add(rdbtnJugador);
		
		ButtonGroup grupo =new ButtonGroup();
		grupo.add(rdbtnJugador);
		grupo.add(rdbtnEquipo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(300, 24, 28, 173);
		contentPane.add(separator);
		
		JLabel lblNombreEq = new JLabel("Nombre");
		lblNombreEq.setBounds(37, 59, 70, 15);
		contentPane.add(lblNombreEq);
		
		comboBoxNombreEq = new JComboBox<String>();
		comboBoxNombreEq.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					textFieldClasificacionEq.setText(String.valueOf(comboBoxNombreEq.getSelectedIndex()+1));
				}
			}
		});
		
		comboBoxNombreEq.setBounds(114, 54, 174, 24);
		contentPane.add(comboBoxNombreEq);
		
		JLabel lblClasificacinEq = new JLabel("Clasificación");
		lblClasificacinEq.setBounds(37, 127, 117, 15);
		contentPane.add(lblClasificacinEq);
		
		textFieldClasificacionEq = new JTextField();
		textFieldClasificacionEq.setBounds(174, 125, 114, 19);
		contentPane.add(textFieldClasificacionEq);
		textFieldClasificacionEq.setColumns(10);
		
		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setBounds(27, 247, 107, 15);
		contentPane.add(lblTemporada);
		
		JLabel lblJornada = new JLabel("Jornada");
		lblJornada.setBounds(342, 247, 70, 15);
		contentPane.add(lblJornada);
		
		comboBoxTemporadas = new JComboBox<Integer>();
		comboBoxTemporadas.setEditable(false);
		comboBoxTemporadas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					comboJornadas.removeAllItems();
					tempSelect=(int)comboBoxTemporadas.getSelectedItem();
					jornadas=C_Estadisticas.getMisEstadisticas().obtenerJornadasDe(tempSelect);					
					Iterator<Integer> itr =jornadas.iterator();
					while(itr.hasNext()){
						comboJornadas.addItem(itr.next());
					}
				}
			}
		});
		
		this.comboBoxTemporadas.setBounds(138, 242, 48, 24);
		contentPane.add(comboBoxTemporadas);
		
		comboJornadas = new JComboBox<Integer>();
		comboJornadas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					if(rdbtnEquipo.isSelected())
					{
						comboboxEquipo.removeAllItems();
						comboBoxJugador.removeAllItems();
						comboBoxNombreEq.removeAllItems();
						textFieldGoles.setText("");
						textFieldSanciones.setText("");						
						tempSelect=(int)comboBoxTemporadas.getSelectedItem();
						jorSelect=(int)comboJornadas.getSelectedItem();
						equipos=C_Estadisticas.getMisEstadisticas().obtenerClasificacion(tempSelect, jorSelect);
					
						for(int i=0;i<equipos.length;i++){
						comboBoxNombreEq.addItem(equipos[i]);
						}
					}
					else if(rdbtnJugador.isSelected())
					{
						comboBoxNombreEq.removeAllItems();
						textFieldClasificacionEq.setText("");
						comboboxEquipo.removeAllItems();
						tempSelect=(int)comboBoxTemporadas.getSelectedItem();
						jorSelect=(int)comboJornadas.getSelectedItem();
						equipos=C_Estadisticas.getMisEstadisticas().obtenerClasificacion(tempSelect, jorSelect);
					
						for(int i=0;i<equipos.length;i++){
						comboboxEquipo.addItem(equipos[i]);
						}
						
					}
				}
			}
		});
		
		comboJornadas.setBounds(430, 242, 48, 24);
		contentPane.add(comboJornadas);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(318, 59, 70, 15);
		contentPane.add(lblEquipo);
		
		comboboxEquipo = new JComboBox<String>();
		comboboxEquipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					String elEq=(String) comboboxEquipo.getSelectedItem();
					jugadores=C_Estadisticas.getMisEstadisticas().getListaJugadores(elEq);
					comboBoxJugador.removeAllItems();
					for(int i=0;i<CatalogoJugadores.getCatalogoJugadores().getNumJugadores(elEq);i++){
						comboBoxJugador.addItem(jugadores[i][1]);
					}
				}
			}
		});
		comboboxEquipo.setBounds(406, 52, 179, 24);
		contentPane.add(comboboxEquipo);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(318, 101, 70, 15);
		contentPane.add(lblJugador);
		
		comboBoxJugador = new JComboBox<String>();
		comboBoxJugador.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED){
				String elEq=(String) comboboxEquipo.getSelectedItem();
				jugadores=C_Estadisticas.getMisEstadisticas().getListaJugadores(elEq);
				int codJug=Integer.parseInt(jugadores[comboBoxJugador.getSelectedIndex()][0]);
				estJug=C_Estadisticas.getMisEstadisticas().obtenerEstadistica(codJug);	
				textFieldGoles.setText(String.valueOf(estJug[1]));
				textFieldSanciones.setText(String.valueOf(estJug[0]));
				
			}
			}
		});
		comboBoxJugador.setBounds(406, 96, 179, 24);
		contentPane.add(comboBoxJugador);
		
		JLabel lblGoles = new JLabel("Goles");
		lblGoles.setBounds(318, 141, 70, 15);
		contentPane.add(lblGoles);
		
		JLabel lblSanciones = new JLabel("Sanciones");
		lblSanciones.setBounds(318, 168, 94, 15);
		contentPane.add(lblSanciones);
		
		textFieldGoles = new JTextField();
		textFieldGoles.setBounds(471, 139, 114, 19);
		contentPane.add(textFieldGoles);
		textFieldGoles.setColumns(10);
		
		textFieldSanciones = new JTextField();
		textFieldSanciones.setBounds(471, 166, 114, 19);
		contentPane.add(textFieldSanciones);
		textFieldSanciones.setColumns(10);
	}
}
