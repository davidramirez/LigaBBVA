package liga.packModelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import liga.packGestorBD.SGBD;

public class Jornada {
	
	private int numJornada;
	private GregorianCalendar fecha;
	private boolean estaJugada;
	private ListaPartidos partidos;
	
	public Jornada(GregorianCalendar pFecha, int pNumJornada)
	{
		numJornada = pNumJornada;
		fecha = pFecha;
		estaJugada = false;
		partidos = new ListaPartidos();
	}

	public void inicializarPrimeraJornada(ListaEquipos pListaEquipos, GregorianCalendar pFecha)
	{
		int i;
		Equipo local,visitante;
		
		
		for (i=0;i<=9;i++){
			local = pListaEquipos.getEquipoPos(i);
			visitante = pListaEquipos.getEquipoPos(i+10);
			Partido partido = new Partido(pFecha,local,visitante);
			this.getPartidos().anadirPartido(partido);
		}
	}
	
	private ListaPartidos getPartidos()
	{
		return partidos;
	}
	
	private GregorianCalendar getFecha()
	{
		return this.fecha;
	}

	public void inicializarSiguienteJornada(Jornada pJornadaAnterior){
		
		Equipo local,visitante,comodin;
		
		int j;
		if (!esPar(numJornada-1)){     // i==1 -> jornada 2 (par)
			comodin = pJornadaAnterior.getComodin();   // Primer paso es localizar el Equipo comodin. El equipo comodin es el que jugaba como local en la 
													  // ...anterior jornada en �ltimo lugar. Ahora pasa a jugar el primero como visitante.
			local = pJornadaAnterior.getPrimerVisitante(); // Equipo que juega contra el Equipo comodin, jugaba el primero como visitante en la jornada anterior.
														  // ... Ahora pasa a jugar el primero como local.
			visitante = comodin;
			Partido partido1 = new Partido (this.getFecha(), local, visitante); // Primer partido de la jornada par.
			this.getPartidos().anadirPartido(partido1);
				
			for (j=1;j<=9;j++){ 					// Para ir a�adiendo los 9 partidos restantes de a jornada.
					
				visitante = pJornadaAnterior.getLocal(j-1); // Los equipos locales mantienen el orden que tenian en la jornada anterior como visitantes, es decir
															  // ... los del 1 al 10 local estar�n del 1 al 10 visitante
				local = pJornadaAnterior.getVisitante(j); // Los equipos visitantes ocuparan una posici�n mas abajo de la que tenian en la 
																		// ...jornada anterior como local. Es decir los del 0 al 9 local estar�n del 1 al 10 visitante
				Partido partido = new Partido(this.getFecha(),local,visitante);
				this.getPartidos().anadirPartido(partido);	
			}	
		}
		else{    // i==2 jornada 3 (impar)
			// En este caso el comodin se queda en la posici�n original
			local = pJornadaAnterior.getPrimerVisitante();
			visitante = pJornadaAnterior.getVisitante(1);
			Partido partido1 = new Partido(this.getFecha(),local,visitante);  // Primer partido de la jornada impar.
			this.getPartidos().anadirPartido(partido1);
			
			for (j=1;j<=8;j++){								  // Para ir a�adiendo los 8 partidos siguientes. Todas menos la primera y ultima jornada
				local = pJornadaAnterior.getLocal(j-1);  
				visitante = pJornadaAnterior.getVisitante(j+1);  // Al contrario de las agujas del reloj, teniendo como referencia la jornada impar anterior.
				Partido partido = new Partido(this.getFecha(),local,visitante);
				this.getPartidos().anadirPartido(partido);		
			}
															  // �ltimo partido de la jornada
			comodin = pJornadaAnterior.getComodin();  
			local = comodin;
			visitante = pJornadaAnterior.getLocal(8);
			Partido partido10 = new Partido(this.getFecha(),local,visitante);
			this.getPartidos().anadirPartido(partido10);
				
		}
		
	}
	
	// Devuelve el equipo que juega como local en la posicion indicada.
	private Equipo getLocal(int i){
		Partido partido;
		partido = this.getPartidos().obtenerPartidoPos(i);
		return partido.getLocal();	
	}
	
	// Devuelve el equipo que juega como visitante en la posici�n indicada.
	private Equipo getVisitante(int i){
		Partido partido = null;
		partido = this.getPartidos().obtenerPartidoPos(i);
		return partido.getVisitante();	
	}
	
	//Devuelve el primer equipo que juega como visitante en la jornada
	private Equipo getPrimerVisitante(){  // Devuelve el primer equipo que juega como visitante en la jornada
		Partido partido;
		partido = this.getPartidos().obtenerPrimero();
		return partido.getVisitante();
	}
	
	//Devuelve true si el numero introducido es par
	private boolean esPar(int numero){
	    if (numero%2==0) return true; else return false;
	}
	
	//Devuelve el equipo comodin para poder realizar la combinacion de partidos de las jornadas
	private Equipo getComodin (){  // Devuelve el equipo comodin
		Equipo comodin;
		Partido partido;
		partido = this.getPartidos().obtenerUltimo();
		comodin = partido.getLocal(); // El equipo comodin es el local del �ltimo partido de la jornada
		return comodin;
	}

	//Establece los partidos de vuelta de la liga
	public void establecerVuelta(Jornada pJornada) {
	
		Iterator<Partido> it = pJornada.getIterador();
		Partido partido;
		// lEquipos.realizarSorteo();
		Equipo local,visitante;
		
		while (it.hasNext()){
			partido = it.next();
			local = partido.getVisitante();
			visitante = partido.getLocal();
			Partido partidoVuelta = new Partido(this.getFecha(),local,visitante);
			this.getPartidos().anadirPartido(partidoVuelta);
			
		}		
	}
	
	//Iterador para poder movernos en el vector de Partidos
	public Iterator<Partido> getIterador(){
		return this.getPartidos().getIterator();
	}

	public void asignarArbitros(ListaArbitros pListaArbitros)
	{
		this.getPartidos().asignarArbitros(pListaArbitros);
	}

	public void almacenarJornada(int pNumTemp)
	{
		String fecha = this.getFecha().get(Calendar.YEAR)+"-"+this.getFecha().get(Calendar.MONTH+1)+"-"+this.getFecha().get(Calendar.DATE);
		SGBD.getSGBD().execSQL("INSERT INTO jornada VALUES ('"+this.getNumJornada()+"','"+fecha+"', FALSE, '"+pNumTemp+"')");
		this.getPartidos().almacenarPartidos(pNumTemp, this.getNumJornada());
	}

	private int getNumJornada()
	{
		return this.numJornada;
	}
}
