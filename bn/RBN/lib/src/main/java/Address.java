import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Address {
	String street;
	String zip;
	
	public Address(){
		if(this.getStreet() == null) {
			this.setStreet(" ");	
		}
		
		if(this.getZip() == null) {
			this.setZip(" ");
		}
	}
	
	public void setZip(String z) {
		this.zip = z;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setStreet(String s) {
		this.street = s;
	}
	
	public String getStreet() {
		return street;
	}
	

}
