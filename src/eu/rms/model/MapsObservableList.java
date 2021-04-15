package eu.rms.model;

import eu.rms.view.MapsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MapsObservableList {

	private final static ObservableList<MapsView> data = FXCollections.observableArrayList();

	private static MapsView content = null;

	public static MapsView getTable() {
		return content;
	}

	public static void setTable(MapsView content) {
		MapsObservableList.content = content;
	}

	public static ObservableList<MapsView> getData() {
		return data;
	}

	public static ObservableList<MapsView> get() {
		return data;
	}
}
