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
	private int pTemp;
	private int pJor;

	@Before
	public void setUp() throws Exception 
	{
		listaPruebas=new ArrayList<Integer>();
		pTemp=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaTemporada();
		pJor=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaJornadaDe(pTemp);
	}

	@After
	public void tearDown() throws Exception 
	{
		listaPruebas=null;
		pTemp=0;
		pJor=0;
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
		
		listaPruebas=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerJornadasDe(pTemp);
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
		int ult=CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaTemporada();
		assertTrue(pTemp==ult);
		System.out.println(ult);
	}

	@Test
	public void testObtenerUltimaJornadaDe() 
	{
		System.out.println(pJor);
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
