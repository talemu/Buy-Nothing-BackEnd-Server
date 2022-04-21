package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

//Capture String imports
import org.junit.*;

import main.Account;
import main.Ask;
import main.Give;
import main.Note;
import main.Thank;

public class AccountTest {
	
	Account a1 = new Account();
	
	
	@Before
	public void init() {
		Ask a = new Ask();
		Give g = new Give();
		Thank t = new Thank();
		Note n = new Note();
		a1.addAsk(a);
		a1.addGive(g);
		a1.addThank(t);
		a1.addNote(n);
	}
	
	@Test
	public void checkGetId() {
		assertTrue(a1.getId() instanceof UUID);
	}
	
	@Test
	public void verifyDateCreatedisBeforePresent() {
		assertTrue(a1.getDateCreated() instanceof Date);
	}
	
	@Test
	public void activateTestAccount() {
		a1.activate_account();
		assertTrue(a1.getActive());
	}
	
	@Test
	public void testUpdatingZip() {
		a1.setZip("60073");
		assertEquals(a1.getZip(), "60073");
	}
	
}