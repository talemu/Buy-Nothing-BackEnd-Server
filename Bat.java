
public class Bat extends Creature implements Flyer{
	
	public Bat(String name) {
		super(name);
	}
	
	@Override
	public void eat(Thing aThing) {
		String className = aThing.getClass().getName();
		if (className == "Thing") {
			System.out.println(String.format("%s won't eat %s", this, aThing));
		}
		else if (Creatures.contains(className)) {
			super.eat(aThing);
		}
		else {
		}
	}
	
	public void fly() {
		System.out.println(String.format("%s is swooping through the dark." , this));
	}
	
	@Override
	public void move() {
		fly();
	}
}
