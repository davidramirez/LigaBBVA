package liga.packModelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import liga.packEnumeration.Provincia;
import liga.packGestorBD.SGBD;

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


	public Equipo getLocal()
	{
		return this.equipoLocal;
	}
	
	public Equipo getVisitante()
	{
		return this.equipoVisitante;
	}


	public void asignarArbitros(ListaArbitros pListaArbitros)
	{
		Provincia provDelPartido = this.getProvincia();
		boolean asignado = false;
		//intentaremos realizar la asignacion hasta lograrla
		while(!asignado)
		{
			Arbitro unArbitro = pListaArbitros.getArbitroAlAzar();
			
			if(provDelPartido == unArbitro.getProvincia())
			{
				this.setArbitro(unArbitro);
				pListaArbitros.eliminarArbitro(unArbitro);
				asignado = true;
			}
		}
	}


	private void setArbitro(Arbitro pArbitro)
	{
		this.arbitro = pArbitro;
	}


	private Provincia getProvincia()
	{
		return this.getLocal().getProvincia();
	}


	public void almacenarPartido(int pNumTemp, int pNumJornada)
	{
		String local = this.getLocal().getNombre();
		String vis = this.getVisitante().getNombre();
		String dni = this.getArbitro().getDNI();
		String fecha = this.getFecha().get(Calendar.YEAR)+"-"+this.getFecha().get(Calendar.MONTH+1)+"-"+this.getFecha().get(Calendar.DATE);
		
		SGBD.getSGBD().execSQL("INSERT INTO partido VALUES ('"+fecha+"','"+ 0 +"','"+ 0 + "','"+pNumTemp+"','"+pNumJornada+"','"+local+"','"+vis+"','"+dni+"')");
	}


	private GregorianCalendar getFecha()
	{
		return this.getFecha();
	}


	private Arbitro getArbitro()
	{
		return this.arbitro;
	}

}
