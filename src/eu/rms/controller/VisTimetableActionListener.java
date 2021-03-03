package eu.rms.controller;

import eu.rms.model.WidgetSettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VisTimetableActionListener implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {

		if (WidgetSettings.getVisTimetable() == true) {
			WidgetSettings.setVisGreetng(false);
		} else if (WidgetSettings.getVisTimetable() == false) {
			WidgetSettings.setVisGreetng(true);
		}
	}

}
