//import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.google.gson.Gson;

import static org.junit.Assert.assertEquals;

import java.lang.*;

public class AccountApplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Account a1 = new Account();	
		BNManager bn1 = new BNManager();
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
		Account ac2 = new Account();
		ac2.addThankFrom(t);
		bn1.addNewThank(t);
		Note n = new Note();
		a1.addNote(n);
		bn1.addNewNote(n);
		
		Ask a5 = new Ask();
		Give g5 = new Give();
		Ask a6 = new Ask();
		Give g6 = new Give();
		bn1.addNewAsk(a5);
		bn1.addNewGive(g5);
		bn1.searchAndUpdate(a5.getId(), a6);
		bn1.searchAndUpdate(g5.getId(), g6);
		
		System.out.println(a1.getGives().size());
//		System.out.println(a6.get);

//		a.contents();
		
		
	}

}
