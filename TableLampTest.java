package edu.iit.cs445.spring22;


//Capture String imports
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

//Junit Import
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

//Importing other classes
import Button_package.Button;
import Button_package.PushDownButton;
import Button_package.buttonInterface;
import Lightbulb_package.Lightbulb;

public class TableLampTest {

	public TableLampTest() {
		
	}
	
	private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private final PrintStream standardOut = System.out;
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(baos));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}
	
	@Test
	public void test_initializing_default_Lightbulb() {
		Lightbulb lb = new Lightbulb();
		assertEquals("<<Lightbulb off>>", baos.toString().trim());
	}
	
	@Test
	public void test_initializing_non_default_Lightbulb() {
		Button b = new Button();
		Lightbulb lb = new Lightbulb(b);
		assertEquals(b, lb.getButton());
	}
	
	@Test
	public void test_Lightbulb_on_statement_when_off() {
		Lightbulb lb = new Lightbulb();
		lb.on();
		assertEquals("<<Lightbulb off>>\n<<Lightbulb on>>", baos.toString().trim());
	}
	
	@Test
	public void test_Lightbulb_on_statement_when_on() {
		Lightbulb lb = new Lightbulb();
		lb.on();
		lb.on();
		assertEquals("<<Lightbulb off>>\n<<Lightbulb on>>", baos.toString().trim());
	}
	
	@Test
	public void test_Lightbulb_off_statement_when_off() {
		Lightbulb lb = new Lightbulb();
		assertEquals("<<Lightbulb off>>", baos.toString().trim());
	}
	
	@Test
	public void test_Lightbulb_off_statement_when_on() {
		Lightbulb lb = new Lightbulb();
		lb.on();
		lb.off();
		assertEquals("<<Lightbulb off>>\n<<Lightbulb on>>\n<<Lightbulb off>>", baos.toString().trim());
	}
	
	@Test
	public void test_setting_Lightbulb_To_button_that_is_off() {
		Button b = new Button();
		Lightbulb l = new Lightbulb(b);
		b.switchOn();
		Button b2 = new Button(l);
		assertEquals(l.is_lightbulb_on(), false);
	}
	
	@Test
	public void test_lightbulb_on_check() {
		Lightbulb lb = new Lightbulb();
		boolean check = lb.is_lightbulb_on();
		assertEquals(false, check);
	}
	
	@Test
	public void test_dependency_inversion_switching_button_from_lightbulb() {
		Button b = new Button();
		Lightbulb lb = new Lightbulb();
		b.connectLightbulb(lb);
		//Lightbulb connected to Button 1
		buttonInterface bi = lb.getButton();
		assertEquals(b, bi);
		Button b2 = new Button();
		lb.setButton(b2);
		//Lightbulb connected to a new button
		buttonInterface bi2 = lb.getButton();
		assertEquals(b2, bi2);
	}
	
	@Test
	public void test_dependency_inversion_switching_button_from_lightbulb_initially_with_button() {
		Button b = new Button();
		Lightbulb lb = new Lightbulb(b);
		//Lightbulb connected to Button 1
		Button b2 = new Button();
		lb.setButton(b2);
		//Lightbulb connected to a new button
		buttonInterface bi2 = lb.getButton();
		assertEquals(b2, bi2);
	}
	
	@Test
	public void test_button_non_default() {
		Lightbulb l = new Lightbulb();
		Button b = new Button(l);
		assertEquals(b.getLightbulb(), l);
	}
	
	@Test
	public void test_dependency_inversion_switching_lightbulbs_with_lightbulb_already_connected() {
		Lightbulb l = new Lightbulb();
		Button b = new Button(l);
		assertEquals(b.getLightbulb(), l);
		Lightbulb l2 = new Lightbulb(new Button());
		b.connectLightbulb(l2);
		assertEquals(b.getLightbulb(),l2);
	}
	
	@Test
	public void test_switch_on_when_off_connected_to_a_lightbulb() {
		Lightbulb l = new Lightbulb();
		Button b = new Button(l);
		b.switchOn();
		assertEquals("<<Lightbulb off>>\nButton switched to ON\n<<Lightbulb on>>", baos.toString().trim());
	}
	
	@Test
	public void test_switch_on_when_on_connected_to_a_lightbulb() {
		Button b = new Button();
		b.switchOn();
		Lightbulb l = new Lightbulb();
		b.connectLightbulb(l);
		b.switchOn();
		assertEquals("Button switched to ON\n<<Lightbulb off>>\n<<Lightbulb on>>\nButton has been ON", baos.toString().trim());
	}
	
	@Test
	public void test_switch_off_when_on_connected_to_a_lightbulb() {
		Button b = new Button();
		b.switchOn();
		Lightbulb l = new Lightbulb();
		b.connectLightbulb(l);
		b.switchOff();
		assertEquals("Button switched to ON\n<<Lightbulb off>>\n<<Lightbulb on>>\nButton switched to OFF\n<<Lightbulb off>>", baos.toString().trim());
	}
	
	@Test
	public void test_switch_off_when_off_connected_to_a_lightbulb() {
		Lightbulb l = new Lightbulb();
		Button b = new Button(l);
		b.switchOff();
		assertEquals("<<Lightbulb off>>\nButton has been OFF", baos.toString().trim());
	}
	
	@Test
	public void test_default_pd_button() {
		PushDownButton pd = new PushDownButton();
		assertEquals(pd.getLightbulb(), null);
	}
	
	@Test
	public void test_non_default_pd_button() {
		Lightbulb l = new Lightbulb();
		PushDownButton pd = new PushDownButton(l);
		assertEquals(pd.getLightbulb(), l);
		pd.disconnectLightbulb();
		assertEquals(pd.getLightbulb(), null);
	}
	
	@Test
	public void test_power_switch_on() {
		Lightbulb l = new Lightbulb();
		PushDownButton pd = new PushDownButton(l);
		pd.powerSwitch();
		assertEquals("<<Lightbulb off>>\nPush Button switched to ON\n<<Lightbulb on>>", baos.toString().trim());
	}
	
	@Test
	public void test_power_switch_off() {
		Lightbulb l = new Lightbulb();
		PushDownButton pd = new PushDownButton(l);
		pd.powerSwitch();
		pd.powerSwitch();
		assertEquals("<<Lightbulb off>>\nPush Button switched to ON\n<<Lightbulb on>>\nPush Button switched to OFF\n<<Lightbulb off>>", baos.toString().trim());
	}
	

}
