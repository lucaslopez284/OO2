package ar.edu.unlp.info.oo2.rw.model;

public class SolarCaterpillarRobotWithLasers extends SolarCaterpillarRobot {

	public SolarCaterpillarRobotWithLasers(String name) {
        super(name);
    }
    
    public void fireArms() {
        System.out.println("Robot " + this.getName() + " firing lasers");
    }

}
