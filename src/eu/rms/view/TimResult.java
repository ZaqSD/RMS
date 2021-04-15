package eu.rms.view;

import eu.rms.model.Arrow;
import eu.rms.model.ContentObservableList;
import eu.rms.model.IconButton;
import eu.rms.model.IconLine;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TimResult extends GridPane{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TimResult() {
		super();
		this.setStyle("-fx-background-color: #E5E5E5;");
		this.setPrefSize(900, 75);
		this.setPadding(new Insets(10,10,10,10));
		
	    Arrow arrow = new Arrow();

		//From DB
	    //TODO constructor with new Object, inside all the attributes from DB
	    int datLinId = 10101;
		String datLinType = "RE";
		String datLinDestination = "Zürich HB";
		int datPlatform = 0;
		String datDepartureTime = "00:00";
		String datArrivalTime = "00:00";
		String datTravelTime = "00:00";
		int datChanges = 0; 
		
		
		//TopInfoGrid
		GridPane infoGrid = new GridPane();
		
		if (datLinType.intern() == "RE") {
			ImgView lineLogo = new ImgView(IconLine.getRe());
			infoGrid.add(lineLogo, 0, 0);
			lineLogo.setFitHeight(25);
		}

		Label destination = new Label(datLinDestination);
		destination.getStyleClass().add("subtitle");
		destination.setStyle("-fx-font-size: 23;");
		
		infoGrid.add(new ImgView(IconButton.getRouteend2x()), 1, 0);
		infoGrid.add(destination, 2, 0);
		
		
		//DetailPane
		GridPane detailPane = new GridPane();
		detailPane.setHgap(30);
		detailPane.setVgap(10);
		String detailStyle = "-fx-font-size: 20;";

		Label labDepartureTime = new Label("Departure Time");
		labDepartureTime.setStyle(detailStyle);
		labDepartureTime.setStyle("-fx-font-family: 'Arial Black'; -fx-font-size:15;");
		Label departureTime = new Label(datDepartureTime);
		departureTime.setStyle(detailStyle);
		Label labDeparturePlat = new Label("Platform");
		labDeparturePlat.setStyle(detailStyle);
		labDeparturePlat.setStyle("-fx-font-family: 'Arial Black'; -fx-font-size:15;");
		Label departurePlat = new Label(Integer.toString(datPlatform));
		departurePlat.setStyle(detailStyle);
		Label labArrivalTime = new Label("Arrival Time");
		labArrivalTime.setStyle(detailStyle);
		labArrivalTime.setStyle("-fx-font-family: 'Arial Black'; -fx-font-size:15;");
		Label arrivalTime = new Label(datArrivalTime);
		arrivalTime.setStyle(detailStyle);
		Label labTravelTime = new Label("Traveltime");
		labTravelTime.setStyle(detailStyle);
		labTravelTime.setStyle("-fx-font-family: 'Arial Black'; -fx-font-size:15;");
		Label travelTime = new Label(datTravelTime);
		travelTime.setStyle(detailStyle);
		Label labChanges = new Label("Changes");
		labChanges.setStyle(detailStyle);
		labChanges.setStyle("-fx-font-family: 'Arial Black'; -fx-font-size:15;");
		Label changes = new Label(Integer.toString(datChanges));
		changes.setStyle(detailStyle);

		//more.setGraphic(new ImgView(IconButton.getMagglass()));
		
		//TODO Give linId with Buttonclick
		Button more = new Button("More");
		more.getStyleClass().add("btn-primary");
		more.setStyle("-fx-font-size: 20");
		more.setPrefHeight(100);
		more.setPrefWidth(100);
		more.setOnAction(λ -> {
			TimResultOverview detailView = new TimResultOverview(datLinId);
			ContentPane content = ContentObservableList.getTable();
			content.Reload(detailView);
		});
		
		detailPane.add(labDepartureTime, 0, 0);
		detailPane.add(departureTime, 1, 0);
		detailPane.add(labDeparturePlat, 0, 1);
		detailPane.add(departurePlat, 1, 1);
		detailPane.add(labArrivalTime, 2, 0);
		detailPane.add(arrivalTime, 3, 0);
		detailPane.add(labTravelTime, 2, 1);
		detailPane.add(travelTime, 3, 1);
		detailPane.add(labChanges, 4, 0);
		detailPane.add(changes, 5, 0);
		
		Label filler = new Label();
		filler.setPrefWidth(30);
		
		this.add(infoGrid, 0, 0);
		this.add(detailPane, 0, 1);
		this.add(filler, 1, 0);
		this.add(more, 2, 0, 1, 2);
		
		//this.add(logo, 0, 0);
	}
}
