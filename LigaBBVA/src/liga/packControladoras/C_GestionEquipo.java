package liga.packControladoras;

public class C_GestionEquipo {
	private static C_GestionEquipo miC_GestionEquipo = new C_GestionEquipo();	
	
	private C_GestionEquipo() {
	}
	
	public static C_GestionEquipo getC_GestionEquipo() {
		return miC_GestionEquipo;
	}
}
