
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import jakarta.validation.constraints.*;
import jakarta.ws.rs.NotFoundException;


public class Account implements EntityInterface {
	private String uid;
	private boolean isActive;
	//Ask ArrayList
	private ArrayList<Ask> userAsks = new ArrayList<Ask>();
	private ArrayList<Give> userGives = new ArrayList<Give>();
	private ArrayList<Thank> userThanks = new ArrayList<Thank>();
	private ArrayList<Thank> thanks_to_this_account = new ArrayList<Thank>();
	private ArrayList<Note> userNotes = new ArrayList<Note>();
	
	private String name;
	
	//how can i extract the json contents of address?
//	public JSONObject address;
	
	@NotNull(message = "Number cannot be empty")
	@Size(min = 11, max = 11, message = "invalid phone number")
	private String phone;
	
	@NotNull(message = "Picture required")
//	private URL picture;
	private String picture;
	
	private String zip;
	private String street;
	
//	@Past
	private String dateCreated;
	
	//these two variable may be empty
	
	private Address address;

	//Account Default method
	
	public Account() {
		this.uid = UUID.randomUUID().toString();
		
		if (this.getDateCreated() == "" || this.getDateCreated() == null) {
			this.setDateCreated(LocalDate.now());;
		}
		
		this.setIsActive(true);
		
		if (this.getName() == "" || this.getName() == null) {
			this.name = "";
		}
		
		if (this.getPicture() == null) {
			this.setPicture(" ");
		}
		
		if (this.getPhone() == null) {
			this.setPhone(" ");
		}
		
		if (this.getZip() == null) {
			this.setZip(" ");
		}
		
		if (this.getStreet() == null) {
			this.setStreet(" ");
		}
	}
	
	
	
	public void setUID(String uid) {
		this.uid = uid;
	}
	
	public String getUID() {
		return uid;
	}
	
	public boolean matchesId(String lid) {
        return(lid.equals(this.uid));
    }
	
	public void setDateCreated(LocalDate l) {
		this.dateCreated = l.toString();
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPicture() {
		return this.picture;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setIsActive(Boolean t) {
		this.isActive = t;
	}
	
	public void deactivate_account() {
		this.isActive = false;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public boolean isNil() {
		return false;
	}
	
	public void setZip(String z) {
		this.zip = z;
	}
	
	public void setPhone(String s) {
		this.phone = s;
	}
	
	public void setPicture (String s) {
		this.picture = s;
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
		if (this.getName().contains(substring) || this.getStreet().contains(substring) || this.getZip().contains(substring) || this.getPicture().contains(substring) || this.getPhone().contains(substring)) {
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
	
	public void addThankFrom(Thank t) {
		thanks_to_this_account.add(t);
	}
	
	
	public void addNote(Note n) {
		userNotes.add(n);
	}
	
	public ArrayList<Ask> getAsks() {
		return userAsks;
	}
	
	public ArrayList<Ask> getAsks(Boolean active) {
		ArrayList <Ask> returningAsks = this.getAsks();
		Iterator<Ask> as = returningAsks.listIterator();
		int count = 0;
        while(as.hasNext()) {
            Ask a = as.next();
            if(a.getActive() != active) {
            	returningAsks.remove(count);
            	count -= 1;
            }
            count += 1;
        }
        return returningAsks;
        
	}
	
	public ArrayList<Give> getGives() {
		return userGives;
	}

	public ArrayList<Thank> getThanks() {
		return userThanks;
	}
	
	public ArrayList<Thank> getThanksFrom() {
		return thanks_to_this_account;
	}

	public ArrayList<Note> getNotes() {
		return userNotes;
	}
	
	private EntityInterface findById(EntityInterface o, String id) throws NotFoundException {
		if (o instanceof Ask) {
			Iterator<Ask> as = userAsks.listIterator();
	        while(as.hasNext()) {
	            Ask a = as.next();
	            if(a.matchesId(id)) return(a);
	        }
	        throw new NotFoundException("Ask Not Found");
		}
		if (o instanceof Give) {
			Iterator<Give> gs = userGives.listIterator();
	        while(gs.hasNext()) {
	            Give g = gs.next();
	            if(g.matchesId(id)) return(g);
	        }
	        throw new NotFoundException("Give Not Found");
		}
		if (o instanceof Thank) {
			Iterator<Thank> ts = userThanks.listIterator();
	        while(ts.hasNext()) {
	            Thank t = ts.next();
	            if(t.matchesId(id)) return(t);
	        }
	        throw new NotFoundException("Thank Not Found");
		}
		if (o instanceof Note) {
			Iterator<Note> ns = userNotes.listIterator();
	        while(ns.hasNext()) {
	            Note n = ns.next();
	            if(n.matchesId(id)) return(n);
	        }
	        throw new NotFoundException("Note Not Found");
		}
		else {
			throw new NotFoundException("Element Not Found");
		}
    }
	
	public EntityInterface searchAndReturn(EntityInterface temp, String aid) {
		return this.findById(temp, aid);
	}
	
	public EntityInterface searchAndDeactivate(EntityInterface temp, String id) {
		if (temp instanceof Ask) {
			((Ask) this.findById(temp, id)).deactivateAsk();
		}
		if (temp instanceof Give) {
			((Give) this.findById(temp, id)).deactivateGive();
		}
		return this.findById(temp, id);
	}
	
	public EntityInterface searchAndUpdate(String id, EntityInterface temp, EntityInterface newItem) throws Exception {
		if (temp instanceof Ask) {
			Ask pulled = (Ask) this.findById(temp, id);
			pulled = pulled.updateThisAsk((Ask) newItem);
			return pulled;
		}
		if (temp instanceof Give) {
			Give pulled = (Give) this.findById(temp, id);
			pulled = pulled.updateThisGive((Give) newItem);
			return pulled;
		}
		if (temp instanceof Thank) {
			Thank pulled = (Thank) this.findById(temp, id);
			pulled = pulled.updateThisThank((Thank) newItem);
			return pulled;
		}
		if (temp instanceof Note) {
			Note pulled = (Note) this.findById(temp, id);
			pulled = pulled.updateThisNote((Note) newItem);
			return pulled;
		}
		else {
			throw new Exception("Element does not exist");
		}
	}
//	
	public void searchAndDelete(EntityInterface temp, String id) {
		if (temp instanceof Ask) {
			Iterator<Ask> as = userAsks.listIterator();
			int count = 0;
	        while(as.hasNext()) {
	            Ask a = as.next();
	            if(a.matchesId(id)) userAsks.remove(count);
	            count += 1;
	        }
		}
		if(temp instanceof Give) {
			Iterator<Give> gs = userGives.listIterator();
			int count = 0;
	        while(gs.hasNext()) {
	            Give g = gs.next();
	            if(g.matchesId(id)) userGives.remove(count);
	            count += 1;
	        }
		}
		if(temp instanceof Note) {
			Iterator<Note> ns = userNotes.listIterator();
			int count = 0;
	        while(ns.hasNext()) {
	            Note n = ns.next();
	            if(n.matchesId(id)) userNotes.remove(count);
	            count += 1;
	        }
		}
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
