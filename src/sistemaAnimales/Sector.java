package sistemaAnimales;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;



public class Sector<T> {
	
	private HashSet<T> animales;
	private double stockAlimento = 0;
	private Date ultimaFechaMantenimiento = null;
	private String nombreSector;
	private int idSector; 
	private int contadorId = 0; /*Contador autoincremental para la asignacion de ID a los Animales*/
	
	/* Constructores */
	public Sector() {
		
		this.nombreSector = "No especificado";
		this.animales = new HashSet<>();
	}
	
	public Sector(String nombreSector) {
		
		this.nombreSector = nombreSector;
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
	
	public int getContadorId() {
		
		return contadorId;
	}
	
	public int getIdSector() {
		return idSector;
	}
	
	
	public void setContadorID(int contadorId) {
		this.contadorId = contadorId;
	}
	
	public void setStockAlimento(double stockAlimento) {
		
		this.stockAlimento = stockAlimento;
	}
	
	public void setIdSector(int idSector) {
		this.idSector = idSector;
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
	
	
	/**
	 * Recibe un animal de tipo indicado por el sector, le inserta el id correspondiente (autoincremental) y lo coloca en el conjunto
	 * 
	 * @param T nuevo(clase extendida de animal)
	 * @return void
	 */
	public void agregarAnimal(T nuevo) {
		
		if(nuevo instanceof Animal) {
			
			((Animal)nuevo).setID(getContadorId());
			animales.add(nuevo);
			
			setContadorID(getContadorId() + 1);
		}
		
	}
	
	
	
	/**
	 * Calcula la cantidad de alimento necesario para el sector, sumando los consumos diarios de cada animal dentro del conjunto
	 * En caso de existir stock suficiente efectua la alimentacion y reduce el stock, en el caso contrario lanza un mensaje informando dicho problema
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
	
	/**
	 * Se encarga de reponer el stock de alimentos sumando el stock existente + el ingreso
	 * 
	 * @param double ingresoStock
	 * @return void
	 */
	public void reponerStock(double ingresoStock) {
		
		setStockAlimento(getStockAlimento() + ingresoStock); 
	}
	
	/**
	 * Recorre el conjunto recolectando los nombres de cada animal del conjunto y lo retorna
	 * 
	 * @return String en forma de lista compuesto por todos los nombres de los animales del sector
	 */
	public String listarAnimales() {
		
		String lista = "";
		
		Iterator it = animales.iterator();
		
		while(it.hasNext()) {
			
			lista = lista + "\n -" + ((Animal)it.next()).getNombre();
		}
		
		return lista;
	}
	
	@Override
	public String toString() {
		
		return "SECTOR = " + getNombreSector() + "\nStock actual de alimento = " + getStockAlimento() + "\nLista de animales: " + listarAnimales();
	}
	
}
