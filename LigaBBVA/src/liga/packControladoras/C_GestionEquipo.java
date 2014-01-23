package liga.packControladoras;

import liga.packModelo.Equipo;

import java.util.ArrayList;
import java.util.Observable;
import java.sql.Date;

public class C_GestionEquipo extends Observable {
	private static C_GestionEquipo miC_GestionEquipo = new C_GestionEquipo();	
	private String miEquipo = null;
			
	private C_GestionEquipo() {
	}
	
	public static C_GestionEquipo getC_GestionEquipo() {
		return miC_GestionEquipo;
	}
	
	public void setEquipo(String equipo) {
		this.miEquipo = equipo;
	}

	/**
	 * AnadirEquipo se encarga de añadir un nuevo equipo a laa BD y comprobar si éste existe previamente.
	 * 
	 * @param pNombreEquipo el nombre del equipo
	 * @param pNombreProvincia la provincia de procedencia
	 * @param pPresupuesto el presupuesto del equipo
	 */
	public void anadirEquipo(String pNombreEquipo,String pNombreProvincia,String pPresupuesto) {
		boolean existe = false;
		existe = Liga.getMiLiga().buscarSiExiste(pNombreEquipo);
		if(!existe) {
			//El equipo no existe, lo insertamos en la BD.
			Liga.getMiLiga().anadirEquipo(pNombreEquipo, pNombreProvincia, pPresupuesto);
		}
	}
	
	/**
	 * Se encarga de obtener todos lo nombres de los equipos
	 * 
	**/
	
	public ArrayList<String> obtenerNombresEquipos() {
		return Liga.getMiLiga().obtenerNombresEquipos();
	}
	
	/**
	 * Obtiene los datos relativos a un equipo dado su nombre.
	 * 
	 * @param pNombre el nombre del equipo.
	 */
	
	public ArrayList<String> obtenerDatosEquipo(String pNombre) {
		return Liga.getMiLiga().obtenerDatosEquipo(pNombre);
	}
	
	/**
	 * Actualiza los datos de un equipo
	 * 
	 * @param pUnNombreEquipo el nombre del equipo que se desea cambiar
	 * @param pUnaProvincia la provincia que se desea cambiar
	 * @param pElEquipo Los datos anteriores del equipo a cambiar.
	 */
	
	public void actualizarDatosEquipo(String pUnNombreEquipo,String pUnaProvincia, Equipo pElEquipo) {
		boolean existe = Liga.getMiLiga().buscarSiExiste(pUnNombreEquipo);
		if(!existe) {
			//El equipo no existe en la bd, podemos actualizarlo.
			Liga.getMiLiga().actualizarDatosEquipo(pUnNombreEquipo, pUnaProvincia, pElEquipo);
		}
	}
	
	/*****************************************/
	/* Métodos para la gestión de jugadores. */
	/*****************************************/
	
	public String[][] getJugadores() {
		return Liga.getMiLiga().getListaJugadores(this.miEquipo);
	}
	
	public String[][] getJugadoresConvocables(Date fecha) {
		return Liga.getMiLiga().getJugadoresConvocables(fecha, this.miEquipo);
	}
	
	public String[][] getJugadoresConvocados(Date fecha) {
		return Liga.getMiLiga().getJugadoresConvocables(fecha, this.miEquipo);
	}
	
	public String[][] getJugadoresTitulares(Date fecha) {
		return Liga.getMiLiga().getJugadoresTitulares(fecha, this.miEquipo);
	}
	
	public boolean anadirJugador(String nombre, String dorsal) {
		if (Liga.getMiLiga().anadirJugador(this.miEquipo, nombre, dorsal)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	
	public boolean modificarJugador(String codJug, String nombre, String dorsal) {
		if (Liga.getMiLiga().modificarJugador(codJug, this.miEquipo, nombre, dorsal)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	
	public void darDeBajaJugador(String codJug) {
		Liga.getMiLiga().darDeBajaJugador(codJug);
		setChanged();
		notifyObservers();
	}
	
	public void anadirJugadoresConvocados(String[] jugadoresConvocados, Date fecha) {
		Liga.getMiLiga().anadirJugadoresConvocados(jugadoresConvocados, fecha, this.miEquipo);
		setChanged();
		notifyObservers();
	}
	
	public void anadirJugadoresTitulares(String[] jugadoresTitulares, Date fecha) {
		Liga.getMiLiga().anadirJugadoresTitulares(jugadoresTitulares, fecha, this.miEquipo);
		setChanged();
		notifyObservers();
	}
}
