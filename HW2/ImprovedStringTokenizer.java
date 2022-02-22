import java.util.StringTokenizer;

public class ImprovedStringTokenizer extends StringTokenizer{

	public ImprovedStringTokenizer(String s) {
		super(s);
	}
	
	public ImprovedStringTokenizer(String s, String d) {
		super(s,d);
	}
	
	public ImprovedStringTokenizer(String s, String d, boolean rd) {
		super(s,d,rd);
	}
	
	public String[] stringTokenArray() {
		int stringWordCount = this.countTokens();
		String [] stringArray = new String [stringWordCount];
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = this.nextToken();
		}
		return stringArray;
	}
	
	public String stringTokenArrayToString() {
		int stringWordCount = this.countTokens();
		String stringArray = "[";
		
		for (int i = 0; i < stringWordCount; i++) {
			if (i < stringWordCount - 1) {
				stringArray += this.nextToken() + ", ";
			}
			else {
				stringArray += this.nextToken() + "]";
			}
		}
		
		return stringArray;
	}
}
