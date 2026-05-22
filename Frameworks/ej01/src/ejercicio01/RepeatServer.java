package ejercicio01;

import java.io.PrintWriter;
import java.util.Collections;

public class RepeatServer extends SingleThreadTCPServer {
	
	private String resultadoServidor = "";

	@Override
	public void handleMessage(String message, PrintWriter out) {
		out.println(this.resultadoServidor);
		
	}
	
	public void setResultado(String resultado) {
		this.resultadoServidor = resultado;
	}
	
	protected static boolean puedePasarANumero(String numero) {
		try {
	        Integer.parseInt(numero); 
	        return true;
	    } catch (NumberFormatException e) {
	        System.err.println("Error: El segundo argumento debe ser un número.");
	        return false; 
	    }
	}
	
	protected static boolean noCumpleValidacionesDeVacio(String[] args) {
		return args[0] == null || args[0].isEmpty();
	}
	
	protected static boolean cumpleconCantidadDeParametros(String[] args) {
		if (args.length < 2) {
            return false;
        }
		return true;
	}
	
	protected static boolean esMayorQueCero(String numero) {
		int cantidad = Integer.parseInt(numero);
        if (cantidad < 1) {
            return false;
        }
        return true;
	}
	
	protected static String getDelimiter(String[] args) {
		if (args.length < 3 || args[2] == null || args[2].isEmpty()) {
            return " ";
        }
        return args[2];
	}
	
	public static void main(String[] args) {
		
		if(!cumpleconCantidadDeParametros(args)) {
			return;
		}
		
		if (noCumpleValidacionesDeVacio(args)) {
			return;
		}
		
		if(!puedePasarANumero(args[1])) {
			return;
		}
		
		if(!esMayorQueCero(args[1])) {
			return;
		}
		
		String texto = args[0];
		String delimiter = getDelimiter(args);
		int cantidad = Integer.parseInt(args[1]);
		
		String resultado = String.join(delimiter, Collections.nCopies(cantidad, texto));
		
		RepeatServer server = new RepeatServer();
		server.setResultado(resultado); 
		server.startLoop(args, resultado);
        
    }

}
