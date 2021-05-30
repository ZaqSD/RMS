package eu.rms.model;

import eu.rms.view.DepartView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchResultObservableList {

	private final static ObservableList<SearchResult> data = FXCollections.observableArrayList();

	private static SearchResult[] content = null;

	public static SearchResult[] getTable() {
		return content;
	}

	public static void setTable(SearchResult[] searchResults) {
		SearchResultObservableList.content = searchResults;
	}

	public static ObservableList<SearchResult> getData() {
		return data;
	}

	public static ObservableList<SearchResult> get() {
		return data;
	}
}
