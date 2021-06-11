package SistemaEmpleados;

import java.util.ArrayList;

public class ListaEmpleados 
{
	private ArrayList <Empleado> lista;
	
	public ListaEmpleados() 
	{
		lista = new ArrayList<Empleado>();
	}
	
	public void addEmpleado(Empleado e)
	{
		lista.add(e);
	}
	
	public void removeEmpleado(Empleado e)
	{
		lista.remove(e);
	}
	
	public String listado()
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<lista.size();i++)
		{
			builder.append(lista.get(i));
		}
		return builder.toString();
	}
	
	public int contar()
	{
		return lista.size();
	}
	
	
}
