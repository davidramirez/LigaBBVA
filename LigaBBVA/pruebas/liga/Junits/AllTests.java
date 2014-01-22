package liga.Junits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CatalogoClasificacionTest.class, CatalogoEquiposTest.class,
		CatalogoEstadisticasJugadorTest.class, CatalogoJugadoresTest.class,
		CatalogoTemporadasTest.class, CatalogoUsuariosTest.class })
public class AllTests {

}
