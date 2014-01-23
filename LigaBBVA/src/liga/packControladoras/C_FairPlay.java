package liga.packControladoras;

import java.util.ArrayList;

public class C_FairPlay 
{
	private static C_FairPlay miFairPlay;
	
	private  C_FairPlay() 
	{
	
	}
	
	public static C_FairPlay getMiFairPlay() 
	{
		return miFairPlay;
	}
	
	public int obtenerUltimaTemporada(){
		return Liga.getMiLiga().obtenerUltimaTemporada();
	}
	
	public ArrayList<String> obtenerJugadorFairPlay(int codTemp){
		return Liga.getMiLiga().obtenerJugadorFairplay(codTemp);
	}
	
	public ArrayList<String> obtenerEquipoFairPlay(int pNumTemporada){
		return Liga.getMiLiga().obtenerEquipoFairPlay(pNumTemporada);
	}
}
