package sistemaEmpleados;

import java.util.Date;

public class Administrativo extends Empleado
{
	private String puesto;
	
	public Administrativo() {
		// TODO Auto-generated constructor stub
	}
	
	public Administrativo(String nombre, String apellido, int dni, int edad, String mail,
			Date fechaDeContratacion, int telefono, String direccion, int legajo, String horario, char genero, int cuil,
			String puesto) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, legajo, horario,
				genero, cuil);
		this.puesto = puesto;
		super.setSueldo(45000);
	}

	public String getPuesto() {
		return puesto;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return super.toString() + "\nClase: Administrativo\nPuesto: " + "\nPuesto: " + getPuesto() + "\n-------------------------";
	}
}
