package liga.packControladoras;

import liga.packGestorBD.*;

public class CatalogoUsuarios {
	private static CatalogoUsuarios misUsuarios=new CatalogoUsuarios();

	
	private  CatalogoUsuarios() 
	{		
	}
	public static CatalogoUsuarios getMiCatalogoUsuarios(){
		return misUsuarios;
	}
	
	public boolean identificarse(String id, String pass)
	{
		boolean rdo=false;
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM Usuario WHERE Nombre=" + id +"  AND Contrasena=" + pass +"");
		if (RdoSQL.next()){rdo=true;}
		
		return rdo;
	}
	
	public String obtenerTipo(String id)
	{
		/*
		 * Método que comprueba el tipo de usuario. No tiene en cuenta el caso de que no
		 * exista el usuario ya que antes se habrá ejecutado indentificarse(id,pass).
		 */
		
		
		String rdo="";
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM Arbitro WHERE NombreUsuario=" + id +"");
		
		if (RdoSQL.next())
		{
			rdo="arbitro";
		}
		else
		{
			RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM Equipo WHERE NombreUsuario=" + id +"");
			if (RdoSQL.next())
			{
				rdo="equipo";
			}
			else
			{
				rdo="admin";
			}
		}
		
		return rdo;
		
	}
	
	public String obtenerPregunta(String id)
	{
		
		/*
		 * Método que devuelve la pregunta de seguridad de un usuario. Si el ID de éste es incorrecto,
		 * devuelve null.
		 */
		String rdo=null;
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT PreguntaSeg FROM Usuario WHERE Nombre=" + id +"");
		if(RdoSQL.next())
		rdo=RdoSQL.get("PreguntaSeg");
		
		return rdo;
	}
	
	public String recuperarPass(String id, String resp)
	{
		/*
		 * Método que devuelve la contraseña de un usuario en función de si ha contestado bien la pregunta
		 * de seguridad. De no ser así devolverá null.
		 */
		
		String rdo=null;
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT Contrasena FROM Usuario WHERE Nombre=" + id +" AND RespuestaSeg="+resp+"");
		if(RdoSQL.next())
		rdo=RdoSQL.get("Contrasena");
		
		return rdo;
	}
	
	
	public boolean cambiarPass(String id, String passAnt, String passN, String preg, String resp)
	{
		/*
		 * Método que cambia la contraseña y además actualiza pregunta y respuesta de seguridad.
		 */
		
		boolean rdo=false;
		if(identificarse(id,passAnt))
		{
			SGBD.getSGBD().execSQL("UPDATE Usuario SET Contrasena="+ passN+", PreguntaSeg="+preg+", RespuestaSeg="+resp+" WHERE Nombre="+id+"");
			rdo=true;
		}
		/*
		 * Como un execSQL no nos permite comprobar si se ha efectuado el cambio, comprobamos que haya introducido
		 * la contraseña vieja correcta mediante el método identificarse(id,pass).
		 */
		
		
		return rdo;
	}
	
	/**
	 * Se encarga de buscar si existe o no un usuario en el sistema.
	 * 
	 * @param pUnUsuario el nombre del usuario que deseamos buscar.
	 */
	
	public boolean buscarUnUsuario(String pUnUsuario) {
		boolean existe = false;
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM Usuario WHERE Nombre="+pUnUsuario);
		if(RdoSQL.next()) {
			//El usuario existe
			existe = true;
		}
		return existe;
	}
	
	/**
	 * Actualizamos el admin y password de un equipo determinado
	 * 
	 * @param pUnUsuario el nombre del usuario
	 * @param pUnaContraseña la contraseña
	 * @param pNombreUsuario el nombre del anterior usuario.
	 */
	public void actualizarAdminEquipo(String pUnUsuario,String pUnaContraseña,String pNombreUsuario) {
		SGBD.getSGBD().execSQL("UPDATE usuario SET nombre='"+pUnUsuario+"',contraseña='"+pUnaContraseña+"' WHERE usuario='"+pNombreUsuario+'"');
	}
}
