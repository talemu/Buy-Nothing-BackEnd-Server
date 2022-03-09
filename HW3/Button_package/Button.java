package Button_package;
import Lightbulb_package.Lightbulb;
import Lightbulb_package.LightbulbInterface;

public class Button implements buttonInterface{
	
	private LightbulbInterface lightbulb;
	private boolean on;
	
	public Button() {
		on = false;
	}
	
	public Button(Lightbulb l) {
		on = false;	
		this.connectLightbulb(l);
		}
	
	private void setLightbulb(Lightbulb l2){
		this.lightbulb = l2;
		l2.setButton(this);
	}
	
	public LightbulbInterface getLightbulb() {
		return this.lightbulb;
	}
	
	public void connectLightbulb(Lightbulb l2) {
		l2.off();
		if (l2.getButton() != null) {
			l2.getButton().disconnectLightbulb();
		}
		if (this.lightbulb == null) {
			this.setLightbulb(l2);
			this.lightbulb.setButton(this);
		}
		else {
			this.lightbulb.setButton(null);
			this.setLightbulb(l2);
		}
	}
	
	public void disconnectLightbulb() {
		if (this.lightbulb != null) {
			this.lightbulb.setButton(null);
		}
		this.lightbulb = null;
	}
	
	
	public boolean switchOn() {
		if (!on) {
			on = true;
			System.out.println("Button switched to ON");
			if (this.lightbulb != null) {
				this.lightbulb.on();
			}
		}
		else {
			on = true;
			System.out.println("Button has been ON");
		}
		return true;
	}
	
	public boolean switchOff() {
		if (on) {
			on = false;
			System.out.println("Button switched to OFF");
			if (this.lightbulb.getButton() == this)
				this.lightbulb.off();
		}
		else {
			on = false;
			System.out.println("Button has been OFF");
		}
		return true;
	}
	
	public boolean is_switch_on() {
		return on;
	}
}
