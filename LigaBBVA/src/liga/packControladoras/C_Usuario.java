package liga.packControladoras;

public class C_Usuario {

	private static C_Usuario miUsuario = new C_Usuario();	
	
	private  C_Usuario() 
	{
	
	}
	
	public static C_Usuario getMiUsuario() 
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
	
	public boolean identificarse(String id, String pass)
	{
		return Liga.getMiLiga().identificarse(id, pass);
	}
	
	public String obtenerTipo(String id)
	{
		return Liga.getMiLiga().obtenerTipo(id);
	}
	
	public String obtenerPregunta(String id)
	{
		return Liga.getMiLiga().obtenerPregunta(id);
	}
	
	public String recuperarPass(String id, String resp)
	{
		return Liga.getMiLiga().recuperarPass(id, resp);
	}
	
	public boolean cambiarPass(String id, String passAnt, String passN, String preg, String resp)
	{
		return Liga.getMiLiga().cambiarPass(id, passAnt, passN, preg, resp);
	}
}
