
public class Fly extends Creature implements Flyer{

	public Fly(String name) {
		super(name);
	}
	
	public void eat(Thing aThing) {
		String className = aThing.getClass().getName();
		if (className == "Thing") {
			super.eat(aThing);
		}
		else if (Creatures.contains(className)) {
			System.out.println(String.format("%s won't eat a %s", this, aThing));
		}
	}
	
	public void fly() {
		System.out.println(String.format("%s is buzzing around in flight." , this));
	}
	
	@Override
	public void move() {
		fly();
	}
}
