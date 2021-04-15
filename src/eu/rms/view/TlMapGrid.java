package eu.rms.view;

import eu.rms.model.IconMap;
import eu.rms.model.Logo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class TlMapGrid extends GridPane{

	TlMapGrid() {
		super();
		this.setPrefSize(345, 140);
		this.setStyle("-fx-background-color: #cccccc");
		
		//tile7.setGraphic(new ImgView(IconButton.getInfo2x()));

		ImgView mapImg = new ImgView(Logo.getTl());
		mapImg.setFitHeight(140);
		mapImg.setFitWidth(140);
		
		Button name = new Button("Métro Lausanne");
		name.getStyleClass().add("btn-maps");
		name.setPrefSize(REMAINING, REMAINING);
		name.setTextAlignment(TextAlignment.LEFT);;
		
		this.add(mapImg, 0, 0, 1, 1);
		this.add(name, 1, 0, 1, 1);
	}
	
}
