package eu.rms.model;

import javafx.scene.image.Image;

public class Logo extends Image{

	final static Image logo = new Image(Logo.class.getResourceAsStream("../ressources/img/logo/RMS_1x.png"));
	final static Image tl = new Image(Logo.class.getResourceAsStream("../ressources/img/logo/tl-logo.png"));
	final static Image lex = new Image(Logo.class.getResourceAsStream("../ressources/img/logo/lex-logo.png"));

	public static Image getLogo() {
		return logo;
	}
	
	public static Image getTl() {
		return tl;
	}

	public static Image getLex() {
		return lex;
	}

	public Logo() {
		super(Logo.class.getResourceAsStream("../ressources/img/logo/RMS_1x.png"));

	}
}
