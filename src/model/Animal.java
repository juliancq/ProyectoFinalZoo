package model;

import java.util.Date;

public class Animal {
	
	private int ID;
	private String nombre;
	private double peso;
	private String raza;
	private String especie;
	private String estadoSalud;//Activo - En recuperacion
	private String sexo;
	private String tipoAlimentacion;//Omnivoro, herbivoro, carnívoro
	private double alimentacionDiaria;//En kg
	private Date fechaDeNacimiento;
	
	public Animal()
	{
		nombre = "No especificado";
		peso = 0;
		raza = "No especificada";
		especie = "No especificada";
		estadoSalud = "Activo";
		sexo = "Macho";
		fechaDeNacimiento = new Date();
	}

	public Animal(String nombre, String especie, String sexo) {
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
	}

	public Animal(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			Date fechaDeNacimiento) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.raza = raza;
		this.especie = especie;
		this.estadoSalud = estadoSalud;
		this.sexo = sexo;
		this.fechaDeNacimiento = fechaDeNacimiento;
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
	
	public String getTipoAlimentacion() {
		return tipoAlimentacion;
	}
	
	public double getAlimentacionDiaria() {
		return alimentacionDiaria;
	}
	
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	
	public String toString() {
		return "Animal [getNombre()=" + getNombre() + ", getPeso()=" + getPeso() + ", getRaza()=" + getRaza()
				+ ", getEspecie()=" + getEspecie() + ", getEstadoSalud()=" + getEstadoSalud() + ", getSexo()="
				+ getSexo() + ", getFechaDeNacimiento()=" + getFechaDeNacimiento() + "]";
	}

	public boolean equals(Animal obj)
	{
		if(obj.getNombre()==getNombre()&&obj.getEspecie()==getEspecie()&&obj.getID()==getID())return true;
		else return false;
	}
}
