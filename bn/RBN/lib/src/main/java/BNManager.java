

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.ws.rs.NotFoundException;

public class BNManager {
	private static List<Account> accounts = new ArrayList<Account>();
	private static List<Ask> asks = new ArrayList <Ask>();
	private static List<Give> gives = new ArrayList <Give>();
	private static List<Thank> thanks = new ArrayList <Thank>();
	private static List<Note> notes = new ArrayList <Note>();

	
	public LocalDate stringToDate (String s) throws ParseException {
		LocalDate d= LocalDate.parse(s);//For reference
		return d;
	}
	
	public Account addNewAccount(Account a) {
		accounts.add(a);
		return a;
	}
	
	public Ask addNewAsk(Ask a) {
		asks.add(a);
		return a;
	}
	
	public Give addNewGive(Give g) {
		gives.add(g);
		return g;
	}
	
	public Thank addNewThank(Thank t) {
		thanks.add(t);
		return t;
	}
	
	public Note addNewNote(Note n) {
		notes.add(n);
		return n;
	}
	
	private Account findById(String uid) throws NotFoundException{
        Iterator<Account> ac = accounts.listIterator();
        while(ac.hasNext()) {
            Account a = ac.next();
            if(a.matchesId(uid)) return(a);
        }
        throw new NotFoundException("Account Not Found");
    }

	public List <Account> searchAccountQuery(String key, String s_d, String e_d) throws Exception {
		
		try {
			LocalDate start_date;
			LocalDate end_date;
			String[] startDateSplit = s_d.split("-",0);
			s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
			start_date = LocalDate.parse(s_d);
			
			String[] endDateSplit = e_d.split("-",0);
			e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
			end_date = LocalDate.parse(e_d);
			List <Account> queriedAccounts = new ArrayList<Account>();
	        Iterator<Account> ac = accounts.listIterator();
	        while(ac.hasNext()) {
//	        	Account a = ac.next();
//	        	queriedAccounts.add(a.containsInAccount(key));
	            Account a = ac.next();
//	            queriedAccounts.add(a.containsInAccount(key));
	            Boolean before = LocalDate.parse(a.getDateCreated()).isAfter(start_date) || LocalDate.parse(a.getDateCreated()).isEqual(start_date);
	            Boolean after = LocalDate.parse(a.getDateCreated()).isBefore(end_date) || LocalDate.parse(a.getDateCreated()).isEqual(end_date);
	            if(a.containsInAccount(key) && before && after) {
	            	queriedAccounts.add(a);
	            }
	        }
	        return(queriedAccounts);
		}
		catch (Exception e){
			throw new Exception ("Date was inputted incorrectly");
		}
	}
	
public List<Ask> searchAccountQueryReturnAsks(String key, String s_d, String e_d) throws Exception {
		
		try {
			LocalDate start_date;
			LocalDate end_date;
			String[] startDateSplit = s_d.split("-",0);
			s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
			start_date = LocalDate.parse(s_d);
			
			String[] endDateSplit = e_d.split("-",0);
			e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
			end_date = LocalDate.parse(e_d);
			List <Ask> queriedAsks = new ArrayList<Ask>();
	        Iterator<Account> ac = accounts.listIterator();
	        while(ac.hasNext()) {
//	        	Account a = ac.next();
//	        	queriedAccounts.add(a.containsInAccount(key));
	            Account a = ac.next();
//	            queriedAccounts.add(a.containsInAccount(key));
	            Boolean before = LocalDate.parse(a.getDateCreated()).isAfter(start_date) || LocalDate.parse(a.getDateCreated()).isEqual(start_date);
	            Boolean after = LocalDate.parse(a.getDateCreated()).isBefore(end_date) || LocalDate.parse(a.getDateCreated()).isEqual(end_date);
	            if(a.containsInAccount(key) && before && after) {
	            	queriedAsks.addAll(a.getAsks());
	            }
	        }
	        return(queriedAsks);
		}
		catch (Exception e){
			throw new Exception ("Date was inputted incorrectly");
		}
	}

public List<Give> searchAccountQueryReturnGives(String key, String s_d, String e_d) throws Exception {
	
	try {
		LocalDate start_date;
		LocalDate end_date;
		String[] startDateSplit = s_d.split("-",0);
		s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
		start_date = LocalDate.parse(s_d);
		
		String[] endDateSplit = e_d.split("-",0);
		e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
		end_date = LocalDate.parse(e_d);
		List <Give> queriedGives = new ArrayList<Give>();
        Iterator<Account> ac = accounts.listIterator();
        while(ac.hasNext()) {
//        	Account a = ac.next();
//        	queriedAccounts.add(a.containsInAccount(key));
            Account a = ac.next();
//            queriedAccounts.add(a.containsInAccount(key));
            Boolean before = LocalDate.parse(a.getDateCreated()).isAfter(start_date) || LocalDate.parse(a.getDateCreated()).isEqual(start_date);
            Boolean after = LocalDate.parse(a.getDateCreated()).isBefore(end_date) || LocalDate.parse(a.getDateCreated()).isEqual(end_date);
            if(a.containsInAccount(key) && before && after) {
            	queriedGives.addAll(a.getGives());
            }
        }
        return(queriedGives);
	}
	catch (Exception e){
		throw new Exception ("Date was inputted incorrectly");
	}
}

public List<Thank> searchAccountQueryReturnThanks(String key, String s_d, String e_d) throws Exception {
	
	try {
		LocalDate start_date;
		LocalDate end_date;
		String[] startDateSplit = s_d.split("-",0);
		s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
		start_date = LocalDate.parse(s_d);
		
		String[] endDateSplit = e_d.split("-",0);
		e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
		end_date = LocalDate.parse(e_d);
		
		List <Thank> queriedThanks = new ArrayList<Thank>();
        Iterator<Account> ac = accounts.listIterator();
        while(ac.hasNext()) {
//        	Account a = ac.next();
//        	queriedAccounts.add(a.containsInAccount(key));
            Account a = ac.next();
//            queriedAccounts.add(a.containsInAccount(key));
            Boolean before = LocalDate.parse(a.getDateCreated()).isAfter(start_date) || LocalDate.parse(a.getDateCreated()).isEqual(start_date);
            Boolean after = LocalDate.parse(a.getDateCreated()).isBefore(end_date) || LocalDate.parse(a.getDateCreated()).isEqual(end_date);
            if(a.containsInAccount(key) && before && after) {
            	queriedThanks.addAll(a.getThanks());
            }
        }
        return(queriedThanks);
	}
	catch (Exception e){
		throw new Exception ("Date was inputted incorrectly");
	}
}
        
	
	public void activateAccount(String uid) throws Exception {
		Account temp = findById(uid);
		if (temp.isNil()) {
			throw new Exception();
			}
		else {
			temp.setIsActive(true);
			}
	}
	
	public void deactivateAccount(String uid) throws Exception {
		Account temp = findById(uid);
		if (temp.isNil()) {
			throw new Exception();
			}
		else {
			temp.deactivate_account();
			}
	}
	
	public void deleteAccountFromManagement(String uid) throws Exception {
		Account temp = findById(uid);
		if (temp.isNil()) {
			throw new Exception("Element does not exist");
			}
		else {
			accounts.remove(temp);
			}
		}
	
	public void updateAccountFromManagement(String uid, String json) throws Exception {
		Account temp = findById(uid);
		if (temp.isNil()) {
			throw new Exception("Element does not exist");
			}
		else {
			ObjectMapper mapper = new ObjectMapper();
			Account a = mapper.readValue(json, Account.class);
			a.setUID(temp.getId());
			accounts.remove(temp);
			accounts.add(a);
			}
		}
	
	
	

//	
	
//	public Note addNewNote(Note n) {
//		Note nn = n;
//		notes.add(nn);
//		return nn;
//	}
//	
	public EntityInterface getEI(EntityInterface temp, String aid) {
		return findById(temp, aid);
	}
	
	public List <Ask> getAllAsks() {
		return asks;
	}
	
	public List <Give> getAllGives() {
		return gives;
	}
	
	public List <Thank> getAllThanks() {
		return thanks;
	}
	
	public List <Note> getAllNotes() {
		return notes;
	}
	
	public void searchAndDeactivate(EntityInterface temp, String aid) {
		if (temp instanceof Ask) {
			((Ask) this.findById(temp, aid)).deactivateAsk();
		}
		if (temp instanceof Give) {
			((Give) this.findById(temp, aid)).deactivateGive();
		}
	}
	
	public void searchAndUpdate(String id, EntityInterface temp) {
		if (temp instanceof Ask) {
			Ask pulled = (Ask) this.findById(temp, id);
			pulled = pulled.updateThisAsk((Ask) temp);
		}
		if (temp instanceof Give) {
			Give pulled = (Give) this.findById(temp, id);
			pulled = pulled.updateThisGive((Give) temp);
		}
		if (temp instanceof Thank) {
			Thank pulled = (Thank) this.findById(temp, id);
			pulled = pulled.updateThisThank((Thank) temp);
		}
		if (temp instanceof Note) {
			Note pulled = (Note) this.findById(temp, id);
			pulled = pulled.updateThisNote((Note) temp);
		}
	}
	
	public void searchAndDeleteAsk(String aid) throws Exception {
		Ask temp = (Ask) findById(new Ask(), aid);
		if (temp.isNil()) {
			throw new Exception("Element does not exist");
			}
		else {
			asks.remove(temp);
			}
	}
	
	public void searchAndDeleteGive(String gid) throws Exception {
		Give temp = (Give) findById(new Give(), gid);
		if (temp.isNil()) {
			throw new Exception("Element does not exist");
			}
		else {
			gives.remove(temp);
			}
	}
	
	public void searchAndDeleteNote(String nid) throws Exception {
		Note temp = (Note) findById(new Note(), nid);
		if (temp.isNil()) {
			throw new Exception("Element does not exist");
			}
		else {
			notes.remove(temp);
			}
	}
	
//	public void searchAndDelete(EntityInterface temp, String id) throws NotFoundException{
//		if (temp instanceof Ask) {
//	        Iterator<Ask> as = asks.listIterator();
//	        while(as.hasNext()) {
//	            Ask a = as.next();
//	            if(a.matchesId(id)) a.deactivateAsk();
//	        }
//		}
//		if (temp instanceof Give) {
//	        Iterator<Give> gs = gives.listIterator();
//	        while(gs.hasNext()) {
//	            Give g = gs.next();
//	            if(g.matchesId(id)) g.deactivateGive();
//	        }
//		}
//		else {
//			throw new NotFoundException("EntityInterface Not Found");
//		}
//    }
	
	private EntityInterface findById(EntityInterface temp, String id) throws NotFoundException{
		if (temp instanceof Ask) {
	        Iterator<Ask> as = asks.listIterator();
	        while(as.hasNext()) {
	            Ask a = as.next();
	            if(a.matchesId(id)) return(a);
	        }
	        throw new NotFoundException("Ask Not Found");
		}
		if (temp instanceof Give) {
	        Iterator<Give> gs = gives.listIterator();
	        while(gs.hasNext()) {
	            Give g = gs.next();
	            if(g.matchesId(id)) return(g);
	        }
	        throw new NotFoundException("Give Not Found");
		}
		if (temp instanceof Thank) {
	        Iterator<Thank> ts = thanks.listIterator();
	        while(ts.hasNext()) {
	            Thank t = ts.next();
	            if(t.matchesId(id)) return(t);
	        }
	        throw new NotFoundException("Give Not Found");
		}
		if (temp instanceof Note) {
	        Iterator<Note> ns = notes.listIterator();
	        while(ns.hasNext()) {
	            Note n = ns.next();
	            if(n.matchesId(id)) return(n);
	        }
	        throw new NotFoundException("Give Not Found");
		}
		else {
			throw new NotFoundException("EntityInterface Not Found");
		}
    }
	
public List <Ask> searchAskQuery(String key, String s_d, String e_d) throws Exception {
		
		try {
			LocalDate start_date;
			LocalDate end_date;
			String[] startDateSplit = s_d.split("-",0);
			s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
			start_date = LocalDate.parse(s_d);
			
			String[] endDateSplit = e_d.split("-",0);
			e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
			end_date = LocalDate.parse(e_d);
			List <Ask> queriedAsks = new ArrayList<Ask>();
	        Iterator<Ask> ac = asks.listIterator();
	        while(ac.hasNext()) {
//	        	Account a = ac.next();
//	        	queriedAccounts.add(a.containsInAccount(key));
	            Ask a = ac.next();
//	            queriedAccounts.add(a.containsInAccount(key));
	            Boolean before = LocalDate.parse(a.getDateCreated()).isAfter(start_date) || LocalDate.parse(a.getDateCreated()).isEqual(start_date);
	            Boolean after;
	            
	            if (a.getEndDate() == ""){
	            	after = true;
	            }
	            else {
	            	String[] askEndDateSplit = a.getEndDate().split("-",0);
					String new_end_date = askEndDateSplit[2] + "-" + askEndDateSplit[0] + "-" + askEndDateSplit[1];
					LocalDate ask_end_date = LocalDate.parse(new_end_date); 

	            	after = ask_end_date.isBefore(end_date) || ask_end_date.isEqual(end_date);
	            }
				
	            
	            if(a.containsInAsk(key) && before && after) {
	            	queriedAsks.add(a);
	            }
	        }
	        return(queriedAsks);
		}
		catch (Exception e){
			throw new Exception ("Date was inputted incorrectly");
		}
	}

public List <Give> searchGiveQuery(String key, String s_d, String e_d) throws Exception {
	
	try {
		LocalDate start_date;
		LocalDate end_date;
		String[] startDateSplit = s_d.split("-",0);
		s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
		start_date = LocalDate.parse(s_d);
		
		String[] endDateSplit = e_d.split("-",0);
		e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
		end_date = LocalDate.parse(e_d);
		
		List <Give> queriedGives = new ArrayList<Give>();
        Iterator<Give> gc = gives.listIterator();
        while(gc.hasNext()) {
//        	Account a = ac.next();
//        	queriedAccounts.add(a.containsInAccount(key));
            Give g = gc.next();
//            queriedAccounts.add(a.containsInAccount(key));
            Boolean before = LocalDate.parse(g.getDateCreated()).isAfter(start_date) || LocalDate.parse(g.getDateCreated()).isEqual(start_date);
            Boolean after;
            
            if (g.getEndDate() == ""){
            	after = true;
            }
            else {
            	String[] giveEndDateSplit = g.getEndDate().split("-",0);
				String new_end_date = giveEndDateSplit[2] + "-" + giveEndDateSplit[0] + "-" + giveEndDateSplit[1];
				LocalDate give_end_date = LocalDate.parse(new_end_date); 

            	after = give_end_date.isBefore(end_date) || give_end_date.isEqual(end_date);
            }
			
            if(g.containsInGive(key) && before && after) {
            	queriedGives.add(g);
            }
        }
        return(queriedGives);
	}
	catch (Exception e){
		throw new Exception ("Date was inputted incorrectly");
	}
}

public List <Thank> searchThankQuery(String key, String s_d, String e_d) throws Exception {
	
	try {
		LocalDate start_date;
		LocalDate end_date;
		String[] startDateSplit = s_d.split("-",0);
		s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
		start_date = LocalDate.parse(s_d);
		
		String[] endDateSplit = e_d.split("-",0);
		e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
		end_date = LocalDate.parse(e_d);
		
		List <Thank> queriedThanks = new ArrayList<Thank>();
        Iterator<Thank> gc = thanks.listIterator();
        while(gc.hasNext()) {
//        	Account a = ac.next();
//        	queriedAccounts.add(a.containsInAccount(key));
            Thank g = gc.next();
//            queriedAccounts.add(a.containsInAccount(key));
            Boolean before = LocalDate.parse(g.getDateCreated()).isAfter(start_date) || LocalDate.parse(g.getDateCreated()).isEqual(start_date);
            Boolean after;
            
            
            if (g.getEndDate() == ""){
            	after = true;
            }
            else {
            	String[] giveEndDateSplit = g.getEndDate().split("-",0);
				String new_end_date = giveEndDateSplit[2] + "-" + giveEndDateSplit[0] + "-" + giveEndDateSplit[1];
				LocalDate give_end_date = LocalDate.parse(new_end_date); 

            	after = give_end_date.isBefore(end_date) || give_end_date.isEqual(end_date);
            }
            if(g.containsInThank(key) && before && after) {
            	queriedThanks.add(g);
            }
        }
        return(queriedThanks);
	}
	catch (Exception e){
		throw new Exception ("Date was inputted incorrectly");
	}
}

public List <Note> searchNoteQuery(String c, String v, String type, String agid, String key, String s_d, String e_d) throws Exception {
	
	try {
		LocalDate start_date;
		LocalDate end_date;
		String[] startDateSplit = s_d.split("-",0);
		s_d = startDateSplit[2] + "-" + startDateSplit[0] + "-" + startDateSplit[1];
		start_date = LocalDate.parse(s_d);
		
		String[] endDateSplit = e_d.split("-",0);
		e_d = endDateSplit[2] + "-" + endDateSplit[0] + "-" + endDateSplit[1];
		end_date = LocalDate.parse(e_d);
		
		List <Note> queriedNotes = new ArrayList<Note>();
        Iterator<Note> nc = notes.listIterator();
        while(nc.hasNext()) {
//        	Account a = ac.next();
//        	queriedAccounts.add(a.containsInAccount(key));
            Note n = nc.next();
//            queriedAccounts.add(a.containsInAccount(key));
            Boolean before = LocalDate.parse(n.getDateCreated()).isAfter(start_date) || LocalDate.parse(n.getDateCreated()).isEqual(start_date);
            Boolean after;
            
			LocalDate note_end_date = LocalDate.parse(n.getDateCreated()); 

            after = note_end_date.isBefore(end_date) || note_end_date.isEqual(end_date);
            
//            Boolean created_by = true;
//            Boolean viewed_by = false;
//            Boolean matching_types = false;
//            Boolean to_user_id = false;
//            
//            n.setUID(n.getUID());
//            
//            if (n.getUID() != c) {
//            	created_by = false;
//            }
//            
//            if (n.getUID() == v || n.getToUserId() == v || v == "") {
//            	viewed_by = true;
//            }
//            
//            if (n.getToType() == type || type == "") {
//            	matching_types = true;
//            }
//            
//            if (n.getToUserId()== agid || agid == "") {
//            	to_user_id = true;
//            }
            
            if(n.containsInNotes(key) && before && after) {
            	queriedNotes.add(n);
            }
        }
        return(queriedNotes);
	}
	catch (Exception e){
		throw new Exception ("Date was inputted incorrectly");
	}
}


	public Account searchAndReturn(String uid) {
		return this.findById(uid);
	}

	
	public List<Account> getAllAccounts() {
		return(accounts);
	}
}
