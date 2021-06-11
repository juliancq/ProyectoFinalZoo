package model;

import java.util.ArrayList;

public class Habitat {
	
	private double temperatura;
	private String tipo;
	private ArrayList<Sector> animales;
	
	public Habitat() 
	{
		temperatura = 0;
		tipo = "No especificado";
		animales = new ArrayList<>();
	}
	
	public Habitat(double temperatura, String tipo)
	{
		this.temperatura = temperatura;
		this.tipo = tipo;
		animales = new ArrayList<>();
	}
	
	
	public double getTemperatura() {
		return temperatura;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		
		return "HABITAT = " + getTipo();
	}
}
