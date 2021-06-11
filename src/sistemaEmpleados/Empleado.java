package sistemaEmpleados;

import java.util.Date;

public abstract class Empleado 
{
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private double sueldo;
	private String mail;
	private Date fechaDeContratacion;
	private int telefono;
	private String direccion;
	private int legajo;
	private String horario;
	private char genero;
	private int cuil;
	private boolean alta = false;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String apellido, int dni, int edad, double sueldo, String mail, Date fechaDeContratacion,
			int telefono, String direccion, int legajo, String horario, char genero, int cuil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.sueldo = sueldo;
		this.mail = mail;
		this.fechaDeContratacion = fechaDeContratacion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.legajo = legajo;
		this.horario = horario;
		this.genero = genero;
		this.cuil = cuil;
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

	public int getTelefono() {
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

	public int getCuil() {
		return cuil;
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
	
	@Override
	public String toString() {
		return "Empleado [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
				+ ", getEdad()=" + getEdad() + ", getSueldo()=" + getSueldo() + ", getMail()=" + getMail()
				+ ", getFechaDeContratacion()=" + getFechaDeContratacion() + ", getTelefono()=" + getTelefono()
				+ ", getDireccion()=" + getDireccion() + ", getLegajo()=" + getLegajo() + ", getArea()=" + ", getHorario()=" + getHorario() + ", getGenero()=" + getGenero() + ", getCuil()=" + getCuil() + "]";
	}
	
	public abstract double calcularSueldo();
	
	public abstract boolean darDeAlta();
	
	public abstract boolean darDeBaja();
	
	
	
	
}
