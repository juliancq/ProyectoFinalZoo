package model;

import java.util.ArrayList;
import java.util.Date;

public class LibretaMedica {
	
	private ArrayList<String>historiaClinica;
	private Date ultimaFechaDeRevision;
	
	public LibretaMedica()
	{
		historiaClinica = new ArrayList<>();
		ultimaFechaDeRevision = new Date();
	}
	
	public void actualizarLibreta()
	{
		
	}
}
