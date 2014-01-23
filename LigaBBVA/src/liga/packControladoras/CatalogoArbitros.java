package liga.packControladoras;

import java.util.ArrayList;

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

	public ArrayList<String[]> obtenerArbitros() {
		ResultadoSQL r = SGBD.getSGBD().consultaSQL("SELECT a.nombre, a.apellidos, a.dni, a.provincia, u.estaactivo FROM arbitro AS a INNER JOIN usuario AS u ON a.nombreusuario = u.nombre");
		
		ArrayList<String[]> rdo = new ArrayList<String[]>();
		
		while(r.next())
		{
			//creamos una nueva posicion para el array
			String[] ar = new String[5];
			ar[0] = r.get("nombre");
			ar[1] = r.get("apellidos");
			ar[2] = r.get("dni");
			ar[3] = r.get("provincia");
			ar[4] = r.get("estaactivo");
			
			//añadimos el arbitro al array
			rdo.add(ar);
		}
		r.close();
		
		return rdo;
	}
	
	/**
	 * Busca la existencia de un árbitro a partir de su dni
	 * 
	 * @param pDni el dni del árbitro a buscar.
	 */
	
	public boolean buscarSiExisteArbitro (String pDni) {
		boolean existe = false;
		ResultadoSQL rdo = SGBD.getSGBD().consultaSQL("SELECT * from Arbitro WHERE dni='"+pDni+"'");
		if(rdo.next()) {
			//El árbitro existe
			existe = true;
		}
		return existe;
	}
	
	/**
	 * Se encarga de actualizar los datos de un árbitro determinado.
	 * 
	 * @param pArbitro los datos relativos al árbitro.
	 */
	
	public void actualizarArbitro(Arbitro pArbitro,String pNombreUsuarioAnterior) {
		SGBD.getSGBD().execSQL("UPDATE arbitro SET nombre='"+pArbitro.getNombre()+"',apellidos='"+pArbitro.getApellidos()+"',provincia='"+pArbitro.getProvincia()+"',fechaNacimiento="+pArbitro.getFechaNacimiento()+",dni='"+pArbitro.getDNI()+"' WHERE nombreUsuario='"+pNombreUsuarioAnterior+"'");
	}
}