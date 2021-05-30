package eu.rms.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.rms.controller.MenuTimetableEventHandler;
import eu.rms.model.ContentObservableList;
import eu.rms.model.DB;
import eu.rms.model.DepartObservableList;
import eu.rms.model.IconButton;
import eu.rms.model.Subtitle;
import eu.rms.model.Title;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DepartView extends GridPane {

	public DepartView() throws SQLException {
		super();
		this.setPadding(new Insets(10, 50, 10, 10));
		Title title = new Title("Next Departs");
		
		DepartBoard departBoard = new DepartBoard();

		TextField textDepStation = new TextField();
		textDepStation.setPromptText("Station");
		textDepStation.setPrefSize(600, 60);

		Button btnDepSearch = new Button("Search");
		btnDepSearch.getStyleClass().add("btn-primary");
		btnDepSearch.setPrefSize(200, 60);
		btnDepSearch.setGraphic(new ImgView(IconButton.getMagglasswhite()));
		btnDepSearch.setOnAction(λ -> {
			String station = textDepStation.getText();
			departBoard.Reload(station);
		});

		textDepStation.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				LoadSearchRecommendations(newValue);
			}
		});
		
		this.add(title, 0, 0);
		this.add(textDepStation, 0, 1, 1, 1);
		this.add(btnDepSearch, 1, 1, 1, 1);
		this.add(departBoard, 0, 3, 2, 1);
		DepartObservableList.setTable(this);

	}
	
	public void LoadSearchRecommendations(String value) {
		Searchrecommendation sr = new Searchrecommendation(value);
		this.add(sr, 0, 2, 2, 1);
	}
}
