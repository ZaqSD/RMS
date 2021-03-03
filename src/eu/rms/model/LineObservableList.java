package eu.rms.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LineObservableList {

	private final static ObservableList<Line> data = FXCollections.observableArrayList();

	private static Line line = null;

	public static Line getTable() {
		return line;
	}

	public static void setTable(Line line) {
		LineObservableList.line = line;
	}

	public static ObservableList<Line> getData() {
		return data;
	}

	public static ObservableList<Line> get() {
		return data;
	}
}
