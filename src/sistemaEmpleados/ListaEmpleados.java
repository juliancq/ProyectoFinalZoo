package sistemaEmpleados;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaEmpleados implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		e.setLegajo(lista.size());
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
			if(lista.get(i).getAlta()==true)
			{
				builder.append(lista.get(i));
			}
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
	public boolean darDeAlta(int legajo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).darAlta();
				return true;
			}
		}
		return false;
	}
	/**
	 * Da de baja a un empleado segun el nro de legajo
	 * @param legajo
	 */
	public boolean darDeBaja(int legajo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).darBaja();
				return true;
			}
		}
		return false;
	}
	/**
	 * Modifica el horario de un empleado
	 * @param legajo
	 * @param horario
	 */
	public boolean modificarHorario(int legajo, String horario)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setHorario(horario);
				return true;
			}
		}
		return false;
	}
	/**
	 * Modifica el sueldo de un empleado
	 * @param legajo
	 * @param sueldo
	 */
	public boolean modificarSueldo(int legajo, double sueldo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setSueldo(sueldo);
				return true;
			}
		}
		return false;
	}
	/**
	 * Modifica la direccion de un empleado
	 * @param legajo
	 * @param direccion
	 */
	public boolean modificarDireccion(int legajo, String direccion)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setDireccion(direccion);
				return true;
			}
		}
		return false;
	}
	/**
	 * Modifica el telefono de un empleado
	 * @param legajo
	 * @param telefono
	 */
	public boolean modificarTelefono(int legajo, String telefono)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.get(i).setTelefono(telefono);
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un empleado segun nro de legajo
	 * @param legajo
	 */
	public boolean eliminarPorLegajo(int legajo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getLegajo() == legajo)
			{
				lista.remove(i);
				return true;
			}
		}
		return false;
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
	
	/**
	 * Recibe un entero y lo almacena en el arreglo de calificaciones que tiene cada empleado
	 * @param num
	 */
	public void calificarAtencion(int legajo, int num)
	{
		if(num>=1 && num<=10)
		{
			for(int i=0;i<lista.size();i++)
			{
				if(legajo == lista.get(i).getLegajo())
				{
					lista.get(i).agregarCalificacion(num);
				}
			}
		}
		else
		{
			System.out.println("Fuera de rango...");
		}
	}
	
	/**
	 * Calcula el promedio de las calificaciones en el arreglo de calificaciones de cada empleado
	 * @param legajo
	 * @return el promedio total de todas las calificaciones
	 */
	public double calcularCalificacionTotal(int legajo)
	{
		double total = 0;
		for(int i=0;i<lista.size();i++)
		{
			if(legajo == lista.get(i).getLegajo())
			{
				total = lista.get(i).calcularCalificacion();
			}
		}
		return total;
	}
	
	/**
	 * busca el empleado con la maxima calificacion acumulada
	 * @return el legajo del empleado con la maxima calificacion
	 */
	public int buscarEmpleadoDelMes()
	{
		double calificacionActual = 0;
		double maximaCalificacion = 0;
		int legajo = lista.get(0).getLegajo();
		for(int i=0;i<lista.size();i++)
		{
			calificacionActual = lista.get(i).calcularCalificacion();
			if(calificacionActual>maximaCalificacion)
			{
				maximaCalificacion = calificacionActual;
				legajo = lista.get(i).getLegajo();
			}
		}
		return legajo; 
	}
}
