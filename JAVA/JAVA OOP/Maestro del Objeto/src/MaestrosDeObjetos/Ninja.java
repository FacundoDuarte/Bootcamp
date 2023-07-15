package MaestrosDeObjetos;

public class Ninja extends Human{

	public Ninja() {
		super.setStealth(10);
	}
	public void steal(Human h) {
		h.setHealth(h.getHealth() - this.getStealth());
		this.setHealth(this.getStealth() + this.getHealth());
		System.out.println("El ninja ha robado puntos de vida al humano... -> Vida humano: " + h.getHealth() + " - Vida ninja: " + this.getHealth());
	}
	public void runAway() {
		this.setHealth(this.getHealth() - 10);
		System.out.println("Ninja corriendo... -> Salud: " + this.getHealth());
	}
}
