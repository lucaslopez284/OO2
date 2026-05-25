package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.impl.WallPostImpl;
import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {
	
	private static final Logger logger = Logger.getLogger(Ejercicio1Application.class.getName());

	
	
	public static void main(String[] args) throws SecurityException, IOException {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				logger.info("Empezo a correr la app");
				new WallPostUI();
			}
		});
	}

}
