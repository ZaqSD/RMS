package eu.rms.view.widgets;

import eu.rms.controller.MenuSettingsEventHandler;
import eu.rms.controller.NoWidgetCloseEventHandler;
import eu.rms.controller.WidgetSetActionListener;
import eu.rms.model.IconButton;
import eu.rms.view.ImgView;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class NoWidget extends GridPane {

	public NoWidget() {
		
		this.getStyleClass().add("widget");
		this.setPrefWidth(700);
		this.setStyle("-fx-background-color: #E5E5E5");
		
		Label message = new Label("You have no Widgets selected");
		Label filler = new Label();
		Button btnAdd = new Button("Settings");
		btnAdd.setOnAction(new MenuSettingsEventHandler());
		Button btnClose = new Button();
		btnClose.setOnAction(new NoWidgetCloseEventHandler());
		
		filler.setPrefWidth(120);
		btnClose.setGraphic(new ImgView(IconButton.getCross1x()));
		btnClose.setStyle("-fx-background-color: transparent");
		btnClose.setPrefWidth(btnClose.getHeight());
		
		DropShadow shadow = new DropShadow();
		//Adding the shadow when the mouse cursor is on
		btnClose.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            btnClose.setEffect(shadow);
		        }
		});
		//Removing the shadow when the mouse cursor is off
		btnClose.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	btnClose.setEffect(null);
		        }
		});
		
		btnAdd.getStyleClass().add("btn-primary");
		this.add(btnClose, 1, 1);
		this.add(message, 2, 1);
		this.add(filler, 3, 1);
		this.add(btnAdd, 2, 2);
	}
}
