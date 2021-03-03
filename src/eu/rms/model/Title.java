package eu.rms.model;

import javafx.scene.control.Label;

public class Title extends Label{

	public Title(String string) {
		super(string);
		this.getStyleClass().add("title");
	}
}
