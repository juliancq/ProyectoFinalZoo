package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import manejoArchivos.PersistenciaZoo;
import sistemaAnimales.Acuatico;
import sistemaAnimales.Habitat;
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
		zoo = per.leerZoo();
		administracion = new ListaEmpleados();
	}
	
	public void menuZoologico()
	{
		int respuesta = -1;

		while (respuesta != 3)
		{
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(
					"Men� Principal\n\nIngrese una opci�n \n1-Administraci�n.\n2-Zool�gico.\n3-Salir"));

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
				JOptionPane.showMessageDialog(null, "Opci�n invalida");
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
					"Zool�gico\n\nIngrese una opci�n\n1-Agregar H�bitat\n2-Listar H�bitats\n3-Ingresar a H�bitat\n4-Salir"));

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
						"\n�En qu� H�bitat desea ingresar?\n"));
				
				Habitat entrar = zoo.buscarHabitatPorNombre(respuestaHabitat);
				menuSector(entrar);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opci�n invalida");
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
					"Habitat\n\nIngrese una opci�n\n1-Agregar Sector\n2-Listar Sectores\n3-Ingresar a Sector\n4-Salir"));

			switch (respuesta)
			{
			case 1:
				//hab.agregarSector(ingresarInformacionSector());
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
				JOptionPane.showMessageDialog(null, "Opci�n invalida");
				break;
			}
		}
	}

	public void menuAdministracion()
	{

	}
	
	private Habitat ingresarInformacionHabitat()
	{
		String tipo = JOptionPane.showInputDialog("Ingrese el tipo de H�bitat(Sabana, Selva, Marino, etc..)");
		double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese temperatura media del H�bitat"));
		
		Habitat aux = new Habitat(temperatura,tipo);
		return aux;
	}
	/*
	private Sector ingresarInformacionSector()
	{
		String nombreSector = JOptionPane.showInputDialog("Ingrese el nombre del Sector");
		int capacidadSector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese capacidad total del Sector"));
		int tipoSector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de animales que este sector contendr�\n\n1-Voladores\n2-Acu�ticos\n3-Terrestres"));
		
		Sector retorno = null;
		
		while(tipoSector!=1||tipoSector!=2||tipoSector!=3)
		{
			if(tipoSector==1)
			{
				retorno = new Sector<Volador>();
			}
		}
		
	}
	*/
}
