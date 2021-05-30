package eu.rms.model;

import eu.rms.view.ContentPane;
import eu.rms.view.WidgetView;
import eu.rms.view.timetable.TimetableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class WidgetObservableList {

	private final static ObservableList<WidgetView> data = FXCollections.observableArrayList();

	private static WidgetView widget = null;

	public static WidgetView getTable() {
		return widget;
	}

	public static void setTable(WidgetView widget) {
		WidgetObservableList.widget = widget;
	}

	public static ObservableList<WidgetView> getData() {
		return data;
	}

	public static ObservableList<WidgetView> get() {
		return data;
	}

}
