package sistemaAnimales;

import java.util.Date;

public class Omnivoro extends Terrestre{
	
	public Omnivoro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Omnivoro(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			String tipoAlimentacion, double alimentacionDiaria, Date fechaDeNacimiento, boolean esFertil) {
		super(nombre, peso, raza, especie, estadoSalud, sexo, tipoAlimentacion, alimentacionDiaria, fechaDeNacimiento,
				esFertil);
		// TODO Auto-generated constructor stub
	}

	public Omnivoro(String nombre, String especie, String sexo) {
		super(nombre, especie, sexo);
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return super.toString();
	}
}
