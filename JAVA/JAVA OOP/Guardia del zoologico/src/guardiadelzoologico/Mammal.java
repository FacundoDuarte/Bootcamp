package guardiadelzoologico;

public class Mammal {
	private int energyLevel = 100;
	
	public int getEnergy() {
		return energyLevel;
	}
	
	public void setEnergy(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	

	public String displayEnergy(){
		return "La energia base es: " + this.energyLevel;
	}
}
