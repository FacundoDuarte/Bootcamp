package guardiadelzoologico;

public class Bat extends Mammal{
	
	public Bat() {
		super.setEnergy(300);
	}
	
	public String fly() {
		super.setEnergy(super.getEnergy() - 50);
		return "fffffssssshhhh " + super.displayEnergy();
	}
	
	public String eatHumans() {
		super.setEnergy(super.getEnergy() + 25);
		return "bueno, no importa " + super.displayEnergy();
	}
	public String attackDown() {
		super.setEnergy(super.getEnergy() - 100);
		return "Ciudad en llamas... " + super.displayEnergy();
	}
	

}
