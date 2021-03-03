package eu.rms.model;

import javafx.scene.image.Image;

public class Logo extends Image{

	final static Image logo = new Image(Logo.class.getResourceAsStream("../ressources/img/logo/RMS_1x.png"));
	
	public static Image getLogo() {
		return logo;
	}

	public Logo() {
		super(Logo.class.getResourceAsStream("../ressources/img/logo/RMS_1x.png"));

	}
}
