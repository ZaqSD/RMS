package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.view.ContentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NoWidgetCloseEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		ContentPane content = ContentObservableList.getTable();
		content.getChildren().clear();
	}

}
