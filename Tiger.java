
public class Tiger extends Creature {
	
	public Tiger(String name) {
		super(name);
	}
	
	@Override
	public void move() {
		System.out.println(String.format("%s has just pounced.", this));
	}
}
