//import static org.junit.Assert.*;
//
//import java.time.Clock;
//import java.time.LocalDate;
//import java.util.*;
//
//import org.junit.*;
//
//public class BNManagerTest {
//	
//	BNManager bn1 = new BNManager();
//	
//	@Before
//	public void init() {
//		Account a1 = new Account();
//		bn1.addNewAccount(a1);
//		Ask a = new Ask();
//		a1.addAsk(a);
//		bn1.addNewAsk(a);
//		Ask a2 = new Ask();
//		a1.addAsk(a2);
//		bn1.addNewAsk(a2);
//		a2.deactivateAsk();
//		Give g = new Give();
//		a1.addGive(g);
//		bn1.addNewGive(g);
//		Give g2 = new Give();
//		a1.addGive(g2);
//		bn1.addNewGive(g2);
//		g2.deactivateGive();
//		Thank t = new Thank();
//		a1.addThank(t);
//		bn1.addNewThank(t);
//		Note n = new Note();
//		a1.addNote(n);
//		bn1.addNewNote(n);
//	}
//	
//	@Test
//	public void test_getAsk_Ask_Found() {
//		Ask a3 = new Ask();
//		bn1.addNewAsk(a3);
//		Ask searchedAsk = bn1.getAsk(a3.getId());
//		assertEquals(a3, searchedAsk);
//	}
//	
//	@Test
//	public void test_getAsk_Ask_NotFound() {
//		//following should produce a null ask
//		Ask searchedAsk = bn1.getAsk(UUID.randomUUID());
//		assertTrue(searchedAsk instanceof NullAsk);
//	}
//	
//	@Test
//	public void test_getGive_Give_Found() {
//		Give g3 = new Give();
//		bn1.addNewGive(g3);
//		Give searchedGive = bn1.getGive(g3.getId());
//		assertEquals(g3, searchedGive);
//	}
//	
//	@Test
//	public void test_getGive_Give_NotFound() {
//		//following should produce a null give
//		Give searchedGive = bn1.getGive(UUID.randomUUID());
//		assertTrue(searchedGive instanceof NullGive);
//	}
//	
//	@Test
//	public void test_getThank_Thank_Found() {
//		Thank t3 = new Thank();
//		bn1.addNewThank(t3);
//		Thank searchedThank = bn1.getThank(t3.getId());
//		assertEquals(t3, searchedThank);
//	}
//	
//	@Test
//	public void test_getThank_Thank_NotFound() {
//		//following should produce a null thank
//		Thank searchedThank = bn1.getThank(UUID.randomUUID());
//		assertTrue(searchedThank instanceof NullThank);
//	}
//	
//	@Test
//	public void test_getNote_Note_Found() {
//		Note n3 = new Note();
//		bn1.addNewNote(n3);
//		Note searchedNote = bn1.getNote(n3.getId());
//		assertEquals(n3, searchedNote);
//	}
//	
//	@Test
//	public void test_getNote_Note_NotFound() {
//		//following should produce a null note
//		Note searchedNote = bn1.getNote(UUID.randomUUID());
//		assertTrue(searchedNote instanceof NullNote);
//	}
//	
//	@Test
//	public void test_removeAsk_Ask_Found() {
//		Ask a3 = new Ask();
//		bn1.addNewAsk(a3);
//		int askArraySizeBeforeDelete = bn1.getAllAsks().size();
//		bn1.removeAsk(a3.getId());
//		int askArraySizeAfterDelete = bn1.getAllAsks().size();
//		//ask array size should decrease by 1
//		assertEquals(askArraySizeAfterDelete, (askArraySizeBeforeDelete - 1));
//	}
//	
//	@Test
//	public void test_removeAsk_Ask_NotFound() {
//		int askArraySizeBeforeDelete = bn1.getAllAsks().size();
//		bn1.removeAsk(UUID.randomUUID());
//		//array size should not change at all before and affter the delete request
//		int askArraySizeAfterDelete = bn1.getAllAsks().size();
//		assertEquals(askArraySizeAfterDelete, askArraySizeBeforeDelete);
//	}
//	
//	@Test
//	public void test_removeGive_Give_Found() {
//		Give g3 = new Give();
//		bn1.addNewGive(g3);
//		int giveArraySizeBeforeDelete = bn1.getAllGives().size();
//		bn1.removeGive(g3.getId());
//		int giveArraySizeAfterDelete = bn1.getAllGives().size();
//		//give array size should decrease by 1
//		assertEquals(giveArraySizeAfterDelete, (giveArraySizeBeforeDelete - 1));
//	}
//	
//	@Test
//	public void test_removeGive_Give_NotFound() {
//		int giveArraySizeBeforeDelete = bn1.getAllGives().size();
//		bn1.removeGive(UUID.randomUUID());
//		//array size should not change at all before and affter the delete request
//		int giveArraySizeAfterDelete = bn1.getAllGives().size();
//		assertEquals(giveArraySizeAfterDelete, giveArraySizeBeforeDelete);
//	}
//	
//	@Test
//	public void test_account_deleted_from_AM() {
//		Account a3 = new Account();
//		bn1.addNewAccount(a3);
//		int accountArraySizeBeforeDelete = bn1.getAllAccounts().size();
//		bn1.deleteAccountFromManagement(a3.getId());
//		int accountArraySizeAfterDelete = bn1.getAllAccounts().size();
//		//account array size should decrease by 1
//		assertEquals(accountArraySizeAfterDelete, (accountArraySizeBeforeDelete - 1));
//	}
//	
//	@Test
//	public void test_SearchAM_Account_NotFound() {
//		Account acc = bn1.searchAM(UUID.randomUUID());
//		assertTrue(acc instanceof NullAccount);
//	}
//	
//	@Test
//	public void test_getAllThanksArray() {
//		ArrayList <Thank> thankArray = bn1.getAllThanks();
//		for (int i = 0; i < thankArray.size(); i++) {
//			assertTrue(thankArray.get(i) instanceof Thank);
//		}
//	}
//	
//	@Test
//	public void test_containsInAccount_item_found() {
//		Account a3 = new Account();
//		a3.setZip("60616");
//		bn1.addNewAccount(a3);
//		ArrayList <Account> temp = bn1.containsArray("60616");
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), a3);
//		}
//	}
//	
//	@Test
//	public void test_containsInAccount_item_NotFound() {
//		//following should produce an empty arraylist
//		ArrayList <Account> temp = bn1.containsArray("60616");
//		assertEquals(0, temp.size());
//	}
//	
//	@Test 
//	public void test_contains_inAsk_Item_InAsk() {
//		Ask a3 = new Ask();
//		a3.addExtraZip("60073");
//		bn1.addNewAsk(a3);
//		ArrayList <Ask> temp = bn1.containsArrayAsk("60073");
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), a3);
//	}
//	}
//	
//	@Test
//	public void test_contains_inAsk_Item_InAccount() {
//		//keyword not in ask instance, but in Account
//		BNManager bn2 = new BNManager();
//		Account acc = new Account();
//		Ask a3 = new Ask();
//		bn2.addNewAccount(acc);
//		bn2.addNewAsk(a3);
//		acc.addAsk(a3);
//		acc.setZip("66666");
//		a3.addExtraZip("60616");
//		
//		bn1.addNewAsk(a3);
//		ArrayList <Ask> temp = bn1.containsArrayAsk("66666");
//		//"66666" is not in a3, but since acc made a3 as as an ask
//		//a3 should be included in the temp array
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), a3);
//	}
//	}
//	
//	@Test 
//	public void test_contains_inGive_Item_InGive() {
//		Give g3 = new Give();
//		g3.addExtraZip("60073");
//		bn1.addNewGive(g3);
//		ArrayList <Give> temp = bn1.containsArrayGive("60073");
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), g3);
//	}
//	}
//	
//	@Test
//	public void test_contains_inGive_Item_InAccount() {
//		//keyword not in give instance, but in Account
//		BNManager bn2 = new BNManager();
//		Account acc = new Account();
//		Give g3 = new Give();
//		bn2.addNewAccount(acc);
//		bn2.addNewGive(g3);
//		acc.addGive(g3);
//		acc.setZip("66666");
//		g3.addExtraZip("60616");
//		
//		bn1.addNewGive(g3);
//		ArrayList <Give> temp = bn1.containsArrayGive("66666");
//		//"66666" is not in g3, but since acc made g3 as as an give
//		//g3 should be included in the temp array
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), g3);
//	}
//	}
//	
//	@Test 
//	public void test_contains_inThank_Item_InThank() {
//		Thank t3 = new Thank();
//		t3.setDescription("john, thanks for the gift");
//		bn1.addNewThank(t3);
//		ArrayList <Thank> temp = bn1.containsArrayThank("john");
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), t3);
//	}
//	}
//	
//	@Test
//	public void test_contains_inThank_Item_InAccount() {
//		//keyword not in thank instance, but in Account
//		BNManager bn2 = new BNManager();
//		Account acc = new Account();
//		Thank t3 = new Thank();
//		bn2.addNewAccount(acc);
//		bn2.addNewThank(t3);
//		acc.addThank(t3);
//		acc.setZip("66666");
//		t3.setDescription("john, thanks for the gift");
//		
//		bn1.addNewThank(t3);
//		ArrayList <Thank> temp = bn1.containsArrayThank("66666");
//		//"66666" is not in t3, but since acc made t3 as as an thank
//		//t3 should be included in the temp array
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), t3);
//	}
//	}
//	
//	@Test 
//	public void test_contains_inNote_Item_InNote() {
//		Note n3 = new Note();
//		n3.setDescription("john, this gift is fragile!");
//		bn1.addNewNote(n3);
//		ArrayList <Note> temp = bn1.containsArrayNote("fragile");
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), n3);
//	}
//	}
//	
//	@Test
//	public void test_contains_inNote_Item_InAccount() {
//		//keyword not in note instance, but in Account
//		BNManager bn2 = new BNManager();
//		Account acc = new Account();
//		Note n3 = new Note();
//		bn2.addNewAccount(acc);
//		bn2.addNewNote(n3);
//		acc.addNote(n3);
//		acc.setZip("66666");
//		n3.setDescription("john, this gift is fragile!");
//		
//		bn1.addNewNote(n3);
//		ArrayList <Note> temp = bn1.containsArrayNote("66666");
//		//"66666" is not in n3, but since acc made n3 as as an note
//		//n3 should be included in the temp array
//		for (int i = 0; i < temp.size(); i++ ) {
//			assertEquals(temp.get(i), n3);
//	}
//	}
//	
//	
//}
