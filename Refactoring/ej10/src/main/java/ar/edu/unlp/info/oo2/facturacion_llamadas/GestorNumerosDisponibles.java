package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private ObtenerNumerosStrategy estrategia = new UltimoStrategy();

	public SortedSet<String> getLineas() {
		return lineas;
	}

	public String obtenerNumeroLibre() {
		return this.estrategia.obtenerNumeroLibre(lineas);
	}

	public void cambiarTipoGenerador(ObtenerNumerosStrategy estrategia) {
		this.estrategia = estrategia;
	}
}
