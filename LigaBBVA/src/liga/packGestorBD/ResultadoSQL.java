package liga.packGestorBD;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class ResultadoSQL {
	
	private ResultSet rdo;
	
	public ResultadoSQL()
	{
		this.rdo = null;
	}
	
	public ResultadoSQL(ResultSet pRdo)
	{
		this.rdo = pRdo;
	}
	
	public boolean next()
	{
		if(this.rdo != null)
		{
			try {
				
				return this.rdo.next();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en la conexion con la base de datos");
			}
		}
		//si el resultado es nulo o falla la conexion
		//se devuelve false
		return false;
	}
	
	/**
	 * devuelve el campo de la fila actual en la columna especificada 
	 * como un string
	 * @param pNomAtributo Nombre de la columna de la tabla
	 * @return un string, null en caso de que falle la conexion
	 * a la base de datos
	 */
	public String get(String pNomAtributo)
	{
		try {
			
			return this.rdo.getString(pNomAtributo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexion con la base de datos");
			return null;
		}
	}

	/**
	 * devuelve el campo de la fila actual en la columna especificada 
	 * como un entero
	 * @param pNomAtributo Nombre de la columna de la tabla
	 * @return un entero, 0 en caso de que falle la conexion
	 * a la base de datos
	 */
	public int getInt(String pNomAtributo)
	{
		try {
			
			return this.rdo.getInt(pNomAtributo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexion con la base de datos");
			return 0;
		}
	}
	
	/**
	 * devuelve el campo de la fila actual en la columna especificada 
	 * como un booleano
	 * @param pNomAtributo Nombre de la columna de la tabla
	 * @return un nooleano, false en caso de que falle la conexion
	 * a la base de datos
	 */
	public boolean getBoolean(String pNomAtributo)
	{
		try {
			
			return this.rdo.getBoolean(pNomAtributo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexion con la base de datos");
			return false;
		}
	}
	
	
	/**
	 * devuelve el campo de la fila actual en la columna especificada 
	 * como una fecha de tipo GregorianCalendar
	 * @param pNomAtributo Nombre de la columna de la tabla
	 * @return la fecha como GregorianCalendar, null en caso de que falle la conexion
	 * a la base de datos
	 */
	public GregorianCalendar getDate(String pNomAtributo)
	{
		try {
			
			Date fecha = this.rdo.getDate(pNomAtributo);
			//transformamos la fecha obtenida a un objeto GregorianCalendar
			return (new GregorianCalendar((fecha.getYear()),fecha.getMonth(),fecha.getDate()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexion con la base de datos");
			return null;
		}
	}
	
	/**
	 * cierra la conexion con la base de datos
	 */
	public void close()
	{
		try {
			
			this.rdo.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al cerrar la conexión");
		}
	}
	
}
