package edu.iit.cs445.spring2022.buyNothing;

import java.util.*;

import javax.validation.constraints.*;

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
	private Date date_created;
	
	private boolean is_active;
	
	public Ask() {
		aid = UUID.randomUUID();
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
	
	public boolean isNil() {
		return false;
	}
	
	public Date getDateCreated() {
		// TODO Auto-generated method stub
		return date_created;
	}
	
}
