package MaestrosDeObjetos;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human h = new Human();
		Wizard w = new Wizard();
		Ninja n = new Ninja();
		Samurai s = new Samurai();
		Samurai s1 = new Samurai();
		Samurai s2 = new Samurai();

		h.attack();
		w.heal(h);
		w.fireBall(h);
		n.steal(h);
		n.runAway();
		s.deathBlow(h);
		s.meditate();
		s.howMany();
	}
}
