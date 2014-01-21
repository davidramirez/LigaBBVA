package liga.packControladoras;

public class C_Usuario {

	private static C_Usuario miUsuario = new C_Usuario();	
	
	private  C_Usuario() 
	{
	
	}
	
	public static C_Usuario getMisEstadisticas() 
	{
		return miUsuario;
	}
	
	/**
	 * Actualizamos el admin y password de un equipo determinado
	 * 
	 * @param pUnUsuario el nombre del usuario
	 * @param pUnaContraseña la contraseña
	 * @param pNombreUsuario el nombre del anterior usuario.
	 */
	
	public void actualizarAdminEquipo(String pUnUsuario, String pUnaContraseña, String pNombreUsuario) {
		//Buscamos si existe el usuario en la BD.
		boolean existe = Liga.getMiLiga().buscarUnUsuario(pUnUsuario);
		if(!existe) {
			Liga.getMiLiga().actualizarAdminEquipo(pUnUsuario, pUnaContraseña, pNombreUsuario);
		}
	}
}
