package MaestrosDeObjetos;

public class Human {

	int strength = 3;
	int intelligence = 3;
	int stealth = 3;
	int health = 100;
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStealth() {
		return stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void attack() {
		this.setHealth(this.health - this.strength);
		System.out.println("El humano ha sido atacado... - Vida: " + this.getHealth());
	}
	
}
