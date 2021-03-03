package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.model.DepartObservableList;
import eu.rms.model.SettingsObservableList;
import eu.rms.view.ContentPane;
import eu.rms.view.SettingsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuSettingsEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		ContentPane content = ContentObservableList.getTable();
		SettingsView settingsView = SettingsObservableList.getTable();
		content.Reload(settingsView);
	}

}
