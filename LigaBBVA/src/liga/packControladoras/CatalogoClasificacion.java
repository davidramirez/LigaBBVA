package liga.packControladoras;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoClasificacion 
{
private static CatalogoClasificacion miCatalogoClasificacion= new CatalogoClasificacion();
	
	private  CatalogoClasificacion() 
	{
	
	}
	
	public static CatalogoClasificacion getMiCatalogoClasificacion() 
	{
		return miCatalogoClasificacion;
	}
	
	public void obtenerClasificacion(int pNumTemporada,int pNumJornada)
	{
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM clasificacion WHERE numtemporada=pNumTemporada"
				+ "AND numjornada=pNumJornada ORDER BY puntos ASC");
		
		 class clasificacion {
			
			private String nombreEquipo;
			private int golesAFavor;
			private int golesEncontra;
			private int puntos;
			
			public clasificacion(String pNomEq,int pGolAFav, int pGolEnContra){
				this.nombreEquipo=pNomEq;
				this.golesAFavor=pGolAFav;
				this.golesEncontra=pGolEnContra;
			}
			
			public String getNombreEquipo(){
				return this.nombreEquipo;
			}
			
			public int getGolesAFavor(){
				return this.getGolesAFavor();
			}
			
			public int getGolesEnContra(){
				return this.getGolesEnContra();
			}
		}
	}

}
