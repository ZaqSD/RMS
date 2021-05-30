package eu.rms.model;

import eu.rms.algorythm.search.SearchAlgo;
import eu.rms.view.MapsView;
import eu.rms.view.timetable.TimResultDetailOverView;
import eu.rms.view.timetable.TimResultDetailView;
import eu.rms.view.timetable.TimResultGrid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TimResultDetailViewObservableList {

	private final static ObservableList<TimResultDetailView> data = FXCollections.observableArrayList();

	private static TimResultDetailView content = null;

	public static TimResultDetailView getTable() {
		return content;
	}

	public static void setTable(TimResultDetailView content) {
		TimResultDetailViewObservableList.content = content;
	}

	public static ObservableList<TimResultDetailView> getData() {
		return data;
	}

	public static ObservableList<TimResultDetailView> get() {
		return data;
	}
}
