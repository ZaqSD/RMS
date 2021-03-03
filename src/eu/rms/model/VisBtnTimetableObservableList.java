package eu.rms.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class VisBtnTimetableObservableList {

	private final static ObservableList<Button> data = FXCollections.observableArrayList();

	private static Button btn = null;

	public static Button getTable() {
		return btn;
	}

	public static void setTable(Button btn) {
		VisBtnTimetableObservableList.btn = btn;
	}

	public static ObservableList<Button> getData() {
		return data;
	}

	public static ObservableList<Button> get() {
		return data;
	}
	
}
