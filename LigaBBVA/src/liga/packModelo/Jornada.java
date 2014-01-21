package liga.packModelo;

import java.util.GregorianCalendar;

public class Jornada {
	
	private int numJornada;
	private GregorianCalendar fecha;
	private boolean estaJugada;
	private ListaPartidos partidos;
	
	public Jornada(int pNumJornada, GregorianCalendar pFecha)
	{
		numJornada = pNumJornada;
		fecha = pFecha;
		estaJugada = false;
		partidos = new ListaPartidos();
	}

}
