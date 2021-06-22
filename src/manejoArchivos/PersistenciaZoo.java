package manejoArchivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sistemaAnimales.Zoologico;

/**
 * Esta clase aporta metodos estaticos para generar persistencia de objetos tipo Zoologico en archivos binarios
 *
 */
public class PersistenciaZoo {

public static void guardarZoo(Zoologico zoo) {
		
		try {
			
			FileOutputStream fOut = new FileOutputStream("zoologico.dat");
			try {
				
				ObjectOutputStream oOut = new ObjectOutputStream(fOut);
				
				oOut.writeObject(zoo);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Zoologico leerZoo() {
		
		Zoologico zoo = null;
		
		try {
			FileInputStream fIn = new FileInputStream("zoologico.dat");
			
			try {
				
				ObjectInputStream oIn = new ObjectInputStream(fIn);
				try {
					zoo = (Zoologico) oIn.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return zoo;
	}
	
	
}
