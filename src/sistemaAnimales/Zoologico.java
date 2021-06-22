package sistemaAnimales;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import sistemaEmpleados.ListaEmpleados;

/**
 * Comentar
 * 
 * @implements Serializable
 */
public class Zoologico implements Serializable{
	
	private ArrayList<Habitat> lista;
	private ListaEmpleados listaEmpleados;

	public Zoologico()
	{
		lista = new ArrayList<>();
		listaEmpleados = new ListaEmpleados();
	}
	
	public void agregarHabitat(Habitat aux)
	{
		aux.setIdContador(lista.size());
		lista.add(aux);
	}
	
	public void eliminar(String tipo)
	{
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).equals(tipo))
			{
				lista.remove(i);
			}
		}
	}
	
	public String toString()
	{
		StringBuilder cadena = new StringBuilder();
			
		for(int i=0;i<lista.size();i++)
		{
			cadena.append(lista.get(i).toString());
		}
		
		return cadena.toString();
	}
	
}
