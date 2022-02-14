

public class Thing {
	
	private String name;
	
	public Thing (String name) {
		this.name = name;
	}
	
	//helper function to verify Constructor was made with name variable:
	public String returnThingName( ) {
		return this.name;
	}
	
	public String toString() {
		if ( this.getClass().getName().equals("Thing")) {
			return this.name;
		}
		else {
			return (this.name + " " + this.getClass().getName());
		}
	}
}
