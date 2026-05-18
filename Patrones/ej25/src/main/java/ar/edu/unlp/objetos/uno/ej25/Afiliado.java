package ar.edu.unlp.objetos.uno.ej25;

import java.time.LocalDate;
import java.util.List;

public class Afiliado {
	
	private String nombre;
	private int familiaresACargo;
	private double salario;
	private LocalDate fechaNacimiento;
	private CoseguroInterfaz coseguro;
	private List<PlanMedico> viejos;
	private PlanMedico plan;
	
	
	
	
	public Afiliado(String nombre, int familiaresACargo, double salario, LocalDate fechaNacimiento, CoseguroInterfaz coseguro,
			List<PlanMedico> viejos, PlanMedico plan) {
		super();
		this.nombre = nombre;
		this.familiaresACargo = familiaresACargo;
		this.salario = salario;
		this.fechaNacimiento = fechaNacimiento;
		this.coseguro = coseguro;
		this.viejos = viejos;
		this.plan = plan;
	}
	
	public Afiliado(String nombre, int familiaresACargo, double salario, LocalDate fechaNacimiento,
			List<PlanMedico> viejos, PlanMedico plan) {
		super();
		this.nombre = nombre;
		this.familiaresACargo = familiaresACargo;
		this.salario = salario;
		this.fechaNacimiento = fechaNacimiento;
		this.coseguro = new CoseguroNull();
		this.viejos = viejos;
		this.plan = plan;
	}
	
	public double calcularMonto() {
		return this.plan.costoMensual(this);
	}

	public void setPlanMedico(PlanMedico plan) {
		this.plan = plan;
	}
	
	public int getFamiliaresACargo() {
		return familiaresACargo;
	}
	
	public boolean tieneCoseguro() {
		return false;
	}
	
	public double getDescuentoCoseguro() {
		return this.coseguro.getDescuento();
	}

	public double getSalario() {
		return salario;
	}
	
	public double getMontoCoberturaViajes() {
		return this.coseguro.getMontoCoberturaViajes();
	}
	
	public int getAntiguedadCoseguro() {
		return this.coseguro.getAntiguedad();
	}

	public PlanMedico getPlan() {
		return plan;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
