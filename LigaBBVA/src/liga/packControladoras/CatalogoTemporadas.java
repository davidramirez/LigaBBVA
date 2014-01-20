package liga.packControladoras;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoTemporadas 
{
private static CatalogoTemporadas misTemporadas=new CatalogoTemporadas();
	
	private  int maxTemporadas;
	
	private  CatalogoTemporadas() 
	{		
		this.maxTemporadas=100;
	}
	public static CatalogoTemporadas getMiCatalogoTemporadas(){
		return misTemporadas;
	}
	public int[] obtenerTemporadas() 
	{
		int[] jugFairPlay =new int[maxTemporadas];
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT numtemporada FROM temporada ORDER BY fechainicio ASC");
		int i=0;
		while(RdoSQL.next())
		{			
			jugFairPlay[i]=RdoSQL.getInt("numtemporada");
			
		}
		return jugFairPlay;
	}
	
	
}
