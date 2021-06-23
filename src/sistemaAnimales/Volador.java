package sistemaAnimales;

import java.util.Date;

public class Volador extends Animal{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoAlimentacion;//Omnivoro, herbivoro, carnívoro
	
	public Volador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Volador(String nombre, double peso, String raza, String especie, String estadoSalud, String sexo,
			double alimentacionDiaria, Date fechaDeNacimiento) {
		super(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fechaDeNacimiento);
	}

	public Volador(String nombre, String especie, String sexo) {
		super(nombre, especie, sexo);
		// TODO Auto-generated constructor stub
	}
	
	public void setTipoAlimentacion(String tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}
	
	public String toString()
	{
		return super.toString();
	}
}
