package liga.packControladoras;

import java.util.Date;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoJugadores {
	private static CatalogoJugadores miCatalogoJugadores = new CatalogoJugadores();
	
	private CatalogoJugadores() {}
	
	public static CatalogoJugadores getCatalogoJugadores() {
		return miCatalogoJugadores;
	}
	
	@SuppressWarnings("null")
	public String[][] getListaJugadores(String equipo) {
		String[][] listaJugadores = null;
		int i = 0;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT Nombre, Dorsal, estaEnVenta, estaRetirado, numSanciones FROM Jugador WHERE NombreEquipo = " + equipo);
		while (RdoSQL.next()) {
			listaJugadores[i][0] = RdoSQL.get("Nombre");
			listaJugadores[i][1] = RdoSQL.get("Dorsal");
			listaJugadores[i][2] = RdoSQL.get("estaEnVenta");
			listaJugadores[i][3] = RdoSQL.get("estaRetirado");
			listaJugadores[i][4] = RdoSQL.get("numSanciones");
			i++;
		}
		return listaJugadores;
	}
	
	public String[][] getJugadoresConvocables(Date fecha, String equipo) {
		return null;
	}
	
	private boolean estaJugador(String nombreEquipo, String nombreJugador) {
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT COUNT(*) as cont FROM Jugador WHERE NombreEquipo = " + nombreEquipo + " AND Nombre = " + nombreJugador);
		RdoSQL.next();
		if (RdoSQL.get("cont") != "0")
			return true;
		return false;
	}
	
	public boolean anadirJugadoresConvocados() {
		return true;
	}
	
	public boolean anadirJugador(String nombreEquipo, String nombreJugador, String dorsal) {
		if (!this.estaJugador(nombreEquipo, nombreJugador)) {
			SGBD.getSGBD().execSQL("INSERT INTO Jugador (Nombre, Dorsal, NombreEquipo) VALUES (" + nombreJugador + ", " + dorsal + ", " + nombreEquipo + ")");
			return true;
		}
		return false;
	}
	
	public boolean modificarJugador(String codJug, String nombreEquipo, String nombreJugador) {
		if (!this.estaJugador(nombreEquipo, nombreJugador)) {
			SGBD.getSGBD().execSQL("UPDATE Jugador SET Nombre = " + nombreJugador + " WHERE CodJug = " + codJug);
			return true;
		}
		return false;
	}
	
	public void darDeBajaJugador(String codJug) {
		SGBD.getSGBD().execSQL("UPDATE Jugador SET estaRetirado = True WHERE CodJug = " + codJug);
	}
}
