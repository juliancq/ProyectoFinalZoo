package SistemaEmpleados;

import java.sql.Date;
import java.util.ArrayList;

public class Guia extends Empleado
{
	private String areaDeTrabajo;
	private ArrayList<String> idiomas;

	public Guia() {
		// TODO Auto-generated constructor stub
	}

	public Guia(String nombre, String apellido, int dni, int edad, double sueldo, String mail, Date fechaDeContratacion,
			int telefono, String direccion, int legajo, String horario, char genero, int cuil, String areaDeTrabajo) {
		super(nombre, apellido, dni, edad, sueldo, mail, fechaDeContratacion, telefono, direccion, legajo, horario,
				genero, cuil);
		this.areaDeTrabajo = areaDeTrabajo;
		idiomas = new ArrayList<String>();
	}

	public String getAreaDeTrabajo() {
		return areaDeTrabajo;
	}
	
	public void setAreaDeTrabajo(String areaDeTrabajo) {
		this.areaDeTrabajo = areaDeTrabajo;
	}
	
	public void addIdiomas(String idioma)
	{
		idiomas.add(idioma);
	}

	public String listarIdiomas()
	{
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<idiomas.size();i++)
		{
			builder.append(idiomas.get(i));
		}
		return builder.toString();
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
		return super.toString() + "Guia [getAreaDeTrabajo()=" + getAreaDeTrabajo() + "]";
	}
	
	
}
