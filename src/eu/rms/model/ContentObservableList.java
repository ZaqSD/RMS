package eu.rms.model;

import eu.rms.view.ContentPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class ContentObservableList {

	private final static ObservableList<ContentPane> data = FXCollections.observableArrayList();

	private static ContentPane content = null;

	public static ContentPane getTable() {
		return content;
	}

	public static void setTable(ContentPane content) {
		ContentObservableList.content = content;
	}

	public static ObservableList<ContentPane> getData() {
		return data;
	}

	public static ObservableList<ContentPane> get() {
		return data;
	}

}
