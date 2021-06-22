package comprobacionTipos;

public class ComprobarTipo {

	public static boolean isAlfabetico(String cadena) {
	    for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si no está entre a y z, ni entre A y Z,
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean isMail(String cadena) {
	    boolean rta = true;
		for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si no está entre a y z, ni entre A y Z, ni @ . o _
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == '@') || (c == '.') || (c == '_'))) {
	        	
	            rta = false;
	        }
	    }
		
	    return (rta && cadena.contains("@") && cadena.contains("."));
	}
	
	public static boolean isNumero(String cadena) {
		
	    for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si no esta entre 0 y 9
	        if (!(c >= '0' && c <= '9')) {
	            return false;
	        }
	    }
	    return true;
		
		
	}
	
	public static boolean isAlfaNum(String cadena) {
		
	    for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si no está entre a y z, ni entre A y Z, ni es nro, ni espacio
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == ' '))) {
	            return false;
	        }
	    }
	    return true;
		
	}
	
}
