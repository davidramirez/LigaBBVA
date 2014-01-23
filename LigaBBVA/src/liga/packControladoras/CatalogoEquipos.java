package liga.packControladoras;

import java.util.ArrayList;
import liga.packModelo.Equipo;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoEquipos {
	private static CatalogoEquipos misEquipos=new CatalogoEquipos();
	
	private CatalogoEquipos(){}
	
	public static CatalogoEquipos getMisEquipos(){
		return misEquipos;
	}
	/**
	 * Se encarga de obtener el equipo Fairplay en la temporada recibida como parámetro.
	 * @param pNumTemporada
	 * @return
	 */
	
	public ArrayList<String> obtenerEquipoFairPlay(int pNumTemporada){
		
		ArrayList<String> equipoFairPlay = new ArrayList<String>();
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT nombreeq,SUM(numsanciones) AS sancionesEquipo FROM "
				+ "equipostemporada AS et INNER JOIN jugador"
				+ "ON et.nombreeq=j.nombreequipo WHERE et.numtemporada=pNumTemporada ORDER BY sancionesEquipo ASC");
		if(RdoSQL.next())
		{
			equipoFairPlay.add(RdoSQL.get("nombreeq"));
			equipoFairPlay.add(RdoSQL.get("sancionesEquipo"));
		}
		
		return equipoFairPlay;
	}
	
	/**
	 * Buscamos si existe o no un equipo basado en el nombre que recibe
	 * @param nombreEquipo el nombre del equipo
	 */

	public boolean buscarSiExiste(String pNombreEquipo) {
		boolean existe = false;
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM equipo WHERE nombre=pNombreEquipo");
		if(RdoSQL.next()) {
			//Existe el equipo.
			existe = true;
		}
		return existe;
	}
	
	/**
	 * Añadimos un nuevo equipo en la BD
	 * @param pNombreEquipo el nombre del equipo
	 * @param pNombreProvincia la provincia de procedencia
	 * @param pPresupuesto el presupuesto del equipo
	 */
	
	public void anadirEquipo(String pNombreEquipo,String pNombreProvincia, String pPresupuesto) {
		//Generamos un usuario por defecto para le nuevo equipo.
		SGBD.getSGBD().execSQL("INSERT INTO Usuario(Nombre, Contrasena,EstaActivo)VALUES('usuario','contraseña',si)");
		
		SGBD.getSGBD().execSQL("INSERT INTO Equipo (Nombre, Puntos, Dinero, NombreUsuario, Provincia) VALUES ('"+pNombreEquipo+"',0,"+pPresupuesto+",'usuario','"+pNombreProvincia+"')");
	}
	
	/**
	 * Se encarga de obtener todos lo nombres de los equipos
	 * 
	**/
	
	public ArrayList<String> obtenerNombresEquipos() {
		ArrayList<String> nombresEquipos = new ArrayList<String>();
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * from equipo");
		while(RdoSQL.next()) {
			nombresEquipos.add(RdoSQL.get("nombre"));
		}
		return nombresEquipos;
	}
	
	/**
	 * Obtiene los datos relativos a un equipo dado su nombre.
	 * 
	 * @param pNombre el nombre del equipo.
	 */
	
	public ArrayList<String> buscarEquipo(String pNombre) {
		ArrayList<String> infoEquipo = new ArrayList<String>();
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM Equipo WHERE Nombre="+pNombre);
		if(RdoSQL.next()) {
			infoEquipo.add(RdoSQL.get("Puntos"));
			infoEquipo.add(RdoSQL.get("Dinero"));
			infoEquipo.add(RdoSQL.get("NombreUsuario"));
		}
		return infoEquipo;
	}

	public ArrayList<String[]> obtenerEquipos() {
		ResultadoSQL r = SGBD.getSGBD().consultaSQL("SELECT e.nombre, e.provincia, u.estaactivo FROM equipo AS e INNER JOIN usuario AS u ON e.nombreusuario = u.nombre");
		
		ArrayList<String[]> rdo = new ArrayList<String[]>();
		
		while(r.next())
		{
			//creamos una nueva posicion para el array
			String[] eq = new String[3];
			eq[0] = r.get("nombre");
			eq[1] = r.get("provincia");
			eq[2] = r.get("estaactivo");
			
			//añadimos el equipo al array
			rdo.add(eq);
		}
		r.close();
		
		return rdo;
	}
	
	/**
	 * Actualiza los datos de un equipo
	 * 
	 * @param pUnNombreEquipo el nombre del equipo que se desea cambiar
	 * @param pUnaProvincia la provincia que se desea cambiar
	 * @param pElEquipo Los datos anteriores del equipo a cambiar.
	 */
	
	public void actualizarDatosEquipo(String pUnNombreEquipo,String pUnaProvincia, Equipo pElEquipo) {
		SGBD.getSGBD().execSQL("UPDATE Equipo set nombre='"+pUnNombreEquipo+"',provincia='"+pUnaProvincia+"' WHERE nombre='"+pElEquipo.getNombre()+"'");
	}
}