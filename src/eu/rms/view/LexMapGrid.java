package eu.rms.view;

import eu.rms.model.IconMap;
import eu.rms.model.Logo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class LexMapGrid extends GridPane{

	LexMapGrid() {
		super();
		this.setPrefSize(345, 140);
		this.setStyle("-fx-background-color: #cccccc");
		
		//tile7.setGraphic(new ImgView(IconButton.getInfo2x()));
/*
		ImgView mapImg = new ImgView(IconMap.getLexS());
		mapImg.setFitHeight(140);
		mapImg.setFitWidth(140);
		*/
		Button name = new Button("Léman Express");
		name.getStyleClass().add("btn-maps");
		name.setPrefSize(REMAINING, REMAINING);
		name.setTextAlignment(TextAlignment.LEFT);;
		//TODO Fix fucking picture bug nullPointer fuck off
		//this.add(mapImg, 0, 0, 1, 1);
		this.add(name, 1, 0, 1, 1);
	}
	
}
