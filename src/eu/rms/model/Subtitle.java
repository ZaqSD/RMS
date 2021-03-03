package eu.rms.model;

import javafx.scene.control.Label;

public class Subtitle extends Label{

	public Subtitle(String string) {
		super(string);
		this.getStyleClass().add("subtitle");
	}
	
}
