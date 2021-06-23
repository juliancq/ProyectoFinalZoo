package sistemaAnimales;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Esta clase contiene un HashSet conformados por los animales que habitan en
 * ella A su vez tiene un contador ID que va aumentando a medida que ingresan
 * animales y se los asigna Mantiene datos sobre la ultima fecha de
 * mantenimiento y el stock de alimentos
 *
 * @implements Serializable
 * @param <T> extends Animal
 */
public class Sector<T extends Animal> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashSet<T> animales;
	private double stockAlimento = 0;
	private Date ultimaFechaMantenimiento = null;
	private String nombreSector;
	private int idSector;
	private int contadorId = 0; /* Contador autoincremental para la asignacion de ID a los Animales */
	private int capacidad;

	public Sector() {

		this.nombreSector = "No especificado";
		this.animales = new HashSet<>();
	}

	public Sector(String nombreSector, int capacidad) {

		this.nombreSector = nombreSector;
		this.animales = new HashSet<>();
		this.capacidad = capacidad;
	}

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

	public HashSet<T> getAnimales() {
		return animales;
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

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCantidadAnimales() {

		return animales.size();
	}

	/**
	 * Recibe un animal de tipo indicado por el sector, le inserta el id
	 * correspondiente (autoincremental) y lo coloca en el conjunto
	 * 
	 * @throws Exception si no hay lugar en el sector
	 * @param T nuevo(clase extendida de animal)
	 * @return void
	 */
	public void agregarAnimal(T nuevo) throws Exception {

		if (nuevo instanceof Animal) {


				if (contarAnimales() < capacidad) {

					((Animal) nuevo).setID(getContadorId());
					animales.add(nuevo);
					setContadorID(getContadorId() + 1);
				} else {

					throw new Exception("Habitat lleno");
				}
		
		}
	}

	/**
	 * Busca un animal por id, si lo halla lo elimina, sino retorna null;
	 * 
	 * @param idAnimal
	 */
	public void borrarAnimal(int idAnimal) {

		Iterator it = animales.iterator();

		Animal aux = getAnimal(idAnimal);

		if (aux != null) {
			animales.remove(aux);
		}
	}

	/**
	 * Retorna la cantidad de animales
	 * 
	 * @return int cantidad de animales en el sector
	 */
	public int contarAnimales() {

		return animales.size();
	}

	/**
	 * Busca un animal y lo retorna
	 * 
	 * 
	 * @param id
	 * @return el animal
	 */
	public Animal getAnimal(int id) {

		Animal a = null;

		Iterator it = animales.iterator();

		while (it.hasNext()) {

			Animal aux = (Animal) it.next();
			if (aux.getID() == id) {

				a = aux;
			}

		}

		return a;
	}

	/**
	 * Calcula la cantidad de alimento necesario para el sector, sumando los
	 * consumos diarios de cada animal dentro del conjunto En caso de existir stock
	 * suficiente efectua la alimentacion y reduce el stock, en el caso contrario
	 * lanza un mensaje informando dicho problema
	 * 
	 * @throws exception
	 * @param void
	 * @return void
	 */
	public void alimentar() throws Exception {

		double consumo = 0;
		Iterator it = animales.iterator();

		while (it.hasNext()) {
			consumo = consumo + ((Animal) it.next()).getAlimentacionDiaria();
		}

		if (consumo > getStockAlimento()) {
			throw new Exception("Stock de alimento insuficiente");
		} else {
			setStockAlimento(getStockAlimento() - consumo);
		}

	}

	/**
	 * Se encarga de reponer el stock de alimentos sumando el stock existente + el
	 * ingreso
	 * 
	 * @param double ingresoStock
	 * @return void
	 */
	public void reponerStock(double ingresoStock) {

		setStockAlimento(getStockAlimento() + ingresoStock);
	}

	/**
	 * Recorre el conjunto recolectando los nombres de cada animal del conjunto y lo
	 * retorna
	 * 
	 * @return String en forma de lista compuesto por todos los nombres de los
	 *         animales del sector
	 */
	public String listarAnimales() {

		String lista = "";

		Iterator it = animales.iterator();

		while (it.hasNext()) {

			Animal aux = ((Animal) it.next());
			lista = lista + "\n -" + aux.getID() + "  " + aux.toString();
		}

		return lista;
	}

	/**
	 * Setea el atributo ultimaFechaMantenimiento a la fecha y hora actual
	 */
	public void hacerMantenimiento() {

		setUltimaFechaMantenimiento(new Date());
	}

	@Override
	public String toString() {

		return "SECTOR = " + getNombreSector() + "\nStock actual de alimento = " + getStockAlimento()
				+ "\nUltima fecha de manteniemiento = " + getUltimaFechaMantenimiento() + "\nLista de animales: "
				+ listarAnimales();
	}

}
