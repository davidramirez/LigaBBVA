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
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM usuario WHERE nombre=" + id +"  AND contrasena=" + pass +"");
		if (RdoSQL.next()){rdo=true;}
		RdoSQL.close();
		return rdo;
	}
	
	public String obtenerTipo(String id)
	{
		/*
		 * Método que comprueba el tipo de usuario. No tiene en cuenta el caso de que no
		 * exista el usuario ya que antes se habrá ejecutado indentificarse(id,pass).
		 */
		
		
		String rdo="";
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM arbitro WHERE nombreusuario=" + id +"");
		
		if (RdoSQL.next())
		{
			rdo="arbitro";
		}
		else
		{
			RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM equipo WHERE nombreusuario=" + id +"");
			if (RdoSQL.next())
			{
				rdo="equipo";
			}
			else
			{
				rdo="admin";
			}
		}
		RdoSQL.close();
		return rdo;
		
	}
	
	public String obtenerPregunta(String id)
	{
		
		/*
		 * Método que devuelve la pregunta de seguridad de un usuario. Si el ID de éste es incorrecto,
		 * devuelve null.
		 */
		String rdo=null;
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT preguntaSeg FROM usuario WHERE nombre=" + id +"");
		if(RdoSQL.next())
		rdo=RdoSQL.get("preguntaseg");
		RdoSQL.close();
		return rdo;
	}
	
	public String recuperarPass(String id, String resp)
	{
		/*
		 * Método que devuelve la contraseña de un usuario en función de si ha contestado bien la pregunta
		 * de seguridad. De no ser así devolverá null.
		 */
		
		String rdo=null;
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT contrasena FROM usuario WHERE nombre=" + id +" AND respuestaseg="+resp+"");
		if(RdoSQL.next())
		rdo=RdoSQL.get("contrasena");
		RdoSQL.close();
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
			SGBD.getSGBD().execSQL("UPDATE usuario SET contrasena="+ passN+", preguntaseg="+preg+", respuestaseg="+resp+" WHERE nombre="+id+"");
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
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM usuario WHERE nombre="+pUnUsuario);
		if(RdoSQL.next()) {
			//El usuario existe
			existe = true;
		}
		return existe;
	}
	
	public String obtenerEquipoDe(String id)
	{
		String rdo=null;
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT nombre FROM equipo WHERE nombreusuario=" + id +"");
		if(RdoSQL.next())
		rdo=RdoSQL.get("nombre");
		RdoSQL.close();
		return rdo;
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
