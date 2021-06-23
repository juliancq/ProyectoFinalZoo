package sistemaEmpleados;



public class Cuidador extends Empleado
{
	private int sector = 0; //asignarle un sector de animales
	
	
	public Cuidador() {
		// TODO Auto-generated constructor stub
	}
	
	public Cuidador(String nombre, String apellido, int dni, int edad, String mail, String telefono, String direccion, String horario, char genero, String cuil,
			int sector) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario,
				genero, cuil);
		this.sector = sector;
		super.setSueldo(50000);
	}

	public int getSector() {
		return sector;
	}
	
	public void setSector(int sector) {
		this.sector = sector;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nClase: Cuidador\nSector: " + getSector() + "\n-------------------------";
	}
}
