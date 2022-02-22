package HW1.gradle.cs445Repo;


public class Bat extends Creature implements Flyer{
	
	public Bat(String name) {
		super(name);
	}
	
	@Override
	public void eat(Thing aThing) {
		String className = aThing.getClass().getName().substring(aThing.getClass().getName().lastIndexOf('.') + 1);
		if (className.equals("Thing")) {
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
	
	//helper functions for testing
	public String return_eat_instruction(Thing aThing) {
		String className = aThing.getClass().getName().substring(aThing.getClass().getName().lastIndexOf('.') + 1);
		if (className.equals("Thing")) {
			return (String.format("%s won't eat %s", this, aThing));
		}
		else if (Creatures.contains(className)) {
			return super.return_eat_instruction(aThing);
		}
		else {
			return "";
		}
	}
	
	public String return_fly_instruction() {
		return (String.format("%s is swooping through the dark." , this));
	}
	
	public String return_move_instruction() {
		return return_fly_instruction();
	}
}
