package liga.packControladoras;

import java.util.ArrayList;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoEquipos 
{
	private static CatalogoEquipos misEquipos=new CatalogoEquipos();
	
	private CatalogoEquipos(){}
	
	public static CatalogoEquipos getMisEquipos(){
		return misEquipos;
	}
	
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
	
	public void AnadirEquipo(String pNombreEquipo,String pNombreProvincia, String pPresupuesto) {
		//Generamos un usuario por defecto para le nuevo equipo.
		SGBD.getSGBD().execSQL("INSERT INTO Usuario(Nombre, Contrasena,EstaActivo)VALUES('usuario','contraseña',si)");
		
		SGBD.getSGBD().execSQL("INSERT INTO Equipo (Nombre, Puntos, Dinero, NombreUsuario, Provincia) VALUES ('"+pNombreEquipo+"',0,"+pPresupuesto+",'usuario','"+pNombreProvincia+"')");
	}
}
