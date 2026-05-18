package ar.edu.unlp.objetos.uno.ej26;

public abstract class Bien {
	
	protected double liquidez;

	public Bien(double liquidez) {
		super();
		this.liquidez = liquidez;
	}
	
	public abstract double valor();
	
	public double valorPrendario() {
		return this.liquidez * this.valor();
	}

}
