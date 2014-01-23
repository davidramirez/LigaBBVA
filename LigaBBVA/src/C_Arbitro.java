import java.util.Observable;

import liga.packControladoras.Liga;
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
}