package sistemaAnimales;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Zoologico {
	
	private ArrayList<Habitat> lista;

	public Zoologico()
	{
		lista = new ArrayList<>();
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
