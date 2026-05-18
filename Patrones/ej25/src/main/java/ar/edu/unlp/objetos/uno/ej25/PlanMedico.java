package ar.edu.unlp.objetos.uno.ej25;

import java.time.LocalDate;

public abstract class PlanMedico {
	
	private LocalDate fechaContratacion;	

	public PlanMedico() {
		super();
		this.fechaContratacion = LocalDate.now();
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
	
	public int limitePrestaciones() {
		return 0;
	}
	
	public abstract double montoFijo(Afiliado unAfiliado);
	public abstract double grupoFamiliar(Afiliado unAfiliado);
	public abstract double coberturaViajera(Afiliado unAfiliado);
	public abstract double seguroInternacion(Afiliado unAfiliado);
	
	public double costoMensual(Afiliado unAfiliado) {
		return this.montoFijo(unAfiliado) +
				this.grupoFamiliar(unAfiliado) +
				this.coberturaViajera(unAfiliado) +
				this.seguroInternacion(unAfiliado);
	}
	
	
}
