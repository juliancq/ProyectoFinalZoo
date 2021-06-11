package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LibretaMedica {
	
	private ArrayList<String>historiaClinica;
	private Date ultimaFechaDeRevision;
	
	public LibretaMedica()
	{
		historiaClinica = new ArrayList<>();
		ultimaFechaDeRevision = new Date();
	}
	
	public Date getUltimaFechaDeRevision() {
		return ultimaFechaDeRevision;
	}
	
	public void actualizar(String descripci�nEstado)
	{
		historiaClinica.add(descripci�nEstado);
		ultimaFechaDeRevision = fechaHoy();
	}
	
	public Date fechaHoy()
    {
        Calendar calendario = new GregorianCalendar();
        Date fecha = new Date();
        calendario.setTime(fecha);

        return fecha;
    }
	
	public String ultimaRevisi�n()
	{
		return historiaClinica.get(historiaClinica.size());
	}
	
	private String acumularRevisiones()
	{
		StringBuilder cadena = new StringBuilder();
		for(int i=0;i<historiaClinica.size();i++)
		{
			cadena.append(historiaClinica.get(i));
		}
		return cadena.toString();
	}

	@Override
	public String toString() {
		return "LibretaMedica [getUltimaFechaDeRevision()=" + getUltimaFechaDeRevision() + ", acumularRevisiones()="
				+ acumularRevisiones() + "]";
	}
}