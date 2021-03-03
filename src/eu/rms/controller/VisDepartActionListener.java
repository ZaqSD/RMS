package eu.rms.controller;

import eu.rms.model.WidgetSettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VisDepartActionListener implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {

		if (WidgetSettings.getVisDepartures() == true) {
			WidgetSettings.setVisDepartures(false);
		} else if (WidgetSettings.getVisDepartures() == false) {
			WidgetSettings.setVisDepartures(true);
		}
	}

}
