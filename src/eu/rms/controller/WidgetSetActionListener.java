package eu.rms.controller;

import java.util.Optional;

import eu.rms.model.WidgetSettings;
import eu.rms.view.WidgetSettingsDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

public class WidgetSetActionListener implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		Dialog<WidgetSettings> dialog = new WidgetSettingsDialog<WidgetSettings>();
		
		Optional<WidgetSettings> result = dialog.showAndWait();
		if (result.isPresent()) {
			//AddressObservableList.get().add(result.get());
		}
	}

}
