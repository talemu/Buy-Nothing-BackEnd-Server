package Lightbulb_package;

import Button_package.buttonInterface;

public interface LightbulbInterface {
	
	void setButton(buttonInterface b);
	buttonInterface getButton();
	boolean on();
	boolean off();
	boolean is_lightbulb_on();
}
