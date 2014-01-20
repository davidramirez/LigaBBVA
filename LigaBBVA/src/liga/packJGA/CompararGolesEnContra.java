package liga.packJGA;

import java.util.Comparator;

public class CompararGolesEnContra implements Comparator<Clasificacion> {

	@Override
	public int compare(Clasificacion pClasf1, Clasificacion pClasf2) {
		if(pClasf1.getPuntos()==pClasf2.getPuntos() && pClasf1.getGolesAFavor()==pClasf2.getGolesAFavor()){
			return pClasf2.getGolesEnContra()-pClasf1.getGolesEnContra();
		}
			
		return 0;
	}

}
