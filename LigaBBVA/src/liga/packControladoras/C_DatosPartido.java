package liga.packControladoras;

import java.util.ArrayList;

public class C_DatosPartido {
	
	private static C_DatosPartido misDatos = new C_DatosPartido();
	
	private  C_DatosPartido() 
	{
	
	}
	
	public static C_DatosPartido getMisDatos() 
	{
		return misDatos;
	}
	
	public ArrayList<Integer> obtenerTemporadas(){
		return Liga.getMiLiga().obtenerTemporadas();
	}
	
	public ArrayList<Integer> obtenerJornadasDe(int pNumTemporada){
		return Liga.getMiLiga().obtenerJornadasDe(pNumTemporada);
	}
	
	
	
	public String[] obtenerGolesPartido(String elLocal, String elVisit, int laJor, int laTemp)
	{
		return Liga.getMiLiga().obtenerGolesPartido(elLocal, elVisit, laJor, laTemp);
	}
	
	public ArrayList<ArrayList<String>> obtenerTitularesPartido(String elLocal, String elVisit, int laJor, int laTemp)
	{
		
		return Liga.getMiLiga().obtenerTitularesPartido(elLocal, elVisit, laJor, laTemp);
	}
	
	public ArrayList<ArrayList<String>> obtenerGoleadoresPartido(String elLocal, String elVisit, int laJor, int laTemp)
	{
		return Liga.getMiLiga().obtenerGoleadoresPartido(elLocal, elVisit, laJor, laTemp);

	}
	
	public ArrayList<String> obtenerCambiosLocal(String elLocal, String elVisit, int laJor, int laTemp)
	{
		return Liga.getMiLiga().obtenerCambiosLocal(elLocal, elVisit, laJor, laTemp);
	}
	
	public ArrayList<String> obtenerCambiosVisitante(String elLocal, String elVisit, int laJor, int laTemp)
	{
		return Liga.getMiLiga().obtenerCambiosVisitante(elLocal, elVisit, laJor, laTemp);
	}
	
	public ArrayList<String[]> obtenerTarjetasLocal(String elLocal, String elVisit, int laJor, int laTemp)
	{
		return Liga.getMiLiga().obtenerTarjetasLocal(elLocal, elVisit, laJor, laTemp);
	}
	
	public ArrayList<String[]> obtenerTarjetasVisitante(String elLocal, String elVisit, int laJor, int laTemp)
	{
		return Liga.getMiLiga().obtenerTarjetasVisitante(elLocal, elVisit, laJor, laTemp);
	}
		
	public ArrayList<String> obtenerPartidosDe(int laJor, int laTemp)
	{
		ArrayList<String> rdo = new ArrayList<String>();
		String[][] partidos = Liga.getMiLiga().obtenerPartidosDe(laJor, laTemp);
		
		for(int i=0; i<20;i++)
		{
			rdo.add(partidos[i][0]+"-"+partidos[i][1]);
		}
		
		return rdo;
	}

	public String[] transformarPartido(String partido)
	{
		String delimiter="-";
		String[] rdo = partido.split(delimiter);
		return rdo;
	}

	
	

}
