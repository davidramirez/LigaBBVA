package liga.packControladoras;
import java.util.ArrayList;

import  liga.packGestorBD.*;

public class CatalogoEstadisticasJugador 
{
	private static CatalogoEstadisticasJugador miCatalogoEstJug=new CatalogoEstadisticasJugador();
	
	private CatalogoEstadisticasJugador(){
		
	}
	
	public static CatalogoEstadisticasJugador getMiCatalogoEstJug()
	{
		return miCatalogoEstJug;
	}
	
	public ArrayList<String> obtenerjugadorFairPlay(int codTemp)
	{
		ArrayList<String> jugFairPlay = new ArrayList<String>();
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM EstadisticasJugador AS e NATURAL JOIN Jugador AS j WHERE e.numtemporada='codTemp' AND j.estaretirado='false' ORDER BY e.numsanciones ASC");
		if(RdoSQL.next())
		{
			jugFairPlay.add(RdoSQL.get("nombre"));
			jugFairPlay.add(RdoSQL.get("nombreequipo"));
			jugFairPlay.add(RdoSQL.get("numsanciones"));
			return jugFairPlay;
		}
		return null;
				
	}

}
