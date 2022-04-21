
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.*;

public class Note implements EntityInterface{
	
	@NotNull(message = "user id can't be empty")
	private UUID uid;
	
	private UUID nid;
	
	@NotNull(message = "type can't be empty")
	//either "ask", "give" or "note"
	@Size(min = 3, max = 4)
	private String to_type;
	
	@NotNull(message = "the 'to user' id can't be empty")
	private UUID to_user_id;
	
	@NotNull(message = "the id of the resource the note is for can't be empty")
	private UUID to_id;
	
	@NotNull(message = "description can't be empty")
	private String description;
	
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
	private Date date_created;
	
	public Note () {
		nid = UUID.randomUUID();
	}

	@Override
	public Date getDateCreated() {
		// TODO Auto-generated method stub
		return date_created;
	}
	
	public UUID getUID() {
		return uid;
	}

	@Override
	public UUID getId() {
		// TODO Auto-generated method stub
		return nid;
	}

	public boolean isNil() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean containsInNotes(String substring) {
		if (description.contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}
}
