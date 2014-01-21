package liga.packControladoras;

public class C_Clasificacion
{
	private static C_Clasificacion miClasificacion= new C_Clasificacion();
	
	private  C_Clasificacion() 
	{
	
	}
	
	public static C_Clasificacion getMisEstadisticas() 
	{
		return miClasificacion;
	}
	
	public int obtenerUltimaTemporada(){
		return Liga.getMiLiga().obtenerUltimaTemporada();
	}
	
	public int[] obtenerTemporadas()
	{
		return Liga.getMiLiga().obtenerTemporadas();
	}
	
	public int obtenerUltimaJornadaDe(int pLaTemporada)
	{
		return Liga.getMiLiga().obtenerUltimaJornadaDe(pLaTemporada);
	}
	public String[] obtenerClasificacion(int pNumTemporada, int pNumJornada)
	{
		return Liga.getMiLiga().obtenerClasificacion(pNumTemporada, pNumJornada);
	}
	
	public int[] obtenerJornadasDe(int pNumTemporada)
	{
		return Liga.getMiLiga().obtenerJornadasDe(pNumTemporada);
	}
}
