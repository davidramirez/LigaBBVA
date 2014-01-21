package liga.packEnumeration;

public enum Provincia {
	
	Álava,
	Albacete,
	Alicante,
	Almería,
	Asturias,
	Ávila,
	Badajoz,
	Barcelona,
	Burgos,
	Cáceres,
	Cádiz,
	Cantabria,
	Castellón,
	Ciudad_Real,
	Córdoba,
	La_Coruña,
	Cuenca,
	Gerona,
	Granada,
	Guadalajara,
	Guipúzcoa,
	Huelva,
	Huesca,
	Islas_Baleares,
	Jaén,
	León,
	Lérida,
	Lugo,
	Madrid,
	Málaga,
	Murcia,
	Navarra,
	Orense,
	Palencia,
	Las_Palmas,
	Pontevedra,
	La_Rioja,
	Salamanca,
	Segovia,
	Sevilla,
	Soria,
	Tarragona,
	Santa_Cruz_de_Tenerife,
	Teruel,
	Toledo,
	Valencia,
	Valladolid,
	Vizcaya,
	Zamora,
	Zaragoza;
	
	/**
	 * A la hora de recoger los valores de este enumerado introducidos en un jComboox, el
	 * valor devuelto es un String.
	 * Con este método obtenemos fácilmente ese valor como Provincia a partir del string dado
	 * @param pProvincia
	 * el valor string de un elemento de este enuerado
	 * @return
	 * el valor como clase Provincia del String dado.
	 * Null en caso de que no se encuentre
	 */
	public static Provincia buscarComponente(String pProvincia)
	{
		for(Provincia p :Provincia.values())
		{
			if(pProvincia.equalsIgnoreCase(p.toString()))
			{
				return p;
			}
		}
		
		return null;
	}

}
