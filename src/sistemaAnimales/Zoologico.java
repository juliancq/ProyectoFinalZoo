package sistemaAnimales;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import sistemaEmpleados.ListaEmpleados;

/**
 * Clase contenedora padre, incluye lista de habitats y de empleados
 * 
 * @implements Serializable
 */
public class Zoologico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Habitat>lista;
	private ListaEmpleados administracion;

	public Zoologico()
	{
		lista = new ArrayList<>();
		administracion = new ListaEmpleados();
	}
	
	/**
	 * Agrega un Habitat a la lista de H?bitat
	 * 
	 * 
	 */
	public void agregarHabitat(Habitat aux)
	{
		aux.setIdContador(lista.size());
		lista.add(aux);
	}

	/**
	 * Menu que da las opciones para controlar la clase Habitat contenida en Zoologico
	 * 
	 * 
	 */
	public void eliminarHabitatPorNombre(String tipo)
	{
		lista.remove(buscarHabitatPorNombre(tipo));
	}
	
	
	public Habitat buscarHabitatPorNombre(String tipo)
	{
		Habitat retorno = null;
		
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getTipo().equals(tipo))
			{
				retorno = lista.get(i);
			}
		}

		return retorno;
	}
	
	
	public String getNombresDeHabitat()
	{
		StringBuilder cadena = new StringBuilder();
		
		for(int i=0;i<lista.size();i++)
		{
			cadena.append(lista.get(i).getTipo()+"\n");
		}
		
		return cadena.toString();
	}
	
	
	public Habitat getHabitat(int indice)
	{
		return lista.get(indice);
	}
	
	
	public String toString()
	{
		StringBuilder cadena = new StringBuilder();

		for (int i = 0; i < lista.size(); i++) {
			cadena.append("\n" + lista.get(i).toString() + "\n");
		}

		return cadena.toString();
	}
	
	public ListaEmpleados getListaEmpleados()
	{
		return administracion;
	}
}
