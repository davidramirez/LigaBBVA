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

}
