package sistemaEmpleados;


public class Adiestrador extends Empleado 
{
	private String especilidad; //especialista en que animales
	private int horasTrabajadasMensuales;
	
	public Adiestrador() {
		// TODO Auto-generated constructor stub
	}
	
	public Adiestrador(String nombre, String apellido, int dni, int edad, String mail, String telefono, String direccion, String horario, char genero, String cuil, String especilidad, int horasTrabajadasMensuales) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil);
		this.especilidad = especilidad;
		this.horasTrabajadasMensuales = horasTrabajadasMensuales;
		super.setSueldo(calcularSueldo());
	}

	public String getEspecilidad() {
		return especilidad;
	}
	
	public double calcularSueldo() {
		return (horasTrabajadasMensuales*1000);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nClase: Adiestrador\nEspecilidad: " + getEspecilidad() + "\n-------------------------";
	}

	

	

	
}
