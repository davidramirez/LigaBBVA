package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoJugadores;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoJugadoresTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetListaJugadores() {
		String[][] jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores[0][1].toString().equals("Erik Morán"));
		assertTrue(jugadores.length == 1);
	}

	@Test
	public void testGetJugadoresConvocables() {
		String[][] jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores[0][1].toString().equals("Erik Morán"));
		assertTrue(jugadores.length == 1);
	}

	@Test
	public void testGetListaJugadoresConvocados() {
		String[][] jugadoresConvocados = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresConvocados(1, 2, "Real Sociedad");
		assertTrue(jugadoresConvocados.length == 1);
	}

	@Test
	public void testGetListaJugadoresTitulares() {
		String[][] jugadoresConvocados = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresTitulares(1, 2, "Athletic");
		assertTrue(jugadoresConvocados.length == 11);
	}

	@Test
	public void testAnadirJugadoresTitulares() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirJugadoresConvocados() {
		/*String[] jugadores = new String[1];
		jugadores[0] = "7";
		CatalogoJugadores.getCatalogoJugadores().anadirJugadoresConvocados(jugadores, "Athletic", "Real Sociedad", 1, 2);
		String[][] jugadoresConvocados = CatalogoJugadores.getCatalogoJugadores().getListaJugadoresConvocados(1, 2, "Real Sociedad");
		assertTrue(jugadoresConvocados[0][1].toString().equals("Antoine Griezmann"));
		assertTrue(jugadoresConvocados.length == 1);*/
	}

	@Test
	public void testAnadirJugador() {
		/* Jugador que existe. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().anadirJugador("Athletic", "Erik Morán", "5"));
		/* Jugador que no existe. */
		assertTrue(CatalogoJugadores.getCatalogoJugadores().anadirJugador("Athletic", "Prueba", "50"));
	}

	@Test
	public void testModificarJugador() {
		/* Jugador sin cambiar datos. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("1", "Athletic", "Erik Morán", "5"));
		/* Jugador con el mismo nombre que otro. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("4", "Athletic", "Erik Morán", "5"));
		/* Jugador que no existe. */
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("2", "Athletic", "Erik Morán", "5"));
	}

	@Test
	public void testDarDeBajaJugador() {
		fail("Not yet implemented");
	}

}
