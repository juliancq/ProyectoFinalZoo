package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import comprobacionTipos.ComprobarTipo;
import manejoArchivos.PersistenciaZoo;
import sistemaAnimales.Acuatico;
import sistemaAnimales.Animal;
import sistemaAnimales.Carnivoro;
import sistemaAnimales.Habitat;
import sistemaAnimales.Herbivoro;
import sistemaAnimales.Omnivoro;
import sistemaAnimales.Sector;
import sistemaAnimales.Volador;
import sistemaAnimales.Zoologico;
import sistemaEmpleados.Adiestrador;
import sistemaEmpleados.Administrativo;
import sistemaEmpleados.Cuidador;
import sistemaEmpleados.Empleado;
import sistemaEmpleados.Guia;
import sistemaEmpleados.Limpieza;
import sistemaEmpleados.ListaEmpleados;
import sistemaEmpleados.Seguridad;
import sistemaEmpleados.ServicioAlCliente;
import sistemaEmpleados.Veterinario;

public class Menu {

	private Zoologico zoo;
	private ListaEmpleados administracion;

	public Menu() {

		zoo = PersistenciaZoo.leerZoo();
		administracion = zoo.getListaEmpleados();
	}
	
	/**
	 * Menu principal del Zoológico
	 * 
	 * 
	 */
	public void menuZoologico() {
		int respuesta = -1;

		while (respuesta != 3) {
			String out = JOptionPane.showInputDialog(
					"Menú Principal\n\nIngrese una opción \n1-Administración.\n2-Zoológico.\n3-Salir");
			while(!ComprobarTipo.isNumero(out))
			{
				out = JOptionPane.showInputDialog(
						"Menú Principal\n\nIngrese una opción \n1-Administración.\n2-Zoológico.\n3-Salir");
			}
			respuesta = Integer.parseInt(out);

			switch (respuesta) {
			case 1:
				menuAdministracion();
				break;
			case 2:
				menuHabitat();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				PersistenciaZoo.guardarZoo(zoo);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción invalida");
				break;
			}
		}
	}
	
	/**
	 * Menu que da las opciones para controlar la clase Habitat contenida en Zoologico
	 * 
	 * 
	 */
	public void menuHabitat() {
		int respuesta = -1;

		while (respuesta != 6) {
			String out = JOptionPane.showInputDialog(
					"Zoológico\n\nIngrese una opción\n1-Agregar Hábitat\n2-Listar Hábitats\n3-Ingresar a Hábitat\n4-Modificar\n5-Eliminar Hábitat\n6-Salir");
			while(!ComprobarTipo.isNumero(out))
			{
				out = JOptionPane.showInputDialog(
						"Zoológico\n\nIngrese una opción\n1-Agregar Hábitat\n2-Listar Hábitats\n3-Ingresar a Hábitat\n4-Modificar\n5-Eliminar Hábitat\n6-Salir");
			}
			respuesta = Integer.parseInt(out);
			
			switch (respuesta) {
			case 1:
				zoo.agregarHabitat(ingresarInformacionHabitat());
				break;
			case 2:
				System.out.println(zoo.toString());
				break;
			case 3:
				String ingresarHabitat = (JOptionPane.showInputDialog("\n¿En qué Hábitat desea ingresar?\n"));
				while(!ComprobarTipo.isAlfabetico(ingresarHabitat))
				{
					ingresarHabitat = (JOptionPane.showInputDialog("\n¿En qué Hábitat desea ingresar?\n"));
				}

				Habitat entrar = zoo.buscarHabitatPorNombre(ingresarHabitat);
				if(entrar!=null)
				{
					menuSector(entrar);
				}
				break;
			case 4:
				String modificacionHabitat = (JOptionPane.showInputDialog("\n¿Qué Hábitat desea modificar?\n"));
				while(!ComprobarTipo.isAlfabetico(modificacionHabitat))
				{
					modificacionHabitat = (JOptionPane.showInputDialog("\n¿Qué Hábitat desea modificar?\n"));
				}

				Habitat modificar = zoo.buscarHabitatPorNombre(modificacionHabitat);
				modificarHabitat(modificar);
				break;
			case 5:
				String eliminarHabitat = (JOptionPane.showInputDialog("\n¿Qué Hábitat desea eliminar?\n"));
				while(!ComprobarTipo.isAlfabetico(eliminarHabitat))
				{
					eliminarHabitat = (JOptionPane.showInputDialog("\n¿Qué Hábitat desea eliminar?\n"));
				}

				zoo.eliminarHabitatPorNombre(eliminarHabitat);
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	/**
	 * Menú que da las opciones para el manejo de sectores, la cual está contenida en Hábitat
	 * 
	 * @param Habitat que contiene los sectores
	 */
	public void menuSector(Habitat hab) {
		int respuesta = -1;

		while (respuesta != 5) {
			String out = JOptionPane.showInputDialog(
					"Habitat\n\nIngrese una opción\n1-Agregar Sector\n2-Listar Sectores\n3-Ingresar a Sector\n4-Modificar Sector\n5-Eliminar Sector\n6-Salir");
			while(!ComprobarTipo.isNumero(out))
			{
				out = JOptionPane.showInputDialog(
						"Habitat\n\nIngrese una opción\n1-Agregar Sector\n2-Listar Sectores\n3-Ingresar a Sector\n4-Modificar Sector\n5-Eliminar Sector\n6-Salir");
			}
			respuesta = Integer.parseInt(out);
			
			switch (respuesta) {
			case 1:
				ingresarInformacionSector(hab);
				break;
			case 2:
				System.out.println(hab.toString());
				break;
			case 3:
				String ingresarSector = (JOptionPane.showInputDialog("\n¿En qué Sector desea ingresar?\n"));
				while(!ComprobarTipo.isAlfabetico(ingresarSector))
				{
					ingresarSector = (JOptionPane.showInputDialog("\n¿En qué Sector desea ingresar?\n"));
				}

				Sector entrar = hab.buscarSectorPorNombre(ingresarSector);
				if(entrar!=null)
				{
					menuAnimales(entrar);
				}
				break;
			case 4:
				String modificacionSector = (JOptionPane.showInputDialog("\n¿En qué Sector desea modificar?\n"));
				while(!ComprobarTipo.isAlfabetico(modificacionSector))
				{
					modificacionSector = (JOptionPane.showInputDialog("\n¿En qué Sector desea modificar?\n"));
				}

				Sector modificar = hab.buscarSectorPorNombre(modificacionSector);
				modificarSector(modificar);
				break;
			case 5:
				String eliminarHabitat = (JOptionPane.showInputDialog("\n¿Qué Sector desea eliminar?\n"));
				while(!ComprobarTipo.isAlfabetico(eliminarHabitat))
				{
					eliminarHabitat = (JOptionPane.showInputDialog("\n¿Qué Sector desea eliminar?\n"));
				}
				hab.eliminarSectorPorNombre(eliminarHabitat);
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	/**
	 * Menu que permite el control de la clase Animal, la cual está contenida en Sector
	 * 
	 * @param Sector que contiene los animales
	 */
	public void menuAnimales(Sector sec) {
		int respuesta = -1;

		while (respuesta != 8) {
			String out = JOptionPane.showInputDialog("Habitat: " + sec.getNombreSector()
					+ "\n\nIngrese una opción\n1-Agregar Animal\n2-Listar Animales\n3-Ingresar a planilla del Animal\n4-Eliminar Animal\n5-Reponer stock Alimento\n6-Alimentar\n7-Hacer mantenimiento\n8-Salir");
			while(!ComprobarTipo.isNumero(out))
			{
				out = JOptionPane.showInputDialog("Habitat: " + sec.getNombreSector()
				+ "\n\nIngrese una opción\n1-Agregar Animal\n2-Listar Animales\n3-Ingresar a planilla del Animal\n4-Eliminar Animal\n5-Reponer stock Alimento\n6-Alimentar\n7-Hacer mantenimiento\n8-Salir");
			}
			respuesta = Integer.parseInt(out);
			
			switch (respuesta) {
			case 1:
				ingresarInformacionAnimal(sec);
				break;
			case 2:
				System.out.println(sec.toString());
				break;
			case 3:
				String respuestaSector = (JOptionPane
						.showInputDialog("\n¿A qué planilla desea ingresar? Ingrese nombre del animal\n"));
				while(!ComprobarTipo.isAlfabetico(respuestaSector))
				{
					respuestaSector = (JOptionPane
							.showInputDialog("\n¿A qué planilla desea ingresar? Ingrese nombre del animal\n"));
				}
				Animal entrar = sec.buscarAnimalPorNombre(respuestaSector);
				if(entrar!=null)
				{
					planillaAnimal(entrar);
				}
				break;
			case 4:
				String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Animal a eliminar");
				while(!ComprobarTipo.isAlfabetico(nombre))
				{
					nombre = JOptionPane.showInputDialog("Ingrese el nombre del Animal a eliminar");
				}
				sec.borrarAnimalPorNombre(nombre);
				break;
			case 5:
				String nuevoStock = JOptionPane.showInputDialog("Ingrese la cantidad de entrada");
				while(!ComprobarTipo.isNumero(nuevoStock))
				{
					nuevoStock = JOptionPane.showInputDialog("Ingrese la cantidad de entrada");
				}
				double nnuevoStock = Double.parseDouble(nuevoStock);
				sec.reponerStock(nnuevoStock);
				break;
			case 6:
				try {
					sec.alimentar();
					JOptionPane.showMessageDialog(null, "Animales alimentados exitosamente !");
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Stock insuficiente");
					//e.printStackTrace();
				}
				break;
			case 7:
				sec.hacerMantenimiento();
				JOptionPane.showMessageDialog(null, "Limpieza de Sector actualizada !");
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	
	/**
	 * Busca un animal por nombre, si lo halla lo elimina, sino retorna null;
	 * 
	 * @param Animal que tiene sus propios datos
	 */
	public void planillaAnimal(Animal ani)
	{
		int respuesta = -1;
		
		while(respuesta!=6)
		{
			String out = JOptionPane.showInputDialog(
					"Planilla: "+ ani.getNombre() +"\nIngrese una opción\n1-Revisión médica\n2-Visualizar historia clínica\n3-Visualizar última revisión\n4-Listar información\n5-Modificar información\n6-Volver");
			while(!ComprobarTipo.isNumero(out))
			{
				out = JOptionPane.showInputDialog(
						"Planilla: "+ ani.getNombre() +"\nIngrese una opción\n1-Revisión médica\n2-Visualizar historia clínica\n3-Visualizar última revisión\n4-Listar información\n5-Modificar información\n6-Volver");
			}
			respuesta = Integer.parseInt(out);
			
			switch(respuesta)
			{
			case 1:
				String diagnostico = JOptionPane.showInputDialog("Ingrese su diagnóstico para el animal");
				while(!ComprobarTipo.isAlfabetico(diagnostico))
				{
					diagnostico = JOptionPane.showInputDialog("Ingrese su diagnóstico para el animal");
				}
				ani.getHistoriaClinica().actualizar(diagnostico);
				break;
			case 2:
				if(ani.getHistoriaClinica().toString()!=null)
				{
					
				}
				System.out.println();
				break;
			case 3:
				if(ani.getHistoriaClinica().ultimaRevisión()!=null)
				{
					System.out.println(ani.getHistoriaClinica().ultimaRevisión());
				}
				break;
			case 4:
				System.out.println(ani.toString());
				break;
			case 5:
				modificarAnimal(ani);
				break;
			case 6:
				//hacer nada
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	/**
	 * Funcion que permite el ingreso de informacion de un Habitat para su posterior carga
	 * 
	 * 
	 */
//Método que permite el ingreso de información para hacer una carga de un Hábitat
	private Habitat ingresarInformacionHabitat() {
		String tipo = JOptionPane.showInputDialog("Ingrese el tipo de Hábitat(Sabana, Selva, Marino, etc..)");
		while(!ComprobarTipo.isAlfabetico(tipo))
		{
			tipo = JOptionPane.showInputDialog("Ingrese el tipo de Hábitat(Sabana, Selva, Marino, etc..)");
		}
		String temperatura = JOptionPane.showInputDialog("Ingrese temperatura media del Hábitat");
		while(!ComprobarTipo.isNumero(temperatura))
		{
			temperatura = JOptionPane.showInputDialog("Ingrese temperatura media del Hábitat");
		}
		double ttemperatura = Double.parseDouble(temperatura);
		Habitat aux = new Habitat(ttemperatura, tipo);
		return aux;
	}

//Método que permite el ingreso de información para hacer una carga de Sector, cuyos datos son 
//guardados en un objeto de este tipo y posteriormente cargados en un Hábitat que recibe por parámetro
	private void ingresarInformacionSector(Habitat hab) {
		String nombreSector = JOptionPane.showInputDialog("Ingrese el nombre del Sector");
		while(!ComprobarTipo.isAlfabetico(nombreSector))
		{
			nombreSector = JOptionPane.showInputDialog("Ingrese el nombre del Sector");
		}
		String capacidadSector = JOptionPane.showInputDialog("Ingrese capacidad total del Sector");
		while(!ComprobarTipo.isNumero(capacidadSector))
		{
			capacidadSector = JOptionPane.showInputDialog("Ingrese capacidad total del Sector");
		}
		int ccapacidadSector = Integer.parseInt(capacidadSector);
		
		int tipoSector = -1;

		while (tipoSector != 1 && tipoSector != 2 && tipoSector != 3 && tipoSector != 4) {
			String out = JOptionPane.showInputDialog(
					"Ingrese el tipo de animales que este sector contendrá\n\n1-Voladores\n2-Acuáticos\n3-Terrestres\n4-Volver");
			while(!ComprobarTipo.isNumero(out))
			{
				out = JOptionPane.showInputDialog(
						"Ingrese el tipo de animales que este sector contendrá\n\n1-Voladores\n2-Acuáticos\n3-Terrestres\n4-Volver");
			}
			tipoSector = Integer.parseInt(out);
			
			switch (tipoSector) {
			case 1:
				hab.agregarSector(new Sector<Volador>(nombreSector, ccapacidadSector));
				break;
			case 2:
				hab.agregarSector(new Sector<Acuatico>(nombreSector, ccapacidadSector));
				break;
			case 3:
				ingresarTipoAlimentacion(hab, nombreSector, ccapacidadSector);
				break;
			case 4:
				//volver
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	
	/**
	 * Este método es utilizado para el ingreso ingreso específico de que tipo de alimentación tendrán los animales del sector a ingresar en el sistema
	 * 
	 * @param Habitat para almacenar el sector creado
	 * @param nombreSector que trae el nombre para el nuevo sector
	 * @param capacidad 
	 */
	private void ingresarTipoAlimentacion(Habitat hab, String nombreSector, int capacidad) {
		int opcion = -1;

		while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
			String aux = JOptionPane.showInputDialog("Usted ha elegido Terrestes.\n\nPor favor, especifique qué tipo de terrestre:\n\n1-Carnínoro\n2-Omnivoro\n3-Herbívoro\n4-Volver");

			while(!ComprobarTipo.isNumero(aux))
			{
				aux = JOptionPane.showInputDialog("Usted ha elegido Terrestes.\n\nPor favor, especifique qué tipo de terrestre:\n\n1-Carnínoro\n2-Omnivoro\n3-Herbívoro\n4-Volver");
			}
			opcion = Integer.parseInt(aux);
			
			switch (opcion) {
			case 1:
				hab.agregarSector(new Sector<Carnivoro>(nombreSector, capacidad));
				break;
			case 2:
				hab.agregarSector(new Sector<Omnivoro>(nombreSector, capacidad));
				break;
			case 3:
				hab.agregarSector(new Sector<Herbivoro>(nombreSector, capacidad));
				break;
			case 4:
				// hacer nada
				break;
			default:
				opcion = -1;
				mostrarMensajeError();
				break;
			}
		}
	}
	
	/**
	 * Método para la carga de información de un animal
	 * 
	 * @param nombre
	 */
	public void ingresarInformacionAnimal(Sector sec) {
		int respuesta = -1;
		while (respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 4) {
			String aux = JOptionPane.showInputDialog("Ingrese qué tipo de Animal desea: \n1-Volador\n2-Acuatico\n3-Terrestre\n4-Volver");
			
			while(!ComprobarTipo.isNumero(aux))
			{
				JOptionPane.showInputDialog("Ingrese qué tipo de Animal desea: \n1-Volador\n2-Acuatico\n3-Terrestre\n4-Volver");
			}
			respuesta = Integer.parseInt(aux);
			
			switch (respuesta) {
			case 1:
				cargarAnimal(sec, 1);
				break;
			case 2:
				cargarAnimal(sec, 2);
				break;
			case 3:
				cargarAnimalTerrestre(sec);
				break;
			case 4:
				// hacer nada
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}

	}

	/**
	 * Metodo que permite el ingreso de el tipo de un animal terrestre
	 * 
	 * 
	 */
	public void cargarAnimalTerrestre(Sector sec) {
		int opcion = -1;

		while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
			String aux = JOptionPane.showInputDialog("Usted ha elegido Terrestre.\n\nPor favor, especifique qué tipo de terrestre:\n\n1-Carnínoro\n2-Omnivoro\n3-Herbívoro\n4-Volver");
			
			while(!ComprobarTipo.isNumero(aux))
			{
				aux = JOptionPane.showInputDialog("Usted ha elegido Terrestre.\n\nPor favor, especifique qué tipo de terrestre:\n\n1-Carnínoro\n2-Omnivoro\n3-Herbívoro\n4-Volver");
			}
			opcion = Integer.parseInt(aux);

			switch (opcion) {
			case 1:
				cargarAnimal(sec, 3);
				break;
			case 2:
				cargarAnimal(sec, 4);
				break;
			case 3:
				cargarAnimal(sec, 5);
				break;
			case 4:
				// hacer nada
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	/**
	 * Permite el ingreso de información general para los animales
	 * 
	 * 
	 */
	private void cargarAnimal(Sector sec, int opcion)
	{
		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		while(!ComprobarTipo.isAlfabetico(nombre))
		{
			nombre = JOptionPane.showInputDialog("Ingrese nombre");
		}
		
		double peso;
		String Speso = JOptionPane.showInputDialog("Ingrese peso");
		while(!ComprobarTipo.isNumero(Speso))
		{
			Speso = JOptionPane.showInputDialog("Ingrese peso");
		}
		peso = Double.parseDouble(Speso);
		
		String raza = JOptionPane.showInputDialog("Ingrese raza");
		while(!ComprobarTipo.isAlfabetico(raza))
		{
			raza = JOptionPane.showInputDialog("Ingrese raza");
		}
		
		String especie = JOptionPane.showInputDialog("Ingrese especie");
		while(!ComprobarTipo.isAlfabetico(especie))
		{
			especie = JOptionPane.showInputDialog("Ingrese especie");
		}
		
		String estadoSalud = "Activo";
		
		String sexo = JOptionPane.showInputDialog("Ingrese sexo");
		while(!ComprobarTipo.isAlfabetico(sexo))
		{
			sexo = JOptionPane.showInputDialog("Ingrese sexo");
		}
		
		Double alimentacionDiaria;
		String SalimentacionDiaria = JOptionPane.showInputDialog("Ingrese la cantidad de alimento diaria que consume");
		while(!ComprobarTipo.isNumero(SalimentacionDiaria))
		{
			SalimentacionDiaria = JOptionPane.showInputDialog("Ingrese la cantidad de alimento diaria que consume");
		}
		alimentacionDiaria = Double.parseDouble(SalimentacionDiaria);
		
		String dia = JOptionPane.showInputDialog("Ingrese el día");
		while(!ComprobarTipo.isNumero(dia))
		{
			dia = JOptionPane.showInputDialog("Ingrese el día");
		}
		
		String mes = JOptionPane.showInputDialog("Ingrese el mes en número");
		while(!ComprobarTipo.isNumero(mes))
		{
			mes = JOptionPane.showInputDialog("Ingrese el mes en número");
		}
		
		
		String ano = JOptionPane.showInputDialog("Ingrese el ano en número");
		while(!ComprobarTipo.isNumero(ano))
		{
			ano = JOptionPane.showInputDialog("Ingrese el ano en número");
		}
		Calendar calendario = new GregorianCalendar(Integer.parseInt(ano),Integer.parseInt(mes),Integer.parseInt(dia));
		Date fecha = new Date();
		calendario.setTime(fecha);

		switch (opcion) {
		case 1:
			Volador vol = new Volador(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fecha);
			
			String aux = JOptionPane.showInputDialog("Ingrese tipo de alimentacion(Carnivoro/Omnivoro/Herbivoro)");
			
			while(!ComprobarTipo.isAlfabetico(aux))
			{
				aux = JOptionPane.showInputDialog("Ingrese tipo de alimentacion(Carnivoro/Omnivoro/Herbivoro)");
			}
			vol.setTipoAlimentacion(aux);
			try {
				sec.agregarAnimal(vol);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			Acuatico acua = new Acuatico(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fecha);
			
			String aux1 = JOptionPane.showInputDialog("Ingrese tipo de alimentacion(Carnivoro/Omnivoro/Herbivoro)");
			
			while(!ComprobarTipo.isAlfabetico(aux1))
			{
				aux1 = JOptionPane.showInputDialog("Ingrese tipo de alimentacion(Carnivoro/Omnivoro/Herbivoro)");
			}
			acua.setTipoAlimentacion(aux1);
			try {
				sec.agregarAnimal(acua);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			Carnivoro car = new Carnivoro(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fecha);
			try {
				sec.agregarAnimal(car);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			Omnivoro omni = new Omnivoro(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fecha);
			try {
				sec.agregarAnimal(omni);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			Herbivoro her = new Herbivoro(nombre, peso, raza, especie, estadoSalud, sexo, alimentacionDiaria, fecha);
			try {
				sec.agregarAnimal(her);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			mostrarMensajeError();
			break;
		}
	}
	
	/**
	 * Método que permite la modificación de la planilla de un animal
	 * 
	 * @param Animal a modificar
	 */
	private void modificarAnimal(Animal ani)
	{
		int respuesta = -1;
		
		while(respuesta!=1 && respuesta!=2 &&respuesta!=3 && respuesta!=4 && respuesta!=5 && respuesta!=6 && respuesta!=6 && respuesta!=7 && respuesta!=8)
		{
			String aux = JOptionPane.showInputDialog("Ingrese el campo que quiere modificar\n\n1-Nombre\n2-Peso\n3-Raza\n4-Especie\n5-Sexo\n6-Alimentacion diaria\n7-Fecha de Nacimiento\n8-Volver");
			
			while(!ComprobarTipo.isNumero(aux))
			{
				aux = JOptionPane.showInputDialog("Ingrese el campo que quiere modificar\n\n1-Nombre\n2-Peso\n3-Raza\n4-Especie\n5-Sexo\n6-Alimentacion diaria\n7-Fecha de Nacimiento\n8-Volver");
			}
			
			respuesta = Integer.parseInt(aux);
			
			switch(respuesta)
			{
			case 1:
				String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nombre");
				
				while(!ComprobarTipo.isAlfabetico(nombreNuevo))
				{
					nombreNuevo = JOptionPane.showInputDialog("Ingrese el nombre");
				}
				ani.setNombre(nombreNuevo);
				break;
			case 2:
				String peso = JOptionPane.showInputDialog("Ingrese el peso");
				
				while(!ComprobarTipo.isNumero(peso))
				{
					peso = JOptionPane.showInputDialog("Ingrese el peso");
				}
				ani.setPeso(Double.parseDouble(peso));
				break;
			case 3:
				String raza = JOptionPane.showInputDialog("Ingrese la raza");
				
				while(!ComprobarTipo.isAlfabetico(raza))
				{
					raza = JOptionPane.showInputDialog("Ingrese la raza");
				}
				ani.setRaza(raza);
			case 4:
				String especie = JOptionPane.showInputDialog("Ingrese especie");
				
				while(!ComprobarTipo.isAlfabetico(especie))
				{
					especie = JOptionPane.showInputDialog("Ingrese especie");
				}
				ani.setEspecie(especie);
				break;
			case 5:
				String sexo = JOptionPane.showInputDialog("Ingrese el sexo");
				
				while(!ComprobarTipo.isAlfabetico(sexo))
				{
					sexo = JOptionPane.showInputDialog("Ingrese el sexo");
				}
				ani.setSexo(sexo);
				break;
			case 6:
				String alimentacion =JOptionPane.showInputDialog("Ingrese alimentación diaria");
				
				while(!ComprobarTipo.isNumero(alimentacion))
				{
					alimentacion = JOptionPane.showInputDialog("Ingrese alimentación diaria");
				}
				ani.setAlimentacionDiaria(Double.parseDouble(alimentacion));
				break;
			case 7:
				String dia = JOptionPane.showInputDialog("Ingrese el día");
				while(!ComprobarTipo.isNumero(dia))
				{
					dia = JOptionPane.showInputDialog("Ingrese el día");
				}
				
				String mes = JOptionPane.showInputDialog("Ingrese el mes en número");
				while(!ComprobarTipo.isNumero(mes))
				{
					mes = JOptionPane.showInputDialog("Ingrese el mes en número");
				}
				
				
				String ano = JOptionPane.showInputDialog("Ingrese el ano en número");
				while(!ComprobarTipo.isNumero(ano))
				{
					ano = JOptionPane.showInputDialog("Ingrese el ano en número");
				}
				
				Calendar calendario = new GregorianCalendar(Integer.parseInt(ano),Integer.parseInt(mes),Integer.parseInt(dia));
				Date fecha = new Date();
				calendario.setTime(fecha);
			case 8:
				//hacer nada
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	/**
	 * Método que permite la modificación de un sector específico
	 * 
	 * @param Sector a modificar
	 */
	public void modificarSector(Sector sec)
	{
		int respuesta = -1;
		
		while(respuesta==-1)
		{
			String aux = JOptionPane.showInputDialog("Ingrese el campo que quiere modificar\n1-Nombre\n2-Capacidad\n3-Volver");
			
			while(!ComprobarTipo.isNumero(aux))
			{
				aux = JOptionPane.showInputDialog("Ingrese el campo que quiere modificar\n1-Nombre\n2-Capacidad\n3-Volver");
			}
			respuesta = Integer.parseInt(aux);
			
			switch(respuesta)
			{
			case 1:
				String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
				
				while(!ComprobarTipo.isAlfabetico(nombre))
				{
					nombre = JOptionPane.showInputDialog("Ingrese el nombre");
				}
				sec.setNombreSector(nombre);
				break;
			case 2:
				String capacidad = JOptionPane.showInputDialog("Ingrese la capacidad");
				
				while(!ComprobarTipo.isNumero(capacidad))
				{
					capacidad = JOptionPane.showInputDialog("Ingrese la capacidad");
				}
				sec.setCapacidad(Integer.parseInt(capacidad));
				break;
			case 3:
				//hacer nada
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	/**
	 * Método que permite la modificación de un Habitat específico
	 * 
	 * @param Habitat a modificar
	 */
	public void modificarHabitat(Habitat hab)
	{
		int respuesta = -1;
		
		while(respuesta!=1)
		{
			String aux = JOptionPane.showInputDialog("Ingrese el campo que quiere modificar\n1-Temperatura\n2-Tipo\n3-Volver");
			
			while(!ComprobarTipo.isNumero(aux))
			{
				aux = JOptionPane.showInputDialog("Ingrese el campo que quiere modificar\n1-Temperatura\n2-Tipo\n3-Volver");
			}
			respuesta = Integer.parseInt(aux);
			
			switch(respuesta)
			{
			case 1:
				String temperatura = JOptionPane.showInputDialog("Ingrese la temperatura");
				
				while(!ComprobarTipo.isNumero(temperatura))
				{
					temperatura = JOptionPane.showInputDialog("Ingrese la temperatura");
				}
				hab.setTemperatura(Double.parseDouble(temperatura));
				break;
			case 2:
				String tipo = JOptionPane.showInputDialog("Ingrese el tipo");
				
				while(!ComprobarTipo.isAlfabetico(tipo))
				{
					tipo = JOptionPane.showInputDialog("Ingrese el tipo");
				}
				hab.setTipo(tipo);
				break;
			case 3:
				//volver
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	private void mostrarMensajeError() {
		JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, vuelva a intentarlo");
	}
	
	
	
	
	
	
	
	
	
	public void menuAdministracion()
	{
		int respuesta = -1;
		
		while(respuesta != 7)
		{
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(
					"Administracion\n\nIngrese una opcionn\n1-Agregar un Empleado\n2-Listar Empleados\n3-Eliminar un Empleado\n4-Modificar datos\n5-Contar empleados\n6-Empleado del mes\n7-Salir"));
			
			switch (respuesta)
			{
			case 1:
				ingresarEmpleado();
				break;
			case 2:
				System.out.println(administracion.listado());
				break;
			case 3:
				int legajo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
				Boolean el = administracion.eliminarPorLegajo(legajo);
				if(el)
				{
					System.out.println("Legajo n° " + legajo + " eliminado con exito!");
				}
				else
				{
					System.out.println("No se encontro el legajo n° " + legajo + " en el sistema...");
				}
				break;
			case 4:
				int rta = -1;
				
				while(rta != 8)
				{
					rta = Integer.parseInt(JOptionPane.showInputDialog("1-Modificar horario\n2-Modificar sueldo\n3-Modificar direccion\n4-Modificar telefono\n5-Dar de alta\n6-Dar de baja\n7-Agregar calificacion\n8-Salir"));
					switch(rta)
					{
						case 1: 
							modificarHorario();
							break;
						case 2:
							modificarSueldo();
							break;
						case 3:
							modificarDireccion();
							break;
						case 4:
							modificarTelefono();
							break;
						case 5:
							int legajo1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
							Empleado emp = administracion.buscarPorLegajo(legajo1);
							if(emp != null)
							{
								System.out.println(emp.toString());
								boolean b = administracion.darDeAlta(legajo1);
								if(b)
								{
									System.out.println("Modificacion exitosa!");
								}
								else
								{
									System.out.println("Error en la modificacion");
								}
							}
							else
							{
								System.out.println("No hay empleados con ese legajo...");
							}
							break;
						case 6:
							int legajo2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
							Empleado empp = administracion.buscarPorLegajo(legajo2);
							if(empp != null)
							{
								System.out.println(empp.toString());
								boolean b = administracion.darDeAlta(legajo2);
								if(b)
								{
									System.out.println("Modificacion exitosa!");
								}
								else
								{
									System.out.println("Error en la modificacion");
								}
							}
							else
							{
								System.out.println("No hay empleados con ese legajo...");
							}
							break;
						case 7:
							int legajo3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
							Empleado emppp = administracion.buscarPorLegajo(legajo3);
							if(emppp != null)
							{
								int calificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese calificacion del 1 al 10"));
								while(calificacion<0&&calificacion>10)
								{
									calificacion = Integer.parseInt(JOptionPane.showInputDialog("Error (fuera de rango)\nIngrese calificacion del 1 al 10"));
								}
								administracion.calificarAtencion(legajo3, calificacion);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "No existe el empleado...");
							}
							break;
						case 8:
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opción invalida");
							break;
					}
				}
		
			case 5:
				System.out.println("Cantidad de empleados: " + administracion.contar());
				break;
			case 6:
				Empleado e = administracion.buscarPorLegajo(administracion.buscarEmpleadoDelMes());
				System.out.println("Empleado del mes:\n " + e.toString() + "Calificacion total: " + administracion.calcularCalificacionTotal(administracion.buscarEmpleadoDelMes()));
				break;
			case 7:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción invalida");
				break;
			}
		}
	}
	
	
	public void modificarHorario()
	{
		int legajo1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
		Empleado emp = administracion.buscarPorLegajo(legajo1);
		if(emp!=null)
		{
			System.out.println(emp.toString());
			String horario = JOptionPane.showInputDialog("Ingrese nuevo horario");
			while(!ComprobarTipo.isAlfabetico(horario))
			{
				horario = JOptionPane.showInputDialog("Error (Recuerde que el sector son caracteres alfabeticos: Mañana, Tarde, Noche)\nIngrese horario");
			}
			boolean mh = administracion.modificarHorario(legajo1, horario);
			if(mh)
			{
				System.out.println("Modificacion exitosa!");
			}
			else
			{
				System.out.println("Error en la modificacion");
			}
		}
		else
		{
			System.out.println("No hay empleados con ese legajo...");
		}
	}
	
	
	public void modificarSueldo()
	{
		int legajo1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
		Empleado emp = administracion.buscarPorLegajo(legajo1);
		if(emp!=null)
		{
			System.out.println(emp.toString());
			String sueldo = JOptionPane.showInputDialog("Ingrese nuevo sueldo");
			while(!ComprobarTipo.isNumero(sueldo))
			{
				sueldo = JOptionPane.showInputDialog("Error (Recuerde ingresar numeros)\nIngrese nuevo sueldo");
			}
			double sueldoo = Double.parseDouble(sueldo);
			boolean ms = administracion.modificarSueldo(legajo1, sueldoo);
			if(ms)
			{
				System.out.println("Modificacion exitosa!");
			}
			else
			{
				System.out.println("Error en la modificacion");
			}
		}
		else
		{
			System.out.println("No hay empleados con ese legajo...");
		}
	}
	
	public void modificarDireccion()
	{
		int legajo1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
		Empleado emp = administracion.buscarPorLegajo(legajo1);
		if(emp!=null)
		{
			System.out.println(emp.toString());
			String direccion = JOptionPane.showInputDialog("Ingrese nueva direccion");
			while(!ComprobarTipo.isAlfaNum(direccion))
			{
				direccion = JOptionPane.showInputDialog("Error (Recuerde agregar solo caracteres alfanumericos)\nIngrese direccion");
			}
			boolean md = administracion.modificarDireccion(legajo1, direccion);
			if(md)
			{
				System.out.println("Modificacion exitosa!");
			}
			else
			{
				System.out.println("Error en la modificacion");
			}
		}
		else
		{
			System.out.println("No hay empleados con ese legajo...");
		}
	}
	
	public void modificarTelefono()
	{
		int legajo1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de legajo"));
		Empleado emp = administracion.buscarPorLegajo(legajo1);
		if(emp!=null)
		{
			System.out.println(emp.toString());
			String telefono = JOptionPane.showInputDialog("Ingrese nuevo telefono");
			while(!ComprobarTipo.isNumero(telefono))
			{
				telefono = JOptionPane.showInputDialog("Error (Recuerde ingresar numeros)\nIngrese nuevo telefono");
			}
			boolean mt = administracion.modificarTelefono(legajo1, telefono);
			if(mt)
			{
				System.out.println("Modificacion exitosa!");
			}
			else
			{
				System.out.println("Error en la modificacion");
			}
		}
		else
		{
			System.out.println("No hay empleados con ese legajo...");
		}
	}
	
	private Empleado ingresarDatos(int opcion)
	{
		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		while(!ComprobarTipo.isAlfabetico(nombre))
		{
			nombre = JOptionPane.showInputDialog("Error (recuerde agregar solo caracteres alfabeticos)\nIngrese nombre");
		}
		String apellido = JOptionPane.showInputDialog("Ingrese apellido");
		while(!ComprobarTipo.isAlfabetico(apellido))
		{
			apellido = JOptionPane.showInputDialog("Error (Recuerde agregar solo caracteres alfabeticos)\nIngrese apellido");
		}
		String dnii = JOptionPane.showInputDialog("Ingrese dni");
		while(!ComprobarTipo.isNumero(dnii))
		{
			dnii = JOptionPane.showInputDialog("Error (Recuerde agregar solo numeros)\nIngrese dni");
		}
		int dni = Integer.parseInt(dnii);
		String edadd = JOptionPane.showInputDialog("Ingrese edad");
		while(!ComprobarTipo.isNumero(edadd))
		{
			edadd = JOptionPane.showInputDialog("Error (Rcuerde agregar solo numeros)\nIngrese edad");
		}
		int edad = Integer.parseInt(edadd);
		String mail = JOptionPane.showInputDialog("Ingrese mail");
		while(!ComprobarTipo.isMail(mail))
		{
			mail = JOptionPane.showInputDialog("Error (Recuerde agregar solo caracteres alfanumericos con el @ incluido)\nIngrese mail");
		}
		String telefono = JOptionPane.showInputDialog("Ingrese telefono");
		while(!ComprobarTipo.isNumero(telefono))
		{
			telefono = JOptionPane.showInputDialog("Error (Rcuerde agregar solo numeros)\nIngrese telefono");
		}
		String direccion = JOptionPane.showInputDialog("Ingrese direccion");
		while(!ComprobarTipo.isAlfaNum(direccion))
		{
			direccion = JOptionPane.showInputDialog("Error (Recuerde agregar solo caracteres alfanumericos)\nIngrese direccion");
		}
		String horario = JOptionPane.showInputDialog("Ingrese horario");
		while(!ComprobarTipo.isAlfabetico(horario))
		{
			horario = JOptionPane.showInputDialog("Error (Recuerde que el sector son caracteres alfabeticos: Mañana, Tarde, Noche)\nIngrese horario");
		}
		char genero = JOptionPane.showInputDialog("Ingrese genero").charAt(0);
		while(genero!='M'&&genero!='F'&&genero!='m'&&genero!='f')
		{
			genero = JOptionPane.showInputDialog("Error (Recuerde agregar solo un caracter alfabetico)\nIngrese genero").charAt(0);
		}
		String cuil = JOptionPane.showInputDialog("Ingrese cuil");
		while(!ComprobarTipo.isNumero(cuil))
		{
			cuil = JOptionPane.showInputDialog("Error (Recuerde agregar solo numeros)\nIngrese cuil");
		}
		
		switch(opcion)
		{
		case 1:
			Adiestrador aux1 = new Adiestrador(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil, null, 0);
			return aux1;
		case 2:
			Administrativo aux2 = new Administrativo(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil, null);
			return aux2;
		case 3:
			Cuidador aux3 = new Cuidador(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil, 0);
			return aux3;
		case 4:
			Guia aux4 = new Guia(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil);
			return aux4;
		case 5:
			Limpieza aux5 = new Limpieza(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil, 0);
			return aux5;
		case 6:
			Seguridad aux6 = new Seguridad(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil, 0);
			return aux6;
		case 7:
			ServicioAlCliente aux7 = new ServicioAlCliente(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil, null);
			return aux7;
		case 8:
			Veterinario aux8 = new Veterinario(nombre, apellido, dni, edad, mail, telefono, direccion, horario, genero, cuil, null);
			return aux8;
		default:
			return null;
		}
	}
	
	private void ingresarEmpleado()
	{
		int tipoEmpleado = -1;
		
		while(tipoEmpleado!=1&&tipoEmpleado!=2&&tipoEmpleado!=3&&tipoEmpleado!=4&&tipoEmpleado!=5&&tipoEmpleado!=6&&tipoEmpleado!=7&&tipoEmpleado!=8)
		{
			tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(
					"Ingrese un tipo\n1-Adiestrador\n2-Administrativo\n3-Cuidador\n4-Guia\n5-Limpieza\n6-Seguridad\n7-Servicio al cliente\n8-Veterinario"));
			
			switch(tipoEmpleado)
			{
				case 1:
					Adiestrador aux1 = (Adiestrador) ingresarDatos(1);
					String especialidad = JOptionPane.showInputDialog("Ingrese especialidad de tipo de animales");
					while(!ComprobarTipo.isAlfabetico(especialidad))
					{
						especialidad = JOptionPane.showInputDialog("Error (Recuerde ingresar solo caracteres alfabeticos)\nIngrese especialidad de tipo de animales");
					}
					aux1.setEspecilidad(especialidad);
					String horass = JOptionPane.showInputDialog("Ingrese horas mensuales trabajadas");
					while(!ComprobarTipo.isNumero(horass))
					{
						horass = JOptionPane.showInputDialog("Error (Recuerde ingresar numeros)\nIngrese horas mensuales trabajadas");
					}
					int horas = Integer.parseInt(horass);
					aux1.setHorasTrabajadasMensuales(horas);
					aux1.setSueldo(aux1.calcularSueldo());
					administracion.addEmpleado(aux1);
					break;
				case 2:
					Administrativo aux2 = (Administrativo) ingresarDatos(2);
					String puesto = JOptionPane.showInputDialog("Ingrese puesto");
					while(!ComprobarTipo.isAlfabetico(puesto))
					{
						puesto = JOptionPane.showInputDialog("Error (Recuerde ingresar solo caracteres alfabeticos)\nIngrese puesto");
					}
					aux2.setPuesto(puesto);
					administracion.addEmpleado(aux2);
					break;
				case 3:
					Cuidador aux3 = (Cuidador) ingresarDatos(3);
					String sectorr = JOptionPane.showInputDialog("Ingrese sector");
					while(!ComprobarTipo.isNumero(sectorr))
					{
						sectorr = JOptionPane.showInputDialog("Error (Recuerde ingresar numeros)\nIngrese sector");
					}
					int sector = Integer.parseInt(sectorr);
					aux3.setSector(sector);
					administracion.addEmpleado(aux3);
					break;
				case 4:
					Guia aux4 = (Guia) ingresarDatos(4);
					char opcion;
					do
					{
						String idioma = JOptionPane.showInputDialog("Ingrese un idioma");
						while(!ComprobarTipo.isAlfabetico(idioma))
						{
							idioma = JOptionPane.showInputDialog("Error (Recuerde ingresar solo caracteres alfabeticos)\nIngrese un idioma");
						}
						aux4.addIdiomas(idioma);
						opcion = JOptionPane.showInputDialog("Desea agregar otro idioma?(S/N)").charAt(0);
					}while(opcion == 's');
					administracion.addEmpleado(aux4);
					break;
				case 5:
					Limpieza aux5 = (Limpieza) ingresarDatos(5);
					String horasss = JOptionPane.showInputDialog("Ingrese horas mensuales trabajadas");
					while(!ComprobarTipo.isNumero(horasss))
					{
						horasss = JOptionPane.showInputDialog("Error (Recuerde ingresar solo numeros)\nIngrese horas mensuales trabajadas");
					}
					int hhoras = Integer.parseInt(horasss);
					aux5.setHorasTrabajadasMensuales(hhoras);
					aux5.setSueldo(aux5.calcularSueldo());
					administracion.addEmpleado(aux5);
					break;
				case 6:
					Seguridad aux6 = (Seguridad) ingresarDatos(6);
					String sectorrr = JOptionPane.showInputDialog("Ingresar sector");
					while(!ComprobarTipo.isNumero(sectorrr))
					{
						sectorr = JOptionPane.showInputDialog("Error (Recuerde ingresar solo numeros)\nIngresar sector");
					}
					int ssector = Integer.parseInt(sectorrr);
					aux6.setSector(ssector);
					administracion.addEmpleado(aux6);
					break;
				case 7:
					ServicioAlCliente aux7 = (ServicioAlCliente) ingresarDatos(7);
					String area = JOptionPane.showInputDialog("Ingrese area de trabajo");
					while(!ComprobarTipo.isAlfabetico(area))
					{
						area = JOptionPane.showInputDialog("Error (Recuerde ingresar solo caracteres alfabeticos)\nIngrese area de trabajo");
					}
					aux7.setArea(area);
					administracion.addEmpleado(aux7);
					break;
				case 8:
					Veterinario aux8 = (Veterinario) ingresarDatos(8);
					String mat = JOptionPane.showInputDialog("Ingrese matricula");
					while(!ComprobarTipo.isNumero(mat))
					{
						mat = JOptionPane.showInputDialog("Error (Recuerde ingresar solo numeros)\nIngrese matricula");
					}
					aux8.setMatricula(mat);
					administracion.addEmpleado(aux8);
					break;
				default:
					mostrarMensajeError();
					break;
			}
		}
	}
}
