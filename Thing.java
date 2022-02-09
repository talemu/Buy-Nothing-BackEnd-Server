
public class Thing {
	
	private String name;
	
	public Thing (String name) {
		this.name = name;
	}
	
	public String toString() {
		if (this.getClass().getName() == "Thing") {
			return this.name;
		}
		else {
			return (this.name + " " + this.getClass().getName());
		}
	}
}
