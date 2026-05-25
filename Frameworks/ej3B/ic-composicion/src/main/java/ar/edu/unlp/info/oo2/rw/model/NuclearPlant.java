package ar.edu.unlp.info.oo2.rw.model;

public class NuclearPlant extends EnergySource


{
	
    public NuclearPlant() {
		super(100);
	}

	public void consumeBattery(Robot r) {
        System.out.println("Robot " + r.getName() + " using nuclear energy");
    }
	
 
}
