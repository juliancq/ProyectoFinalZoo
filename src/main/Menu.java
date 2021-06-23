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
				menuAdministracion();
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
		int respuesta = -1;
		
		while(respuesta != 4)
		{
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(
					"Administracion\n\nIngrese una opcionn\n1-Agregar un Empleado\n2-Listar Empleados\n3-Eliminar un Empleado\n4-Salir"));
			
			switch (respuesta)
			{
			case 1:
				ingresarEmpleado();
			}
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
					Adiestrador aux1 = (Adiestrador) ingresarDatos();
					aux1.setEspecilidad(JOptionPane.showInputDialog("Ingrese especialidad de tipo de animales"));
					aux1.setHorasTrabajadasMensuales(Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas mensuales trabajadas")));
					administracion.addEmpleado(aux1);
				case 2:
					Administrativo aux2 = (Administrativo) ingresarDatos();
					aux2.setPuesto(JOptionPane.showInputDialog("Ingrese puesto"));
					administracion.addEmpleado(aux2);
				case 3:
					Cuidador aux3 = (Cuidador) ingresarDatos();
					aux3.setSector(Integer.parseInt(JOptionPane.showInputDialog("Ingrese sector")));
					administracion.addEmpleado(aux3);
				case 4:
					Guia aux4 = (Guia) ingresarDatos();
					char opcion;
					do
					{
						aux4.addIdiomas(JOptionPane.showInputDialog("Ingrese un idioma"));
						opcion = JOptionPane.showInputDialog("Desea agregar otro idioma?(S/N)").charAt(0);
					}while(opcion == 's');
					administracion.addEmpleado(aux4);
				case 5:
					Limpieza aux5 = (Limpieza) ingresarDatos();
					aux5.setHorasTrabajadasMensuales(Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas mensuales trabajadas")));
					administracion.addEmpleado(aux5);
				case 6:
					Seguridad aux6 = (Seguridad) ingresarDatos();
					aux6.setSector(Integer.parseInt(JOptionPane.showInputDialog("Ingresar sector")));
					administracion.addEmpleado(aux6);
				case 7:
					ServicioAlCliente aux7 = (ServicioAlCliente) ingresarDatos();
					aux7.setArea(JOptionPane.showInputDialog("Ingrese area de trabajo"));
					administracion.addEmpleado(aux7);
				case 8:
					Veterinario aux8 = (Veterinario) ingresarDatos();
					aux8.setMatricula(JOptionPane.showInputDialog("Ingrese matricula"));
					administracion.addEmpleado(aux8);
				default:
					mostrarMensajeError();
					break;
			}
		}
	}
	
	private Empleado ingresarDatos()
	{
		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		String apellido = JOptionPane.showInputDialog("Ingrese apellido");
		int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni"));
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
		String mail = JOptionPane.showInputDialog("Ingrese mail");
		String telefono = JOptionPane.showInputDialog("Ingrese telefono");
		String direccion = JOptionPane.showInputDialog("Ingrese direccion");
		String horario = JOptionPane.showInputDialog("Ingrese horario");
		char genero = JOptionPane.showInputDialog("Ingrese genero").charAt(0);
		String cuil = JOptionPane.showInputDialog("Ingrese cuil");
		
		Empleado aux = new Empleado(nombre,apellido,dni,edad,mail,telefono,direccion,horario,genero,cuil);
		
		return aux;
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
		
		while(tipoSector!=1&&tipoSector!=2&&tipoSector!=3&&tipoSector!=4)
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
			case 4:
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
