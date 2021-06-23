package sistemaAnimales;

import java.util.Date;

public class Terrestre extends Animal{
	
	public Terrestre() {
		super();
	}
	
	public Terrestre(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			double alimentacionDiaria, Date fechaDeNacimiento) {
		super(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fechaDeNacimiento);
		
	}

	public Terrestre(String nombre, String especie, String sexo) {
		super(nombre, especie, sexo);
		
	}
		
	
	@Override
	public String toString() {
		return super.toString();
	}
}
