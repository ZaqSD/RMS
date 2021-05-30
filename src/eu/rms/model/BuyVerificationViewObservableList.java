package eu.rms.model;

import eu.rms.algorythm.search.SearchAlgo;
import eu.rms.view.BuyVerificationView;
import eu.rms.view.MapsView;
import eu.rms.view.timetable.TimResultGrid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BuyVerificationViewObservableList {

	private final static ObservableList<BuyVerificationView> data = FXCollections.observableArrayList();

	private static BuyVerificationView content = null;

	public static BuyVerificationView getTable() {
		return content;
	}

	public static void setTable(BuyVerificationView content) {
		BuyVerificationViewObservableList.content = content;
	}

	public static ObservableList<BuyVerificationView> getData() {
		return data;
	}

	public static ObservableList<BuyVerificationView> get() {
		return data;
	}
}
