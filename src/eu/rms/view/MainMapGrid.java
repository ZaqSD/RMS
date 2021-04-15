package eu.rms.view;

import eu.rms.controller.MapLoadMainEventHandler;
import eu.rms.model.IconMap;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainMapGrid extends GridPane{

	MainMapGrid() {
		super();
		this.setPrefSize(700, 310);
		this.setStyle("-fx-background-color: #cccccc");
		this.setHgap(10);
		this.setVgap(10);
		
		//tile7.setGraphic(new ImgView(IconButton.getInfo2x()));
/*
		ImgView mapImg = new ImgView(IconMap.getFvS());
		mapImg.setFitHeight(240);
		mapImg.setFitWidth(700);
		*/
		Label name = new Label(" Long-Distance Network");
		name.setPrefWidth(530);
		name.getStyleClass().add("text-map");
		
		Button show = new Button("Show");
		show.getStyleClass().add("btn-primary");
		show.setPrefSize(150, 50);
		show.setOnAction(new MapLoadMainEventHandler());
		
		//this.add(mapImg, 0, 0, 2, 1);
		this.add(name, 0, 1, 1, 1);
		this.add(show, 1, 1, 1, 1);
	}
	
}
