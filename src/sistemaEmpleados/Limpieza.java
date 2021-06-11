package sistemaEmpleados;

public class Limpieza extends Empleado
{
	private String areaDeTrabajo;
	
	public Limpieza() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAreaDeTrabajo() {
		return areaDeTrabajo;
	}
	
	public void setAreaDeTrabajo(String areaDeTrabajo) {

		this.areaDeTrabajo = areaDeTrabajo;
	}
	
	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean darDeAlta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean darDeBaja() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "Limpieza [getAreaDeTrabajo()=" + getAreaDeTrabajo() + "]";
	}
	
	

}
