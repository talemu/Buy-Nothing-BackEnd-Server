package Button_package;

import Lightbulb_package.Lightbulb;
import Lightbulb_package.LightbulbInterface;

public interface buttonInterface {
	
	void connectLightbulb(Lightbulb l);
	boolean is_switch_on();
	LightbulbInterface getLightbulb();
	void disconnectLightbulb();
}
