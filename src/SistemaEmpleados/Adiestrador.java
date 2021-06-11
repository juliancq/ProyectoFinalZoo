package SistemaEmpleados;

import java.sql.Date;

public class Adiestrador extends Empleado 
{
	private String especilidad; //especialista en que animales
	
	
	public Adiestrador() {
		// TODO Auto-generated constructor stub
	}
	
	public Adiestrador(String nombre, String apellido, int dni, int edad, double sueldo, String mail,
			Date fechaDeContratacion, int telefono, String direccion, int legajo, String horario, char genero, int cuil,
			String especilidad) {
		super(nombre, apellido, dni, edad, sueldo, mail, fechaDeContratacion, telefono, direccion, legajo, horario,
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
	public boolean darDeAlta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean darDeBaja() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "Adiestrador [getEspecilidad()=" + getEspecilidad() + "]";
	}

	

	
}
