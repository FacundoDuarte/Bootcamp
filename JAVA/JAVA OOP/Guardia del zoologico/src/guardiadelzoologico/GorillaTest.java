package guardiadelzoologico;

public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla g = new Gorilla();
		Bat b = new Bat();
		

		// Gorila lanza algo tres veces
		System.out.println(g.throwSomething());
		System.out.println(g.throwSomething());
		System.out.println(g.throwSomething());
		
		// Come dos veces una banana
		System.out.println(g.eatBananas());
		System.out.println(g.eatBananas());
		
		// Trepa una vez al arbol
		System.out.println(g.climb());
		
	}

}
