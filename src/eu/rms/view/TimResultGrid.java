package eu.rms.view;

import eu.rms.model.IconLine;
import eu.rms.model.SearchResult;
import eu.rms.model.TimResultGridObservableList;
import javafx.scene.layout.GridPane;

public class TimResultGrid extends GridPane{
	
	public TimResultGrid() {
		super();
		this.setHgap(10);	
		TimResultGridObservableList.setTable(this);
	}
	
	public void addResults(SearchResult[] searchResults) {
		this.add(new TimResult(searchResults), 0, 0);
	}
}
