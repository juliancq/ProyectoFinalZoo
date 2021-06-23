package sistemaEmpleados;


public class Adiestrador extends Empleado implements ICalculoSueldo 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String especilidad = null; //especialista en que animales
	private int horasTrabajadasMensuales = 0;
	
	public Adiestrador() {
		// TODO Auto-generated constructor stub
	}
	
	public Adiestrador(String nombre, String apellido, int dni, int edad, String mail, String telefono, String direccion, String horario, char genero, String cuil, String especilidad, int horasTrabajadasMensuales) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil);
		this.especilidad = especilidad;
		this.horasTrabajadasMensuales = horasTrabajadasMensuales;
		super.setSueldo(calcularSueldo());
	}

	public int getHorasTrabajadasMensuales() {
		return horasTrabajadasMensuales;
	}
	
	public String getEspecilidad() {
		return especilidad;
	}
	
	public void setEspecilidad(String especilidad) {
		this.especilidad = especilidad;
	}
	
	public void setHorasTrabajadasMensuales(int horasTrabajadasMensuales) {
		this.horasTrabajadasMensuales = horasTrabajadasMensuales;
	}
	
	/**
	 * multiplica las horas trabajadas mensuales por el monto
	 * a cobrar por hora y lo devuelve
	 */
	public double calcularSueldo() {
		return (horasTrabajadasMensuales*1000);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nClase: Adiestrador\nEspecilidad: " + getEspecilidad() + "\nHoras trabajadas: " + getHorasTrabajadasMensuales() + "\n-------------------------";
	}
}
