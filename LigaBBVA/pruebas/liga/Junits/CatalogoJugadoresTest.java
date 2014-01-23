package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoJugadores;
import liga.packGestorBD.SGBD;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoJugadoresTest {

	@Before
	public void setUp() throws Exception {
		SGBD.getSGBD().execSQL("INSERT INTO usuario (nombre, contrasena, preguntaseg, respuestaseg, estaactivo) VALUES ('AthleticUser', '12345', '', '', 1)");
		SGBD.getSGBD().execSQL("INSERT INTO usuario (nombre, contrasena, preguntaseg, respuestaseg, estaactivo) VALUES ('RealSociedadUser', '12345', '', '', 1)");
		
		SGBD.getSGBD().execSQL("INSERT INTO equipo (nombre, puntos, dinero, nombreusuario, provincia) VALUES ('Athletic', 0, 9999999999, 'AthleticUser', 'Bizkaia')");
		SGBD.getSGBD().execSQL("INSERT INTO equipo (nombre, puntos, dinero, nombreusuario, provincia) VALUES ('Real Sociedad', 0, 9999999999, 'RealSociedadUser', 'Gipuzkoa')");
		
		SGBD.getSGBD().execSQL("INSERT INTO temporada (numtemporada, fechainicio, fechafin) VALUES (1, '2014-01-20', '2014-01-24')");
		
		SGBD.getSGBD().execSQL("INSERT INTO jornada (numjornada, fecha, estajugada, numtemporada) VALUES (1, '2014-01-20', 1, 1)");
		
		SGBD.getSGBD().execSQL("INSERT INTO jugador (codjug, nombre, dorsal, estaenventa, estaretirado, numsanciones, nombreequipo) VALUES (200, 'Prueba1', 1, 0, 1, 0, 'Athletic')");
		SGBD.getSGBD().execSQL("INSERT INTO jugador (codjug, nombre, dorsal, estaenventa, estaretirado, numsanciones, nombreequipo) VALUES (201, 'Prueba2', 2, 1, 0, 0, 'Athletic')");
		SGBD.getSGBD().execSQL("INSERT INTO jugador (codjug, nombre, dorsal, estaenventa, estaretirado, numsanciones, nombreequipo) VALUES (202, 'Prueba3', 3, 0, 0, 0, 'Athletic')");
		SGBD.getSGBD().execSQL("INSERT INTO jugador (codjug, nombre, dorsal, estaenventa, estaretirado, numsanciones, nombreequipo) VALUES (203, 'Prueba4', 4, 0, 1, 0, 'Athletic')");
		SGBD.getSGBD().execSQL("INSERT INTO jugador (codjug, nombre, dorsal, estaenventa, estaretirado, numsanciones, nombreequipo) VALUES (204, 'Prueba4', 1, 0, 0, 0, 'Real Sociedad')");
		
		SGBD.getSGBD().execSQL("INSERT INTO partido (fecha, numtemporada, numjornada, nomeqlocal, nomeqvisitante) VALUES ('2014-01-20', 1, 1, 'Athletic', 'Real Sociedad')");
		
		SGBD.getSGBD().execSQL("INSERT INTO convocado (numtemporada, numjornada, nomeqlocal, nomeqvisitante, codjug) VALUES (1, 1, 'Athletic', 'Real Sociedad', 201)");
		
		SGBD.getSGBD().execSQL("INSERT INTO titular (numtemporada, numjornada, nomeqlocal, nomeqvisitante, codjug) VALUES (1, 1, 'Athletic', 'Real Sociedad', 204)");
	}

	@After
	public void tearDown() throws Exception {
		SGBD.getSGBD().execSQL("DELETE FROM titular WHERE codjug = 204");
		SGBD.getSGBD().execSQL("DELETE FROM titular WHERE codjug = 202");
		
		SGBD.getSGBD().execSQL("DELETE FROM convocado WHERE codjug = 201");
		SGBD.getSGBD().execSQL("DELETE FROM convocado WHERE codjug = 204");
		
		SGBD.getSGBD().execSQL("DELETE FROM partido WHERE numtemporada = 1");
		
		SGBD.getSGBD().execSQL("DELETE FROM jugador WHERE codjug = 200");
		SGBD.getSGBD().execSQL("DELETE FROM jugador WHERE codjug = 201");
		SGBD.getSGBD().execSQL("DELETE FROM jugador WHERE codjug = 202");
		SGBD.getSGBD().execSQL("DELETE FROM jugador WHERE codjug = 203");
		SGBD.getSGBD().execSQL("DELETE FROM jugador WHERE codjug = 204");
		SGBD.getSGBD().execSQL("DELETE FROM jugador WHERE nombre = 'Prueba' AND dorsal = 50");
		
		SGBD.getSGBD().execSQL("DELETE FROM jornada WHERE numjornada = 1");
		
		SGBD.getSGBD().execSQL("DELETE FROM temporada WHERE numtemporada = 1");
		
		SGBD.getSGBD().execSQL("DELETE FROM equipo WHERE nombre = 'Real Sociedad'");
		SGBD.getSGBD().execSQL("DELETE FROM equipo WHERE nombre = 'Athletic'");
		
		SGBD.getSGBD().execSQL("DELETE FROM usuario WHERE nombre = 'RealSociedadUser'");
		SGBD.getSGBD().execSQL("DELETE FROM usuario WHERE nombre = 'AthleticUser'");
	}

	@Test
	public void testGetListaJugadores() {
		/* Lista de jugadores de un equipo. */
		String[][] jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores.length == 2);
		/* Lista de jugadores del otro equipo. */
		jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Real Sociedad");
		assertTrue(jugadores.length == 1);
	}

	@Test
	public void testGetJugadoresConvocables() {
		/* Convocables de un equipo. */
		String[][] jugadores = CatalogoJugadores.getCatalogoJugadores().getJugadoresConvocables(1, 1, "Athletic");
		assertTrue(jugadores[0][0].equals("202"));
		/* Convocables del otro equipo. */
		jugadores = CatalogoJugadores.getCatalogoJugadores().getJugadoresConvocables(1, 1, "Real Sociedad");
		assertTrue(jugadores[0][0].equals("204"));
	}

	@Test
	public void testGetListaJugadoresConvocados() {
		/* No hay convocados para esa jornada. */
		String[][] jugadoresConvocados = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresConvocados(1, 1, "Real Sociedad");
		assertTrue(jugadoresConvocados.length == 0);
		/* Hay convocados para esa jornada. */
		jugadoresConvocados = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresConvocados(1, 1, "Athletic");
		assertTrue(jugadoresConvocados.length == 1);
	}

	@Test
	public void testGetListaJugadoresTitulares() {
		/* Hay titulares para esa jornada. */
		String[][] jugadoresTitulares = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresTitulares(1, 1, "Real Sociedad");
		assertTrue(jugadoresTitulares[0][0].equals("204"));
		/* No hay titulares para esa jornada. */
		jugadoresTitulares = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresTitulares(1, 1, "Athletic");
		assertNull(jugadoresTitulares[0][0]);
	}

	@Test
	public void testAnadirJugadoresTitulares() {
		String[] jugadores = new String[1];
		jugadores[0] = "202";
		CatalogoJugadores.getCatalogoJugadores().anadirJugadoresTitulares(jugadores, "Athletic", "Real Sociedad", 1, 1);
		String[][] jugadoresTitulares = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresTitulares(1, 1, "Athletic");
		assertTrue(jugadoresTitulares[0][0].equals("202"));
	}

	@Test
	public void testAnadirJugadoresConvocados() {
		String[] jugadores = new String[1];
		jugadores[0] = "204";
		CatalogoJugadores.getCatalogoJugadores().anadirJugadoresConvocados(jugadores, "Athletic", "Real Sociedad", 1, 1);
		String[][] jugadoresConvocados = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresConvocados(1, 1, "Real Sociedad");
		assertTrue(jugadoresConvocados[0][0].equals("204"));
	}

	@Test
	public void testAnadirJugador() {
		/* Jugador que existe. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().anadirJugador("Athletic", "Prueba1", "5"));
		/* Jugador que no existe. */
		assertTrue(CatalogoJugadores.getCatalogoJugadores().anadirJugador("Athletic", "Prueba", "50"));
	}

	@Test
	public void testModificarJugador() {
		/* Jugador sin cambiar datos. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("200", "Athletic", "Prueba1", "5"));
		/* Jugador con el mismo nombre que otro. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("201", "Athletic", "Prueba1", "5"));
		/* Jugador que no existe. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("205", "Athletic", "Prueba1", "5"));
	}

	@Test
	public void testDarDeBajaJugador() {
		/* Jugador ya en baja, la lista tiene el mismo tamaño. */
		CatalogoJugadores.getCatalogoJugadores().darDeBajaJugador("200");
		String[][] jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores.length == 2);
		/* Jugador no en baja, modificar la lista. */
		CatalogoJugadores.getCatalogoJugadores().darDeBajaJugador("201");
		jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores.length == 1);
		/* Jugador no existe, no pasa nada. */
		CatalogoJugadores.getCatalogoJugadores().darDeBajaJugador("201");
		jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores.length == 1);
	}
}
