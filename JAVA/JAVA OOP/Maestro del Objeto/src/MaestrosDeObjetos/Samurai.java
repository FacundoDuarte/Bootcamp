package MaestrosDeObjetos;

public class Samurai extends Human{
	private static int countSamurais;

	public Samurai() {
		super.setHealth(200);
		countSamurais++;
	}
	
	public void deathBlow(Human h) {
		h.setHealth(0);
		this.setHealth(this.getHealth() / 2);
		System.out.println("El humano fue asesinado... -> Vida humano: " + h.getHealth() + 
				" - Vida Samurai: " + this.getHealth());
	}
 	public void meditate() {
 		this.setHealth(this.getHealth() + (this.getHealth() / 2));
 		System.out.println("Meditando... -> Vida Samurai: " + this.getHealth());
 	}
 	 public static void howMany() {
         System.out.println("El numero total de Samuaris es: " + countSamurais);
     }
}
