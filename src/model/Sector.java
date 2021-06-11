package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Sector<T> {
	
	private HashSet<T> animales;
	private double stockAlimento = 0;
	private Date ultimaFechaMantenimiento = null;
	private String nombreSector;
	
	/* Constructores */
	public Sector() {
		// TODO Auto-generated constructor stub
		this.nombreSector = "No especificado";
	}
	
	public Sector(String nombreSector) {
		
		this.nombreSector = nombreSector;
	}
	
	/* Getters & Setters */	
	public String getNombreSector() {
		return nombreSector;
	}
	
	public double getStockAlimento() {
		return stockAlimento;
	}
	
	public Date getUltimaFechaMantenimiento() {
		return ultimaFechaMantenimiento;
	}
	
	public void setStockAlimento(double stockAlimento) {
		this.stockAlimento = stockAlimento;
	}
	
	public void setUltimaFechaMantenimiento(Date ultimaFechaMantenimiento) {
		this.ultimaFechaMantenimiento = ultimaFechaMantenimiento;
	}
	public void setNombreSector(String nombreSector) {
		this.nombreSector = nombreSector;
	}
	
	public int getCantidadAnimales() {
		
		return animales.size();
	}
	
	/*
	 * Esta funcion calcula la cantidad de alimento necesario para el sector, conociendo la cantidad de alimento que consume un animal al dia
	 * la multiplica por la cantidad de ejemplares existentes en el habitat y se lo resta el stock de alimento
	 * @param void
	 * @return void
	 */
	public void alimentar() {
		
		try
		{
			double consumo = 0;
			Iterator it = animales.iterator();
	        int contador = 0;

	        while(it.hasNext())
	        {
	            //contador = contador + ((Animal)it.next()).getAlimentacionDiaria();
	        }
			
			if(consumo > getStockAlimento()) {
				throw new Exception("El stock de alimentos es insuficiente, porfavor reponga");
			}
			else {
				setStockAlimento(getStockAlimento() - consumo);
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	@Override
	public String toString() {
		
		return "SECTOR = " + getNombreSector() + "\nStock actual de alimento = " + getStockAlimento();
	}
	
}
