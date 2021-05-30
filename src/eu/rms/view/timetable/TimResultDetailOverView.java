package eu.rms.view.timetable;

import eu.rms.algorythm.search.SearchAlgo;
import eu.rms.controller.BuyFirstEventHandler;
import eu.rms.model.ContentObservableList;
import eu.rms.model.IconButton;
import eu.rms.model.Currency;
import eu.rms.model.SearchResult;
import eu.rms.view.ContentPane;
import eu.rms.view.ImgView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TimResultDetailOverView extends GridPane {

	public TimResultDetailOverView(String start, String destination) {
		this.getStyleClass().add("panel-dark");
		this.setVgap(10);
		this.setHgap(10);
				
		GridPane ticketPane = new GridPane();
		
		Button btnTicketBuy = new Button("Single Ride  4.90");
		btnTicketBuy.getStyleClass().add("btn-primary");
		btnTicketBuy.setStyle("-fx-text-size: 28px");
		btnTicketBuy.setOnAction(new BuyFirstEventHandler());
		
		ticketPane.add(btnTicketBuy, 0, 0);
		
		Button back = new Button();
		back.getStyleClass().add("btn-back");
		back.setMaxSize(12, 12);
		back.setGraphic(new ImgView(IconButton.getBackarrow1x()));
		back.setOnAction(λ -> {
			ContentPane contentPane = ContentObservableList.getTable();
			contentPane.Reload(11);
		});
		
		Label overview = new Label(start + " ➔ " + destination);
		overview.setStyle("-fx-font-weight: 700; -fx-text-size: 24px;");
		overview.setPrefWidth(400);
		
		this.add(back, 0, 0);
		this.add(overview, 1, 0);
		this.add(ticketPane, 2, 0);
	}
}
