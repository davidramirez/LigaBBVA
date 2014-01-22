package liga.packVistas;

import javax.swing.JTable; 
import javax.swing.JScrollPane; 
import javax.swing.JFrame; 

import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class IU_Clasificacion extends JFrame {
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTemporada;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxJornada;
	private JButton btnMostrar;
	private JPanel panelTabla;
	private JTable tableChampions;
	private JTable tableEuropa;
	private JTable table;
	private JTable tableDescenso;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JLabel lblChampions;
	private JLabel lblEuropaLeague;
	private JLabel lblDescenso;

public IU_Clasificacion() { 
	


	initialize();
}
private void initialize() {
	setAlwaysOnTop(true);
	setResizable(false);
	setBounds(100, 100, 456, 470);
	/*Controlador con = Controlador.getControlador();
	con.actualizarClasificacion();
	

	//Array bidimensional de objetos con los datos de la tabla 
	Object[][] data = { 
		{1,con.devoverEquipoPos(0), con.devoverEquipoPuntos(0)}, 
		{2,con.devoverEquipoPos(1), con.devoverEquipoPuntos(1)}, 
		{3,con.devoverEquipoPos(2), con.devoverEquipoPuntos(2)}, 
		{4,con.devoverEquipoPos(3), con.devoverEquipoPuntos(3)},
		{5,con.devoverEquipoPos(4), con.devoverEquipoPuntos(4)},
		{6,con.devoverEquipoPos(5), con.devoverEquipoPuntos(5)},
		{7,con.devoverEquipoPos(6), con.devoverEquipoPuntos(6)},
		{8,con.devoverEquipoPos(7), con.devoverEquipoPuntos(7)},
		{9,con.devoverEquipoPos(8), con.devoverEquipoPuntos(8)},
		{10,con.devoverEquipoPos(9), con.devoverEquipoPuntos(9)},
		{11,con.devoverEquipoPos(10), con.devoverEquipoPuntos(10)},
		{12,con.devoverEquipoPos(11), con.devoverEquipoPuntos(11)},
		{13,con.devoverEquipoPos(12), con.devoverEquipoPuntos(12)},
		{14,con.devoverEquipoPos(13), con.devoverEquipoPuntos(13)},
		{15,con.devoverEquipoPos(14), con.devoverEquipoPuntos(14)},
		{16,con.devoverEquipoPos(15), con.devoverEquipoPuntos(15)},
		{17,con.devoverEquipoPos(16), con.devoverEquipoPuntos(16)},
		{18,con.devoverEquipoPos(17), con.devoverEquipoPuntos(17)},
		{19,con.devoverEquipoPos(18), con.devoverEquipoPuntos(18)},
		{20,con.devoverEquipoPos(19), con.devoverEquipoPuntos(19)}
	};*/
	
	//Array de �String� con los titulos de las columnas 
	String[] columnNames = {"Posici�n", "Nombre del equipo", "Puntos"};
	getContentPane().setLayout(null);
	
	getContentPane().add(getComboBoxTemporada());
	getContentPane().add(getComboBoxJornada());
	getContentPane().add(getBtnMostrar());
	getContentPane().add(getPanelTabla());
	getContentPane().add(getTable_4());
	getContentPane().add(getTable_5());
	getContentPane().add(getTable_6());
	getContentPane().add(getLblChampions());
	getContentPane().add(getLblEuropaLeague());
	getContentPane().add(getLblDescenso());
}
	private JComboBox getComboBoxTemporada() {
		if (comboBoxTemporada == null) {
			comboBoxTemporada = new JComboBox();
			comboBoxTemporada.setBounds(10, 11, 141, 20);
		}
		return comboBoxTemporada;
	}
	private JComboBox getComboBoxJornada() {
		if (comboBoxJornada == null) {
			comboBoxJornada = new JComboBox();
			comboBoxJornada.setBounds(163, 11, 148, 20);
		}
		return comboBoxJornada;
	}
	private JButton getBtnMostrar() {
		if (btnMostrar == null) {
			btnMostrar = new JButton("Mostrar");
			btnMostrar.setBounds(323, 10, 115, 23);
		}
		return btnMostrar;
	}
	private JPanel getPanelTabla() {
		if (panelTabla == null) {
			panelTabla = new JPanel();
			panelTabla.setLayout(null);
			panelTabla.add(getTableEuropa());
			panelTabla.add(getTableChampions());
			panelTabla.add(getTable());
			panelTabla.setBounds(10, 45, 428, 344);
			panelTabla.add(getTableDescenso());
		}
		return panelTabla;
	}
	@SuppressWarnings("serial")
	private JTable getTableChampions() {
		if (tableChampions == null) {
			tableChampions = new JTable();
			tableChampions.setBorder(new CompoundBorder());
			tableChampions.setBackground(Color.GREEN);
			tableChampions.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Posici\u00F3n", "Equipo", "Puntos"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tableChampions.setBounds(12, 12, 404, 64);
		}
		return tableChampions;
	}
	private JTable getTableEuropa() {
		if (tableEuropa == null) {
			tableEuropa = new JTable();
			tableEuropa.setBackground(Color.YELLOW);
			tableEuropa.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"New column", "New column", "New column"
				}
			));
			tableEuropa.setBounds(12, 75, 404, 32);
		}
		return tableEuropa;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"New column", "New column", "New column"
				}
			));
			table.setBounds(12, 107, 404, 176);
		}
		return table;
	}
	private JTable getTableDescenso() {
		if (tableDescenso == null) {
			tableDescenso = new JTable();
			tableDescenso.setBackground(Color.RED);
			tableDescenso.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"New column", "New column", "New column"
				}
			));
			tableDescenso.setBounds(12, 283, 404, 48);
		}
		return tableDescenso;
	}
	private JTable getTable_4() {
		if (table_4 == null) {
			table_4 = new JTable();
			table_4.setBackground(Color.GREEN);
			table_4.setBounds(20, 394, 131, 13);
		}
		return table_4;
	}
	private JTable getTable_5() {
		if (table_5 == null) {
			table_5 = new JTable();
			table_5.setBackground(Color.YELLOW);
			table_5.setBounds(151, 394, 131, 13);
		}
		return table_5;
	}
	private JTable getTable_6() {
		if (table_6 == null) {
			table_6 = new JTable();
			table_6.setBackground(Color.RED);
			table_6.setBounds(281, 394, 141, 13);
		}
		return table_6;
	}
	private JLabel getLblChampions() {
		if (lblChampions == null) {
			lblChampions = new JLabel("Champions");
			lblChampions.setBounds(20, 410, 131, 16);
		}
		return lblChampions;
	}
	private JLabel getLblEuropaLeague() {
		if (lblEuropaLeague == null) {
			lblEuropaLeague = new JLabel("Europa league");
			lblEuropaLeague.setBounds(150, 410, 132, 16);
		}
		return lblEuropaLeague;
	}
	private JLabel getLblDescenso() {
		if (lblDescenso == null) {
			lblDescenso = new JLabel("Descenso");
			lblDescenso.setBounds(281, 410, 120, 16);
		}
		return lblDescenso;
	}
}