package guardiadelzoologico;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bat b = new Bat();
		b.setEnergy(300);
		//Ataque tres veces la ciudad
		System.out.println(b.attackDown());
		System.out.println(b.attackDown());
		System.out.println(b.attackDown());

		
//		Come dos veces humanos
		System.out.println(b.eatHumans());
		System.out.println(b.eatHumans());

		
//		Vuela dos veces
		System.out.println(b.fly());
		System.out.println(b.fly());


	}

}
