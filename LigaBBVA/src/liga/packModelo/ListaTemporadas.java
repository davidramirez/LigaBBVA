package liga.packModelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ListaTemporadas {
	
	private ArrayList<Temporada> lista;
	
	
	public ListaTemporadas()
	{
		lista = new ArrayList<Temporada>();
	}


	public void inicializarTemporada(ListaEquipos pListaEquipos, ListaArbitros pListaArbitros, GregorianCalendar pFecha, int pNumTemp)
	{
		Temporada laTemporada = new Temporada(pNumTemp, pFecha, pListaArbitros, pListaEquipos);
		this.anadirTemporada(laTemporada);
		laTemporada.inicializarTemporada();
	}
	
	private void anadirTemporada(Temporada pTemporada)
	{
		if(!this.getLista().contains(pTemporada))
		{
			this.getLista().add(pTemporada);
		}
	}
	
	private ArrayList<Temporada> getLista()
	{
		return this.lista;
	}

}
