package eu.rms.controller;

import eu.rms.model.WidgetSettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VisTicketActionListener implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		if (WidgetSettings.getVisTickets() == true) {
			WidgetSettings.setVisTickets(false);
		} else if (WidgetSettings.getVisTickets() == false) {
			WidgetSettings.setVisTickets(true);
		}
	}

}
