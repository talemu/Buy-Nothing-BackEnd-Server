

import java.time.LocalDate;
import java.util.*;

import jakarta.validation.constraints.*;

public class Ask implements EntityInterface{
	
	private String uid;
	private String aid;
	
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
	
	//ask activity status
	private boolean is_active;
	
	@NotNull(message = "Date cannot be empty")
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "invalid date")
	private String date_created;
	
	
//	
//	private boolean is_active;
//	
	public Ask() {
		aid = UUID.randomUUID().toString();
		this.activateAsk();
		this.date_created = LocalDate.now().toString();
		this.startDate = date_created.toString();
		
		if (this.startDate == "" || this.startDate == null) {
			this.startDate = date_created;
		}
		
		if (this.getEndDate() == null || this.getEndDate() == "") {
			this.setEndDate("");
		}
		
		if (this.extra_zip == null) {
			this.extra_zip = new ArrayList <String>();
		}
		
		if (this.getType() == null) {
			this.setType(" ");
		}
		
		if (this.getDescription() == null) {
			this.setDescription(" ");
		}
	}
	
	public Ask updateThisAsk(Ask a) {
		this.uid = this.uid;
		this.aid = this.aid;
		this.activateAsk();
		
		this.date_created = a.getDateCreated().toString();
		
		this.extra_zip = a.getExtraZip();
		this.setType(a.getType());
		this.setDescription(a.getDescription());
		
		return this;
	}
	
	public String getUid() {
		return uid;
	}
	
	public String getId() {
		return aid;
	}
	
	public boolean matchesId(String tid) {
		return (tid.equals(this.aid));
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
	
	public String getEndDate() {
		return endDate;
	}
	
	public ArrayList <String> getExtraZip() {
		return this.extra_zip;
	}
	
	public void setUID(String u) {
		this.uid = u;
	}
	
	public void setType(String s) {
		this.type = s;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}
	
	public void setEndDate(String d) {
		this.endDate = d;
	}
	
	public void addExtraZip(String z) {
		//adds zip z to the list of requested zips
		this.extra_zip.add(z);
	}
	
	public String getDateCreated() {
		// TODO Auto-generated method stub
		return date_created;
	}
	
}
