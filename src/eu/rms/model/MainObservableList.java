package eu.rms.model;

import eu.rms.view.ContentPane;
import eu.rms.view.MainGrid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class MainObservableList {

	private final static ObservableList<MainGrid> data = FXCollections.observableArrayList();

	private static MainGrid content = null;

	public static MainGrid getTable() {
		return content;
	}

	public static void setTable(MainGrid content) {
		MainObservableList.content = content;
	}

	public static ObservableList<MainGrid> getData() {
		return data;
	}

	public static ObservableList<MainGrid> get() {
		return data;
	}

}
