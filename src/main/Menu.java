package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistemaAnimales.Habitat;
import sistemaAnimales.Zoologico;

public class Menu {

	private Zoologico zoo;
	
	public Menu()
	{
		zoo = new Zoologico();
	}
	
	public void menu1()
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
				menuZoologico();
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

	public void menuZoologico()
	{
		int respuesta = -1;

		while (respuesta != 4)
		{
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(
					"Zool�gico\n\nIngrese una opci�n\n1-Agregar h�bitat\n2-Listar h�bitats\n3-Ingresar a h�bitat\n4-Salir"));

			switch (respuesta)
			{
			case 1:
				zoo.agregarHabitat(ingresarInformacionHabitat());
				break;
			case 2:
				// sda
				break;
			case 3:
				// das
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
}
