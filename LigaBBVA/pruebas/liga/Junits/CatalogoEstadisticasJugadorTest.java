package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoEstadisticasJugador;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoEstadisticasJugadorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testObtenerJugadorFairPlay() {
		//CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerEstadisticasJugador(1);
	}

	@Test
	public void testObtenerEstadisticasJugador() {
		int[] estadistica =CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerEstadisticasJugador(1);
		System.out.println(estadistica[1]);
	}

}
