package sistemaEmpleados;

import java.sql.Date;

public class Veterinario extends Empleado
{
	private int matricula;
	
	public Veterinario() {
		// TODO Auto-generated constructor stub
	}

	public Veterinario(String nombre, String apellido, int dni, int edad, double sueldo, String mail,
			Date fechaDeContratacion, int telefono, String direccion, int legajo, String area, String horario,
			char genero, int cuil, int matricula) {
		super(nombre, apellido, dni, edad, sueldo, mail, telefono, direccion, legajo,
				horario, genero, cuil);
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}
	
	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String toString() {
		return super.toString() + "Veterinario [getMatricula()=" + getMatricula() + "]";
	}
	
	
}
