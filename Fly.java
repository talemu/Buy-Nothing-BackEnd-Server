

public class Fly extends Creature implements Flyer{

	public Fly(String name) {
		super(name);
	}
	
	public void eat(Thing aThing) {
		String className = aThing.getClass().getName();
		if (className.equals("Thing")) {
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
	
	//helper functions for testing
	public String return_eat_instruction(Thing aThing) {
		String className = aThing.getClass().getName();
		if (className.equals("Thing")) {
			return super.return_eat_instruction(aThing);
		}
		else if (Creatures.contains(className)) {
			return (String.format("%s won't eat a %s", this, aThing));
		}
		else {
			return "";
		}
	}
	
	
	public String return_fly_instruction() {
		return (String.format("%s is buzzing around in flight." , this));
	}
	
	public String return_move_instruction() {
		return return_fly_instruction();
	}
}
