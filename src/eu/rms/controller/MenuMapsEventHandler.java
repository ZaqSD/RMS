package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.model.MapsObservableList;
import eu.rms.view.ContentPane;
import eu.rms.view.MapsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuMapsEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		ContentPane content = ContentObservableList.getTable();
		MapsView mapsView = MapsObservableList.getTable();
		//content.Reload(mapsView);
	}

}
