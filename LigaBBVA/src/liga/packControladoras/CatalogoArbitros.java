package liga.packControladoras;

import liga.packEnumeration.Provincia;
import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;
import liga.packModelo.Arbitro;
import liga.packModelo.ListaArbitros;

public class CatalogoArbitros {
	
	private static CatalogoArbitros miCatalogoArbitros = new CatalogoArbitros();
	
	private CatalogoArbitros()
	{
		
	}

	public static CatalogoArbitros getMiCatalogoArbitros()
	{
		return miCatalogoArbitros;
	}

	public ListaArbitros obtenerArbitrosTemporada(int pNumTemp) {
		
		ListaArbitros lista = new ListaArbitros();
		ResultadoSQL r = SGBD.getSGBD().consultaSQL("SELECT * FROM arbitro AS a INNER JOIN arbitrostemporada AS at ON a.dni = at.dniarbitro WHERE at.numtemporada ="+pNumTemp);
		while(r.next())
		{
			lista.anadirArbitro(new Arbitro(r.get("nombre"), r.get("apellido"), Provincia.buscarComponente(r.get("provincia")), r.get("dni")));
		}
		r.close();
		return lista;
	}
}
