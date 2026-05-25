package ar.edu.unlp.info.oo2.rw.model;

public class SolarCaterpillarRobotWithBombs extends SolarCaterpillarRobot {

	public SolarCaterpillarRobotWithBombs(String name) {
        super(name);
    }
    
    public void fireArms() {
        System.out.println("Robot " + this.getName() + " firing bombs");
    }

}
