package main;

import sistemaEmpleados.*;
import sistemaAnimales.*;
import java.util.Scanner;
import java.util.Date;
import manejoArchivos.*;


public class Main {

	public static void main(String[] args) {

		Zoologico zoo = new Zoologico();
		
		zoo = PersistenciaZoo.leerZoo();
		
		//MENU
		
		System.out.println(zoo);
		
		PersistenciaZoo.guardarZoo(zoo);
	}

}
