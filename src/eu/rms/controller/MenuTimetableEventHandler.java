package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.model.TimetableObservableList;
import eu.rms.view.ContentPane;
import eu.rms.view.timetable.TimetableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MenuTimetableEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		
		ContentPane content = ContentObservableList.getTable();
		TimetableView timetableView = TimetableObservableList.getTable();
		content.Reload(timetableView);
	}

}
