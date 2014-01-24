package liga.packModelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import liga.packGestorBD.SGBD;

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
	
	private Iterator<Equipo> getIterador()
	{
		return this.getLista().iterator();
	}

	public void almacenarEquiposTemporada(int pNumTemp)
	{
		Iterator<Equipo> it = this.getIterador();
		Equipo unEquipo;
		
		while(it.hasNext())
		{
			unEquipo = it.next();
			SGBD.getSGBD().execSQL("INSERT INTO equipostemporada VALUES('"+pNumTemp+"','"+unEquipo.getNombre()+"')");
		}
	}


	public void anadirEquipo(Equipo equipo) {
		this.getLista().add(equipo);
		
	}
	
	public String[] getNombres()
	{
		Iterator<Equipo> it = this.getIterador();
		Equipo e;
		String[] nombres = new String[this.getLista().size()];
		int i =0;
		while(it.hasNext())
		{
			e = it.next();
			nombres[i] = e.getNombre();
			i++;
		}
		return nombres;
	}
	
	public void eliminarEquipoPos(int pPos)
	{
		this.getLista().remove(pPos);
	}


	public int getTamano() {
		return this.getLista().size();
	}


	public boolean esta(String pNombre) {
		Iterator<Equipo> it = this.getIterador();
		Equipo e;
		boolean esta = false;
		
		while(it.hasNext() && !esta)
		{
			e = it.next();
			
			if(e.getNombre().equals(pNombre))
			{
				esta = true;
			}
		}
		
		return esta;
	}

}