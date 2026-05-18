package ar.edu.unlp.objetos.uno.ej26;

public class Inmueble extends Bien {
	
	private String direccion;
	private double superficie;
	private double costoM2;
	
	public Inmueble(String direccion, double superficie, double costoM2) {
		super(0.2);
		this.direccion = direccion;
		this.superficie = superficie;
		this.costoM2 = costoM2;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public double getCostoM2() {
		return costoM2;
	}

	public double valor() {
		return this.getSuperficie() * this.getCostoM2();
	}

}
