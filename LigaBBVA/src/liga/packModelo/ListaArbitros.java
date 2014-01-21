package liga.packModelo;

import java.util.ArrayList;
import java.util.Iterator;

import liga.packGestorBD.SGBD;

public class ListaArbitros {
	
	private ArrayList<Arbitro> lista;
	
	public ListaArbitros()
	{
		lista = new ArrayList<Arbitro>();
	}

	private ListaArbitros(ArrayList<Arbitro> pLista)
	{
		lista = pLista;
	}
	
	private ArrayList<Arbitro> getLista()
	{
		return this.lista;
	}
	
	@SuppressWarnings("unchecked")
	public ListaArbitros clonar()
	{
		return (new ListaArbitros((ArrayList<Arbitro>) this.getLista().clone()));
	}

	public Arbitro getArbitroAlAzar()
	{
		//generamos un numero al azar entre 0 y el num-1 de elementos restantes del array
		//usando la formula: min + (int)(Math.random() * ((max-min)+1)
		int num = (int)(Math.random()*(this.getLista().size()));
		//devolvemos el arbitro que ocupa esa posicion
		return this.getArbitroPos(num);
	}

	private Arbitro getArbitroPos(int pPos)
	{
		return this.getLista().get(pPos);
	}

	public void eliminarArbitro(Arbitro pArbitro)
	{
		this.getLista().remove(pArbitro);
	}

	public void almacenarArbitrosTemporada(int pNumTemp)
	{
		Iterator<Arbitro> it = this.getIterator();
		Arbitro unArbitro;
		
		while(it.hasNext())
		{
			unArbitro = it.next();
			SGBD.getSGBD().execSQL("INSERT INTO aritrostemporada VALUES ("+pNumTemp+","+unArbitro.getDNI()+")");
		}
	}

	private Iterator<Arbitro> getIterator()
	{
		return this.getLista().iterator();
	}

}
