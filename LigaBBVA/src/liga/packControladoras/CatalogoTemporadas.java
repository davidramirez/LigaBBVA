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
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE estajugada = 0 AND fecha >= '" + fecha + "' AND numtemporada = '" + temporadaActual + "' ORDER BY numjornada ASC");		
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
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT nomeqlocal, nomeqvisitante FROM partido WHERE numtemporada='"+laTemp+"' AND numjornada='"+laJor+"'");
		while (RdoSQL.next())
		{
			rdo[i][0]=RdoSQL.get("nomeqlocal");
			rdo[i][1]=RdoSQL.get("nomeqvisitante");
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
	

	
	public String[] obtenerGolesPartido(String elLocal, String elVisit, int laJor, int laTemp)
	{
		String[] rdo = new String [2];
		ResultadoSQL Goles=SGBD.getSGBD().consultaSQL("SELECT golesvisitante, goleslocal FROM partido WHERE "
				+ "numtemporada='"+laTemp+"' AND numjornada='"+laJor+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"'");
		Goles.next();
		rdo[0]= Goles.get("goleslocal");
		rdo[1]= Goles.get("golesvisitante");
		// comprobada, sentencia correcta
		Goles.close();
		return rdo;
	}
	public ArrayList<ArrayList<String>> obtenerTitularesPartido(String elLocal, String elVisit, int laJor, int laTemp)
	{
		ArrayList<ArrayList<String>> rdo = new ArrayList<ArrayList<String>>();
		ResultadoSQL TitularesLocal=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN titular NATURAL JOIN partido "
				+ "WHERE numtemporada='"+laTemp+"' AND numjornada='"+laJor+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND nombreequipo='"+elLocal+"'");
		
		ResultadoSQL TitularesVisitante=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN titular NATURAL JOIN partido "
				+ "WHERE numtemporada='"+laTemp+"' AND numjornada='"+laJor+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND nombreequipo='"+elVisit+"'");
		
		while (TitularesLocal.next()&&TitularesVisitante.next())
		{
			rdo.get(0).add(TitularesLocal.get("nombre"));
			rdo.get(1).add(TitularesVisitante.get("nombre"));
		}
		TitularesLocal.close();
		TitularesVisitante.close();
		return rdo;
	//comprobado, sentencia correcta (titulares)
	}
	public ArrayList<ArrayList<String>> obtenerGoleadoresPartido(String elLocal, String elVisit, int laJor, int laTemp)
	{
		ArrayList<ArrayList<String>> rdo = new ArrayList<ArrayList<String>>();
		
		ResultadoSQL GoleadoresLocal=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN goles NATURAL JOIN partido "
				+ "WHERE numtemporada='"+laTemp+"' AND numjornada='"+laJor+"' AND nomeqLocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND nombreequipo='"+elLocal+"'");
		ResultadoSQL GoleadoresVisitante=SGBD.getSGBD().consultaSQL("SELECT nombre FROM jugador NATURAL JOIN goles NATURAL JOIN partido "
				+ "WHERE numtemporada='"+laTemp+"' AND numjornada='"+laJor+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND nombreequipo='"+elVisit+"'");
	
		rdo.add(new ArrayList<String>());
		rdo.add(new ArrayList<String>());
		while (GoleadoresLocal.next())
			rdo.get(0).add(GoleadoresLocal.get("nombre"));
		while (GoleadoresVisitante.next())
			rdo.get(1).add(GoleadoresVisitante.get("nombre"));
		
		
		GoleadoresLocal.close();
		GoleadoresVisitante.close();
		
		//comprobado, sentencia correcta (goleadores)
		return rdo;
	}
		
	public ArrayList<String> obtenerCambiosLocal(String elLocal, String elVisit, int laJor, int laTemp)
	{
		ArrayList<String> rdo = new ArrayList<String>();
	
		ResultadoSQL CambiosLocal=SGBD.getSGBD().consultaSQL("SELECT j.nombre, jj.nombre FROM (sustituciones AS s INNER JOIN "
				+ "jugador AS j ON s.codjugsale=j.codjug) INNER JOIN jugador AS jj ON s.codjugentra=jj.codjug where"
				+ " s.equipoafectado='"+elLocal+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND"
						+ "numtemporada='"+laTemp+"' AND numjornada='"+laJor+"'");
		
		while (CambiosLocal.next())
		{
			
			rdo.add(CambiosLocal.get("j.nombre")+"sale por"+CambiosLocal.get("jj.nombre"));
		}
		
		//CambiosLocal.close();
		return rdo;
	}	
	
	
	public ArrayList<String> obtenerCambiosVisitante(String elLocal, String elVisit, int laJor, int laTemp)
	{
		ArrayList<String> rdo = new ArrayList<String>();
	
		ResultadoSQL CambiosVisitante=SGBD.getSGBD().consultaSQL("SELECT j.nombre, jj.nombre FROM (sustituciones AS s INNER JOIN "
				+ "jugador AS j ON s.codjugsale=j.codjug) INNER JOIN jugador AS jj ON s.codjugentra=jj.codjug where"
				+ " s.equipoafectado='"+elVisit+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND"
						+ "numtemporada='"+laTemp+"' AND numjornada='"+laJor+"'");
		
		while (CambiosVisitante.next())
		{
			rdo.add(CambiosVisitante.get("j.nombre")+"sale por"+CambiosVisitante.get("jj.nombre"));
		}
		//CambiosVisitante.close();
		return rdo;
	}	
	
	public ArrayList<String[]> obtenerTarjetasLocal(String elLocal, String elVisit, int laJor, int laTemp)
	{
		ArrayList<String[]> rdo = new ArrayList<String[]>();
	
		ResultadoSQL TarjetasLocal=SGBD.getSGBD().consultaSQL("SELECT nombre, esamarilla FROM jugador NATURAL JOIN tarjetas NATURAL JOIN partido "
				+ "WHERE numtemporada='"+laTemp+"' AND numjornada='"+laJor+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND nombreequipo='"+elLocal+"'");
		
		
		//comprobado, sentencia correcta (tarjetas)
		String[] aux = new String[2];
		while (TarjetasLocal.next())
		{
			aux[0]=TarjetasLocal.get("nombre");
			aux[1]=TarjetasLocal.get("esamarilla");
					
			rdo.add(aux);
		}
		TarjetasLocal.close();
		return rdo;
	}
	public ArrayList<String[]> obtenerTarjetasVisitante(String elLocal, String elVisit, int laJor, int laTemp)
	{
		ArrayList<String[]> rdo = new ArrayList<String[]>();
		ResultadoSQL TarjetasVisitante=SGBD.getSGBD().consultaSQL("SELECT nombre, esamarilla FROM jugador NATURAL JOIN tarjetas NATURAL JOIN partido "
				+ "WHERE numtemporada='"+laTemp+"' AND numjornada='"+laJor+"' AND nomeqlocal='"+elLocal+"' AND nomeqvisitante='"+elVisit+"' AND nombreequipo='"+elVisit+"'");
	
		
		String[] aux = new String[2];
		while (TarjetasVisitante.next())
		{
			aux[0]=TarjetasVisitante.get("nombre");
			aux[1]=TarjetasVisitante.get("esamarilla");
					
			rdo.add(aux);
		}
		TarjetasVisitante.close();
		return rdo;
	}
	
	public String[] obtenerEquiposJornada(int temporada, int jornada, String equipo) {
		String[] equipos = new String[2];
		ResultadoSQL equiposJornada = SGBD.getSGBD().consultaSQL("SELECT nomeqlocal, nomeqvisitante FROM partido WHERE numtemporada = '" + temporada + "' AND numjornada = '" + jornada + "' AND (nomeqlocal = '" + equipo + "' OR nomeqvisitante = '" + equipo + "')");
		if (equiposJornada.next()) {
			equipos[0] = equiposJornada.get("nomeqlocal");
			equipos[1] = equiposJornada.get("nomeqvisitante");
		}
		return equipos;
	}
	
	/**
	 * Obtiene la lista de los nombres de los aŕbitros de la temporada actual
	 * 
	 * @param temporadaActual Los datos realtivos a la temporada actual.
	 */
	
	public ArrayList<String[]> obtenerNombreArbitros(int temporadaActual) {
		ArrayList<String[]> rdo = new ArrayList<String[]>();
		String[] arbitros = new String[2];
		ResultadoSQL arbitrosTemp = SGBD.getSGBD().consultaSQL("Select * from Arbitro AS Arbitro INNER JOIN ArbitrosTemporada AS ArbitrosTemporada ON Arbitro.Dni=ArbitrosTemporada.DNIArbitro WHERE ArbitrosTemporada.NumTemporada="+temporadaActual);
		while(arbitrosTemp.next()) {
			arbitros[0] = arbitrosTemp.get("dni");
			arbitros[1] = arbitrosTemp.get("nombre");
			rdo.add(arbitros);
		}
		return rdo;
	}
}
