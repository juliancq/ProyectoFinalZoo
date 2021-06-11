package sistemaEmpleados;

import java.sql.Date;

public class Servicio_al_cliente extends Empleado
{
	private String area;//atencion telefonica,candy shop, cafe, etc...
	
	public Servicio_al_cliente() {
		// TODO Auto-generated constructor stub
	}
		
	public Servicio_al_cliente(String nombre, String apellido, int dni, int edad, double sueldo, String mail,
			Date fechaDeContratacion, int telefono, String direccion, int legajo, String horario, char genero, int cuil,
			String area) {
		super(nombre, apellido, dni, edad, sueldo, mail, fechaDeContratacion, telefono, direccion, legajo, horario,
				genero, cuil);
		this.area = area;
	}

	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String toString() {
		return super.toString() + "Servicio_al_cliente [getArea()=" + getArea() + "]";
	}
}
