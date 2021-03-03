package eu.rms.view;

import eu.rms.model.Title;
import javafx.scene.layout.GridPane;

public class TicketBox extends GridPane {

	public TicketBox(String string) {
		this.getStyleClass().add("widget");
		Title title = new Title(string);
	}
}
