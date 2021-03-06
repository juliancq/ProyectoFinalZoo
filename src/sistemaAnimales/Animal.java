package sistemaAnimales;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase padre de todo animal, mantiene amplia informacion acerca del animal Id,
 * nombre, peso, raza, especie, estado, sexo, alimentacion diaria, fecha de
 * nacimiento y su libreta medica
 *
 * @implements Serializable
 */
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String nombre;
	private double peso;
	private String raza;
	private String especie;
	private String estadoSalud;// Activo - En recuperacion
	private String sexo;
	private double alimentacionDiaria;// En kg
	private Date fechaDeNacimiento;
	private LibretaMedica historiaClinica;

	public Animal() {
		nombre = "No especificado";
		peso = 0;
		raza = "No especificada";
		especie = "No especificada";
		estadoSalud = "Activo";
		sexo = "Macho";
		alimentacionDiaria = 0;
		fechaDeNacimiento = new Date();
		historiaClinica = new LibretaMedica();
	}

	public Animal(String nombre, String especie, String sexo) {
		this.nombre = nombre;
		this.peso = 0;
		this.raza = "No especificada";
		this.especie = especie;
		this.estadoSalud = "Activo";
		this.sexo = sexo;
		this.alimentacionDiaria = 0;
		this.fechaDeNacimiento = new Date();
		historiaClinica = new LibretaMedica();
	}

	public Animal(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			double alimentacionDiaria, Date fechaDeNacimiento) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.raza = raza;
		this.especie = especie;
		this.estadoSalud = estadoSalud;
		this.sexo = sexo;
		this.alimentacionDiaria = alimentacionDiaria;
		this.fechaDeNacimiento = fechaDeNacimiento;
		historiaClinica = new LibretaMedica();
	}

	public LibretaMedica getHistoriaClinica() {
		return historiaClinica;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getPeso() {
		return peso;
	}

	public String getRaza() {
		return raza;
	}

	public String getEspecie() {
		return especie;
	}

	public String getEstadoSalud() {
		return estadoSalud;
	}

	public String getSexo() {
		return sexo;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public int getID() {
		return ID;
	}

	/*
	 * public String getTipoAlimentacion() { return tipoAlimentacion; }
	 */

	public double getAlimentacionDiaria() {
		return alimentacionDiaria;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setAlimentacionDiaria(double alimentacionDiaria) {
		this.alimentacionDiaria = alimentacionDiaria;
	}

	public String toString() {
		return "Animal [Nombre:" + getNombre() + ", Peso:" + getPeso() + ", Raza:" + getRaza() + ", Especie:"
				+ getEspecie() + ", Estado de Salud:" + getEstadoSalud() + ", Sexo:" + getSexo()
				+ ", Fecha de Nacimiento:" + getFechaDeNacimiento() + "]";
	}
	
	/**
	 * Pasa la informacion contenida en el animal a JSON
	 * 
	 * 
	 */
	public JSONObject toJSON()
	{
		
		try {
			JSONObject jsonObject_animal = new JSONObject();
			
			jsonObject_animal.put("ID", getID());
			jsonObject_animal.put("Nombre", getNombre());
			jsonObject_animal.put("Peso", getPeso());
			jsonObject_animal.put("Raza", getRaza());
			jsonObject_animal.put("Especie", getEspecie());
			jsonObject_animal.put("Salud", getEstadoSalud());
			jsonObject_animal.put("Sexo", getSexo());
			jsonObject_animal.put("Cantidad comida", getAlimentacionDiaria());
			jsonObject_animal.put("Nacimiento", getFechaDeNacimiento());
			jsonObject_animal.put("Clase", "Animal");
			
			return jsonObject_animal;
		} catch (JSONException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public boolean equals(Animal obj) {
		if (obj.getNombre() == getNombre() && obj.getEspecie() == getEspecie() && obj.getID() == getID())
			return true;
		else
			return false;
	}
}
