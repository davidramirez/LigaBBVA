package liga.packControladoras;

import java.sql.Date;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

/**MAE patron fachadas
 *
 */
public class Liga 
{
	private static Liga miLiga=new Liga();
	
	private Liga(){
		
	}
	public static Liga getMiLiga(){
		return miLiga;
	}
	
	public int obtenerUltimaTemporada(){
		return 0;
		
	}
	
	public Jugador obtenerJugadorFairplay(int codTemporada)
	{
		return CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerjugadorFairPlay(codTemporada);
	}
	
	private int obtenerJornadaAnterior(Date fecha) {
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE estajugada = 1 AND fecha < " + fecha + " ORDER BY fecha DESC");
		RdoSQL.next();
		return RdoSQL.getInt("numjornada"); 
	}
	
	public String[][] getListaJugadores(String equipo) {
		return CatalogoJugadores.getCatalogoJugadores().getListaJugadores(equipo);
	}
	
	public String[][] getJugadoresConvocables(Date fecha, String equipo) {
		return CatalogoJugadores.getCatalogoJugadores().getJugadoresConvocables(0, obtenerJornadaAnterior(fecha), equipo);
	}
	
	public boolean anadirJugadoresConvocados() {
		return CatalogoJugadores.getCatalogoJugadores().anadirJugadoresConvocados();
	}
	
	public boolean anadirJugador(String equipo, String nombreJugador, String dorsal) {
		return CatalogoJugadores.getCatalogoJugadores().anadirJugador(equipo, nombreJugador, dorsal);
	}
	
	public boolean modificarJugador(String codJug, String equipo, String nombreJugador) {
		return CatalogoJugadores.getCatalogoJugadores().modificarJugador(codJug, equipo, nombreJugador);
	}
	
	public void darDeBajaJugador(String codJug) {
		CatalogoJugadores.getCatalogoJugadores().darDeBajaJugador(codJug);
	}
}
