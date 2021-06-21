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
					"Menú Principal\n\nIngrese una opción \n1-Administración.\n2-Zoológico.\n3-Salir"));

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
				JOptionPane.showMessageDialog(null, "Opción invalida");
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
					"Zoológico\n\nIngrese una opción\n1-Agregar hábitat\n2-Listar hábitats\n3-Ingresar a hábitat\n4-Salir"));

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
				JOptionPane.showMessageDialog(null, "Opción invalida");
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
}
