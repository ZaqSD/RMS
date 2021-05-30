package eu.rms.view.timetable;

import eu.rms.model.IconLine;
import eu.rms.model.SearchResult;
import eu.rms.model.TimResultGridObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TimResultGrid extends GridPane{

	private int count = 0;
	Button more = new Button("More");
	
	public TimResultGrid() {
		super();
		this.setVgap(10);	
		TimResultGridObservableList.setTable(this);		
	}
	
	public void addResults(SearchResult[] searchResults) {
		this.add(new TimResult(searchResults), 0, count);
		//this.add(this.more, 0, count+1);
		this.count++;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Button getMore() {
		return more;
	}

	public void setMore(Button more) {
		this.more = more;
	}
	
}
