//
//
//import static org.junit.Assert.*;
//
//import java.time.Clock;
//import java.time.LocalDate;
//import java.util.*;
//
//import org.junit.*;
//
////Junit Import
//
//public class AccountTest {
//	
//	Account a1 = new Account();	
//	BNManager bn = new BNManager();
//	
//	
//	@Before
//	public void init() {
//		a1.setZip("60616");
//		a1.setStreet("Elm Street");
//		Ask a = new Ask();
//		a1.addAsk(a);
//		Ask a2 = new Ask();
//		a1.addAsk(a2);
//		a2.deactivateAsk();
//		Give g = new Give();
//		a1.addGive(g);
//		Give g2 = new Give();
//		a1.addGive(g2);
//		g2.deactivateGive();
//		Thank t = new Thank();
//		a1.addThank(t);
//		Note n = new Note();
//		a1.addNote(n);
//	}
//	
//	@Test
//	public void account_ID_Built() {
//		assertTrue(a1.getId() instanceof UUID);
//		assertTrue(a1.isNil() == false);
//	}
//	
//	@Test
//	public void valid_Date_Created() {
//		//test creating a date instance that is before now local time
//		LocalDate d = a1.getDateCreated();
//		System.out.println(d);
//		LocalDate now = LocalDate.now();
//		assertTrue(d.compareTo(now) <= 0);
//	}
////	
//	@Test
//	public void test_Account_Activity() {
//		//this first test looks at the activity of a1
//		boolean firstTest = a1.getActive();
//		a1.deactivate_account();
//		boolean secondTest = a1.getActive();
//		assertEquals(firstTest, true);
//		assertEquals(secondTest, false);
//	}
//	
//	@Test
//	public void test_getZip_and_getStreet() {
//		String z = a1.getZip();
//		String s = a1.getStreet();
//		assertTrue(z == "60616" && s == "Elm Street");
//	}
//	
//	@Test
//	public void test_ContainsInAccountFuction() {
//		assertTrue(a1.containsInAccount("60616"));
//		assertFalse(a1.containsInAccount("State"));
//	}
//	
//	@Test
//	public void test_action_gets() {
//		ArrayList <Ask> temp = a1.getAsks(); 
//		for (int i = 0; i < temp.size(); i++) {
//			assertTrue(temp.get(i) instanceof Ask);
//		}
//		ArrayList <Give> temp2 = a1.getGives(); 
//		for (int i = 0; i < temp2.size(); i++) {
//			assertTrue(temp2.get(i) instanceof Give);
//		}
//		ArrayList <Thank> temp3 = a1.getThanks(); 
//		for (int i = 0; i < temp3.size(); i++) {
//			assertTrue(temp3.get(i) instanceof Thank);
//		}
//		ArrayList <Note> temp4 = a1.getNotes(); 
//		for (int i = 0; i < temp4.size(); i++) {
//			assertTrue(temp4.get(i) instanceof Note);
//		}
//	}
//	
//	@Test
//	public void test_getAsksBasedonActivity_active() {
//		//true asks should include only ask a
//		ArrayList <Ask> trueAsks = a1.getAsksBasedonActivity("true");
//		for (int i = 0; i < trueAsks.size(); i++) {
//			assertTrue (trueAsks.get(i).getActive());
//		}
//		
//		//All asks should include ask a and a2
//		ArrayList <Ask> allAsks = a1.getAsksBasedonActivity("null");
//		for (int i = 0; i < allAsks.size(); i++) {
//			assertTrue (allAsks.get(i) instanceof Ask);
//		}
//	}
//	
//	@Test
//	public void test_getGivesBasedonActivity_active() {
//		//true gives should include only ask g
//		ArrayList <Give> trueGives = a1.getGivesBasedonActivity("true");
//		for (int i = 0; i < trueGives.size(); i++) {
//			assertTrue (trueGives.get(i).getActive());
//		}
//		
//		//All gives should include ask g and g2
//		ArrayList <Give> allGives = a1.getGivesBasedonActivity("null");
//		for (int i = 0; i < allGives.size(); i++) {
//			assertTrue (allGives.get(i) instanceof Give);
//		}
//	}
//	
//	@Test
//	public void test_searchForAsk_Ask_Found() {
//		Ask a3 = new Ask();
//		a1.addAsk(a3);
//		Ask searchedAsk = a1.searchForAsk(a3.getId());
//		assertEquals(searchedAsk, a3);
//	}
//	
//	@Test
//	public void test_searchForAsk_Ask_NotFound() {
//		//searchedAsk will not be found, creating a null ask
//		Ask searchedAsk = a1.searchForAsk(UUID.randomUUID());
//		assertTrue(searchedAsk instanceof NullAsk);
//	}
//	
//	@Test
//	public void test_searchForGive_Give_Found() {
//		Give g3 = new Give();
//		a1.addGive(g3);
//		Give searchedGive = a1.searchForGive(g3.getId());
//		assertEquals(searchedGive, g3);
//	}
//	
//	@Test
//	public void test_searchForGive_Give_NotFound() {
//		//searchedAsk will not be found, creating a null ask
//		Give searchedGive = a1.searchForGive(UUID.randomUUID());
//		assertTrue(searchedGive instanceof NullGive);
//	}
//	
//	@Test
//	public void test_searchForThank_Thank_Found() {
//		Thank t3 = new Thank();
//		a1.addThank(t3);
//		Thank searchedThank = a1.searchForThank(t3.getId());
//		assertEquals(searchedThank, t3);
//	}
//	
//	@Test
//	public void test_searchForThank_Thank_NotFound() {
//		//searchedThank will not be found, creating a null thank
//		Thank searchedThank = a1.searchForThank(UUID.randomUUID());
//		assertTrue(searchedThank instanceof NullThank);
//	}
//	
//	@Test
//	public void test_searchForNote_Note_Found() {
//		Note n3 = new Note();
//		a1.addNote(n3);
//		Note searchedNote = a1.searchForNote(n3.getId());
//		assertEquals(searchedNote, n3);
//	}
//	
//	@Test
//	public void test_searchForNote_Note_NotFound() {
//		//searchedNote will not be found, creating a null note
//		Note searchedNote = a1.searchForNote(UUID.randomUUID());
//		assertTrue(searchedNote instanceof NullNote);
//	}
//	
//	@Test
//	public void test_deleteAsk_Ask_Found() {
//		//create ask instance
//		Ask a3 = new Ask();
//		a1.addAsk(a3);
//		//delete ask instance
//		a1.deleteAsk(a3.getId());
//		//when searching for deleted ask instance, 
//		//it should return a null ask
//		Ask a4 = a1.searchForAsk(a3.getId());
//		assertTrue(a4 instanceof NullAsk);
//	}
//	
//	@Test
//	public void test_deleteAsk_Ask_NotFound() {
//		Ask a3 = a1.deleteAsk(UUID.randomUUID());
//		assertTrue(a3 instanceof NullAsk);
//	}
//	
//	@Test
//	public void test_deleteGive_Give_Found() {
//		//create give instance
//		Give g3 = new Give();
//		a1.addGive(g3);
//		//delete give instance
//		a1.deleteGive(g3.getId());
//		//when searching for deleted give instance, 
//		//it should return a null give
//		Give g4 = a1.searchForGive(g3.getId());
//		assertTrue(g4 instanceof NullGive);
//	}
//	
//	@Test
//	public void test_deleteGive_Give_NotFound() {
//		Give g3 = a1.deleteGive(UUID.randomUUID());
//		assertTrue(g3 instanceof NullGive);
//	}
//	
//	@Test
//	public void test_deleteNote_Note_Found() {
//		//create note instance
//		Note n3 = new Note();
//		a1.addNote(n3);
//		//delete note instance
//		a1.deleteNote(n3.getId());
//		//when searching for deleted note instance, 
//		//it should return a null note
//		Note n4 = a1.searchForNote(n3.getId());
//		assertTrue(n4 instanceof NullNote);
//	}
//	
//	@Test
//	public void test_deleteNote_Note_NotFound() {
//		Note n3 = a1.deleteNote(UUID.randomUUID());
//		assertTrue(n3 instanceof NullNote);
//	}
//}
//
//
