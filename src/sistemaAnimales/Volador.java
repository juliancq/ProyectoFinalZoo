package sistemaAnimales;

import java.util.Date;

public class Volador extends Animal{

	public Volador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Volador(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			String tipoAlimentacion, double alimentacionDiaria, Date fechaDeNacimiento) {
		super(nombre, peso, raza, especie, estadoSalud, sexo, tipoAlimentacion, alimentacionDiaria, fechaDeNacimiento);
		// TODO Auto-generated constructor stub
	}

	public Volador(String nombre, String especie, String sexo) {
		super(nombre, especie, sexo);
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return super.toString();
	}
}
