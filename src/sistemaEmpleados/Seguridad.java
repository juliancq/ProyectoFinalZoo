package sistemaEmpleados;


public class Seguridad extends Empleado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sector = 0;

	public Seguridad() {
		// TODO Auto-generated constructor stub
	}

	public Seguridad(String nombre, String apellido, int dni, int edad, String mail,
			String telefono, String direccion, String horario, char genero, String cuil, int sector) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil);
		this.sector = sector;
		super.setSueldo(47000);
	}

	public int getSector() {
		return sector;
	}

	public void setSector(int sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return super.toString() + "\nClase: Seguridad\nSector: " + getSector() + "\n-------------------------";
	}
}
