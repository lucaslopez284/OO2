package ejercicio01;

import java.io.PrintWriter;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordServer extends SingleThreadTCPServer {
	private String resultadoServidor = "";

	@Override
	public void handleMessage(String message, PrintWriter out) {
		out.println(this.resultadoServidor);
	}
	
	public void setResultado(String resultado) {
		this.resultadoServidor = resultado;
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
	
	
	public static void main(String[] args) {
		
		if (args.length < 3 || args[0].length() < 6 || args[1].length() < 1 || args[2].length() < 1){
			return;
		}
		String cadenaChar = args[0];
		String cadenaNum = args[1];
		String cadenaEspChar = args[2];
		
        String cadenaAlt = obtenerCaracteresAleatorios(cadenaChar, 6);
        char numero = obtenerCaracter(cadenaNum);
        char caracterEsp = obtenerCaracter(cadenaEspChar);
        
        String passwordMezclado = mezclarTodo(cadenaAlt, numero, caracterEsp);
        new PasswordServer().startLoop(args, passwordMezclado);
        
        PasswordServer server = new PasswordServer();
		server.setResultado(passwordMezclado); 
		server.startLoop(args, passwordMezclado);
    }

}
