package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoTemporadas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoTemporadasTest {

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testObtenerTemporadas() {
		assertNotNull(CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas());
		assertTrue(CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas()[0]==1);
		
	}

	@Test
	public void testObtenerJornadasDe() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerJornadaAnterior() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerUltimaTemporada() {
		int codTemp=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaTemporada();
	}

	@Test
	public void testObtenerUltimaJornadaDe() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerPartidosDe() {
		fail("Not yet implemented");
	}

	@Test
	public void testInicializarTemporada() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerDatosPartido() {
		fail("Not yet implemented");
	}

}
