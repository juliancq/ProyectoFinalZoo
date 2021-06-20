package manejoArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JsonUtiles {

	public static void grabar(JSONObject jsonObject, String nombreArchivo)
	{
		try
		{
			FileWriter file = new FileWriter(nombreArchivo);
			file.write(jsonObject.toString());
			file.flush();
			file.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String leer(String nombreArchivo)
	{
		String contenido = "";
		
		try
		{
			contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
		}
		catch(IOException e)
		{
			System.out.println("Error aca, no se que onda");
			//e.printStackTrace();
		}
		
		return contenido;
	}
}
