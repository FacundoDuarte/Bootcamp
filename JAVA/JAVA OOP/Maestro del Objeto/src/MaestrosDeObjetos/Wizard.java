package MaestrosDeObjetos;

public class Wizard extends Human{

	public Wizard() {
		super.setHealth(50);
		super.setIntelligence(8);
	}
	
	public void heal(Human h) {
		h.setHealth(h.getHealth() + this.getIntelligence());
		System.out.println("El humano se ha curado... - Vida: " + h.getHealth());
	}
	
	public void fireBall(Human h) {
		h.setHealth(h.getHealth() - (this.getIntelligence() * 3));
		System.out.println("El humano ha sido herido... - Vida: " + h.getHealth());
	}
}
