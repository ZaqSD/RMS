package eu.rms.view.widgets;

import eu.rms.model.IconButton;
import eu.rms.view.ImgView;
import eu.rms.view.TicketList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicketWidget extends GridPane{

	public TicketWidget() {
		
		this.getStyleClass().add("widget");
		this.setPrefWidth(700);
		this.setHgap(10);
		
		Label title = new Label("Tickets");
		title.setStyle("-fx-font-family: 'arial black'; -fx-font-size: 40px;");
		
		Button history = new Button("History");
		history.getStyleClass().add("btn-secondary");
		history.setPrefSize(340, 75);
		history.setGraphic(new ImgView(IconButton.getClock1x()));
		Button profileCard = new Button("ProfileCard");
		profileCard.getStyleClass().add("btn-secondary");
		profileCard.setPrefSize(340, 75);
		profileCard.setGraphic(new ImgView(IconButton.getUser1x()));
		
		TicketList ticketList = new TicketList();
		
		this.add(title, 0, 0);
		this.add(history, 0, 1);
		this.add(profileCard, 1, 1);
		this.add(ticketList, 0, 2);
	}
}
