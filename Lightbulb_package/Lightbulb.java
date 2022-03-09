package Lightbulb_package;

import Button_package.Button;
import Button_package.buttonInterface;

public class Lightbulb implements LightbulbInterface{
	
	private buttonInterface button;
	private boolean on;
	
	public Lightbulb() {
		on = true;
		off();
	}
	
	public Lightbulb (buttonInterface b) {
		setButton(b);
	}
	
	public void setButton(buttonInterface b) {
		this.button = b;
		if (b != null) {
			if (!on && b.is_switch_on()) {
				this.on();
			}
			else if (on && !b.is_switch_on()) {
				this.off();
			}
			on = b.is_switch_on();
		}
	}
	
	public buttonInterface getButton() {
		if (this.button != null) {
			return this.button;
		}
		else {
			return null;
		}
	}
	
	public boolean on() {
		if (on) {
			//do nothing
		}
		else {
			System.out.println("<<Lightbulb on>>");
			on = true;
		}
		return true;
	}
	
	public boolean off() {
		if (on) {
			System.out.println("<<Lightbulb off>>");
			on = false;
		}
		else {
			//do nothing
		}
		return true;
	}
	
	public boolean is_lightbulb_on() {
		return on;
	}

}

