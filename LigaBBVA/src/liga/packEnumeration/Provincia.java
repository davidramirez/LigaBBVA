package liga.packEnumeration;

public enum Provincia {
	
	alava,
	Albacete,
	Alicante,
	Almeria,
	Asturias,
	avila,
	Badajoz,
	Barcelona,
	Burgos,
	Caceres,
	Cadiz,
	Cantabria,
	Castellon,
	Ciudad_Real,
	Cordoba,
	La_Coruña,
	Cuenca,
	Gerona,
	Granada,
	Guadalajara,
	Guipuzcoa,
	Huelva,
	Huesca,
	Islas_Baleares,
	Jaen,
	Leon,
	Lerida,
	Lugo,
	Madrid,
	Malaga,
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
	 * Con este metodo obtenemos facilmente ese valor como Provincia a partir del string dado
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
