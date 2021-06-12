package sistemaEmpleados;

import java.util.ArrayList;

public class ListaEmpleados 
{
	private ArrayList <Empleado> lista;
	/**
	 * Lista a los empleados de la lista
	 */
	public ListaEmpleados() 
	{
		lista = new ArrayList<Empleado>();
	}
	/**
	 * Agrega un empleado a la lista
	 * @param e
	 */
	public void addEmpleado(Empleado e)
	{
		lista.add(e);
	}
	/**
	 * Elimina un empleado de la lista
	 * @param e
	 */
	public void removeEmpleado(Empleado e)
	{
		lista.remove(e);
	}
	/**
	 * Lista a todos los empleados de la lista
	 * @return
	 */
	public String listado()
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<lista.size();i++)
		{
			builder.append(lista.get(i));
		}
		return builder.toString();
	}
	/**
	 * Cuenta la cantidad de empleados de la lista
	 * @return
	 */
	public int contar()
	{
		return lista.size();
	}
	/**
	 * Da de alta a un empleado segun el nro de legajo
	 * @param legajo
	 */
	public void darDeAlta(int legajo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).darAlta();
			}
		}
	}
	/**
	 * Da de baja a un empleado segun el nro de legajo
	 * @param legajo
	 */
	public void darDeBaja(int legajo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).darBaja();
			}
		}
	}
	/**
	 * Modifica el horario de un empleado
	 * @param legajo
	 * @param horario
	 */
	public void modificarHorario(int legajo, String horario)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setHorario(horario);
			}
		}
	}
	/**
	 * Modifica el sueldo de un empleado
	 * @param legajo
	 * @param sueldo
	 */
	public void modificarSueldo(int legajo, double sueldo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setSueldo(sueldo);
			}
		}
	}
	/**
	 * Modifica la direccion de un empleado
	 * @param legajo
	 * @param direccion
	 */
	public void modificarDireccion(int legajo, String direccion)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setDireccion(direccion);
			}
		}
	}
	/**
	 * Modifica el telefono de un empleado
	 * @param legajo
	 * @param telefono
	 */
	public void modificarTelefono(int legajo, int telefono)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setTelefono(telefono);
			}
		}
	}
	/**
	 * Elimina un empleado segun nro de legajo
	 * @param legajo
	 */
	public void eliminarPorLegajo(int legajo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.remove(i);
			}
		}
	}
	/**
	 * Busca un empleado segun el nro de legajo
	 * @param legajo
	 * @return
	 */
	public Empleado buscarPorLegajo(int legajo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				return lista.get(i);
			}
		}
		return null;
	}
}
