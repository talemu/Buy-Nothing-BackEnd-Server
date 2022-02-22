import java.util.*;


public class ImprovedRandomApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImprovedRandom ir = new ImprovedRandom(52);
		System.out.println(ir.nextIntWithinRange(-8, 11));
		
		StringTokenizer s = new StringTokenizer("hello Mr Alemu");
		System.out.println(s.nextToken());
		System.out.println(s.nextToken());
		System.out.println(s.nextToken());
		ImprovedStringTokenizer w = new ImprovedStringTokenizer("hello Mr West");
		System.out.println(w.stringTokenArrayToString());
	}

}
