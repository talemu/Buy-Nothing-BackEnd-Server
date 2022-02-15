package HW1.gradle.cs445Repo;

import java.util.Set;


public abstract class Creature extends Thing {
	
	public String stomach = null;
	public final Set<String> Creatures = Set.of(
			"Ant", "Bat", "Fly", "Tiger"
			);
	
	public Creature(String name) {
		super(name);
	}
	
	public void eat(Thing aThing) {
		System.out.println(String.format("%s has just eaten a %s", this ,aThing));
		stomach = aThing.getClass().getName().substring(aThing.getClass().getName().lastIndexOf('.') + 1);

	}
	
	public abstract void move();
	
	public void whatDidYouEat() {
		if (stomach == null) {
			System.out.println(String.format("%s has had nothing to eat!", this));
		}
		
		else {
			System.out.println(String.format("%s has eaten a %s", this, stomach));
		}
	}
	
	//helper functions for testing
	public String return_eat_instruction(Thing aThing) {
		this.eat(aThing);
		return(String.format("%s has just eaten a %s", this ,aThing));
	}
	
	public String return_whatDidYouEat_instruction() {
		if (stomach == null) {
			return (String.format("%s has had nothing to eat!", this));
		}
		
		else {
			return (String.format("%s has eaten a %s", this, stomach));
		}
	}
}
