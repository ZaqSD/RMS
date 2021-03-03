package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.model.DepartObservableList;
import eu.rms.model.TimetableObservableList;
import eu.rms.view.ContentPane;
import eu.rms.view.DepartView;
import eu.rms.view.TimetableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuDepartEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		ContentPane content = ContentObservableList.getTable();
		DepartView departView = DepartObservableList.getTable();
		content.Reload(departView);
		
	}

}