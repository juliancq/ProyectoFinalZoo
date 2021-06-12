package sistemaAnimales;

import java.util.ArrayList;

public class Habitat {
	
	private double temperatura;
	private String tipo;
	private ArrayList<Sector> sectores;
	int idContador = 0; /*Contador autoincremental para la asignacion de ID a los Sectores*/
	
	/* Constructores */
	public Habitat() 
	{
		temperatura = 0;
		tipo = "No especificado";
		sectores = new ArrayList<>();
	}
	
	public Habitat(double temperatura, String tipo)
	{
		this.temperatura = temperatura;
		this.tipo = tipo;
		sectores = new ArrayList<>();
	}
	
	/* Getters & Setters */
	public double getTemperatura() {
		return temperatura;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getIdContador() {
		return idContador;
	}
	
	public void setIdContador(int idContador) {
		this.idContador = idContador;
	}
	
	@Override
	public String toString() {
		
		return "HABITAT = " + getTipo() + "\nTEMPERATURA = " + getTemperatura() + "°" + "\nSectores: " + listarSectores();
	}
	
	/**
	 * Recibe un nuevo sector y lo agrega a la lista del habitat
	 * 
	 * @param <T> tipo de animal perteneciente al sector
	 * @param nuevo Sector
	 */
	public <T> void agregarSector(Sector<T> nuevo) {
		
		nuevo.setIdSector(idContador);
		sectores.add(nuevo);
		setIdContador(getIdContador() + 1); 
	}
	
	/**
	 * Recorre el conjunto y va construyendo un string con los nombres de cada sector existente en el habitat
	 * 
	 * @return String compuesto por todos los sectores del habitat
	 */
	public String listarSectores() {
	
		String lista = "";
		
		for(int i = 0; i < sectores.size(); i++) {
			
			lista = lista + "\n -" + sectores.get(i).getNombreSector(); 
		}
		
		return lista;
	}
	
	/**
	 * Recorre el conjunto de sectores y recolecta los animales existentes en cada uno, los coloca a todos en un String y lo retorna
	 * 
	 * @return String con todos los animales del habitat, separado por sectores
	 */
	public String listarSectoresyAnimales() {
		
		String lista = "";
		
		for(int i = 0; i < sectores.size(); i++) {
			
			lista = lista + "\n " + sectores.get(i).getNombreSector().toUpperCase() + sectores.get(i).listarAnimales() + "\n";
			
		}
		
		
		return lista;
	}
}
