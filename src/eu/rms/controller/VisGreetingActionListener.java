package eu.rms.controller;

import eu.rms.model.VisBtnGreetingObservableList;
import eu.rms.model.VisGridObservableList;
import eu.rms.model.WidgetSettings;
import eu.rms.view.WidgetSettingsDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class VisGreetingActionListener implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {

		if (WidgetSettings.getVisGreetng() == true) {
			WidgetSettings.setVisGreetng(false);
		} else if (WidgetSettings.getVisGreetng() == false) {
			WidgetSettings.setVisGreetng(true);
		}
	}

}
