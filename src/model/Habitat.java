package model;

import java.util.ArrayList;

public class Habitat {
	
	private float temperatura;
	private String tipo;
	private ArrayList<String> animales;
	
	public Habitat() {
		// TODO Auto-generated constructor stub
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
