package liga.packModelo;

import java.util.GregorianCalendar;

public class Temporada {
	
	private int numTemporada;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	
	
	public Temporada(int pNumTemp, GregorianCalendar pFechaInicio)
	{
		numTemporada = pNumTemp;
		fechaInicio = pFechaInicio;
		fechaFin = null;
	}

}
