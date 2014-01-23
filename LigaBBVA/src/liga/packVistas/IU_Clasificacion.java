package liga.packVistas;

import javax.swing.JTable; 
import javax.swing.JScrollPane; 
import javax.swing.JFrame; 

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import liga.packControladoras.C_Clasificacion;
import liga.packControladoras.Liga;
import liga.packJGA.Clasificacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private Clasificacion[] clasificacion;
	private int ulTemp;
	private int ultJor;
	
	
public IU_Clasificacion() { 
	


	initialize();
}
private void initialize() {
	setAlwaysOnTop(true);
	setResizable(false);
	setBounds(100, 100, 456, 470);
	ulTemp=C_Clasificacion.getMiClasificacion().obtenerUltimaTemporada();
	ultJor=C_Clasificacion.getMiClasificacion().obtenerUltimaJornadaDe(ulTemp);
	clasificacion=C_Clasificacion.getMiClasificacion().obtenerClasificacione(ulTemp,ultJor);	
	//Array de �String� con los titulos de las columnas 
	String[] columnNames = {"Posicion", "Nombre del equipo", "Puntos"};
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
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
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
			try
			{
			tableChampions.setModel(new DefaultTableModel(
				new Object[][] {
						
					{1, clasificacion[0].getNombreEquipo(), clasificacion[0].getPuntos()},
					{2, clasificacion[1].getNombreEquipo(), clasificacion[1].getPuntos()},
					{3, clasificacion[2].getNombreEquipo(), clasificacion[2].getPuntos()},
					{4, clasificacion[3].getNombreEquipo(), clasificacion[3].getPuntos()},
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
			}
			catch (NullPointerException n)
			{
				
				JOptionPane.showMessageDialog(null,"Numero de equipos insuficientes",n.toString(),JOptionPane.ERROR_MESSAGE);
				
				
			}
			catch(StackOverflowError s)
			{
				s.printStackTrace();
			}
			tableChampions.setBounds(12, 12, 404, 64);
		}
		return tableChampions;
	}
	private JTable getTableEuropa() {
		if (tableEuropa == null) {
			tableEuropa = new JTable();
			tableEuropa.setBackground(Color.YELLOW);
			try
			{
			tableEuropa.setModel(new DefaultTableModel(
				new Object[][] {
					{5, clasificacion[4].getNombreEquipo(), clasificacion[4].getPuntos()},
					{6, clasificacion[5].getNombreEquipo(), clasificacion[5].getPuntos()},
				},
				new String[] {
					"New column", "New column", "New column"
				}
			));			
			tableEuropa.setBounds(12, 75, 404, 32);
			}
			catch(NullPointerException n)
			{
				JOptionPane.showMessageDialog(null,"Numero de equipos insuficientes",n.toString(),JOptionPane.ERROR_MESSAGE);
				
			}
		}
		return tableEuropa;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			try{
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{7, clasificacion[6].getNombreEquipo(), clasificacion[6].getPuntos()},
					{8, clasificacion[7].getNombreEquipo(), clasificacion[7].getPuntos()},
					{9, clasificacion[8].getNombreEquipo(), clasificacion[8].getPuntos()},
					{10, clasificacion[9].getNombreEquipo(), clasificacion[9].getPuntos()},
					{11, clasificacion[10].getNombreEquipo(), clasificacion[10].getPuntos()},
					{12, clasificacion[11].getNombreEquipo(), clasificacion[11].getPuntos()},
					{13, clasificacion[12].getNombreEquipo(), clasificacion[12].getPuntos()},
					{14, clasificacion[13].getNombreEquipo(), clasificacion[13].getPuntos()},
					{15, clasificacion[14].getNombreEquipo(), clasificacion[14].getPuntos()},
					{16, clasificacion[15].getNombreEquipo(), clasificacion[15].getPuntos()},
					{17, clasificacion[16].getNombreEquipo(), clasificacion[16].getPuntos()},
				},
				new String[] {
					"New column", "New column", "New column"
				}
			));
			}			
			catch(NullPointerException n)
			{
				JOptionPane.showMessageDialog(null,"Numero de equipos insuficientes",n.toString(),JOptionPane.ERROR_MESSAGE);
			}
			}
			table.setBounds(12, 107, 404, 176);
			
		
		return table;
	}

	private JTable getTableDescenso() {
		if (tableDescenso == null) {
			tableDescenso = new JTable();
			tableDescenso.setBackground(Color.RED);
			try
			{
			tableDescenso.setModel(new DefaultTableModel(
				new Object[][] {
					{18, clasificacion[17].getNombreEquipo(), clasificacion[17].getPuntos()},
					{19, clasificacion[18].getNombreEquipo(), clasificacion[18].getPuntos()},
					{20, clasificacion[19].getNombreEquipo(), clasificacion[19].getPuntos()},
				},
				new String[] {
					"New column", "New column", "New column"
				}
			));
			tableDescenso.setBounds(12, 283, 404, 48);
			}
			catch(NullPointerException n)
			{
				JOptionPane.showMessageDialog(null,"Numero de equipos insuficientes",n.toString(),JOptionPane.ERROR_MESSAGE);
			}
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