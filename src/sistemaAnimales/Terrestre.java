package sistemaAnimales;

import java.util.Date;

public class Terrestre extends Animal{
	
	private boolean esFertil;

	public Terrestre() {
		super();
		this.esFertil = false;
	}
	
	public Terrestre(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			double alimentacionDiaria, Date fechaDeNacimiento, boolean esFertil) {
		super(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fechaDeNacimiento);
		
		this.esFertil = esFertil;
	}

	public Terrestre(String nombre, String especie, String sexo) {
		super(nombre, especie, sexo);
		this.esFertil = false;
	}
	
	private boolean getEsFertil() {
		return esFertil;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + ", getEsFertil()=" + getEsFertil();
	}
}
