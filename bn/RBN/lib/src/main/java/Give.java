

import java.time.LocalDate;
import java.util.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Give implements EntityInterface{
	
	@NotNull(message= "user id cant be null")
	private String uid;
	
	private String gid;
	
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
	private String date_created;
	
	private boolean is_active;
	
	public Give() {
		gid = UUID.randomUUID().toString();
		this.date_created = LocalDate.now().toString();
		this.startDate = this.date_created.toString();
		
		if (this.getEndDate() == null) {
			this.setEndDate("");
		}
		
		this.activateGive();
		
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
	
	public Give updateThisGive(Give a) {
		this.uid = this.uid;
		this.gid = this.gid;
		this.activateGive();
		
		this.date_created = a.getDateCreated();
		this.extra_zip = a.getExtraZip();
		this.setType(a.getType());
		this.setDescription(a.getDescription());
		
		return this;
	}
	
	public void setUID(String id) {
		this.uid = id;
	}
	
	public String getUID() {
		return uid;
	}
	
	public String getId() {
		return gid;
	}
	
	public boolean matchesId(String tid) {
		return (tid.equals(this.gid));
	}
	
	public ArrayList<String> getExtraZip() {
		return extra_zip;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String s) {
		this.endDate = s;
	}
	
	public void activateGive() {
		this.is_active = true;
	}
	
	public void deactivateGive() {
		this.is_active = false;
	}
	
	public boolean getActive() {
		return this.is_active;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean isNil() {
		return false;
	}
	
	public boolean containsInGive(String substring) {
		if (type.toLowerCase().contains(substring) || description.toLowerCase().contains(substring) || extra_zip.contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getDateCreated() {
		return date_created;
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
	
}
