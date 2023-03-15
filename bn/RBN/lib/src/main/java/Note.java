

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Note implements EntityInterface{
	
	@NotNull(message = "user id can't be empty")
	private String uid;
	
	private String nid;
	
	@NotNull(message = "type can't be empty")
	//either "ask", "give" or "note"
	@Size(min = 3, max = 4)
	private String toType;
	
	@NotNull(message = "the 'to user' id can't be empty")
	private String toUserId;
	
	@NotNull(message = "the id of the resource the note is for can't be empty")
	private String toId;
	
	@NotNull(message = "description can't be empty")
	private String description;
	
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
	private String date_created;
	
	public Note () {
		nid = UUID.randomUUID().toString();
		this.date_created = LocalDate.now().toString();
		
		if (this.getToType() == null) {
			this.setToType(" ");
		}
		
		if(this.getToUserId() == null) {
			this.setToUserId(" ");
		}
		
		if(this.getToId() == null) {
			this.setToUserId(" ");
		}
		
		if (this.getDescription() == null) {
			this.setDescription(" ");
		}
	}
	
	public Note updateThisNote(Note n) {
		this.uid = this.uid;
		this.nid = this.nid;
		
		this.setToType(n.getToType());
		this.setToUserId(n.getToUserId());
		this.setDescription(n.getDescription());
		
		return this;
	}

	@Override
	public String getDateCreated() {
		// TODO Auto-generated method stub
		return date_created;
	}
	
	public String getUID() {
		return uid;
	}
	
	public void setUID(String s) {
		this.uid = s;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return nid;
	}
	
	public void setId(String s) {
		this.nid = s;
	}
	
	public boolean matchesId(String tid) {
		return (tid.equals(this.nid));
	}
	
	public String getToType() {
		return toType;
	}
	
	public void setToType(String s) {
		this.toType = s;
	}
	
	public String getToUserId () {
		return toUserId;
	}
	
	public void setToUserId (String s) {
		this.toUserId = s;
	}
	
	public String getToId() {
		return toId;
	}
	
	public void setToId(String s) {
		this.toId = s;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}

	public boolean isNil() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean containsInNotes(String substring) {
		if (description.toLowerCase().contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}
}
