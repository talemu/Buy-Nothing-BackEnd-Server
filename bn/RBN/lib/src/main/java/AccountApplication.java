import java.time.LocalDate;
import java.util.ArrayList;

public class AccountApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BNManager bn1 = new BNManager();
		
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
		
		
		Ask a3 = new Ask();
		a3.addExtraZip("60073");
		System.out.println(a3.getExtraZip());
		bn1.addNewAsk(a3);
		ArrayList <Ask> temp = bn1.containsArrayAsk("60073");
		for (int i = 0; i < temp.size(); i++ ) {
		}
		
		
	}

}
