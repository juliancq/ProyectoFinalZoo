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

	private ArrayList<Habitat> lista;
	private ListaEmpleados listaEmpleados;

	public Zoologico() {
		lista = new ArrayList<>();
		listaEmpleados = new ListaEmpleados();
	}

	public void agregarHabitat(Habitat aux) {
		aux.setIdContador(lista.size());
		lista.add(aux);
	}

	public void eliminar(String tipo) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(tipo)) {
				lista.remove(i);
			}
		}
	}

	public ListaEmpleados getListaEmpleados() {
		
		return listaEmpleados;
	}
	
	public Habitat getHabitat(int indice) {
		
		return lista.get(indice);
	}
	
	public String toString() {
		StringBuilder cadena = new StringBuilder();

		for (int i = 0; i < lista.size(); i++) {
			cadena.append(lista.get(i).toString());
		}

		return cadena.toString();
	}

}
