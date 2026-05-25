package ar.edu.unlp.info.oo2.rw.model;

public class SolarOvercraftRobotWithLasers extends SolarOvercraftRobot {
	
	private int consumo = 30;

	public SolarOvercraftRobotWithLasers(String name) {
        super(name);
    }
  
    public void fireArms() {
        System.out.println("Robot " + this.getName() + " firing lasers");
    }
    
    public void disparar() {
    	if (this.tieneEnergia(consumo)) {
    		this.atacar(consumo);
    	}
    }

}
