package sistemaEmpleados;

public class Veterinario extends Empleado {
	private String matricula;

	public Veterinario() {
		// TODO Auto-generated constructor stub
	}

	public Veterinario(String nombre, String apellido, int dni, int edad, String mail, String telefono,
			String direccion, String horario, char genero, String cuil, String matricula) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil);
		this.matricula = matricula;
		super.setSueldo(65000);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return super.toString() + "\nClase: Veterinario\nMatricula: " + getMatricula() + "\n-------------------------";
	}
}
