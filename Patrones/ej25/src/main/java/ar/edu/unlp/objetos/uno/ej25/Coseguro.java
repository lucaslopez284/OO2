package ar.edu.unlp.objetos.uno.ej25;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Coseguro implements CoseguroInterfaz {
	
	private String nombre;
	private double descuento;
	private LocalDate fechaIngreso;
	private double montoCoberturaViajes;
	
	
	
	
	public Coseguro(String nombre, double descuento, LocalDate fechaIngreso, double montoCoberturaViajes) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
		this.fechaIngreso = fechaIngreso;
		this.montoCoberturaViajes = montoCoberturaViajes;
	}

	public double getDescuento() {
		return descuento;
	}
	
	public int getAntiguedad() {
		return Period.between(fechaIngreso, LocalDate.now()).getYears();
	}
	public double getMontoCoberturaViajes() {
		return montoCoberturaViajes;
	}
	
	
	

}
