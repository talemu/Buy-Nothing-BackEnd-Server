

import java.time.LocalDate;
import java.util.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Thank implements EntityInterface{
	
	@NotNull(message = "uid can't be empty")
	private String uid;
	
	private String tid;
	
	@NotNull(message = "thank_to can't be empty")
	private String thankTo;
	
	@NotNull(message = "description can't be empty")
	private String description;
	
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
	private String date_created;
	
	//these two variable may be empty
		@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null", message = "invalid date")
		private String startDate;
		@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
		private String endDate;
	
	public Thank() {
		tid = UUID.randomUUID().toString();
		date_created = LocalDate.now().toString();
		this.startDate = date_created.toString();
		
		if (this.getEndDate() == null || this.getEndDate() == "") {
			this.setEndDate("");
		}
		
		if (this.getThankTo() == null) {
			this.setThankTo("");
		}
		
		if (this.getDescription() == null) {
			this.setDescription("");
		}
	}
	
	public Thank updateThisThank(Thank t) {
		this.uid = this.uid;
		this.tid = this.tid;
		
		this.thankTo = t.getThankTo();
		this.date_created = t.getDateCreated();
		this.setDescription(t.getDescription());
		
		return this;
		
	}

	@Override
	public String getDateCreated() {
		// TODO Auto-generated method stub
		return date_created;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return tid;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setTid(String t) {
		this.tid = t;
	}
	
	public String getUID() {
		return uid;
	}
	
	public void setUID(String u) {
		this.uid = u;
	}
	
	public void setEndDate(String s) {
		this.endDate = s;
	}
	
	public boolean matchesId(String thank_id) {
		return (thank_id.equals(this.tid));
	}
	
	public boolean isNil() {
		return false;
	}
	
	public String getThankTo() {
		return this.thankTo;
	}
	
	public void setThankTo(String s) {
		this.thankTo = s;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}
	
	public boolean containsInThank(String substring) {
		if (description.toLowerCase().contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}

}
