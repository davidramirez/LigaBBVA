package liga.packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPartidos {
	
	private ArrayList<Partido> lista;
	
	public ListaPartidos()
	{
		lista = new ArrayList<Partido>();
	}

	public void anadirPartido(Partido partido)
	{
		if(!this.getLista().contains(partido))
		{
			this.getLista().add(partido);
		}
	}
	
	private ArrayList<Partido> getLista()
	{
		return this.lista;
	}

	public Partido obtenerUltimo() {
		return this.getLista().get(this.getLista().size()-1);
	}
	
	public Partido obtenerPrimero()
	{
		return this.getLista().get(0);
	}

	public Partido obtenerPartidoPos(int pPos)
	{
		return this.getLista().get(pPos);
	}

	public Iterator<Partido> getIterator() {
		// TODO Auto-generated method stub
		return this.getLista().iterator();
	}

	public void asignarArbitros(ListaArbitros pListaArbitros)
	{
		Partido unPartido;
		Iterator<Partido> it = this.getIterator();
		
		while(it.hasNext())
		{
			unPartido = it.next();
			unPartido.asignarArbitros(pListaArbitros);
		}
	}

	public void almacenarPartidos(int pNumTemp, int pNumJornada)
	{
		Iterator<Partido> it = this.getIterator();
		Partido unPartido;
		
		while(it.hasNext())
		{
			unPartido = it.next();
			unPartido.almacenarPartido(pNumTemp, pNumJornada);
		}
	}
}
