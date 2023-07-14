package guardiadelzoologico;

public class Gorilla extends Mammal{

	public String throwSomething() {
		super.setEnergy(getEnergy() -5);
		return "El gorila arrojo algo... - " + super.displayEnergy();
	}
	
	public String eatBananas() {
		super.setEnergy(getEnergy() + 10);
		return "El gorila comio una banana... - " + super.displayEnergy();
	}
	
	public String climb() {
		super.setEnergy(getEnergy() - 10);
		return "El gorila subio a la cima de un arbol... - " + super.displayEnergy();
	}
	
}
