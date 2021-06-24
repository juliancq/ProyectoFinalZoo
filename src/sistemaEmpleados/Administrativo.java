package sistemaEmpleados;



public class Administrativo extends Empleado
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String puesto = null;
	
	public Administrativo() {
		// TODO Auto-generated constructor stub
	}
	
	public Administrativo(String nombre, String apellido, int dni, int edad, String mail, String telefono, String direccion, String horario, char genero, String cuil,
			String puesto) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario,
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
		return super.toString() + "\nClase: Administrativo\nPuesto: " + getPuesto() + "\n-------------------------";
	}
}
