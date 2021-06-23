package sistemaEmpleados;

public class Limpieza extends Empleado implements ICalculoSueldo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int horasTrabajadasMensuales = 0;

	public Limpieza() {
		// TODO Auto-generated constructor stub
	}

	public Limpieza(String nombre, String apellido, int dni, int edad, String mail, String telefono, String direccion, String horario, char genero, String cuil, int horasTrabajadasMensuales) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil);
		super.setSueldo(calcularSueldo());
	}

	public int getHorasTrabajadasMensuales() {
		return horasTrabajadasMensuales;
	}
	
	public void setHorasTrabajadasMensuales(int horasTrabajadasMensuales) {
		this.horasTrabajadasMensuales = horasTrabajadasMensuales;
	}
	
	/**
	 * multiplica las horas trabajadas mensuales por el monto
	 * a cobrar por hora y lo devuelve
	 */
	public double calcularSueldo() {
		return (horasTrabajadasMensuales * 600);
	}

	@Override
	public String toString() {
		return super.toString() + "\nClase: Limpieza\nHoras trbajadas: " + getHorasTrabajadasMensuales() + "\n-------------------------";
	}
}
