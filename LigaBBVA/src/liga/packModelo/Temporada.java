package liga.packModelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Temporada {
	
	private int numTemporada;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private ListaArbitros listaArbitros;
	private ListaEquipos listaEquipos;
	private ListaJornadas listaJornadas;
	
	public Temporada(int pNumTemp, GregorianCalendar pFechaInicio, ListaArbitros pListaArbitros, ListaEquipos pListaEquipos)
	{
		numTemporada = pNumTemp;
		fechaInicio = pFechaInicio;
		fechaFin = null;
		listaArbitros = pListaArbitros;
		listaEquipos = pListaEquipos;
		listaJornadas = new ListaJornadas();
	}

	public void inicializarTemporada()
	{
		//esta primera parte aprovecha el código del anterior proyecto
		this.getListaEquipos().realizarSorteo();
		GregorianCalendar fechaFinVuelta = this.inicializarPrimeraVuelta();
		fechaFinVuelta = this.inicializarSegundaVuelta(fechaFinVuelta);
		
		//esta parte es nueva
		//hacemos que inicializarSegundaVuelta nois devuelva la fecha del ultimo partido
		//sera la fecha de fin de la temporada
		this.setFechaFin(fechaFinVuelta);
		
		this.asignarArbitrosAPartidos();
		
		//y guardamos todos los datos creados en la BD
		this.almacenarTemporada();
	}
	

	private GregorianCalendar inicializarPrimeraVuelta() {
		Jornada jornada1 = new Jornada(this.getFecha(),1);
		jornada1.inicializarPrimeraJornada(this.getListaEquipos(), this.getFecha());      // Inicilizamos la primera jornada
		this.getListaJornadas().anadirJornada(jornada1);
		
		Jornada jornadaAnterior = jornada1; 
		int dia = this.getFecha().get(Calendar.DATE);
		int mes = this.getFecha().get(Calendar.MONDAY);
		int ano = this.getFecha().get(Calendar.YEAR);
		GregorianCalendar fecha = null;
		
		for (int i=1;i<=18;i++){   						// Primera vuelta desde la segunda jornada (i=1)
			fecha = new GregorianCalendar(ano,mes,dia+7);
			dia = fecha.get(Calendar.DATE);
			mes = fecha.get(Calendar.MONTH);
			ano = fecha.get(Calendar.YEAR);
			Jornada jornada = new Jornada(fecha,i+1);
			jornada.inicializarSiguienteJornada(jornadaAnterior); // la variable i marca la jornada a inicializar
			this.getListaJornadas().anadirJornada(jornada);
			if (i%2==0){   // es par i==2 jornada 3 (impar)
				jornadaAnterior = jornada;			// La referencia es siempre la jornada impar anterior.
			}
		}
		return fecha;
	}
	
	private GregorianCalendar inicializarSegundaVuelta(GregorianCalendar pFecha) {
		int dia = pFecha.get(Calendar.DATE);
		int mes = pFecha.get(Calendar.MONDAY);
		int ano = pFecha.get(Calendar.YEAR);
		GregorianCalendar fecha = null;
		for (int i=19;i<=37;i++){
			fecha = new GregorianCalendar(ano,mes,dia+7);
			dia = fecha.get(Calendar.DATE);
			mes = fecha.get(Calendar.MONTH);
			ano = fecha.get(Calendar.YEAR);
			Jornada jornadaIda = this.getListaJornadas().obtenerJornadaPos(i-19);
			Jornada jorVuelta = new Jornada(fecha,i);
			jorVuelta.establecerVuelta(jornadaIda);
			this.getListaJornadas().anadirJornada(jorVuelta);
		}
	
		return fecha;
	}
	
	private void setFechaFin(GregorianCalendar pFecha)
	{
		this.fechaFin = pFecha;
	}
	
	private ListaJornadas getListaJornadas()
	{
		return this.listaJornadas;
	}

	private ListaEquipos getListaEquipos()
	{
		return this.listaEquipos;
	}
	
	private GregorianCalendar getFecha()
	{
		return this.fechaInicio;
	}

}
