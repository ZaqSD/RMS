package eu.rms.model;

import eu.rms.algorythm.search.SearchAlgo;
import eu.rms.view.MapsView;
import eu.rms.view.timetable.TimResultGrid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchAlgoObservableList {

	private final static ObservableList<SearchAlgo> data = FXCollections.observableArrayList();

	private static SearchAlgo content = null;

	public static SearchAlgo getTable() {
		return content;
	}

	public static void setTable(SearchAlgo content) {
		SearchAlgoObservableList.content = content;
	}

	public static ObservableList<SearchAlgo> getData() {
		return data;
	}

	public static ObservableList<SearchAlgo> get() {
		return data;
	}
}
