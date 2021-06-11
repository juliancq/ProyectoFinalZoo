package model;

import java.util.ArrayList;

public class Habitat {
	
	private float temperatura;
	private String tipo;
	private ArrayList<String> animales;
	
	public Habitat(float temperatura, String tipo)
	{
		this.temperatura = temperatura;
		this.tipo = tipo;
		animales = new ArrayList<>();
	}
	
	public Habitat() 
	{
		temperatura = 0;
		tipo = "No especificado";
		animales = new ArrayList<>();
	}
	
	public float getTemperatura() {
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
