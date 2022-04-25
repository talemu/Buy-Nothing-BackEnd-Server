

import java.time.LocalDate;
import java.util.*;

import jakarta.validation.constraints.*;

public class Ask implements EntityInterface{
	
	@NotNull (message = "user id can't be empty")
	private UUID uid;
	
	private UUID aid;
	
	@NotNull (message = "type cannot be empty")
	private String type;
	
	@NotNull (message = "description cannot be empty")
	private String description;
	
	//these two variable may be empty
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null", message = "invalid date")
	private String startDate;
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
	private String endDate;
	
	//arraylist of zips that user wants to be seen from
	private ArrayList<String> extra_zip;
	
	@NotNull(message = "Date cannot be empty")
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "invalid date")
	private LocalDate date_created;
	
	private boolean is_active;
	
	public Ask() {
		aid = UUID.randomUUID();
		
		if (this.extra_zip == null) {
			this.extra_zip = new ArrayList <String>();
			this.extra_zip.add(" ");
		}
		
		if (this.getType() == null) {
			this.setType(" ");
		}
		
		if (this.getDescription() == null) {
			this.setDescription(" ");
		}
	}
	
	public void setUID(UUID id) {
		this.uid = id;
	}
	
	public UUID getUID() {
		return uid;
	}
	
	public UUID getId() {
		return aid;
	}
	
	public void activateAsk() {
		this.is_active = true;
	}
	
	public void deactivateAsk() {
		this.is_active = false;
	}
	
	public boolean containsInAsk(String substring) {
		if (type.contains(substring) || description.contains(substring) || extra_zip.contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean getActive() {
		return this.is_active;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean isNil() {
		return false;
	}
	
	public String getType() {
		return type;
	}
	
	public ArrayList <String> getExtraZip() {
		return this.extra_zip;
	}
	
	public void setType(String s) {
		this.type = s;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}
	
	public void addExtraZip(String z) {
		//adds zip z to the list of requested zips
		this.extra_zip.add(z);
	}
	
	public LocalDate getDateCreated() {
		// TODO Auto-generated method stub
		return date_created;
	}
	
}
