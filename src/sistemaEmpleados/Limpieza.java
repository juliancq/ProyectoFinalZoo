package sistemaEmpleados;

public class Limpieza extends Empleado {
	
	private int horasTrabajadasMensuales;

	public Limpieza() {
		// TODO Auto-generated constructor stub
	}

	public Limpieza(String nombre, String apellido, int dni, int edad, String mail, String telefono, String direccion, String horario, char genero, String cuil, int horasTrabajadasMensuales) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil);
		super.setSueldo(calcularSueldo());
	}

	public double calcularSueldo() {
		return (horasTrabajadasMensuales * 600);
	}

	@Override
	public String toString() {
		return super.toString() + "\nClase: Limpieza"
				+ "\n-------------------------";
	}

}
