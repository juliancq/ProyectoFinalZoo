package sistemaEmpleados;


public class Veterinario extends Empleado
{
	private int matricula;
	
	
	public Veterinario() {
		// TODO Auto-generated constructor stub
	}

	public Veterinario(String nombre, String apellido, int dni, int edad, String mail, int telefono, String direccion, int legajo, String area, String horario,
			char genero, int cuil, int matricula) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, legajo,
				horario, genero, cuil);
		this.matricula = matricula;
		super.setSueldo(65000);
	}

	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return super.toString() + "\nClase: Veterinario\nMatricula: " + getMatricula() + "\n-------------------------";
	}
}
