package eu.rms.view;

import eu.rms.model.IconMap;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class ZhMapGrid extends GridPane{

	ZhMapGrid() {
		super();
		this.setPrefSize(345, 140);
		this.setStyle("-fx-background-color: #cccccc");
		
		//tile7.setGraphic(new ImgView(IconButton.getInfo2x()));
/*
		ImgView mapImg = new ImgView(IconMap.getFvS());
		mapImg.setFitHeight(140);
		mapImg.setFitWidth(140);
		*/
		Button name = new Button("S-Bahn Zürich");
		name.getStyleClass().add("btn-maps");
		name.setPrefSize(REMAINING, REMAINING);
		name.setTextAlignment(TextAlignment.LEFT);;
		
		//this.add(mapImg, 0, 0, 1, 1);
		this.add(name, 1, 0, 1, 1);
	}
	
}
