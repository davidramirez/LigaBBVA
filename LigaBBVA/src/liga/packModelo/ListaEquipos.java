package liga.packModelo;

import java.util.ArrayList;
import java.util.Collections;

public class ListaEquipos {
	
	private ArrayList<Equipo> lista;
	
	
	public ListaEquipos()
	{
		lista = new ArrayList<Equipo>();
	}


	public void realizarSorteo()
	{
		Collections.shuffle(this.getLista());
	}
	
	private ArrayList<Equipo> getLista()
	{
		return this.lista;
	}


	public Equipo getEquipoPos(int pPos)
	{
		return this.getLista().get(pPos);
	}

}
