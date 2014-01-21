package liga.packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJornadas {
	
	private ArrayList<Jornada> lista;
	
	public ListaJornadas()
	{
		lista = new ArrayList<Jornada>();
	}

	public void anadirJornada(Jornada pJornada)
	{
		if(!this.getLista().contains(pJornada))
		{
			this.getLista().add(pJornada);
		}
	}
	
	private ArrayList<Jornada> getLista()
	{
		return this.lista;
	}
	
	public Jornada obtenerJornadaPos(int pPos)
	{
		return this.getLista().get(pPos);
	}
	
	private Iterator<Jornada> getIterator()
	{
		return this.getLista().iterator();
	}

	public void asignarArbitros(ListaArbitros pListaArbitros)
	{
		Jornada unaJornada;
		Iterator<Jornada> it = this.getIterator();
		ListaArbitros lArbJornada;
		
		while(it.hasNext())
		{
			unaJornada = it.next();
			
			//clonamos la lista de arbitros de la temporada que recibimos
			lArbJornada = pListaArbitros.clonar();
			//de esta forma no se repetiran arbitros dentro de una misma jornada
			//pero se podran repetir entre jornadas distintas
			unaJornada.asignarArbitros(lArbJornada);
		}
	}

	public void almacenarJornadas(int pNumTemp)
	{
		Iterator<Jornada> it = this.getIterator();
		Jornada unaJornada;
		
		while(it.hasNext())
		{
			unaJornada = it.next();
			unaJornada.almacenarJornada(pNumTemp);
		}
	}

}
