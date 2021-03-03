package eu.rms.model;

import eu.rms.view.DepartView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DepartObservableList {

	private final static ObservableList<DepartView> data = FXCollections.observableArrayList();

	private static DepartView content = null;

	public static DepartView getTable() {
		return content;
	}

	public static void setTable(DepartView content) {
		DepartObservableList.content = content;
	}

	public static ObservableList<DepartView> getData() {
		return data;
	}

	public static ObservableList<DepartView> get() {
		return data;
	}
}
