package liga.packControladoras;

public class CatalogoEstadisticasJugador 
{
	private static CatalogoEstadisticasJugador miCatalogoEstJug=new CatalogoEstadisticasJugador();
	
	private CatalogoEstadisticasJugador(){
		
	}
	
	public static CatalogoEstadisticasJugador getMiCatalogoEstJug()
	{
		return miCatalogoEstJug;
	}

}
