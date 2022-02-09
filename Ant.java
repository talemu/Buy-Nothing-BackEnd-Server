
public class Ant extends Creature{
	
	public Ant(String name) {
		super(name);
	}
	
	@Override
	public void move() {
		System.out.println(String.format("%s is crawling around.", this));
	}
	
}
