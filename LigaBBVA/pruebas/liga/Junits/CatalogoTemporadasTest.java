package liga.Junits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import liga.packControladoras.CatalogoTemporadas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoTemporadasTest {

	private ArrayList<Integer> listaPruebas;

	@Before
	public void setUp() throws Exception 
	{
		listaPruebas=new ArrayList<Integer>();
	}

	@After
	public void tearDown() throws Exception 
	{
		listaPruebas=null;
	}

	@Test
	public void testObtenerTemporadas() {
		listaPruebas=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas();
		assertNotNull(listaPruebas);
		assertTrue(listaPruebas.size()!=0);
		
	}

	@Test
	public void testObtenerJornadasDe()
	{
		int codTemp=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaTemporada();
		listaPruebas=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerJornadasDe(codTemp);
		Iterator<Integer> itr=listaPruebas.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	@Test
	public void testObtenerJornadaAnterior() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerUltimaTemporada() {
		int codTemp=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaTemporada();
		System.out.println(codTemp);
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
