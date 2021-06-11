package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Sector<T> {
	
	private HashSet<T> animales;
	private double stockAlimento = 0;
	private Date ultimaFechaMantenimiento = null;
	private String nombreSector;
	private int idSector;
	private int contadorID = 0;
	
	/* Constructores */
	public Sector() {
		
		this.nombreSector = "No especificado";
		this.animales = new HashSet<>();
	}
	
	public Sector(String nombreSector, int idSector) {
		
		this.nombreSector = nombreSector;
		this.idSector = idSector;
		this.animales = new HashSet<>();
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
	
	public int getContadorID() {
		
		return contadorID;
	}
	
	public int getIdSector() {
		return idSector;
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
	
	
	public void agregarAnimal(T nuevo) {
		
		if(nuevo instanceof Animal) {
			
			((Animal)nuevo).setID(getContadorID());
			
		}
		animales.add(nuevo);
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
	        

	        while(it.hasNext())
	        {
	            consumo = consumo + ((Animal)it.next()).getAlimentacionDiaria();
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
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Esta funcion se encarga de reponer el stock de alimentos sumando el stock inicial + el ingreso
	 * 
	 * @param double ingresoStock
	 * @return void
	 */
	public void reponerStock(double ingresoStock) {
		
		setStockAlimento(getStockAlimento() + ingresoStock); 
	}
	
	@Override
	public String toString() {
		
		return "SECTOR = " + getNombreSector() + "\nStock actual de alimento = " + getStockAlimento();
	}
	
}
