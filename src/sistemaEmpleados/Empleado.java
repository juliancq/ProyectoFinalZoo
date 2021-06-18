package sistemaEmpleados;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Empleado 
{
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private double sueldo;
	private String mail;
	private Date fechaDeContratacion;
	private long telefono;
	private String direccion;
	private int legajo;
	private String horario;
	private char genero;
	private long cuil;
	private boolean alta = false;
	private boolean empDelMes = false;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String apellido, int dni, int edad, double sueldo, String mail,
			long telefono, String direccion, int legajo, String horario, char genero, long cuil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.sueldo = sueldo;
		this.mail = mail;
		this.fechaDeContratacion = generarFechaActual();
		this.telefono = telefono;
		this.direccion = direccion;
		this.legajo = legajo;
		this.horario = horario;
		this.genero = genero;
		this.cuil = cuil;
	}

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

	public double getSueldo() {
		return sueldo;
	}

	public String getMail() {
		return mail;
	}

	public Date getFechaDeContratacion() {
		return fechaDeContratacion;
	}

	public long getTelefono() {
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

	public long getCuil() {
		return cuil;
	}

	public boolean getAlta() {
		return alta;
	}
	
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public void darAlta() {
		alta = true;
	}
	
	public void darBaja() {
		alta = false;
	}
	
	public void altaEmpDelMes()
	{
		empDelMes = true;
	}
	
	public void bajaEmpDelMes()
	{
		empDelMes = false;
	}
	
	@Override
	public String toString() {
		return "Empleado:" + "\n-------------------------\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nDni: " + getDni()
				+ "\nEdad: " + getEdad() + "\nSueldo: $" + getSueldo() + "\nMail: " + getMail()
				+ "\nFecha de contratacion: " + getFechaDeContratacion() + "\nTelefono: " + getTelefono()
				+ "\nDireccion: " + getDireccion() + "\nLegajo: " + getLegajo() + "\nHorario: " + getHorario() + "\nGenero: " + getGenero() + "\nCuil: " + getCuil();
	}
	

	
	
	public abstract double calcularSueldo();
	
	
}
