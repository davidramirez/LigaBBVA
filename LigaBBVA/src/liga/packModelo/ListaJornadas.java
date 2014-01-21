package liga.packModelo;

import java.util.ArrayList;

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

}
