package eu.rms.view;

import eu.rms.controller.MenuTimetableEventHandler;
import eu.rms.model.DepartObservableList;
import eu.rms.model.IconButton;
import eu.rms.model.Subtitle;
import eu.rms.model.Title;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DepartView extends GridPane{

	public DepartView() {
		super();
		this.setPadding(new Insets(10,50,10,10));
		Title title = new Title("Next Departs");

		TextField textDepStation = new TextField();
		textDepStation.setPromptText("Station");
		textDepStation.setPrefSize(600, 60);
		
		Button btnDepSearch = new Button("Search");
		btnDepSearch.getStyleClass().add("btn-primary");
		btnDepSearch.setPrefSize(200, 60);
		btnDepSearch.setGraphic(new ImgView(IconButton.getMagglasswhite()));
		
		this.add(title, 0, 0);
		this.add(textDepStation, 0, 1, 1, 1);
		this.add(btnDepSearch, 1, 1, 1, 1);
		DepartBoard departBoard = new DepartBoard();
		this.add(departBoard, 0, 2, 2, 1);
		DepartObservableList.setTable(this);
	}
}
