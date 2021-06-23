package sistemaAnimales;

import java.util.Date;

public class Carnivoro extends Terrestre{

	public Carnivoro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carnivoro(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			 double alimentacionDiaria, Date fechaDeNacimiento) {
		super(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fechaDeNacimiento);
		// TODO Auto-generated constructor stub
	}

	public Carnivoro(String nombre, String especie, String sexo) {
		super(nombre, especie, sexo);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		return super.toString();
	}
}
