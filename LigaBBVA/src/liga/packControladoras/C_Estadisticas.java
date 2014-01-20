package liga.packControladoras;

public class C_Estadisticas 
{
private static C_Estadisticas misEstadisticas = new C_Estadisticas();	
	
	private  C_Estadisticas() 
	{
	
	}
	
	public static C_Estadisticas getMisEstadisticas() 
	{
		return misEstadisticas;
	}
	
	public int[] obtenerTemporadas(){
		return Liga.getMiLiga().obtenerTemporadas();
	}
}
