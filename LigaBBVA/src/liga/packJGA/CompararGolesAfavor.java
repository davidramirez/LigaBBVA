package liga.packJGA;

import java.util.Comparator;

public  class CompararGolesAfavor implements Comparator<Clasificacion> {

	@Override
	public int compare(Clasificacion pClasif1, Clasificacion pClasif2) {
		if(pClasif1.getPuntos()==pClasif2.getPuntos()){
		return (pClasif1.getGolesAFavor()-pClasif2.getGolesAFavor());
		}
		else return 0;
	}
	

}
