package test;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.*;

import main.Account;
import main.Ask;
import main.Give;
import main.Note;
import main.Thank;

//Junit Import

public class AccountTest {
	
	Account a1 = new Account();
	
	@Before
	public static void init() {
		Ask a = new Ask();
		Give g = new Give();
		Thank t = new Thank();
		Note n = new Note();
	}
	
	@Test
	public void account_ID_Built() {
		assertTrue(a1.getId() instanceof UUID);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void valid_Date_Created() {
		Date d = a1.getDateCreated();
		assertTrue(true);
	}
}