

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class TestCreature{
	public static final int THING_COUNT = 8;
	public static final int CREATURE_COUNT = 5;
	
	public TestCreature() { 
		
	}
	@Test
	public void test_Thing_toString() {
		Thing test = new Thing("Name");
		assertEquals("Name", test.toString());
	}
	
	@Test 
	public void test_Ant_toString() {
		Ant a = new Ant("anty");
		assertEquals("anty Ant", a.toString());
	}
	
	@Test
	public void test_Fly_toString() {
		Fly f = new Fly("buzz");
		assertEquals("buzz Fly", f.toString());
	}
	
	@Test
	public void test_Tiger_toString() {
		Tiger t = new Tiger("roar");
		assertEquals("roar Tiger", t.toString());
	}
	
	@Test
	public void test_Bat_toString() {
		Bat b = new Bat("dracula");
		assertEquals("dracula Bat", b.toString());
	}
	
	
	
	public static void main(java.lang.String[] args) {
		/* Creating Creature Array of size CREATURE_COUNT
		 */
		Creature[] creatureArray = new Creature[CREATURE_COUNT];
		
		/* Adding items to creatureArray*/
		creatureArray[0] = new Tiger("tigga");
		creatureArray[1] = new Bat ("Vamp");
		creatureArray[2] = new Fly ("bugg");
		creatureArray[3] = new Ant ("ant");
		creatureArray[4] = new Tiger("tiger king");
		
		/* Creating Thing Array of size THING_COUNT
		 */
		Thing[] thingArray = new Thing [THING_COUNT];
		
		/* Adding items to thingArray*/
		thingArray[0] = new Thing ("Tabor");
		thingArray[1] = new Thing ("Monti");
		thingArray[2] = new Thing ("Adi");
		
		/*For loop to add creatures to thingArray, ensuring polymorphism*/
		for (int i = 0; i < creatureArray.length; i++) {
			thingArray [3+i] = creatureArray[i];
		}
		
		System.out.println("Things:");
		
		/* Printing thingArray elements*/
		for (int i = 0; i < thingArray.length; i++) {
			System.out.println(thingArray[i]);	
		}
		System.out.println("\n");
		
		/* Printing thingArray elements that are not Things*/
		for (int i = 0; i < thingArray.length; i++) {
			if (thingArray[i].getClass().getName() == "Thing") {
		}
			else {
				System.out.println(thingArray[i]);
			}
		}
		
		/// ant
		System.out.println("\n**ant crawling");
		Ant a = new Ant("anty");
		a.move();
		
		//bat
		Bat b = new Bat("dracula");
		System.out.println("\n**bat eating a thing");
		b.eat(thingArray[0]);
		System.out.println("\n**bat eating a tiger");
		b.eat(thingArray[7]);
		
		System.out.println("\n**bat move method");
		b.move();
		System.out.println("\n**bat fly method");
		b.fly();
		
		//fly
		Fly f = new Fly("buzz");
		System.out.println("\n**fly eating a thing");
		f.eat(thingArray[0]);
		System.out.println("\n**fly eating a tiger");
		f.eat(thingArray[7]);
		
		System.out.println("\n**fly move method");
		f.move();
		System.out.println("\n**fly fly method");
		f.fly();
		
		//tiger
		Tiger t = new Tiger("roar");
		System.out.println("\n**tiger move method");
		t.move();
	}
}
