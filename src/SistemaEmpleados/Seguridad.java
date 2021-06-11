package SistemaEmpleados;

import java.sql.Date;

public class Seguridad extends Empleado
{
	private int sector;
	
	public Seguridad() {
		// TODO Auto-generated constructor stub
	}
	
	public Seguridad(String nombre, String apellido, int dni, int edad, double sueldo, String mail,
			Date fechaDeContratacion, int telefono, String direccion, int legajo, String horario, char genero, int cuil,
			int sector) {
		super(nombre, apellido, dni, edad, sueldo, mail, fechaDeContratacion, telefono, direccion, legajo, horario,
				genero, cuil);
		this.sector = sector;
	}

	public int getSector() {
		return sector;
	}
	
	public void setSector(int sector) {
		this.sector = sector;
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
		return super.toString() + "Seguridad [getSector()=" + getSector() + "]";
	}
}
