package main;

import sistemaEmpleados.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
ListaEmpleados lista = new ListaEmpleados();
		
		lista.addEmpleado(new Adiestrador("Pablo", "Rizzo", 36383448, 29, 30000, "rizzo@hotmail.com", 223589, "vieytes 454", 1, "Mañana", 'M', 2436381, "leones"));
		System.out.println(lista.listado());
		lista.eliminarPorLegajo(1);
		System.out.println(lista.listado());

	}

}
