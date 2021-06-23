package sistemaEmpleados;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado implements Serializable
{
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private String mail;
	private Date fechaDeContratacion;
	private String telefono;
	private String direccion;
	private int legajo = 0;
	private String horario;
	private char genero;
	private String cuil;
	private boolean alta = false;
	private int calificacion[] = new int[100];
	private int posActual = 0;
	private double sueldo = 0;
	
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String apellido, int dni, int edad, String mail,
			String telefono, String direccion, String horario, char genero, String cuil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.mail = mail;
		this.fechaDeContratacion = generarFechaActual();
		this.telefono = telefono;
		this.direccion = direccion;
		this.horario = horario;
		this.genero = genero;
		this.cuil = cuil;
	}

	/**
	 * Genera automaticamente la fecha del dia actual
	 * y la devuelve.
	 */
	public Date generarFechaActual()
    {
        Calendar calendario = new GregorianCalendar();
        Date fecha = new Date();
        calendario.setTime(fecha);

        return fecha;
    }
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public int getDni() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

	public String getMail() {
		return mail;
	}

	public Date getFechaDeContratacion() {
		return fechaDeContratacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getLegajo() {
		return legajo;
	}

	public String getHorario() {
		return horario;
	}

	public char getGenero() {
		return genero;
	}

	public String getCuil() {
		return cuil;
	}

	public boolean getAlta() {
		return alta;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	/**
	 * Cambia el estado del atributo alta en true
	 */
	public void darAlta() {
		alta = true;
	}
	
	/**
	 * cambia el estado del atributo alta en false
	 */
	public void darBaja() {
		alta = false;
	}
	
	/**
	 * Agrega un numero entero al arreglo de calificaciones del empleado
	 * @param num
	 */
	public void agregarCalificacion(int num)
	{
		calificacion[posActual] = num;
		posActual++;
	}
	
	/**
	 * suma el total del arreglo de calificaciones, lo divide
	 * por la cantidad total de calificaciones y devuelve el promedio.
	 */
	public double calcularCalificacion()
	{
		int cant = 0;
		double total = 0;
		for(int i=0;i<posActual;i++)
		{
			cant++;
			total = total + calificacion[i];
		}
		return total/cant;
	}
	
	@Override
	public String toString() {
		return "\nEmpleado:" + "\n-------------------------\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nDni: " + getDni()
				+ "\nEdad: " + getEdad() + "\nMail: " + getMail()
				+ "\nFecha de contratacion: " + getFechaDeContratacion() + "\nTelefono: " + getTelefono()
				+ "\nDireccion: " + getDireccion() + "\nLegajo: " + getLegajo() + "\nHorario: " + getHorario() + "\nGenero: " + getGenero() + "\nSueldo: $" + getSueldo() + "\nCuil: " + getCuil();
	}
	
}
