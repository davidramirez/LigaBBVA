package liga.packControladoras;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoJugadores {
	private static CatalogoJugadores miCatalogoJugadores = new CatalogoJugadores();
	
	private CatalogoJugadores() {}
	
	public static CatalogoJugadores getCatalogoJugadores() {
		return miCatalogoJugadores;
	}
	
	public String[][] getListaJugadores(String equipo) {
		int i = 0, numJugadores = this.getNumJugadores(equipo);
		String[][] listaJugadores = new String[numJugadores][5];
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT codjug, nombre, dorsal, estaenventa, numsanciones FROM jugador WHERE estaretirado = 0 AND nombreequipo = '" + equipo + "'");
		while (RdoSQL.next()) {
			listaJugadores[i][0] = RdoSQL.get("codjug");
			listaJugadores[i][1] = RdoSQL.get("nombre");
			listaJugadores[i][2] = RdoSQL.get("dorsal");
			listaJugadores[i][3] = RdoSQL.get("estaenventa");
			listaJugadores[i][4] = RdoSQL.get("numsanciones");
			i++;
		}
		RdoSQL.close();
		return listaJugadores;
	}
	
	public String[][] getJugadoresConvocables(int temporada, int jornadaAnterior, String equipo) {
		String[][] listaJugadores = getListaJugadores(equipo);
		String[][] listaJugadoresConvocables = new String[18][3];
		int i, cont = 0;
		for (i = 0; i < listaJugadores.length; i++) { // Hay que comprobar cada jugador.
			int estaEnVenta = Integer.parseInt(listaJugadores[i][3]);
			if (estaEnVenta == 0) { // Solo puede ser convocado si no esta en venta...
				ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT COUNT(*) as cont FROM tarjetas WHERE numtemporada = '" + temporada + "' AND numjornada = '" + jornadaAnterior + "' AND codjug = '" + listaJugadores[i][0] + "' AND esamarilla = 0");
				RdoSQL.next();
				if (RdoSQL.getInt("cont") == 0) { // ...ademas de no haber tenido tarjeta roja la jornada anterior.
					listaJugadoresConvocables[cont][0] = listaJugadores[i][0]; // CodJug.
					listaJugadoresConvocables[cont][1] = listaJugadores[i][1]; // Nombre.
					listaJugadoresConvocables[cont][2] = listaJugadores[i][2]; // Dorsal.
					cont++;
				}
				RdoSQL.close();
			}
		}
		return listaJugadoresConvocables;
	}
	
	public String[][] getListaJugadoresConvocados(int temporada, int jornada, String equipo) {
		int i = 0, numJugadores = this.getNumJugadoresConvocados(temporada, jornada, equipo);
		String[][] listaJugadores = new String[numJugadores][3];
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT c.codjug as cj, j.nombre as nj, j.dorsal as dj FROM convocado as c, jugador as j WHERE c.numtemporada = '" + temporada + "' AND c.numjornada '" + jornada + "' AND c.codjug = j.codjug AND (nomeqlocal = '" + equipo + "' OR nomeqvisitante = '" + equipo + "'");
		while (RdoSQL.next()) {
			listaJugadores[i][0] = RdoSQL.get("cj");
			listaJugadores[i][1] = RdoSQL.get("nj");
			listaJugadores[i][2] = RdoSQL.get("dj");
			i++;
		}
		RdoSQL.close();
		return listaJugadores;
	}
	
	public String[][] getListaJugadoresTitulares(int temporada, int jornada, String equipo) {
		String[][] listaJugadores = new String[11][3];
		int i = 0;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT t.codjug as cj, j.nombre as nj, j.dorsal as dj FROM titular as t, jugador as j WHERE t.numtemporada = '" + temporada + "' AND t.numjornada '" + jornada + "' AND t.codjug = j.codjug AND (nomeqlocal = '" + equipo + "' OR nomeqvisitante = '" + equipo + "'");
		while (RdoSQL.next()) {
			listaJugadores[i][0] = RdoSQL.get("cj");
			listaJugadores[i][1] = RdoSQL.get("nj");
			listaJugadores[i][2] = RdoSQL.get("dj");
			i++;
		}
		RdoSQL.close();
		return listaJugadores;
	}
	
	private boolean estaJugador(String nombreEquipo, String nombreJugador) {
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT COUNT(*) as cont FROM jugador WHERE nombreequipo = '" + nombreEquipo + "' AND nombre = '" + nombreJugador + "'");
		RdoSQL.next();
		int cont = RdoSQL.getInt("cont");
		RdoSQL.close();
		if (cont != 0)
			return true;
		return false;
	}
	
	public void anadirJugadoresTitulares(String[] jugadoresTitulares, String equipoLocal, String equipoVisitante, int temporada, int jornada) {
		for (int i = 0; i < jugadoresTitulares.length; i++)
			SGBD.getSGBD().execSQL("INSERT INTO convocado (numtemporada, numjornada, nomeqlocal, nomeqvisitante, codjug) VALUES ('" + temporada + "', '" + jornada + "', '" + equipoLocal + "', '" + equipoVisitante + "', '" + jugadoresTitulares[i] + "')");
	}
	
	public void anadirJugadoresConvocados(String[] jugadoresConvocados, String equipoLocal, String equipoVisitante, int temporada, int jornada) {
		for (int i = 0; i < jugadoresConvocados.length; i++)
			SGBD.getSGBD().execSQL("INSERT INTO convocado (numtemporada, numjornada, nomeqlocal, nomeqvisitante, codjug) VALUES ('" + temporada + "', '" + jornada + "', '" + equipoLocal + "', '" + equipoVisitante + "', '" + jugadoresConvocados[i] + "')");
	}
	
	public boolean anadirJugador(String nombreEquipo, String nombreJugador, String dorsal) {
		if (!this.estaJugador(nombreEquipo, nombreJugador)) {
			SGBD.getSGBD().execSQL("INSERT INTO jugador (nombre, dorsal, nombreequipo) VALUES ('" + nombreJugador + "', '" + dorsal + "', '" + nombreEquipo + "')");
			return true;
		}
		return false;
	}
	
	public boolean modificarJugador(String codJug, String nombreEquipo, String nombreJugador, String dorsal) {
		if (!this.estaJugador(nombreEquipo, nombreJugador)) {
			SGBD.getSGBD().execSQL("UPDATE jugador SET nombre = '" + nombreJugador + "', dorsal = '" + dorsal + "' WHERE codjug = '" + codJug + "'");
			return true;
		}
		return false;
	}
	
	public void darDeBajaJugador(String codJug) {
		SGBD.getSGBD().execSQL("UPDATE jugador SET estaretirado = 1 WHERE codjug = '" + codJug + "'");
	}
	
	public int getNumJugadores(String equipo) {
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT COUNT(*) as cont FROM jugador WHERE estaretirado = 0 AND nombreequipo = '" + equipo + "'");
		RdoSQL.next();
		int num = RdoSQL.getInt("cont");
		RdoSQL.close();
		return num;
	}
	
	private int getNumJugadoresConvocados(int temporada, int jornada, String equipo) {
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT COUNT(*) as cont FROM convocado as c, jugador as j WHERE c.numtemporada = '" + temporada + "' AND c.numjornada '" + jornada + "' AND c.codjug = j.codjug AND (nomeqlocal = '" + equipo + "' OR nomeqvisitante = '" + equipo + "'");
		RdoSQL.next();
		int num = RdoSQL.getInt("cont");
		RdoSQL.close();
		return num;
	}
}
