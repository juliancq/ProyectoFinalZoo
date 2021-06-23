package sistemaEmpleados;


public class ServicioAlCliente extends Empleado
{
	private String area = null;//atencion telefonica,candy shop, cafe, etc...
	
	
	public ServicioAlCliente() {
		// TODO Auto-generated constructor stub
	}
		
	public ServicioAlCliente(String nombre, String apellido, int dni, int edad, String mail, String telefono, String direccion, String horario, char genero, String cuil,
			String area) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario,
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
