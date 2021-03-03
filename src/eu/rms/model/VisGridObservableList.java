package eu.rms.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class VisGridObservableList {

	private final static ObservableList<GridPane> data = FXCollections.observableArrayList();

	private static GridPane grid = null;

	public static GridPane getTable() {
		return grid;
	}

	public static void setTable(GridPane grid) {
		VisGridObservableList.grid = grid;
	}

	public static ObservableList<GridPane> getData() {
		return data;
	}

	public static ObservableList<GridPane> get() {
		return data;
	}
}
