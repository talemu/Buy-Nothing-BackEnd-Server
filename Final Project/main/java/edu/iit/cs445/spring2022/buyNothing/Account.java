package edu.iit.cs445.spring2022.buyNothing;

//makes a url
import java.net.URL;

//A class that represents an immutable universally unique identifier (UUID). A UUID represents a 128-bit value. 
import java.util.*;
import javax.validation.constraints.*;

import org.json.JSONObject;

public class Account implements EntityInterface {
	private UUID uid;
	private boolean isActive;
	//Ask ArrayList
	private ArrayList<Ask> userAsks = new ArrayList<Ask>();
	private ArrayList<Give> userGives = new ArrayList<Give>();
	private ArrayList<Thank> userThanks = new ArrayList<Thank>();
	private ArrayList<Note> userNotes = new ArrayList<Note>();
	
	
	@NotNull(message= "name cannot be null")
	private String name;
	
	//how can i extract the json contents of address?
	public JSONObject address;
	
	@NotNull(message= "zip code cannot be null")
	@Size(min= 5, max = 5, message = "invalid zip code")
	private String zip;
	
	@NotNull(message = "street cannot be empty")
	private String street;
	
	@NotNull(message = "Number cannot be empty")
	@Size(min = 12, max = 12, message = "invalid phone number")
	private String phoneNumber;
	
	@NotNull(message = "Picture required")
	private URL picture;
	private String urlString;
	
	@NotNull(message = "Date cannot be empty")
	@Past
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "invalid date")
	private Date date_created;
	
	//these two variable may be empty
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null", message = "invalid date")
	private String startDate;
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
	private String endDate;
	
	//Account Default method
	
	public Account() {
		uid = UUID.randomUUID();
	}
	
	public UUID getId() {
		return uid;
	}
	
	public Date getDateCreated() {
		return date_created;
	}
	
	public void activate_account() {
		this.isActive = true;
	}
	
	public boolean getActive() {
		return this.isActive;
	}
	
	public boolean isNil() {
		return false;
	}
	
	public void setZip(String z) {
		this.zip = z;
	}
	
	public void setStreet(String s) {
		this.street = s;
	}
	
	public boolean containsInAccount(String substring) {
		if (name.contains(substring) || street.contains(substring) || urlString.contains(substring) || phoneNumber.contains(substring)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addAsk(Ask a) {
		userAsks.add(a);
	}
	
	public void addGive(Give g) {
		userGives.add(g);
	}
	
	public void addThank(Thank t) {
		userThanks.add(t);
	}
	
	public void addNote(Note n) {
		userNotes.add(n);
	}
	
	public ArrayList<Ask> getAsks() {
		return userAsks;
	}
	
	public ArrayList<Give> getGives() {
		return userGives;
	}
	
	public ArrayList<Thank> getThanks() {
		return userThanks;
	}
	
	public ArrayList<Note> getNotes() {
		return userNotes;
	}
	
	public ArrayList<Ask> getAsksBasedonActivity(boolean tf) {
		ArrayList <Ask> temp = new ArrayList<Ask>();
		for (int i = 0; i < userAsks.size(); i++) {
			Ask temp2 = userAsks.get(i);
			if(temp2.getActive() == tf) {
				temp.add(temp2);
			}
		}
		return temp;
	}
	
	public Ask searchForAsk(UUID aid) {
		for(int i = 0; i < userAsks.size(); i++) {
			if (userAsks.get(i).getId() == uid) {
				return userAsks.get(i);
			}
		}
		return new NullAsk();
	}
	
	public Give searchForGive(UUID gid) {
		for(int i = 0; i < userGives.size(); i++) {
			if (userGives.get(i).getId() == uid) {
				return userGives.get(i);
			}
		}
		return new NullGive();
	}
	
	public Thank searchForThank(UUID tid) {
		for(int i = 0; i < userThanks.size(); i++) {
			if (userThanks.get(i).getId() == uid) {
				return userThanks.get(i);
			}
		}
		return new NullThank();
	}
	
	public Note searchForNote(UUID nid) {
		for(int i = 0; i < userNotes.size(); i++) {
			if (userNotes.get(i).getId() == nid) {
				return userNotes.get(i);
			}
		}
		return new NullNote();
	}
	
	public Ask deleteAsk(UUID aid) {
		for(int i = 0; i < userAsks.size(); i++) {
			if (userAsks.get(i).getId() == uid) {
				userAsks.remove(i);
				return userAsks.get(i);
			}
		}
		return new NullAsk();
	}
	
	public Give deleteGive(UUID gid) {
		for(int i = 0; i < userGives.size(); i++) {
			if (userGives.get(i).getId() == uid) {
				userGives.remove(i);
				return userGives.get(i);
			}
		}
		return new NullGive();
		}
}
