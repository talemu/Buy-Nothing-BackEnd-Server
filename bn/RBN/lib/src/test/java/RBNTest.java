import static org.junit.Assert.*;


import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

//Junit Import

public class RBNTest {
	
	Account a1 = new Account();	
	BNManager bn1 = new BNManager();
	
	
	@Before
	public void init() {
		bn1.addNewAccount(a1);
	}
	
	@Test
	public void account_date_created_up_to_date() {
		int a1_date_created_year = LocalDate.parse(a1.getDateCreated()).getYear();
		assertTrue(a1_date_created_year == LocalDate.now().getYear());
		assertTrue(a1.isNil() == false);
		}

	@Test
	public void setting_Account_uid_and_returning_value_and_test_matching_method() {
		Account a2 = new Account();
		String s = "101";
		a1.setUID(s);
		assertEquals(s, a1.getUID());
		assertFalse(a1.matchesId(a2.getUID()));
		}
	
	@Test
	public void test_contains_method() {
		a1.deactivate_account();
		assertFalse(a1.getIsActive());
		}
	
	@Test
	public void test_search_and_return_methods() {
		Ask a = new Ask();
		Give g = new Give();
		Thank t = new Thank();
		Note n = new Note();
		a1.addAsk(a);
		a1.addGive(g);
		a1.addThank(t);
		a1.addNote(n);
		EntityInterface e1 = a1.searchAndReturn(new Ask(),a.getId());
		EntityInterface e2 = a1.searchAndReturn(new Give(), g.getId());
		EntityInterface e3 = a1.searchAndReturn(new Thank(),t.getId());
		EntityInterface e4 = a1.searchAndReturn(new Note(),n.getId());
		assertTrue(a == e1 && g == e2 && t == e3 && n == e4);
	}
	
	@Test
	public void test_search_and_deactivate_methods() {
		Ask a = new Ask();
		Give g = new Give();
		a1.addAsk(a);
		a1.addGive(g);
		a1.searchAndDeactivate(new Ask(),a.getId());
		a1.searchAndDeactivate(new Give(), g.getId());
		assertTrue(a.getActive() == false && g.getActive() == false);
	}
	
	@Test
	public void test_search_account_query() throws Exception {
		bn1.addNewAccount(a1);
		List <Account> l1 = bn1.searchAccountQuery("", "10-28-2000", "10-28-2030");
		List <Account> l2 = bn1.getAllAccounts();
		assertEquals(l1, l2);
	}
	
	@Test
	public void test_search_asks_query() throws Exception {
		Ask as = new Ask();
		as.setEndDate("10-22-2025");
		bn1.addNewAsk(as);
		List<Ask> l1 = bn1.searchAskQuery("", "10-28-2000", "10-28-2030");
		List <Ask> l2 = bn1.getAllAsks();
		assertEquals(l1, l2);
	}
	
	@Test
	public void test_search_gives_query() throws Exception {
		Give gs = new Give();
		gs.setEndDate("10-22-2025");
		bn1.addNewGive(gs);
		List<Give> l1 = bn1.searchGiveQuery("", "10-28-2000", "10-28-2030");
		List <Give> l2 = bn1.getAllGives();
		assertEquals(l1, l2);
	}
	
	@Test
	public void test_search_thanks_query() throws Exception {
		Thank ts = new Thank();
		ts.setEndDate("10-22-2025");
		bn1.addNewThank(ts);
		List<Thank> l1 = bn1.searchThankQuery("", "10-28-2000", "10-28-2030");
		List <Thank> l2 = bn1.getAllThanks();
		assertEquals(l1, l2);
	}
	
	@Test
	public void test_search_notes_query() throws Exception {
		Note ns = new Note();
		bn1.addNewNote(ns);
		List<Note> l1 = bn1.searchNoteQuery("", "", "", "", "", "10-28-2000", "10-28-2030");
		List <Note> l2 = bn1.getAllNotes();
		assertEquals(l1, l2);
	}
	
	@Test
	public void test_search_account_query_return_all_asks() throws Exception {
		List<Ask> l1 = bn1.searchAccountQueryReturnAsks("", "10-28-2000", "10-28-2030");
		List<Ask> l2 = a1.getAsks();
		assertEquals(l1, l2);
	}
	
	@Test
	public void test_search_account_query_return_all_thanks() throws Exception {
		List<Thank> l1 = bn1.searchAccountQueryReturnThanks("", "10-28-2000", "10-28-2030");
		List<Thank> l2 = a1.getThanks();
		assertEquals(l1, l1);
	}
	
	@Test
	public void test_search_account_query_return_all_gives() throws Exception {
		List<Give> l1 = bn1.searchAccountQueryReturnGives("", "10-28-2000", "10-28-2030");
		List<Give> l2 = a1.getGives();
		assertEquals(l1, l1);
	}
	
	@Test
	public void test_activate_deactivate_account() throws Exception {
		bn1.activateAccount(a1.getUID());
		assertTrue(a1.getIsActive());
		bn1.deactivateAccount(a1.getUID());
		assertFalse(a1.getIsActive());
	}
	
	
	@Test
	public void test_search_and_deactivate_methods_ask_give() throws Exception {
		Ask a = new Ask();
		Give g = new Give();
		bn1.addNewAsk(a);
		bn1.addNewGive(g);
		bn1.searchAndDeactivate(a, a.getId());
		bn1.searchAndDeactivate(g, g.getId());
		assertFalse(a.getActive());
		assertFalse(g.getActive());
	}
	
	@Test
	public void test_search_and_update_methods_ask_give_thank_note() throws Exception {
		Ask a = new Ask();
		Give g = new Give();
		Thank t = new Thank();
		Note n = new Note();
		Ask a1 = new Ask();
		Give g1 = new Give();
		Thank t1 = new Thank();
		Note n1 = new Note();
		bn1.addNewAsk(a);
		bn1.addNewGive(g);
		bn1.addNewThank(t);
		bn1.addNewNote(n);
		bn1.searchAndUpdate(a.getId(), a1);
		bn1.searchAndUpdate(g.getId(), g1);
		bn1.searchAndUpdate(t.getId(), t1);
		bn1.searchAndUpdate(n.getId(), n1);
		assertEquals(a.getType(), a1.getType());
		assertEquals(g.getType(), g1.getType());
		assertEquals(t.getEndDate(), t1.getEndDate());
		assertEquals(n.getToId(), n1.getToId());
	}
	
	@Test
	public void test_search_and_update_fromAccount_methods_ask_give_thank_note() throws Exception {
		Ask a = new Ask();
		Give g = new Give();
		Thank t = new Thank();
		Note n = new Note();
		Ask a2 = new Ask();
		Give g1 = new Give();
		Thank t1 = new Thank();
		Note n1 = new Note();
		a1.addAsk(a);
		a1.addGive(g);
		a1.addThank(t);
		a1.addNote(n);
		a1.searchAndUpdate(a.getId(), new Ask(), a2);
		a1.searchAndUpdate(g.getId(), new Give(), g1);
		a1.searchAndUpdate(t.getId(), new Thank(), t1);
		a1.searchAndUpdate(n.getId(), new Note(), n1);
		assertEquals(a.getType(), a2.getType());
		assertEquals(g.getType(), g1.getType());
		assertEquals(t.getEndDate(), t1.getEndDate());
		assertEquals(n.getToId(), n1.getToId());
	}
	
	@Test
	public void test_searchAndDeleteAsk_Give_Note() throws Exception {
		Ask a = new Ask();
		Give g = new Give();
		Note n = new Note();
		bn1.addNewAsk(a);
		bn1.searchAndDeleteAsk(a.getId());
		bn1.addNewGive(g);
		bn1.searchAndDeleteGive(g.getId());
		bn1.addNewNote(n);
		bn1.searchAndDeleteNote(n.getId());
		assertEquals(bn1.getAllAsks().size(), 0);
		assertEquals(bn1.getAllGives().size(), 0);
		assertEquals(bn1.getAllNotes().size(), 0);
	}
	
}

	
//	@Test
//	public void test_containsArrayST_ET() {
//		//testing if contains array in start time end time
//		Account a2 = new Account();
//		bn1.addNewAccount(a2);
//		System.out.println(bn1);
//		BNManager beforeA2 = bn1.containsArrayStartTime(LocalDate.now());
//		System.out.println(beforeA2.getAllAccounts());
//	}
//}


