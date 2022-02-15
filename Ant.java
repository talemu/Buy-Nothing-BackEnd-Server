package HW1.gradle.cs445Repo;


public class Ant extends Creature{
	
	public Ant(String name) {
		super(name);
	}
	
	@Override
	public void move() {
		System.out.println(String.format("%s is crawling around.", this));
	}
	
	//helper method used for testing
	
	public String return_move_instruction() {
		return (String.format("%s is crawling around.", this));
	}
}
