package liga.packModelo;

import java.util.GregorianCalendar;

import liga.packEnumeration.Provincia;

public class Arbitro {
	
	private String nombre;
	private String apellidos;
	private Provincia provincia;
	private GregorianCalendar fechaNacimiento;
	private String dNI;
	private GregorianCalendar enNeveraHasta;
	
	
	public Arbitro(String pNombre, String pApellidos, Provincia pProvincia, String pDNI)
	{
		nombre = pNombre;
		apellidos = pApellidos;
		provincia = pProvincia;
		dNI = pDNI;
		
		fechaNacimiento = null;
		enNeveraHasta = null;
	}


	public Provincia getProvincia()
	{
		return this.provincia;
	}


	public String getDNI()
	{
		return this.dNI;
	}


	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre+" "+this.apellidos;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public GregorianCalendar getFechaNacimiento() {
		return this.fechaNacimiento;
	}

}
