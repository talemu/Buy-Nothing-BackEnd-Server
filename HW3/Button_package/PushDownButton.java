package Button_package;
import Lightbulb_package.Lightbulb;

public class PushDownButton implements buttonInterface{

	private Lightbulb lightbulb;
	private boolean on = false;
	
	public PushDownButton() {
		on = false;
	}
	
	public PushDownButton(Lightbulb l) {
		on = false;	
		this.connectLightbulb(l);
	}
	
	private void setLightbulb(Lightbulb l2){
		this.lightbulb = l2;
		l2.setButton(this);
	}
	
	public Lightbulb getLightbulb() {
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
	
	
	public void powerSwitch() {
		if (on) {
			System.out.println("Push Button switched to OFF");
			if (this.lightbulb != null) {
				lightbulb.off();
			}
			on = false;
		}
		else {
			System.out.println("Push Button switched to ON");
			if (this.lightbulb != null) {
				lightbulb.on();
				}
			on = true;
		}
	}
	
	public boolean is_switch_on() {
		return on;
	}
	
}
