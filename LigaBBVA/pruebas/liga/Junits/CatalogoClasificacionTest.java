package liga.Junits;

import liga.packControladoras.Liga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoClasificacionTest {
	
	private int temp;
	private int jor;
	private String[] clasificacion;
	
	@Before
	public void setUp() throws Exception 
	{
		 temp=Liga.getMiLiga().obtenerUltimaTemporada();
		 jor=Liga.getMiLiga().obtenerUltimaJornadaDe(temp);
		 clasificacion=Liga.getMiLiga().obtenerClasificacion(temp, jor);
	}

	@After
	public void tearDown() throws Exception {
		temp=0;
		jor=0;
		clasificacion=null;		
	}

	@Test
	public void testObtenerClasificacion() 
	{
		System.out.println(clasificacion[0]);
	}

}
