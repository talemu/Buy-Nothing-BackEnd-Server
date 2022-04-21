
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BNManager {
	private static ArrayList<Account> accounts;
	private static ArrayList<Ask> asks;
	private static ArrayList<Give> gives;
	private static ArrayList<Thank> thanks;
	private static ArrayList<Note> notes;
	
	public BNManager() {
		accounts = new ArrayList<Account>();
		asks = new ArrayList<Ask>();
		gives = new ArrayList<Give>();
		thanks = new ArrayList<Thank>();
		notes = new ArrayList<Note>();
	}
	
	public Date stringToDate (String s) throws ParseException {
		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(s);
		return d;
	}
	
	public Account addNewAccount(Account a) {
		Account na = a;
		accounts.add(na);
		return na;
	}
	
	public Ask addNewAsk(Ask a) {
		Ask na = a;
		asks.add(na);
		return na;
	}
	
	public Give addNewGive(Give g) {
		Give ng = g;
		gives.add(ng);
		return ng;
	}
	
	public Thank addNewThank(Thank t) {
		Thank nt = t;
		thanks.add(nt);
		return nt;
	}
	
	public Note addNewNote(Note n) {
		Note nn = n;
		notes.add(nn);
		return nn;
	}
	
	public Ask getAsk(UUID aid) {
		for(int i = 0; i < asks.size(); i++) {
			if (asks.get(i).getId() == aid) {
				return asks.get(i);
			}
		}
		return new NullAsk();
	}
	
	public Give getGive(UUID gid) {
		for(int i = 0; i < gives.size(); i++) {
			if (gives.get(i).getId() == gid) {
				return gives.get(i);
			}
		}
		return new NullGive();
	}
	
	public Thank getThank(UUID tid) {
		for(int i = 0; i < thanks.size(); i++) {
			if (thanks.get(i).getId() == tid) {
				return thanks.get(i);
			}
		}
		return new NullThank();
	}
	
	public Note getNote(UUID nid) {
		for(int i = 0; i < notes.size(); i++) {
			if (notes.get(i).getId() == nid) {
				return notes.get(i);
			}
		}
		return new NullNote();
	}
	
	public Account searchAM(UUID uid) {
		for(int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getId() == uid) {
				return accounts.get(i);
			}
		}
		return new NullAccount();
	}
	
	public void removeAsk(UUID aid) {
		for(int i = 0; i < asks.size(); i++) {
			if (asks.get(i).getId() == aid) {
				asks.remove(i);
			}
		}
	}
	
	public void removeGive(UUID gid) {
		for(int i = 0; i < gives.size(); i++) {
			if (gives.get(i).getId() == gid) {
				gives.remove(i);
			}
		}
	}
//	
//	public Ask searchAskM(UUID aid) {
//		
//	}
//	}
	
	public void deleteAccountFromManagement(UUID uid) {
		Account temp = searchAM(uid);
		accounts.remove(temp);
		}
	
	public ArrayList<Account> getAllAccounts() {
		return(accounts);
	}
	
	public ArrayList<Ask> getAllAsks() {
		return(asks);
	}
	
	public ArrayList<Give> getAllGives() {
		return(gives);
	}
	
	public ArrayList<Thank> getAllThanks() {
		return(thanks);
	}
	
	public ArrayList<Thank> getThankTo(UUID tid) {
		ArrayList <Thank> temp = new ArrayList <Thank>();
		for(int i = 0; i < thanks.size(); i++) {
			if (thanks.get(i).getThankTo() == tid) {
				temp.add(thanks.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Account> containsArray(String s) {
		ArrayList<Account> temp = new ArrayList<Account>();
		for(int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).containsInAccount(s)) {
				temp.add(accounts.get(i));
			}
	}
		return temp;
	}
	
	public ArrayList<Ask> containsArrayAsk(String s) {
		ArrayList<Ask> temp = new ArrayList<Ask>();
		for(int i = 0; i < asks.size(); i++) {
			if (asks.get(i).containsInAsk(s)) {
				temp.add(asks.get(i));
			}
	}
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).containsInAccount(s)) {
				temp.addAll(accounts.get(i).getAsks());
			}
		}
		return temp;
	}
	
	public ArrayList<Give> containsArrayGive(String s) {
		ArrayList<Give> temp = new ArrayList<Give>();
		for(int i = 0; i < gives.size(); i++) {
			if (gives.get(i).containsInGive(s)) {
				temp.add(gives.get(i));
			}
	}
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).containsInAccount(s)) {
				temp.addAll(accounts.get(i).getGives());
			}
		}
		return temp;
	}
	
	public ArrayList<Thank> containsArrayThank(String s) {
		ArrayList<Thank> temp = new ArrayList<Thank>();
		for(int i = 0; i < thanks.size(); i++) {
			if (thanks.get(i).containsInThank(s)) {
				temp.add(thanks.get(i));
			}
	}
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).containsInAccount(s)) {
				temp.addAll(accounts.get(i).getThanks());
			}
		}
		return temp;
	}
	
	public ArrayList<Note> containsArrayNote(String s) {
		ArrayList<Note> temp = new ArrayList<Note>();
		for(int i = 0; i < notes.size(); i++) {
			if (notes.get(i).containsInNotes(s)) {
				temp.add(notes.get(i));
			}
	}
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).containsInAccount(s)) {
				temp.addAll(accounts.get(i).getNotes());
			}
		}
		return temp;
	}
	
	//date parameter arrays for accounts
	public BNManager containsArrayStartTime(String st) throws ParseException {
		BNManager temp = new BNManager();
		Date d = stringToDate(st);
		for(int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getDateCreated().compareTo(d) >= 0) {
				temp.addNewAccount(accounts.get(i));
			}
	}
		return temp;
	}
	
	public BNManager containsArrayEndTime(String st) throws ParseException {
		BNManager temp = new BNManager();
		Date d = stringToDate(st);
		for(int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getDateCreated().compareTo(d) <= 0) {
				temp.addNewAccount(accounts.get(i));
			}
	}
		return temp;
	}
	
	//date parameter arrays for asks
	public BNManager containsASTA(String st) throws ParseException {
		BNManager temp = new BNManager();
		Date d = stringToDate(st);
		for(int i = 0; i < asks.size(); i++) {
			if (asks.get(i).getDateCreated().compareTo(d) >= 0) {
				temp.addNewAsk(asks.get(i));
			}
	}
		return temp;
	}
	
	public BNManager containsAETA(String st) throws ParseException {
		BNManager temp = new BNManager();
		Date d = stringToDate(st);
		for(int i = 0; i < asks.size(); i++) {
			if (asks.get(i).getDateCreated().compareTo(d) <= 0) {
				temp.addNewAsk(asks.get(i));
			}
	}
		return temp;
	}
	
	//date parameter arrays for gives
	public BNManager containsASTG(String st) throws ParseException {
		BNManager temp = new BNManager();
		Date d = stringToDate(st);
		for(int i = 0; i < gives.size(); i++) {
			if (gives.get(i).getDateCreated().compareTo(d) >= 0) {
				temp.addNewGive(gives.get(i));
			}
	}
		return temp;
	}
	
	public BNManager containsAETG(String st) throws ParseException {
		BNManager temp = new BNManager();
		Date d = stringToDate(st);
		for(int i = 0; i < gives.size(); i++) {
			if (gives.get(i).getDateCreated().compareTo(d) <= 0) {
				temp.addNewGive(gives.get(i));
			}
	}
		return temp;
	}
	//date parameter arrays for thanks
		public BNManager containsASTT(String st) throws ParseException {
			BNManager temp = new BNManager();
			Date d = stringToDate(st);
			for(int i = 0; i < thanks.size(); i++) {
				if (thanks.get(i).getDateCreated().compareTo(d) >= 0) {
					temp.addNewThank(thanks.get(i));
				}
		}
			return temp;
		}
		
		public BNManager containsAETT(String st) throws ParseException {
			BNManager temp = new BNManager();
			Date d = stringToDate(st);
			for(int i = 0; i < thanks.size(); i++) {
				if (thanks.get(i).getDateCreated().compareTo(d) <= 0) {
					temp.addNewThank(thanks.get(i));
				}
		}
			return temp;
		}
		
		public BNManager containsASTN(String st) throws ParseException {
			BNManager temp = new BNManager();
			Date d = stringToDate(st);
			for(int i = 0; i < notes.size(); i++) {
				if (notes.get(i).getDateCreated().compareTo(d) >= 0) {
					temp.addNewNote(notes.get(i));
				}
		}
			return temp;
		}
		
		public BNManager containsAETN(String st) throws ParseException {
			BNManager temp = new BNManager();
			Date d = stringToDate(st);
			for(int i = 0; i < notes.size(); i++) {
				if (notes.get(i).getDateCreated().compareTo(d) <= 0) {
					temp.addNewNote(notes.get(i));
				}
		}
			return temp;
		}
}
