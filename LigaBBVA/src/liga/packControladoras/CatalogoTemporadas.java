package liga.packControladoras;

import java.sql.Date;
import java.util.GregorianCalendar;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;
import liga.packModelo.ListaArbitros;
import liga.packModelo.ListaEquipos;
import liga.packModelo.ListaTemporadas;

public class CatalogoTemporadas 
{
	private static CatalogoTemporadas misTemporadas=new CatalogoTemporadas();
	private ListaTemporadas listaTemporadas;
	
 	static final int  maxTemporadas=100;
	static final int maxJornadas=38; 
	
	private  CatalogoTemporadas() 
	{		
		listaTemporadas = new ListaTemporadas();
	}
	public static CatalogoTemporadas getMiCatalogoTemporadas(){
		return misTemporadas;
	}
	public int[] obtenerTemporadas() 
	{
		int[] jugFairPlay =new int[maxTemporadas];
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT numtemporada FROM temporada ORDER BY fechainicio DESC");
		int i=0;
		while(RdoSQL.next() && i<maxTemporadas)
		{			
			jugFairPlay[i]=RdoSQL.getInt("numtemporada");
			i++;			
		}
		RdoSQL.close();
		return jugFairPlay;
	}
	public int[] obtenerJornadasDe(int unaTemporada)
	{
		int i=0;
		int[] jornadas= new int[maxJornadas];
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornadas WHERE numtemporada=unatemporada");
		while(RdoSQL.next() && i< maxJornadas){
			jornadas[i]=RdoSQL.getInt("numjornada");
		}
		RdoSQL.close();
		return jornadas;
	}
	public int obtenerJornadaAnterior(Date fecha) {
		int rdo=0;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE estajugada = 1 "
				+ "AND fecha < " + fecha + " ORDER BY fecha DESC");		
		if(RdoSQL.next()) rdo=RdoSQL.getInt("numjornada") ;
		RdoSQL.close();
		return rdo;
	}
	
	public int obtenerUltimaTemporada(){
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas()[0];
	}
	
	public int obtenerUltimaJornadaDe(int pLaTemporada)
	//pre:se obtiene la última jornada de la temporada recibida como parametro.
	//pos:si existe última jornada en esa temporada se devuelve, si no devuelve 0.
	{
		int laJornada=0;		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("Select numjornada FROM jornada WHERE numtemporada=pLaTemporada ORDER BY Fecha DESC");
		if(RdoSQL.next()){
			laJornada=RdoSQL.getInt("numjornada");
		}
		RdoSQL.close();
		return laJornada;
	}
	
	public String[][] obtenerPartidosDe(int laJor, int laTemp)
	{
		String[][] rdo= new String[10][2];
		int i=0;
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT NomEqLocal, NomEqVisitante FROM Partido WHERE NumTemporada="+laTemp+" AND NumJornada="+laJor+"");
		while (RdoSQL.next())
		{
			rdo[i][0]=RdoSQL.get("NomEqLocal");
			rdo[i][1]=RdoSQL.get("NomEqVisitante");
			i++;
		}
		
		return rdo;
	}
	
	private ListaTemporadas getListaTemporadas()
	{
		return this.listaTemporadas;
	}
	
	public void inicializarTemporada(ListaEquipos pListaEquipos, ListaArbitros pListaArbitros, GregorianCalendar pFecha, int pNumTemp)
	{
		this.getListaTemporadas().inicializarTemporada(pListaEquipos, pListaArbitros, pFecha, pNumTemp);
	}
	
}
