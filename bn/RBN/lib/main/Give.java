package main;

import java.util.*;

import jakarta.validation.constraints.*;

public class Give implements EntityInterface{
	
	@NotNull(message= "user id cant be null")
	private UUID uid;
	
	private UUID gid;
	
	@NotNull (message = "type cannot be empty")
	private String type;
	
	@NotNull (message = "description cannot be empty")
	private String description;
	
	//these two variable may be empty
	private String startDate;
	private String endDate;
	
	//arraylist of zips that user wants to be seen from
	private ArrayList<String> extra_zip;
	
	@NotNull(message = "Date cannot be empty")
	@Size(min = 20, max = 20, message = "invalid date")
	@Past
	private Date date_created;
	
	private boolean is_active;
	
	public Give() {
		gid = UUID.randomUUID();
	}
	
	public void setUID(UUID id) {
		this.uid = id;
	}
	
	public UUID getUID() {
		return uid;
	}
	
	public UUID getId() {
		return gid;
	}
	
	public void deactivateGive() {
		this.is_active = false;
	}
	
	public boolean getActive() {
		return this.is_active;
	}
	
	public boolean isNil() {
		return false;
	}
	
	public boolean containsInGive(String substring) {
		if (type.contains(substring) || description.contains(substring) || extra_zip.contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Date getDateCreated() {
		return date_created;
	}
	
}
