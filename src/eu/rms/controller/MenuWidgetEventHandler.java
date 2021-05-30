package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.model.TimetableObservableList;
import eu.rms.model.WidgetObservableList;
import eu.rms.view.ContentPane;
import eu.rms.view.WidgetView;
import eu.rms.view.timetable.TimetableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuWidgetEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		WidgetObservableList.setTable(new WidgetView());
		ContentPane content = ContentObservableList.getTable();
		WidgetView widgetView = WidgetObservableList.getTable();
		content.Reload(widgetView);
	}

}
