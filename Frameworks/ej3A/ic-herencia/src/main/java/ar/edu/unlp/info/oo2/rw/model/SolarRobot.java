package ar.edu.unlp.info.oo2.rw.model;

public abstract class SolarRobot extends Robot {
	
	private int energia = 100;
	
	public SolarRobot(String name) {
        super(name);
    }

	@Override
	public void consumeBattery() {
		System.out.println("Robot " + this.getName() + " using solar energy");
	}
	
	protected boolean tieneEnergia(int consumoArma) {
		return this.energia >= consumoArma;
	}
	
	protected void atacar(int consumoArma) {
		this.energia = this.energia - consumoArma;
	}

}
