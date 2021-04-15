package eu.rms.view;

import eu.rms.controller.MapCloseEventHandler;
import eu.rms.model.IconButton;
import eu.rms.model.Subtitle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MapPopoutView extends GridPane{

	public MapPopoutView(ImgView imgView, String string) {
		
		imgView.setFitHeight(REMAINING);
		imgView.setPreserveRatio(true);
		
		Subtitle subtitle = new Subtitle("Long-Distance Network");
		subtitle.setPrefWidth(1500);
		
		Button close = new Button();
		close.setGraphic(new ImgView(IconButton.getCross1x()));
		close.setStyle("-fx-background-color: transparent");
		close.setOnAction(new MapCloseEventHandler());
		close.setPrefWidth(close.getHeight());
		//TODO close Message
		
		DropShadow shadow = new DropShadow();
		//Adding the shadow when the mouse cursor is on
		close.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	close.setEffect(shadow);
		        }
		});
		//Removing the shadow when the mouse cursor is off
		close.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	close.setEffect(null);
		        }
		});
		
		//TODO Fix Map not appearing properly
		
		this.add(subtitle, 0, 0, 1, 1);
		this.add(close, 1, 0, 1, 1);
		this.add(imgView, 0, 1, 2, 1);
		
	}

	
}
