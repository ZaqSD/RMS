package eu.rms.model;

import javafx.scene.image.Image;

public class IconTheme {

	private final static Image light = new Image(Logo.class.getResourceAsStream("../ressources/img/theme/RMS_Light.png"));
	private final static Image dark = new Image(Logo.class.getResourceAsStream("../ressources/img/theme/RMS_Dark.png"));
	private final static Image accessabiity = new Image(Logo.class.getResourceAsStream("../ressources/img/theme/RMS_Accessability.png"));
	private final static Image purple = new Image(Logo.class.getResourceAsStream("../ressources/img/theme/RMS_Purple.png"));
	
	public static Image getLight() {
		return light;
	}
	public static Image getDark() {
		return dark;
	}
	public static Image getAccessability() {
		return accessabiity;
	}
	public static Image getAccessabiity() {
		return accessabiity;
	}
	public static Image getPurple() {
		return purple;
	}

	

}
