package tcp.server.reply;

import java.io.PrintWriter;
import java.util.*;

public class PasswordServer implements IMessageHandler {

	@Override
	public void handleMessage(String message, PrintWriter out) {
		out.println(retornarPassword(message));

	}
	
	public static String obtenerCaracteresAleatorios(String fuente, int cantidad) {
        Random random = new Random();
        StringBuilder constructor = new StringBuilder(cantidad);

        for (int i = 0; i < cantidad; i++) {
            // Genera un índice aleatorio entre 0 y la longitud del string - 1
            int indiceAleatorio = random.nextInt(fuente.length());
            
            // Toma el carácter de ese índice y lo añade al resultado
            constructor.append(fuente.charAt(indiceAleatorio));
        }

        return constructor.toString();
    }
	
	public static char obtenerCaracter(String cadena) {
		Random random = new Random();
        int indiceAleatorio = random.nextInt(cadena.length());
        return cadena.charAt(indiceAleatorio);
	}
	
	public static String mezclarTodo(String letras, char numero, char especial) {
        List<Character> caracteres = new ArrayList<>();
        
        // Agrega los caracteres del String
        for (char c : letras.toCharArray()) {
            caracteres.add(c);
        }
        // Agrega los caracteres individuales
        caracteres.add(numero);
        caracteres.add(especial);
        
        // Desordena la lista de forma aleatoria
        Collections.shuffle(caracteres);
        
        // Reconstruye el String final ya mezclado
        StringBuilder resultado = new StringBuilder(caracteres.size());
        for (char c : caracteres) {
            resultado.append(c);
        }
        return resultado.toString();
    }
	
	public String retornarPassword(String mensaje) {
		String[] params = mensaje.split(",");
		String letras, numeros, especiales;
		if (params.length == 3) {
		    letras = params[0];
		    numeros = params[1];
		    especiales = params[2];
		} else {
		    return "";
		}
		
		String cadenaAlt = obtenerCaracteresAleatorios(letras, 6);
        char numero = obtenerCaracter(numeros);
        char caracterEsp = obtenerCaracter(especiales);
        
        return mezclarTodo(cadenaAlt, numero, caracterEsp);
	}

}
