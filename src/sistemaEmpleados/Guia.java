package sistemaEmpleados;


import java.util.ArrayList;

public class Guia extends Empleado
{
	private ArrayList<String> idiomas;


	public Guia() {
		// TODO Auto-generated constructor stub
	}

	public Guia(String nombre, String apellido, int dni, int edad, String mail,
			String telefono, String direccion, String horario, char genero, String cuil) {
		super(nombre, apellido, dni, edad, mail, telefono, direccion, horario,
				genero, cuil);
		idiomas = new ArrayList<String>();
		super.setSueldo(43000);
	}
	
	public void addIdiomas(String idioma)
	{
		idiomas.add(idioma);
	}

	public String listarIdiomas()
	{
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<idiomas.size();i++)
		{
			builder.append(idiomas.get(i));
		}
		return builder.toString();
	}

	
	@Override
	public String toString() {
		return super.toString() + "\nClase: Guia\nIdiomas: " + listarIdiomas() + "\n-------------------------";
	}
}
