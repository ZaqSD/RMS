package eu.rms.model;

import javafx.scene.image.Image;

public class IconMap extends Image{
	
	final static Image fv_s = new Image(IconMap.class.getResourceAsStream("../ressources/img/maps/RMS_FV_S.png"));
	final static Image fv_l = new Image(IconMap.class.getResourceAsStream("../ressources/img/maps/RMS_FV_L.png"));
	final static Image lex_s = new Image(IconMap.class.getResourceAsStream("../ressources/img/maps/RMS_LEX_S.png"));

	public static Image getFvS() {
		return fv_s;
	}
	
	public static Image getFvL() {
		return fv_l;
	}
	
	public static Image getLexS() {
		return lex_s;
	}
	
	public IconMap() {
		super(IconMap.class.getResourceAsStream("../ressources/img/maps/RMS_FV_S.png"));
	}
	
}