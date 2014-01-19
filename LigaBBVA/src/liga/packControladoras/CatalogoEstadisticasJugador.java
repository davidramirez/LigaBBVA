package liga.packControladoras;
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
	
	public Jugador obtenerjugadorFairPlay(int codTemp)
	{
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM EstadisticasJugador AS e NATURAL JOIN Jugador AS j WHERE e.numtemporada='codTemp' AND j.estaretirado='false' ORDER BY e.numsanciones ASC");
		if(RdoSQL.next())
		{
			String nombre=RdoSQL.get("nombre");
			String nomEquipo=RdoSQL.get("nombreequipo");
			int sanciones=RdoSQL.getInt("numsanciones");
			return new Jugador(nombre,nomEquipo,sanciones);
		}
		return null;
				
	}

}
