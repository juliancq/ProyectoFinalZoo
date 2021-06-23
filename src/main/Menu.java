package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
import sistemaEmpleados.ListaEmpleados;

public class Menu {

	private Zoologico zoo;
	private ListaEmpleados administracion;
	
	public Menu()
	{
		PersistenciaZoo per = new PersistenciaZoo();
		zoo = new Zoologico();
		administracion = new ListaEmpleados();
	}
	
	public void menuZoologico()
	{
		int respuesta = -1;

		while (respuesta != 3)
		{
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(
					"Menú Principal\n\nIngrese una opción \n1-Administración.\n2-Zoológico.\n3-Salir"));

			switch (respuesta)
			{
			case 1:
				// asd
				break;
			case 2:
				menuHabitat();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción invalida");
				break;
			}
		}
	}

	public void menuHabitat()
	{
		int respuesta = -1;

		while (respuesta != 4)
		{
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(
					"Zoológico\n\nIngrese una opción\n1-Agregar Hábitat\n2-Listar Hábitats\n3-Ingresar a Hábitat\n4-Salir"));

			switch (respuesta)
			{
			case 1:
				zoo.agregarHabitat(ingresarInformacionHabitat());
				break;
			case 2:
				System.out.println(zoo.toString());
				break;
			case 3:
				String respuestaHabitat = (JOptionPane.showInputDialog(
						"\n¿En qué Hábitat desea ingresar?\n"));
				
				Habitat entrar = zoo.buscarHabitatPorNombre(respuestaHabitat);
				
				menuSector(entrar);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}
	
	public void menuSector(Habitat hab)
	{
		int respuesta = -1;

		while (respuesta != 4)
		{
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(
					"Habitat\n\nIngrese una opción\n1-Agregar Sector\n2-Listar Sectores\n3-Ingresar a Sector\n4-Salir"));

			switch (respuesta)
			{
			case 1:
				ingresarInformacionSector(hab);
				break;
			case 2:
				System.out.println(hab.toString());
				break;
			case 3:
				
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				break;
			default:
				mostrarMensajeError();
				break;
			}
		}
	}

	public void menuAdministracion()
	{

	}
	
	private Habitat ingresarInformacionHabitat()
	{
		String tipo = JOptionPane.showInputDialog("Ingrese el tipo de Hábitat(Sabana, Selva, Marino, etc..)");
		double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese temperatura media del Hábitat"));
		
		Habitat aux = new Habitat(temperatura,tipo);
		return aux;
	}
	
	private void ingresarInformacionSector(Habitat hab)
	{
		String nombreSector = JOptionPane.showInputDialog("Ingrese el nombre del Sector");
		int capacidadSector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese capacidad total del Sector"));

		int tipoSector = -1;
		
		while(tipoSector!=1||tipoSector!=2||tipoSector!=3||tipoSector!=4)
		{
			tipoSector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de animales que este sector contendrá\n\n1-Voladores\n2-Acuáticos\n3-Terrestres\n4-Volver"));
			
			switch(tipoSector)
			{
			case 1:
				hab.agregarSector(new Sector<Volador>(nombreSector,capacidadSector));
				break;
			case 2:
				hab.agregarSector(new Sector<Acuatico>(nombreSector,capacidadSector));
				break;
			case 3:
				ingresarTipoAlimentacion(hab,nombreSector,capacidadSector);
				break;
			default:
				mostrarMensajeError();
				break;
			}
			
		}
		
	}
	
	//Me quede trabado en esta funcion de mierda que anda como el culo. Ya probé de todo. Sé que se está agregando bien porque si haces toString lo comprobas. Pero no entiendo porque pija no sale del while
	private void ingresarTipoAlimentacion(Habitat hab, String nombreSector, int capacidad)
	{
		int opcion = -1;
		
		
		while(opcion==-1)
		{
			int contador = 0;
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Usted ha elegido Terrestes.\n\nPor favor, especifique qué tipo de terrestre:\n\n1-Carnínoro\n2-Omnivoro\n3-Herbívoro\n4-Volver"));
			
			switch(opcion)
			{
			case 1:
				hab.agregarSector(new Sector<Carnivoro>(nombreSector,capacidad));
				break;
			case 2:
				hab.agregarSector(new Sector<Omnivoro>(nombreSector,capacidad));
				break;
			case 3:
				hab.agregarSector(new Sector<Herbivoro>(nombreSector,capacidad));
				break;
			case 4:
				//hacer nada
				break;
			default:
				opcion=-1;
				mostrarMensajeError();
				break;
			}
		}
	}
	
	
	private void mostrarMensajeError()
	{
		JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, vuelva a intentarlo");
	}
	
}
