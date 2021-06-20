package sistemaEmpleados;


public class Servicio_al_cliente extends Empleado
{
	private String area;//atencion telefonica,candy shop, cafe, etc...
	
	
	public Servicio_al_cliente() {
		// TODO Auto-generated constructor stub
	}
		
	public Servicio_al_cliente(String nombre, String apellido, int dni, int edad, String mail, int telefono, String direccion, int legajo, String horario, char genero, int cuil,
			String area) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, legajo, horario,
				genero, cuil);
		this.area = area;
		super.setSueldo(40000);
	}

	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nClase: Servicio al cliente\nArea: " + getArea() + "\n-------------------------";
	}
}
