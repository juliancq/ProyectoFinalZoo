package sistemaEmpleados;


public class Limpieza extends Empleado
{
	private String areaDeTrabajo;
	private int horasTrabajadasMensuales;
	
	
	public Limpieza() {
		// TODO Auto-generated constructor stub
	}
	
	public Limpieza(String nombre, String apellido, int dni, int edad, String mail, long telefono, String direccion,
			int legajo, String horario, char genero, long cuil, String areaDeTrabajo,int horasTrabajadasMensuales) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, legajo, horario, genero, cuil);
		this.areaDeTrabajo = areaDeTrabajo;
		super.setSueldo(calcularSueldo());
	}
	
	public String getAreaDeTrabajo() {
		return areaDeTrabajo;
	}
	
	public void setAreaDeTrabajo(String areaDeTrabajo) {

		this.areaDeTrabajo = areaDeTrabajo;
	}
	
	public double calcularSueldo() {
		return (horasTrabajadasMensuales*600);
	}

	@Override
	public String toString() {
		return super.toString() + "\nClase: Limpieza\nreaDeTrabajo: " + getAreaDeTrabajo() + "\n-------------------------";
	}
	
	

}
