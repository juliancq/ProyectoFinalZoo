package sistemaAnimales;

import java.util.Date;

public class Reptil extends Carnivoro{

	public Reptil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reptil(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			String tipoAlimentacion, double alimentacionDiaria, Date fechaDeNacimiento, boolean esFertil) {
		super(nombre, peso, raza, especie, estadoSalud, sexo, tipoAlimentacion, alimentacionDiaria, fechaDeNacimiento,
				esFertil);
		// TODO Auto-generated constructor stub
	}

	public Reptil(String nombre, String especie, String sexo) {
		super(nombre, especie, sexo);
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return super.toString();
	}
}
