package liga.packControladoras;

import java.util.ArrayList;

import liga.packJGA.Clasificacion;

public class C_Clasificacion
{
	private static C_Clasificacion miClasificacion= new C_Clasificacion();
	
	private  C_Clasificacion() 
	{
	
	}
	
	public static C_Clasificacion getMiClasificacion() 
	{
		return miClasificacion;
	}
	
	public int obtenerUltimaTemporada(){
		return Liga.getMiLiga().obtenerUltimaTemporada();
	}
	
	public ArrayList<Integer> obtenerTemporadas()
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
	
	public ArrayList<Integer> obtenerJornadasDe(int pNumTemporada)
	{
		return Liga.getMiLiga().obtenerJornadasDe(pNumTemporada);
	}
	public Clasificacion[] obtenerClasificacione(int pNumTemporada, int pNumJornada)
	{
		return Liga.getMiLiga().obtenerClasificacione(pNumTemporada, pNumJornada);
	}
}
