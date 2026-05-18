package ar.edu.unlp.objetos.uno.ej26;

import java.time.Year;

public class Automovil extends Bien {
	
	private int modelo;
	private double kilometraje;
	private double costo0km;
	
	
	
	public Automovil(int modelo, double kilometraje, double costo0km) {
		super(0.7);
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.costo0km = costo0km;
	}

	public int getModelo() {
		return modelo;
	}
	
	public double getKilometraje() {
		return kilometraje;
	}

	public double getCosto0km() {
		return costo0km;
	}
	
	@Override
	public double valor() {
		// TODO Auto-generated method stub
		return this.getCosto0km() * (1 - ((Year.now().getValue() - this.getModelo()) * 0.1));
	}

}
