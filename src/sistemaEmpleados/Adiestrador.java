package sistemaEmpleados;

import java.sql.Date;

public class Adiestrador extends Empleado 
{
	private String especilidad; //especialista en que animales
	
	
	public Adiestrador() {
		// TODO Auto-generated constructor stub
	}
	
	public Adiestrador(String nombre, String apellido, int dni, int edad, double sueldo, String mail, long telefono, String direccion, int legajo, String horario, char genero, long cuil,
			String especilidad) {
		super(nombre, apellido, dni, edad, sueldo, mail, telefono, direccion, legajo, horario,
				genero, cuil);
		this.especilidad = especilidad;
	}

	public String getEspecilidad() {
		return especilidad;
	}


	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String toString() {
		return super.toString() + "\nClase: Adiestrador\nEspecilidad: " + getEspecilidad();
	}

	

	
}
