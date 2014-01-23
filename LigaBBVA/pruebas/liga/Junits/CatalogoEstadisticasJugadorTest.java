package liga.Junits;

import liga.packControladoras.CatalogoEstadisticasJugador;
import liga.packControladoras.CatalogoTemporadas;

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
		int codTemp=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaTemporada();
		System.out.println(codTemp);
		//Iterator<String>itr=C_FairPlay.getMiFairPlay().obtenerJugadorFairPlay(codTemp).iterator();
		System.out.println(CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerJugadorFairPlay(codTemp).iterator().next());
	}

	@Test
	public void testObtenerEstadisticasJugador() {
		int[] estadistica =CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerEstadisticasJugador(1);
		System.out.println(estadistica[1]);
	}

}
