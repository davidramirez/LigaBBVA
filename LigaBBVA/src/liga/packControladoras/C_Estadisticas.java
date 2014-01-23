package liga.packControladoras;

import java.util.ArrayList;

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
	
	public ArrayList<Integer> obtenerTemporadas(){
		return Liga.getMiLiga().obtenerTemporadas();
	}
	
	public ArrayList<Integer> obtenerJornadasDe(int pNumTemporada){
		return Liga.getMiLiga().obtenerJornadasDe(pNumTemporada);
	}
	
	public String[] obtenerClasificacion(int pNumTemporada, int pNumJornada){
		return Liga.getMiLiga().obtenerClasificacion(pNumTemporada, pNumJornada);
	}
	public int[] obtenerEstadistica(int elJugador){
		return Liga.getMiLiga().obtenerEstadisticas(elJugador);
	}
}
