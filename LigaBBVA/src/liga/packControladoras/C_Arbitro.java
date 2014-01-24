package liga.packControladoras;
import java.util.ArrayList;
import java.util.Observable;

import liga.packModelo.Arbitro;

public class C_Arbitro {
	private static C_Arbitro miC_Arbitro = new C_Arbitro();	
			
	private C_Arbitro() {
	}
	
	public static C_Arbitro getC_Arbitro() {
		return miC_Arbitro;
	}

	/**
	 * Se encarga de actualizar los datos de un árbitro determinado.
	 * 
	 * @param pArbitro los datos relativos al árbitro.
	 */
	
	public void actualizarArbitro(Arbitro pArbitro,String pUnUsuario,String pUnaContrasena,String pNombreUsuarioAnterior) {
		//Buscamos si existe duplicado
		boolean existeArbitro = Liga.getMiLiga().buscarSiExisteArbitro(pArbitro.getDNI());
		if(!existeArbitro) {
			//Buscamos si el usuario existe
			boolean existeUsuario = Liga.getMiLiga().buscarUnUsuario(pUnUsuario);
			if(!existeUsuario) {
				//Actualizamos los datos
				Liga.getMiLiga().actualizarArbitro(pArbitro, pNombreUsuarioAnterior);
				Liga.getMiLiga().actualizarUsuario(pUnUsuario, pUnaContrasena, pNombreUsuarioAnterior);
			}
		}
	}
	
	
	/**
	 * Obtiene la lista de los nombres de los aŕbitros de la temporada actual
	 * 
	 * @param temporadaActual Los datos realtivos a la temporada actual.
	 */
	
	public ArrayList<String[]> obtenerNombreArbitros(int temporadaActual) {
		return Liga.getMiLiga().obtenerNombreArbitros(temporadaActual);
	}
	
	/**
	 * Obtiene los datos relativos a un árbitro a partir de su dni
	 * 
	 * @param elArbitroSeleccionado el dni del árbitro seleccionado.
	 */
	public String ObtenerDatosArbitro(String elArbitroSeleccionado) {
		return Liga.getMiLiga().ObtenerDatosArbitro(elArbitroSeleccionado);
	}
	
	/**
	 * Obtiene los árbitros de una provincia que NO están en la temporada actual.
	 * 
	 */
	public ArrayList<String[]> ObtenerArbitroPorProvincia(String provincia, int temporadaActual) {
		return Liga.getMiLiga().ObtenerArbitroPorProvincia(provincia, temporadaActual);
	}
}