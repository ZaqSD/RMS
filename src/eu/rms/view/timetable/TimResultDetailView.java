package eu.rms.view.timetable;

import eu.rms.model.SearchResult;
import eu.rms.model.SearchResultObservableList;
import eu.rms.model.TimResultDetailViewObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TimResultDetailView extends BorderPane {

	private SearchResult[] searchResult;
	
	public TimResultDetailView(SearchResult[] searchResults) {
		
		this.setSearchResult(searchResults);
		TimResultDetailViewObservableList.setTable(this);;

		SearchResultObservableList.setTable(this.getSearchResult());
		
		GridPane routeList = new GridPane();
		ScrollPane scrollShell = new ScrollPane(routeList);
		
		String start = searchResults[0].getLinStart();
		String end = searchResults[searchResults.length-1].getLinEnd();
		
		this.setTop(new TimResultDetailOverView(start, end));
		this.setCenter(scrollShell);

		int count = 1;
				
		for (SearchResult searchResult : searchResults) {
			if(searchResult != searchResults[0]) {
				routeList.add(new Label("Change"), 0, count);
			}
			
			count++;
			
			routeList.add(new TimResultDetailInfoView(searchResult), 0, count);
			count++;
		}
		
	}

	public SearchResult[] getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(SearchResult[] searchResult) {
		this.searchResult = searchResult;
	}

}
