import java.util.Random;

public class ImprovedRandom extends Random {
	
	public ImprovedRandom() {
		super();
	}
	
	public ImprovedRandom(int i) {
		super(i);
	}
	
	public int nextIntWithinRange (int start, int exclusiveEnd) {
		int range = exclusiveEnd - start;
		int temp = this.nextInt(range);
		return temp + start;
	}
}
