package sistemaEmpleados;

import java.sql.Date;

public class Administrativo extends Empleado
{
	private String puesto;
	
	public Administrativo() {
		// TODO Auto-generated constructor stub
	}
	
	public Administrativo(String nombre, String apellido, int dni, int edad, double sueldo, String mail,
			Date fechaDeContratacion, int telefono, String direccion, int legajo, String horario, char genero, int cuil,
			String puesto) {
		super(nombre, apellido, dni, edad, sueldo, mail, telefono, direccion, legajo, horario,
				genero, cuil);
		this.puesto = puesto;
	}

	public String getPuesto() {
		return puesto;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	
	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String toString() {
		return super.toString() + "\nClase: Administrativo\nPuesto: " + getPuesto() + "\n-------------------------";
	}
	
}
