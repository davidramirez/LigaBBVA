package liga.packModelo;

import liga.packEnumeration.Provincia;

public class Equipo {
	
	private String nombre;
	private int puntos;
	private int dinero;
	private Provincia provincia;
	
	public Equipo(String pNombre, Provincia pProvincia)
	{
		nombre = pNombre;
		provincia = pProvincia;
		
		puntos = 0;
		dinero = 0;
	}

}
