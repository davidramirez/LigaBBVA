package liga.packControladoras;

import java.util.ArrayList;
import java.util.Iterator;

import net.sf.jga.algorithms.Sort;
import liga.packJGA.*;
import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoClasificacion 
{
private static CatalogoClasificacion miCatalogoClasificacion= new CatalogoClasificacion();

	private int maxEquipos;
	
	private  CatalogoClasificacion() 
	{
		this.maxEquipos=20;
	}
	
	public static CatalogoClasificacion getMiCatalogoClasificacion() 
	{
		return miCatalogoClasificacion;
	}
	
	public String[] obtenerClasificacion(int pNumTemporada,int pNumJornada)
	{
		//pre:se recibe como parametro el número de Temporada y Jornada de la que se quiere la clasificación
		//pos:Se devuelve una lista con los equipos ordenados por puntos, goles a favor y goles en contra.
		
		
		
		//La lista para return con la clasificación
		String[] clasificacion = new String [maxEquipos];
		//Obtenemos de la base de datos los equipos ordenados por puntuación y los atributos necesarios para procesar el resto de
		//criterios de ordenación utilizando la librería JGA, la interfaz Comparator y la clase SORT
		ArrayList<Clasificacion> listaClasificacion=new ArrayList<Clasificacion>();
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM clasificacion WHERE numtemporada=pNumTemporada"
				+ "AND numjornada=pNumJornada ORDER BY puntos ASC");
		while (RdoSQL.next())
		{
			listaClasificacion.add(
		    new Clasificacion(RdoSQL.get("nombreeq"), 
					RdoSQL.getInt("puntos"),
					RdoSQL.getInt("golesafavor"),
					RdoSQL.getInt("golesencontra")));
		}
		//Se ordena según los goles a favor los equipos que tienen los mismos puntos.
		Iterable<Clasificacion> pOrden1=Sort.sort(listaClasificacion,new CompararGolesAfavor());
		//Se ordena en función de los goles en contra los equipos que además de los mismos puntos tienen los mismos goles a favor.
		pOrden1=Sort.sort(pOrden1,new CompararGolesEnContra());
		//creamos el iterador de donde coger los equipos
		Iterator <Clasificacion>itr=pOrden1.iterator();
		
		for(int i=0;i< maxEquipos && itr.hasNext() ;i++)
		{
			String pNomEq=itr.next().getNombreEquipo();
			clasificacion[i]=pNomEq;
		}
		RdoSQL.close();
		return clasificacion;
	}

}
