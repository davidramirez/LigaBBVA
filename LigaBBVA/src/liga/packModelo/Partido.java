package liga.packModelo;

import java.util.GregorianCalendar;

public class Partido {
	
	private GregorianCalendar fecha;
	private int golesVisitante;
	private int golesLocal;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Arbitro arbitro;
	
	
	public Partido(GregorianCalendar pFecha, Equipo pLocal, Equipo pVisitante)
	{
		fecha = pFecha;
		equipoLocal = pLocal;
		equipoVisitante = pVisitante;
		
		arbitro = null;
		golesVisitante = 0;
		golesLocal = 0;
	}

}
