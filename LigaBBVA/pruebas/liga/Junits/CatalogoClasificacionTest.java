package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoClasificacion;
import liga.packControladoras.Liga;
import liga.packJGA.Clasificacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoClasificacionTest {
	
	private int temp;
	private int jor;
	String[] clasificacion;
	
	@Before
	public void setUp() throws Exception 
	{
		 temp=Liga.getMiLiga().obtenerUltimaTemporada();
		 jor=Liga.getMiLiga().obtenerUltimaJornadaDe(temp);
		 clasificacion=CatalogoClasificacion.getMiCatalogoClasificacion().obtenerClasificacion(temp, jor);
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
		String pEq=clasificacion[0];		
		assertEquals(pEq,"Athletic");//Depende de los datos
		/*Probado, funcionamiento correcto, con la interfaz
		 */

	}
	
	@Test	
	public void testobtenerClasificacione()
	{
		Clasificacion[] clasE=CatalogoClasificacion.getMiCatalogoClasificacion().obtenerClasificacione(temp, jor);
		/*Probado, funcionamiento correcto, con la interfaz
		 */
	}
	
	
}
