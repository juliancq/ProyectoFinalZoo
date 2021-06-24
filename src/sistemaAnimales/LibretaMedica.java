package sistemaAnimales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Esta clase crea un objeto que sirve como libreta medica de animales, almacena
 * datos acerca de su historia clinica y fecha de revision
 * 
 * @implements Serializable
 */
public class LibretaMedica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> historiaClinica;
	private Date ultimaFechaDeRevision;

	public LibretaMedica() {
		historiaClinica = new ArrayList<>();
		ultimaFechaDeRevision = new Date();
	}

	public Date getUltimaFechaDeRevision() {
		return ultimaFechaDeRevision;
	}
	
	/**
	 * Permite la actualización de la historia clinica
	 * 
	 * @param recibe un diagnóstico del animal
	 */
	public void actualizar(String descripciónEstado) {
		historiaClinica.add(descripciónEstado);
		ultimaFechaDeRevision = fechaHoy();
	}

	/**
	 * Setea la fecha para el momento en el que se está invocando
	 * 
	 * 
	 */
	private Date fechaHoy() {
		Calendar calendario = new GregorianCalendar();
		Date fecha = new Date();
		calendario.setTime(fecha);

		return fecha;
	}
	
	/**
	 * @return Busca en el arreglo que contiene las revisiones(historiaClinica) y retorna la ultima posición
	 * 
	 * 
	 */
	public String ultimaRevisión() {
		return historiaClinica.get(historiaClinica.size());
	}

	/**
	 * Acumula en un solo string todas las revisiones y las retorna
	 * 
	 * 
	 */
	private String acumularRevisiones() {
		StringBuilder cadena = new StringBuilder();
		for (int i = 0; i < historiaClinica.size(); i++) {
			cadena.append(historiaClinica.get(i));
		}
		return cadena.toString();
	}

	@Override
	public String toString() {
		return "LibretaMedica [Ultima Fecha de Revisión:" + getUltimaFechaDeRevision() + ", Revisiones acumuladas: "
				+ acumularRevisiones() + "]";
	}
}
