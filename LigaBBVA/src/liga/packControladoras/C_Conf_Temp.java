package liga.packControladoras;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import liga.packEnumeration.Provincia;
import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;
import liga.packModelo.Equipo;
import liga.packModelo.ListaArbitros;
import liga.packModelo.ListaEquipos;
import liga.packVistas.IU_Conf_Temp;

public class C_Conf_Temp {

	private static C_Conf_Temp miC_Conf_Temp = new C_Conf_Temp();
	private IU_Conf_Temp vista;
	
	private ListaArbitros listaArbitros;//los arbitros que estan seleccionados para la temporada
	private ListaEquipos listaEquipos;//los equipos que estan seleccionados para la temporada
	
	private int numUltimaTemporada;
	private Date fechaFinUltTemp;
	
	
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
		// TODO Auto-generated method stub
		return false;
	}

	public void resetear() {
		// TODO Auto-generated method stub
		
	}

	public void eliminarEquipo() {
		// TODO Auto-generated method stub
		
	}

	public void eliminarArbitro() {
		// TODO Auto-generated method stub
		
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
}
