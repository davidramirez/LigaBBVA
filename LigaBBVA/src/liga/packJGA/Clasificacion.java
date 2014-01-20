package liga.packJGA;

public class Clasificacion 
{
			
			private String nombreEquipo;
			private int golesAFavor;
			private int golesEncontra;
			private int puntos;
			
			public Clasificacion(String pNomEq, int pPoints, int pGolAFav, int pGolEnContra){
				this.puntos=pPoints;
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
			public int getPuntos(){
				return this.puntos;
			}
		}


