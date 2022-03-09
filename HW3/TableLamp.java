package Application;




import Button_package.Button;
import Button_package.PushDownButton;
import Lightbulb_package.Lightbulb;

public class TableLamp {
	
	public static void main(String[] args) {
		
//		When initiated, the light bulb is off. Button is initiated to turn on;
		System.out.println("Lightbulb and button is initially off:");
		Button b = new Button(new Lightbulb());
		
		System.out.println("\nButton switched on:");
		b.switchOn();
		
		System.out.println("\nButton switched off:");
		b.switchOff();
		
		System.out.println("\nswitching out lightbulb (Dependency Inversion)");
		Lightbulb new_lightbulb = new Lightbulb();
		b.connectLightbulb(new_lightbulb);
		
		System.out.println("\nButton switched on post-switch:");
		b.switchOn();
		
		System.out.println("\nButton switched off post-switch:");
		b.switchOff();
		
		System.out.println("\nButton switched off with no lightbulb hooked:");
		Button c = new Button(new_lightbulb);
		b.switchOff();
		
		System.out.println("\nLightbulb hooked to a Push Down Button:");
		PushDownButton pb = new PushDownButton(new Lightbulb());
		
		System.out.println("\nPushButton Switched on:");
		pb.powerSwitch();
		
		System.out.println("\nPushButton Switched off:");
		pb.powerSwitch();
		
		System.out.println("\nButton assigned to a new lightbulb (Dependency Inversion):");
		new_lightbulb.setButton(pb);
		pb.powerSwitch();
		pb.powerSwitch();
	}
}
