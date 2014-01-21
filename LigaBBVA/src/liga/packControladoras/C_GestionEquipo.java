package liga.packControladoras;

import java.util.ArrayList;

public class C_GestionEquipo {
	private static C_GestionEquipo miC_GestionEquipo = new C_GestionEquipo();	
	
	private C_GestionEquipo() {
	}
	
	public static C_GestionEquipo getC_GestionEquipo() {
		return miC_GestionEquipo;
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
}
