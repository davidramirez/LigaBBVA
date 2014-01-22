package liga.packControladoras;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JOptionPane;

import liga.packEnumeration.Provincia;
import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;
import liga.packModelo.Arbitro;
import liga.packModelo.Equipo;
import liga.packModelo.ListaArbitros;
import liga.packModelo.ListaEquipos;
import liga.packVistas.IU_Anadir_Arbitro;
import liga.packVistas.IU_Anadir_Equipo;
import liga.packVistas.IU_Conf_Temp;

public class C_Conf_Temp {

	private static C_Conf_Temp miC_Conf_Temp = new C_Conf_Temp();
	private IU_Conf_Temp vista;
	
	private ListaArbitros listaArbitros;//los arbitros que estan seleccionados para la temporada
	private ListaEquipos listaEquipos;//los equipos que estan seleccionados para la temporada
	
	private int numUltimaTemporada;
	private Date fechaFinUltTemp;
	
	private ListaArbitros arbitrosSeleccionables;//los arbitros que se mostraran en la interfaz de añadir arbitros
	private ListaEquipos equiposSeleccionables;//los equipos que se mostraran en la interfaz de añadir equipos
	
	
	private C_Conf_Temp()
	{
		
	}
	
	public void setIU_Conf_Temp(IU_Conf_Temp pIU)
	{
		vista = pIU;
	}
	
	public static C_Conf_Temp getMiC_Conf_Temp()
	{
		return miC_Conf_Temp;
	}

	@SuppressWarnings("deprecation")
	public void inicializarTemporada() {
		if(this.comprobarConfiguracion())
		{
			//obtenemos la fecha y la transformamos al tipo GregorianCalendar para llamar a la inicializacion
			Date temp = this.vista.getComboFecha().getDate();
			GregorianCalendar fecha = new GregorianCalendar(temp.getYear()+1900, temp.getMonth(), temp.getDate());
			Liga.getMiLiga().inicializarTemporada(listaEquipos, listaArbitros, fecha, this.numUltimaTemporada+1);
		}
	}

	private boolean comprobarConfiguracion() {
		
		boolean valida = true;
		
		//puede ser incorrecta si la lista de equipos no tiene 20
		if(this.listaEquipos.getTamano() != 20)
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar exactamente 20 equipos para la temporada", "Error", JOptionPane.ERROR_MESSAGE);
			valida = false;
		}
		
		//puede serlo si no hay al menos 10 arbitros
		if(this.listaArbitros.getTamano() < 10)
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 árbitros para la temporada", "Error", JOptionPane.ERROR_MESSAGE);
			valida = false;
		}
		
		//o porque si habia una temporada, la fecha elegida no es posterior a la de fin
		if(this.numUltimaTemporada != 0)
		{
			//existe una temporada anterior
			if(this.vista.getComboFecha().getDate().before(this.fechaFinUltTemp))
			{
				JOptionPane.showMessageDialog(null, "La fecha de inicio de la temporada debe ser posterior a la de fin de la temporada anterior", "Error", JOptionPane.ERROR_MESSAGE);
				valida = false;
			}
		}
		
		return valida;
	}

	public void resetear() {
		this.vista = null;
		this.listaArbitros = null;
		this.listaEquipos = null;
		this.numUltimaTemporada = 0;
		this.fechaFinUltTemp = null;
		
	}

	public void eliminarEquipo() {
		int seleccionado = this.vista.getListEquipos().getSelectedIndex();
		
		if(seleccionado >= 0)
		{
			this.listaEquipos.eliminarEquipoPos(seleccionado);
		}
		
	}

	public void eliminarArbitro() {
		int seleccionado = this.vista.getListArbitros().getSelectedIndex();
		
		if(seleccionado >= 0)
		{
			this.listaArbitros.eliminarArbitroPos(seleccionado);
		}
		
	}

	@SuppressWarnings("deprecation")
	public Date obtenerFechaFinUltimaTemporada() {
		numUltimaTemporada = Liga.getMiLiga().obtenerUltimaTemporada();
		ResultadoSQL r = SGBD.getSGBD().consultaSQL("SELECT fechafin FROM temporada WHERE numtemporada ="+numUltimaTemporada);
		if(r.next()){
			GregorianCalendar fecha = r.getDate("fechafin");
			fechaFinUltTemp = new Date(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));
		}
		else{
			fechaFinUltTemp = null;
		}
		r.close();
		return this.fechaFinUltTemp;
	}

	public void obtenerEquiposQuePasan() {
		String[] equipos = Liga.getMiLiga().obtenerClasificacion(numUltimaTemporada, 38);//nos devuelve 20 equipos, los tres últimos no pasan
		//para cada uno de los 17 buscamos su provincia y creamos su objeto correspondiente
		listaEquipos = new ListaEquipos();
		
		ResultadoSQL r = null;
		for(int i=0;i<17;i++)
		{
			Provincia p;
			r = SGBD.getSGBD().consultaSQL("SELECT provincia FROM equipo WHERE nombre ="+equipos[i]);
			r.next();
			p = Provincia.buscarComponente(r.get("provincia"));
			listaEquipos.anadirEquipo(new Equipo(equipos[i],p));
		}
		r.close();
		
		//con los nombres de los equipos, actualizamos la lista de la interfaz
		this.vista.setEquipos(this.listaEquipos.getNombres());
		
		
	}

	public void obtenerArbitrosTemporada() {
		listaArbitros = Liga.getMiLiga().obtenerArbitrosTemporada(this.numUltimaTemporada);
		// con los nombres de los arbitros, actualizamos la lista de la interfaz
		this.vista.setArbitros(this.listaArbitros.getNombres());
	}

	public String[] obtenerArbitrosNoSeleccionados() {
		//obtenemos todos los arbitros de la liga
		ArrayList<String[]> arbitros = Liga.getMiLiga().obtenerArbitros();
		
		//ahora debemos recorrerlos para quitar los que ya esten seleccionados
		//al mismo tiempo iremos instanciando como objetos a los diferentes arbitros
		Iterator<String[]> it = arbitros.iterator();
		String[] ar;
		
		this.arbitrosSeleccionables = new ListaArbitros();
		
		while(it.hasNext())
		{
			ar = it.next();
			if(!this.listaArbitros.esta(ar[2]))
			{
				//si el arbitro no estaba seleccionado, lo añadimos a la lista
				this.arbitrosSeleccionables.anadirArbitro(new Arbitro(ar[0], ar[1], Provincia.buscarComponente(ar[3]), ar[2]));
			}
		}
		
		
		return this.arbitrosSeleccionables.getNombres();
	}

	/**
	 * restaura la ventana de configuracion y
	 * vacia las listas temporales de las ventanas de añadir
	 * árbitros y equipos
	 */
	public void restaurarVentanaConf() {
		this.vista.setVisible(true);
		this.arbitrosSeleccionables = null;
		this.equiposSeleccionables = null;
	}

	/**
	 * obtiene los arbitros seleccionados y los introduce en la lista de
	 * los que formaran parte de la temporada
	 * 
	 * tambien restaura la pantalla de configuración
	 * @param pVentana
	 */
	public void anadirArbitrosSeleccionados(IU_Anadir_Arbitro pVentana) {
		//obtenemos los índices seleccionados
		int[] ind = pVentana.getList().getSelectedIndices();
		
		//recorremos los indices y seleccionamos el arbitro correspondiente
		for(int i = 0; i < ind.length; i++)
		{
			Arbitro a = this.arbitrosSeleccionables.obtenerArbitroPos(ind[i]);
			this.listaArbitros.anadirArbitro(a);
		}
		
		//actualizamos la lista de arbitros de la pantalla de configuracion
		this.vista.setArbitros(this.listaArbitros.getNombres());
		
		//restauramos la ventana de configuración
		this.restaurarVentanaConf();
		
		//y eliminamos la ventana de seleccion de arbitros
		pVentana.dispose();
	}

	public void anadirEquiposSeleccinados(IU_Anadir_Equipo pVentana) {
		//obtenemos los índices seleccionados
		int[] ind = pVentana.getList().getSelectedIndices();
		
		//recorremos los indices y seleccionamos el arbitro correspondiente
		for(int i = 0; i < ind.length; i++)
		{
			Equipo a = this.equiposSeleccionables.getEquipoPos(ind[i]);
			this.listaEquipos.anadirEquipo(a);
		}
		
		//actualizamos la lista de arbitros de la pantalla de configuracion
		this.vista.setArbitros(this.listaArbitros.getNombres());
		
		//restauramos la ventana de configuración
		this.restaurarVentanaConf();
		
		//y eliminamos la ventana de seleccion de arbitros
		pVentana.dispose();
		
	}

	public String[] obtenerEquiposNoSeleccionados() {
		//obtenemos todos los equipos de la liga
		ArrayList<String[]> arbitros = Liga.getMiLiga().obtenerEquipos();
		
		//ahora debemos recorrerlos para quitar los que ya esten seleccionados
		//al mismo tiempo iremos instanciando como objetos a los diferentes equipos
		Iterator<String[]> it = arbitros.iterator();
		String[] eq;
		
		this.equiposSeleccionables = new ListaEquipos();
		
		while(it.hasNext())
		{
			eq = it.next();
			if(!this.listaEquipos.esta(eq[2]))
			{
				//si el arbitro no estaba seleccionado, lo añadimos a la lista
				this.equiposSeleccionables.anadirEquipo(new Equipo(eq[0], Provincia.buscarComponente(eq[1])));
			}
		}
		
		
		return this.arbitrosSeleccionables.getNombres();
	}
}