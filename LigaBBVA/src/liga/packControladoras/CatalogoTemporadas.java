package liga.packControladoras;

import java.sql.Date;

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
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT numtemporada FROM temporada ORDER BY fechainicio DESC");
		int i=0;
		while(RdoSQL.next())
		{			
			jugFairPlay[i]=RdoSQL.getInt("numtemporada");
			
		}
		return jugFairPlay;
	}
	public int obtenerJornadaAnterior(Date fecha) {
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE estajugada = 1 AND fecha < " + fecha + " ORDER BY fecha DESC");
		RdoSQL.next();
		return RdoSQL.getInt("numjornada"); 
	}
	
	public int obtenerUltimaTemporada(){
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas()[0];
	}
	
}
