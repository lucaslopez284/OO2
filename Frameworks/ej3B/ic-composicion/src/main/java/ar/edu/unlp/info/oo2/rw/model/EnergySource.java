package ar.edu.unlp.info.oo2.rw.model;

public abstract class EnergySource


{
	private int bateria;
	
	
    public EnergySource(int bateria) {
		super();
		this.bateria = bateria;
	}


	public abstract void consumeBattery(Robot r);  
	
	public boolean tieneEnergia(int consumoArma) {
		return this.bateria >= consumoArma;
	}
	
	public void atacar(int consumoArma) {
		this.bateria = this.bateria - consumoArma;
	}
}
