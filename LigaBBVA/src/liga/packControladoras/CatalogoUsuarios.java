package liga.packControladoras;

public class CatalogoUsuarios {
	private static CatalogoUsuarios misUsuarios=new CatalogoUsuarios();

	
	private  CatalogoUsuarios() 
	{		
	}
	public static CatalogoUsuarios getMiCatalogoUsuarios(){
		return misUsuarios;
	}
}
