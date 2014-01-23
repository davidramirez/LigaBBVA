package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoEquipos;
import liga.packControladoras.Liga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoEquiposTest {

	int ultTemp=Liga.getMiLiga().obtenerUltimaTemporada();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		ultTemp=0;
	}

	@Test
	public void testObtenerEquipoFairPlay() {
		CatalogoEquipos.getMisEquipos().obtenerEquipoFairPlay(ultTemp);
		System.out.println(CatalogoEquipos.getMisEquipos().obtenerEquipoFairPlay(ultTemp));
	}

	@Test
	public void testBuscarSiExiste() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirEquipo() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerNombresEquipos() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarEquipo() {
		fail("Not yet implemented");
	}

}
