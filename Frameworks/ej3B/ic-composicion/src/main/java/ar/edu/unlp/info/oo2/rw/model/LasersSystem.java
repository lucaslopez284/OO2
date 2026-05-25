package ar.edu.unlp.info.oo2.rw.model;

public class LasersSystem extends ArmsSystem


{
	private int consumo = 50;
	
    public void fireArms(Robot r) {
        System.out.println("Robot " + r.getName() + " firing lasers");
    } 
    
    public void disparar(EnergySource energia) {
    	if (energia.tieneEnergia(this.consumo)) {
    		energia.atacar(consumo);
    	}
    }
 
}
