package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoUsuarios;
import liga.packGestorBD.SGBD;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoUsuariosTest {

	@Before
	public void setUp() throws Exception {
		SGBD.getSGBD().execSQL("INSERT INTO usuario VALUES ('prueba', 'contrasena','preg','resp','1')");
		SGBD.getSGBD().execSQL("INSERT INTO equipo VALUES ('equipoprueba', '1','1000','prueba','Vizcaya')");
		
	}

	@After
	public void tearDown() throws Exception {
		
		SGBD.getSGBD().execSQL("DELETE FROM usuario WHERE nombre='prueba'");
	}

	@Test
	public void testIdentificarse() {
		
		assertTrue(CatalogoUsuarios.getMiCatalogoUsuarios().identificarse("prueba", "contrasena"));
		assertFalse(CatalogoUsuarios.getMiCatalogoUsuarios().identificarse("prueba", "contraseno"));
		
		
	}

	@Test
	public void testObtenerTipo() {
		String rdo = CatalogoUsuarios.getMiCatalogoUsuarios().obtenerTipo("prueba");
		assertEquals("equipo",rdo);
	}

	@Test
	public void testObtenerPregunta() {
		String rdo = CatalogoUsuarios.getMiCatalogoUsuarios().obtenerPregunta("prueba");
		assertEquals(rdo, "preg");
	}

	@Test
	public void testRecuperarPass() {
		String rdo = CatalogoUsuarios.getMiCatalogoUsuarios().recuperarPass("prueba", "resp");
		assertEquals(rdo,"contrasena");
		rdo= CatalogoUsuarios.getMiCatalogoUsuarios().recuperarPass("prueba", "rusp");
		assertNull(rdo);
	}

	@Test
	public void testCambiarPass() {
		CatalogoUsuarios.getMiCatalogoUsuarios().cambiarPass("prueba", "contrasena", "contrasena2", "preg", "resp");
		assertTrue(CatalogoUsuarios.getMiCatalogoUsuarios().identificarse("prueba", "contrasena2"));
	}

	@Test
	public void testBuscarUnUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizarAdminEquipo() {
		fail("Not yet implemented");
	
	}

}
