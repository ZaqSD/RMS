package eu.rms.view.timetable;

import eu.rms.model.ContentObservableList;
import eu.rms.model.IconButton;
import eu.rms.model.TimetableObservableList;
import eu.rms.model.Title;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TimetableView extends GridPane {
	
	public TimetableView() {
		super();
		this.setPadding(new Insets(10,50,10,10));
		Title title = new Title("Timetable");
		
		TimSearchGrid topGrid = new TimSearchGrid();
		TimResultGrid bottomGrid = new TimResultGrid();
		ScrollPane bottomGridContainer = new ScrollPane(bottomGrid);
		bottomGridContainer.setFitToWidth(true);

		Label fill = new Label("");
		fill.setPrefSize(222, 60);

		Label filler = new Label();
		filler.setPrefHeight(30);
		//bottomGrid.setPadding(new Insets(25));
				
		this.add(topGrid, 0, 1);
		this.add(filler, 0, 2);
		this.add(bottomGridContainer, 0, 3);
		//this.add(fill, 1, 1);

		this.add(title, 0, 0);
		this.setPrefWidth(850);
		//content.Reload(this);
		TimetableObservableList.setTable(this);
		
	}

	private void algoDisplay() {
		
		
	}
	
}
