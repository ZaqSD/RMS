package eu.rms.model;

import eu.rms.view.MapsView;
import eu.rms.view.TimResultGrid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TimResultGridObservableList {

	private final static ObservableList<TimResultGrid> data = FXCollections.observableArrayList();

	private static TimResultGrid content = null;

	public static TimResultGrid getTable() {
		return content;
	}

	public static void setTable(TimResultGrid content) {
		TimResultGridObservableList.content = content;
	}

	public static ObservableList<TimResultGrid> getData() {
		return data;
	}

	public static ObservableList<TimResultGrid> get() {
		return data;
	}
}
