
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import jakarta.validation.constraints.*;


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
//	public JSONObject address;
	
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
	private LocalDate date_created;
	
	//these two variable may be empty
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null", message = "invalid date")
	private String startDate;
	@Pattern(regexp = "((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) || null ", message = "invalid date")
	private String endDate;
	
	//Account Default method
	
	public Account() {
		uid = UUID.randomUUID();
		if (this.getDateCreated() == null) {
			this.setDateCreated(LocalDate.now());
		}
		this.activate_account();
		if (this.getName() == null) {
			this.name = " ";
		}
		if (this.getURLString() == null) {
			this.urlString = " ";
		}
		if (this.getPhoneNumber() == null) {
			this.phoneNumber = " ";
		}
	}
	
	public UUID getId() {
		return uid;
	}
	
	public void setDateCreated(LocalDate l) {
		this.date_created = l;
	}
	
	public LocalDate getDateCreated() {
		return date_created;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getURLString() {
		return this.urlString;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void activate_account() {
		this.isActive = true;
	}
	
	public void deactivate_account() {
		this.isActive = false;
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
	
	public String getZip() {
		return zip;
	}
	
	public void setStreet(String s) {
		this.street = s;
	}
	
	public String getStreet() {
		return street;
	}
	
	public boolean containsInAccount(String substring) {
		if (this.getName().contains(substring) || this.getStreet().contains(substring) || this.getZip().contains(substring) || this.getURLString().contains(substring) || this.getPhoneNumber().contains(substring)) {
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
	
	public ArrayList<Ask> getAsksBasedonActivity(String s) {
		ArrayList <Ask> temp = new ArrayList<Ask>();
		if (s == "null") {
			for (int i = 0; i < userAsks.size(); i++) {
				temp.add(userAsks.get(i));
			}
		}
		else {
			Boolean tf = Boolean.parseBoolean(s);
			for (int i = 0; i < userAsks.size(); i++) {
				Ask temp2 = userAsks.get(i);
				if(temp2.getActive() == tf) {
					temp.add(temp2);
				}
		}
		}
		return temp;
	}
	
	public ArrayList<Give> getGivesBasedonActivity(String s) {
		ArrayList <Give> temp = new ArrayList<Give>();
		if (s == "null") {
			for (int i = 0; i < userGives.size(); i++) {
				temp.add(userGives.get(i));
			}
		}
		else {
			Boolean tf = Boolean.parseBoolean(s);
			for (int i = 0; i < userGives.size(); i++) {
				Give temp2 = userGives.get(i);
				if(temp2.getActive() == tf) {
					temp.add(temp2);
				}
		}
		}
		return temp;
	}
	
	public Ask searchForAsk(UUID aid) {
		for(int i = 0; i < userAsks.size(); i++) {
			if (userAsks.get(i).getId() == aid) {
				return userAsks.get(i);
			}
		}
		return new NullAsk();
	}
	
	public Give searchForGive(UUID gid) {
		for(int i = 0; i < userGives.size(); i++) {
			if (userGives.get(i).getId() == gid) {
				return userGives.get(i);
			}
		}
		return new NullGive();
	}
	
	public Thank searchForThank(UUID tid) {
		for(int i = 0; i < userThanks.size(); i++) {
			if (userThanks.get(i).getId() == tid) {
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
			if (userAsks.get(i).getId() == aid) {
				Ask deletedAsk = userAsks.get(i);
				userAsks.remove(i);
				return deletedAsk;
			}
		}
		return new NullAsk();
	}
	
	public Give deleteGive(UUID gid) {
		for(int i = 0; i < userGives.size(); i++) {
			if (userGives.get(i).getId() == gid) {
				Give deletedGive = userGives.get(i);
				userGives.remove(i);
				return deletedGive;
			}
		}
		return new NullGive();
		}
	
	public Note deleteNote(UUID nid) {
		for(int i = 0; i < userNotes.size(); i++) {
			if (userNotes.get(i).getId() == nid) {
				Note deletedNote = userNotes.get(i);
				userNotes.remove(i);
				return deletedNote;
			}
		}
		return new NullNote();
		}
}
