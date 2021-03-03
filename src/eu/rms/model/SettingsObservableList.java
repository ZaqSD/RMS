package eu.rms.model;

import eu.rms.view.SettingsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SettingsObservableList {

	private final static ObservableList<SettingsView> data = FXCollections.observableArrayList();

	private static SettingsView content = null;

	public static SettingsView getTable() {
		return content;
	}

	public static void setTable(SettingsView content) {
		SettingsObservableList.content = content;
	}

	public static ObservableList<SettingsView> getData() {
		return data;
	}

	public static ObservableList<SettingsView> get() {
		return data;
	}
}
