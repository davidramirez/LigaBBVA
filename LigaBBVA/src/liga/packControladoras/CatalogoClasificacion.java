package liga.packControladoras;

import java.util.Comparator;

import net.sf.jga.fn.comparison.Max.Comparable;
import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoClasificacion 
{
private static CatalogoClasificacion miCatalogoClasificacion= new CatalogoClasificacion();
	
	private  CatalogoClasificacion() 
	{
	
	}
	
	public static CatalogoClasificacion getMiCatalogoClasificacion() 
	{
		return miCatalogoClasificacion;
	}
	
	public void obtenerClasificacion(int pNumTemporada,int pNumJornada)
	{
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM clasificacion WHERE numtemporada=pNumTemporada"
				+ "AND numjornada=pNumJornada ORDER BY puntos ASC");
		
		
	}

}
