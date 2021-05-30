package eu.rms.model;

import eu.rms.view.ContentPane;
import eu.rms.view.timetable.TimetableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class TimetableObservableList {

	private final static ObservableList<TimetableView> data = FXCollections.observableArrayList();

	private static TimetableView timetable = null;

	public static TimetableView getTable() {
		return timetable;
	}

	public static void setTable(TimetableView timetable) {
		TimetableObservableList.timetable = timetable;
	}

	public static ObservableList<TimetableView> getData() {
		return data;
	}

	public static ObservableList<TimetableView> get() {
		return data;
	}

}
