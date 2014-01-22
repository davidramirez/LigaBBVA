package liga.packControladoras;

import java.util.ArrayList;
import java.util.Date;

public class C_GestionEquipo {
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
		return CatalogoEquipos.getMisEquipos().obtenerNombresEquipos();
	}
	
	/**
	 * Obtiene los datos relativos a un equipo dado su nombre.
	 * 
	 * @param pNombre el nombre del equipo.
	 */
	
	public ArrayList<String> buscarEquipo(String pNombre) {
		return Liga.getMiLiga().buscarEquipo(pNombre);
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
		return Liga.getMiLiga().anadirJugador(this.miEquipo, nombre, dorsal);
	}
	
	public boolean modificarJugador(String codJug, String nombre, String dorsal) {
		return Liga.getMiLiga().modificarJugador(codJug, this.miEquipo, nombre, dorsal);
	}
	
	public void darDeBajaJugador(String codJug) {
		Liga.getMiLiga().darDeBajaJugador(codJug);
	}
}
