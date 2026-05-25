package ar.edu.unlp.info.oo2.rw.model;

public abstract class NuclearRobot extends Robot

{
	private int energia = 100;
	
    public NuclearRobot(String name) {
        super(name);
    }
    
    public void consumeBattery() {
        System.out.println("Robot " + this.getName() + " using nuclear energy");
    }
    
    protected boolean tieneEnergia(int consumoArma) {
		return this.energia >= consumoArma;
	}
	
	protected void atacar(int consumoArma) {
		this.energia = this.energia - consumoArma;
	}
}
