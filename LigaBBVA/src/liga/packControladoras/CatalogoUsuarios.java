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
		 * Función que comprueba el tipo de usuario. No tiene en cuenta el caso de que no
		 * exista el usuario ya que antes se habrá ejecutado indentificarse(id,pass)
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
	
	
	
}
