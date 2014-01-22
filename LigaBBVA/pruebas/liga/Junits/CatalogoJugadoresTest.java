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
		fail("Not yet implemented");
	}

	@Test
	public void testGetJugadoresConvocables() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListaJugadoresConvocados() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListaJugadoresTitulares() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirJugadoresTitulares() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirJugadoresConvocados() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirJugador() {
		assertFalse(CatalogoJugadores.getCatalogoJugadores().anadirJugador("Athletic", "Erik Morán", "5"));
	}

	@Test
	public void testModificarJugador() {
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("1", "Athletic", "Erik Morán", "5"));
	}

	@Test
	public void testDarDeBajaJugador() {
		fail("Not yet implemented");
	}

}
