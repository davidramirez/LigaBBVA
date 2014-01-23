package liga.packControladoras;

import java.sql.Date;
import java.util.ArrayList;
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
	static final int maxJornadas=5;
	
	
	private  CatalogoTemporadas() 
	{		
		listaTemporadas = new ListaTemporadas();
	}
	public static CatalogoTemporadas getMiCatalogoTemporadas(){
		return misTemporadas;
	}
	
	/**
	 * sirve para utilizarlo en los Junits
	 * @return
	 */
	public static int getMaxJor(){
		return maxJornadas;
	}
	/**
	 * Se encarga de obtener la lista de todas las temporadas que hay en la BD (un máximo de 100) en orden ascendente
	 */
	public ArrayList<Integer> obtenerTemporadas() 
	{
		ArrayList<Integer> pListTemporadas =new ArrayList<Integer>();
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT numtemporada FROM temporada ORDER BY fechainicio ASC");
		
		while(RdoSQL.next() )
		{			
			pListTemporadas.add(RdoSQL.getInt("numtemporada"));			
		}
		RdoSQL.close();
		return pListTemporadas;
	}
	/**
	 * Se encarga de obtener las jornadas en la temporada recibida como parámetro.
	 * @param unaTemporada
	 * @return
	 */
	public ArrayList<Integer> obtenerJornadasDe(int unaTemporada)
	{
		
		ArrayList<Integer> jornadas= new ArrayList<Integer>();
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE numtemporada='"+unaTemporada+"'");
		while(RdoSQL.next() ){
			jornadas.add(RdoSQL.getInt("numjornada"));
		}
		RdoSQL.close();
		return jornadas;
	}
	/**
	 * Se encarga de devolver la última jornada jugada desde una fecha determinada. 
	 * @param fecha
	 * @return
	 */
	public int obtenerJornadaAnterior(Date fecha) {
		int rdo = 0;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE estajugada = 1 AND fecha <= '" + fecha + "' ORDER BY fecha DESC");		
		if (RdoSQL.next()) {
			rdo = RdoSQL.getInt("numjornada");
		}
		RdoSQL.close();
		return rdo;
	}
	/**
	 * Se encarga de devolver la próxima jornada a jugar desde una fecha determinada. 
	 * @param
	 * @return
	 */
	public int obtenerJornadaAJugar(Date fecha) {
		int rdo = 0;
		int temporadaActual = this.obtenerUltimaTemporada();
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE estajugada = 0 AND fecha >= '" + fecha + "' numtemporada = '" + temporadaActual + "' ORDER BY numjornada ASC");		
		if (RdoSQL.next())
			rdo = RdoSQL.getInt("numjornada");
		RdoSQL.close();
		return rdo;
	}
	/**
	 * Se encarga de obtener la última temporada(la actual)
	 * @return
	 */
	public int obtenerUltimaTemporada(){
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas().get(CatalogoTemporadas.getMiCatalogoTemporadas()
				.obtenerTemporadas().size()-1);
	}
	/**
	 * 
	 * @param pLaTemporada
	 * @return
	 */
	public int obtenerUltimaJornadaDe(int pLaTemporada)
	//pre:se obtiene la última jornada de la temporada recibida como parametro.
	//pos:si existe última jornada en esa temporada se devuelve, si no devuelve 0.
	{
		int laJornada=0;		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("Select numjornada FROM jornada WHERE numtemporada='"+pLaTemporada+"' AND numjornada='"+maxJornadas+"'");
		if(RdoSQL.next()){
			laJornada=RdoSQL.getInt("numjornada");
		}
		RdoSQL.close();
		return laJornada;
	}
	/**
	 * 
	 * @param laJor
	 * @param laTemp
	 * @return
	 */
	public String[][] obtenerPartidosDe(int laJor, int laTemp)
	{
		String[][] rdo= new String[10][2];
		int i=0;
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT NomEqLocal, NomEqVisitante FROM Partido WHERE NumTemporada='"+laTemp+"' AND NumJornada='"+laJor+"'");
		while (RdoSQL.next())
		{
			rdo[i][0]=RdoSQL.get("NomEqLocal");
			rdo[i][1]=RdoSQL.get("NomEqVisitante");
			i++;
		}
		RdoSQL.close();
		return rdo;
	}
	/**
	 * 
	 * @return
	 */
	private ListaTemporadas getListaTemporadas()
	{
		return this.listaTemporadas;
	}
	/**
	 * 
	 * @param pListaEquipos
	 * @param pListaArbitros
	 * @param pFecha
	 * @param pNumTemp
	 */
	public void inicializarTemporada(ListaEquipos pListaEquipos, ListaArbitros pListaArbitros, GregorianCalendar pFecha, int pNumTemp)
	{
		this.getListaTemporadas().inicializarTemporada(pListaEquipos, pListaArbitros, pFecha, pNumTemp);
	}
	
	public void obtenerDatosPartido(String elLocal, String elVisit, int laJor, int laTemp)
	{
		ResultadoSQL Goles=SGBD.getSGBD().consultaSQL("SELECT golesvisitante, goleslocal FROM partido WHERE "
				+ "numtemporada="+laTemp+" AND numjornada="+laJor+" AND nomeqlocal="+elLocal+" AND nomeqvisitante="+elVisit+"");
		// comprobada, sentencia correcta
		
		ResultadoSQL TitularesLocal=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN titular NATURAL JOIN partido "
				+ "WHERE numtemporada="+laTemp+" AND numjornada="+laJor+" AND nomeqlocal="+elLocal+" AND nomeqvisitante="+elVisit+" AND nombreequipo="+elLocal+"");
		
		ResultadoSQL TitularesVisitante=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN titular NATURAL JOIN partido "
				+ "WHERE numtemporada="+laTemp+" AND numjornada="+laJor+" AND nomeqlocal="+elLocal+" AND nomeqvisitante="+elVisit+" AND nombreequipo="+elVisit+"");
	//comprobado, sentencia correcta (titulares)
		ResultadoSQL GoleadoresLocal=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN goles NATURAL JOIN partido "
				+ "WHERE numtemporada="+laTemp+" AND numjornada="+laJor+" AND nomeqLocal="+elLocal+" AND nomeqvisitante="+elVisit+" AND nombreequipo="+elLocal+"");
		
		ResultadoSQL GoleadoresVisitante=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN goles NATURAL JOIN partido "
				+ "WHERE numtemporada="+laTemp+" AND numjornada="+laJor+" AND nomeqlocal="+elLocal+" AND nomeqvisitante="+elVisit+" AND nombreequipo="+elVisit+"");
	//comprobado, sentencia correcta (goleadores)
		
		
		//TODO cambios pendiente
		ResultadoSQL CambiosLocal=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN sustituciones NATURAL JOIN partido "
				+ "WHERE numtemporada="+laTemp+" AND numjornada="+laJor+" AND nomeqlocal="+elLocal+" AND nomeqvisitante="+elVisit+" AND nombreequipo="+elLocal+"");
		//cambios pendiente
		
		ResultadoSQL TarjetasLocal=SGBD.getSGBD().consultaSQL("SELECT nombre, esamarilla FROM jugador NATURAL JOIN tarjetas NATURAL JOIN partido "
				+ "WHERE numtemporada="+laTemp+" AND numjornada="+laJor+" AND nomeqlocal="+elLocal+" AND nomeqvisitante="+elVisit+" AND nombreequipo="+elLocal+"");
		
		ResultadoSQL TarjetasVisitante=SGBD.getSGBD().consultaSQL("SELECT Nombre, EsAmarilla FROM Jugador NATURAL JOIN Tarjetas NATURAL JOIN Partido "
				+ "WHERE NumTemporada="+laTemp+" AND NumJornada="+laJor+" AND NomEqLocal="+elLocal+" AND NomEqVisitante="+elVisit+" AND NombreEquipo="+elVisit+"");
	
		//comprobado, sentencia correcta (tarjetas)
		
		
		
		
		
	}
	
	
}
