import static org.junit.Assert.*;

import java.time.Clock;
import java.time.LocalDate;
import java.util.*;

import org.junit.*;

public class BNManagerTest {
	
	BNManager bn1 = new BNManager();
	
	@Before
	public void init() {
		Account a1 = new Account();
		bn1.addNewAccount(a1);
		Ask a = new Ask();
		a1.addAsk(a);
		bn1.addNewAsk(a);
		Ask a2 = new Ask();
		a1.addAsk(a2);
		bn1.addNewAsk(a2);
		a2.deactivateAsk();
		Give g = new Give();
		a1.addGive(g);
		bn1.addNewGive(g);
		Give g2 = new Give();
		a1.addGive(g2);
		bn1.addNewGive(g2);
		g2.deactivateGive();
		Thank t = new Thank();
		a1.addThank(t);
		bn1.addNewThank(t);
		Note n = new Note();
		a1.addNote(n);
		bn1.addNewNote(n);
	}
	
	@Test
	public void test_getAsk_Ask_Found() {
		Ask a3 = new Ask();
		bn1.addNewAsk(a3);
		Ask searchedAsk = bn1.getAsk(a3.getId());
		assertEquals(a3, searchedAsk);
	}
	
	@Test
	public void test_getAsk_Ask_NotFound() {
		//following should produce a null ask
		Ask searchedAsk = bn1.getAsk(UUID.randomUUID());
		assertTrue(searchedAsk instanceof NullAsk);
	}
	
	@Test
	public void test_getGive_Give_Found() {
		Give g3 = new Give();
		bn1.addNewGive(g3);
		Give searchedGive = bn1.getGive(g3.getId());
		assertEquals(g3, searchedGive);
	}
	
	@Test
	public void test_getGive_Give_NotFound() {
		//following should produce a null give
		Give searchedGive = bn1.getGive(UUID.randomUUID());
		assertTrue(searchedGive instanceof NullGive);
	}
	
	@Test
	public void test_getThank_Thank_Found() {
		Thank t3 = new Thank();
		bn1.addNewThank(t3);
		Thank searchedThank = bn1.getThank(t3.getId());
		assertEquals(t3, searchedThank);
	}
	
	@Test
	public void test_getThank_Thank_NotFound() {
		//following should produce a null thank
		Thank searchedThank = bn1.getThank(UUID.randomUUID());
		assertTrue(searchedThank instanceof NullThank);
	}
	
	@Test
	public void test_getNote_Note_Found() {
		Note n3 = new Note();
		bn1.addNewNote(n3);
		Note searchedNote = bn1.getNote(n3.getId());
		assertEquals(n3, searchedNote);
	}
	
	@Test
	public void test_getNote_Note_NotFound() {
		//following should produce a null note
		Note searchedNote = bn1.getNote(UUID.randomUUID());
		assertTrue(searchedNote instanceof NullNote);
	}
	
	@Test
	public void test_removeAsk_Ask_Found() {
		Ask a3 = new Ask();
		bn1.addNewAsk(a3);
		int askArraySizeBeforeDelete = bn1.getAllAsks().size();
		bn1.removeAsk(a3.getId());
		int askArraySizeAfterDelete = bn1.getAllAsks().size();
		//ask array size should decrease by 1
		assertEquals(askArraySizeAfterDelete, (askArraySizeBeforeDelete - 1));
	}
	
	@Test
	public void test_removeGive_Give_Found() {
		Give g3 = new Give();
		bn1.addNewGive(g3);
		int giveArraySizeBeforeDelete = bn1.getAllGives().size();
		bn1.removeGive(g3.getId());
		int giveArraySizeAfterDelete = bn1.getAllGives().size();
		//give array size should decrease by 1
		assertEquals(giveArraySizeAfterDelete, (giveArraySizeBeforeDelete - 1));
	}
	
	@Test
	public void test_account_deleted_from_AM() {
		
	}
}
