package ar.edu.unlp.objetos.uno.ej26;

import java.time.LocalDate;
import java.time.Period;

public class Alquiler extends Bien {
	
	private LocalDate comienzoContrato;
	private LocalDate finContrato;
	private double costoMensual;
	
	public Alquiler(LocalDate comienzoContrato, LocalDate finContrato, double costoMensual) {
		super(0.9);
		this.comienzoContrato = comienzoContrato;
		this.finContrato = finContrato;
		this.costoMensual = costoMensual;
	}

	public LocalDate getComienzoContrato() {
		return comienzoContrato;
	}

	public LocalDate getFinContrato() {
		return finContrato;
	}
	
	public double getCostoMensual() {
		return costoMensual;
	}

	public double valor() {
		return this.getCostoMensual() * Period.between(this.getComienzoContrato(), this.getFinContrato()).getMonths();
	}

}
