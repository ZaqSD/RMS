package eu.rms.view;

import eu.rms.model.IconButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TimSearchGrid extends GridPane{
	
	public TimSearchGrid() {
		super();
		
		this.setHgap(5);
		this.setVgap(5);
		//this.setPadding(new Insets(25));
		
		this.Reload();
		
	}

	public void Reload() {
		
		//Create Textfields
		TextField textTimStart = new TextField();
		textTimStart.setPromptText("Start");
		textTimStart.setPrefSize(400, 60);
		TextField textTimDestination = new TextField();
		textTimDestination.setPromptText("Destination");
		textTimDestination.setPrefSize(400, 60);
		TextField textTimHour = new TextField();
		textTimHour.setPromptText("00");
		textTimHour.setPrefSize(70, 60);
		TextField textTimMinute = new TextField();
		textTimMinute.setPromptText("00");
		textTimMinute.setPrefSize(70, 60);
		TextField textTimDate = new TextField();
		textTimDate.setPromptText("01.01.2020");
		textTimDate.setPrefSize(140, 60);
		
		//Create Radiobuttons
		final ToggleGroup timetable = new ToggleGroup();
		Font radioFont = new Font("Sans", 15);

		RadioButton radioTimAb = new RadioButton();
		radioTimAb.setText("From");
		radioTimAb.isSelected();
		radioTimAb.setToggleGroup(timetable);

		RadioButton radioTimAn = new RadioButton();
		radioTimAn.setText("To");
		radioTimAn.setToggleGroup(timetable);

		radioTimAb.setUserData("Ab");
		radioTimAn.setUserData("An");
		radioTimAb.setFont(radioFont);
		radioTimAn.setFont(radioFont);
		
		//Create Search
		Button btnTimSearch = new Button("Search");
		btnTimSearch.getStyleClass().add("btn-primary");
		btnTimSearch.setPrefSize(400, 60);		

		//Add Timetable
		this.add(textTimStart, 0, 0, 1, 1);
		this.add(textTimDestination, 0, 1, 1, 1);
		this.add(textTimHour, 2, 0, 1, 1);
		this.add(new Label(" : "), 3, 0, 1, 1);
		this.add(textTimMinute, 4, 0, 1, 1);
		this.add(textTimDate, 2, 1, 3, 1);
		this.add(btnTimSearch, 0, 2, 1, 1);
		this.add(radioTimAb, 2, 2, 1, 2);
		this.add(radioTimAn, 4, 2, 1, 2);
		
	}
	
}
