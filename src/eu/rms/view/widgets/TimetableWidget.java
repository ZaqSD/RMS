package eu.rms.view.widgets;

import eu.rms.algorythm.search.SearchAlgo;
import eu.rms.model.ContentObservableList;
import eu.rms.model.Title;
import eu.rms.view.ContentPane;
import eu.rms.view.timetable.TimResultDetailView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TimetableWidget extends GridPane{

	public TimetableWidget() {
		
		this.getStyleClass().add("widget");
		this.setPrefWidth(700);
		this.setHgap(2);
		
		int height = 60;
		int width = 395;
		
		TextField textTimStart = new TextField();
		textTimStart.setPromptText("Start");
		textTimStart.setPrefSize(width, height);
		
		TextField textTimDest = new TextField();
		textTimDest.setPromptText("Destination");
		textTimDest.setPrefSize(width, height);
		
		Button btnTimSearch = new Button("Search");
		btnTimSearch.getStyleClass().add("btn-primary");
		btnTimSearch.setPrefSize(width, height);
		btnTimSearch.setOnAction(λ -> {
			new SearchAlgo();
		});
		
		Title title = new Title("Timetable - Now");
		
		this.add(title, 0, 0, 3, 1);
		this.add(textTimStart, 0, 1);
		this.add(textTimDest, 1, 1);
		this.add(btnTimSearch, 2, 1);
	}
}
