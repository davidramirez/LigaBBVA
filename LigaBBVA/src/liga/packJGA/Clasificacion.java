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
				return this.golesAFavor;
			}
			
			public int getGolesEnContra(){
				return this.golesEncontra;
			}
			public int getPuntos(){
				return this.puntos;
			}
		}


