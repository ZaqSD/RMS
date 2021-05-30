package eu.rms.view.timetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.rms.model.Arrow;
import eu.rms.model.ContentObservableList;
import eu.rms.model.DB;
import eu.rms.model.IconButton;
import eu.rms.model.IconLine;
import eu.rms.model.Logo;
import eu.rms.model.SearchResult;
import eu.rms.view.ContentPane;
import eu.rms.view.ImgView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class TimResult extends GridPane {

	private String datLinId = "";
	private String datLinType = "";
	private String datLinNr;
	private String datLinDestination = "";
	private String datPlatform = "";
	private String datDepartureTime = "";
	private String datArrivalTime = "";
	private String datTravelTime = "";
	private int datChanges = 0;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TimResult(SearchResult[] searchResults) {
		super();
		this.setStyle("-fx-background-color: #E5E5E5;");
		this.setPrefSize(900, 75);
		this.setPadding(new Insets(10, 10, 10, 10));

		int outChanges = 0;

		for (int i = 0; i < searchResults.length; i++) {
			outChanges = i;
		}

		SearchResult start = searchResults[0];
		SearchResult end = searchResults[searchResults.length - 1];

		// From DB
		this.setDatChanges(outChanges);

		this.getStartInfo(start);
		this.getEndInfo(end);

		// TopInfoGrid
		GridPane infoGrid = new GridPane();

		String lineName = this.getDatLinType();

		if (this.getDatLinNr() != null) {
			lineName = lineName + "-" + this.getDatLinNr();
		}
		
		infoGrid.add(
				new ImgView(new Image(Logo.class
						.getResourceAsStream("../ressources/img/line/product-" + lineName.toLowerCase() + ".png"))),
				0, 0);

		Label destination = new Label(datLinDestination);
		destination.setStyle("-fx-font-size: 23; -fx-font-weight: 700;");

		infoGrid.add(new ImgView(IconButton.getRouteend2x()), 1, 0);
		infoGrid.add(new Label(this.getDatLinDestination()), 2, 0);

		// DetailPane
		GridPane detailPane = new GridPane();
		detailPane.setHgap(30);
		detailPane.setVgap(10);

		Label labDepartureTime = new Label("Departure Time");
		labDepartureTime.getStyleClass().add("result-detail-text");
		labDepartureTime.setStyle("-fx-font-family:'arial'; -fx-font-size:18; -fx-font-weight: 700;");
		Label departureTime = new Label(this.getDatDepartureTime());
		departureTime.getStyleClass().add("result-detail-text");
		Label labDeparturePlat = new Label("Platform");
		labDeparturePlat.getStyleClass().add("result-detail-text");
		labDeparturePlat.setStyle("-fx-font-family:'arial'; -fx-font-size:18; -fx-font-weight: 700;");
		Label departurePlat = new Label(this.getDatPlatform());
		departurePlat.getStyleClass().add("result-detail-text");
		Label labArrivalTime = new Label("Arrival Time");
		labArrivalTime.getStyleClass().add("result-detail-text");
		labArrivalTime.setStyle("-fx-font-family:'arial'; -fx-font-size:18; -fx-font-weight: 700;");
		Label arrivalTime = new Label(this.getDatArrivalTime());
		arrivalTime.getStyleClass().add("result-detail-text");
		Label labTravelTime = new Label("Traveltime");
		labTravelTime.getStyleClass().add("result-detail-text");
		labTravelTime.setStyle("-fx-font-family:'arial'; -fx-font-size:18; -fx-font-weight: 700;");
		Label travelTime = new Label(this.getDatTravelTime());
		travelTime.getStyleClass().add("result-detail-text");
		Label labChanges = new Label("Changes");
		labChanges.getStyleClass().add("result-detail-text");
		labChanges.setStyle("-fx-font-family:'arial'; -fx-font-size:18; -fx-font-weight: 700;");
		Label changes = new Label(Integer.toString(this.getDatChanges()));
		changes.getStyleClass().add("result-detail-text");

		// TODO Give linId with Buttonclick
		Button more = new Button("More");
		more.getStyleClass().add("btn-primary");
		more.setStyle("-fx-font-size: 20");
		more.setPrefHeight(90);
		more.setPrefWidth(90);
		more.setOnAction(λ -> {
			TimResultDetailView detailView = new TimResultDetailView(searchResults);
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
		GridPane.setHalignment(more, HPos.RIGHT);
	}

	private void getStartInfo(SearchResult result) {

		System.out.println(
				"SELECT a.timTimeOnDeparture, a.timTimeOnArrival, a.timPlatform, b.staName, c.linType, c.linNr, c.linKey, c.linDestination FROM tStation b JOIN tStationTimetable a ON b.staKey=a.staId JOIN tLine c ON a.linId=c.linKey WHERE b.staName = '"
						+ result.getLinStart() + "' AND c.linKey = '" + result.getLinId() + "';");

		GetStartDB("SELECT a.timTimeOnDeparture, a.timPlatform, b.staName, c.linType, c.linNr, c.linKey, c.linDestination FROM tStation b JOIN tStationTimetable a ON b.staKey=a.staId JOIN tLine c ON a.linId=c.linKey WHERE b.staName = '"
				+ result.getLinStart() + "' AND c.linKey = '" + result.getLinId() + "';");
	}

	private void getEndInfo(SearchResult result) {

		GetDestinationDB("SELECT a.timTimeOnDeparture, a.timTimeOnArrival, a.timPlatform, b.staName, c.linType, c.linNr, c.linKey, c.linDestination FROM tStation b JOIN tStationTimetable a ON b.staKey=a.staId JOIN tLine c ON a.linId=c.linKey WHERE b.staName = '"
				+ result.getLinEnd() + "' AND c.linKey = '" + result.getLinId() + "';");
	}

	public String GetStartDB(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			int count = 0;
			rs.next();

			String departureTime = rs.getString("timTimeOnDeparture");
			String arrivalTime = "00:00";// wtf ka wieso es nicht funktiniert
			String platform = rs.getString("timPlatform");
			String lineType = rs.getString("linType");
			String lineNr = rs.getString("linNr");
			String destination = rs.getString("linDestination");
			String lineKey = rs.getString("linKey");
			count++;

			addStartInfo(lineKey, lineType, lineNr, departureTime, destination, platform, count);

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String GetDestinationDB(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			int count = 0;
			rs.next();

			String departureTime = rs.getString("timTimeOnDeparture");
			String arrivalTime = rs.getString("timTimeOnArrival");// wtf ka wieso es nicht funktiniert
			String platform = rs.getString("timPlatform");
			String lineType = rs.getString("linType");
			String lineNr = rs.getString("linNr");
			String destination = rs.getString("linDestination");
			String lineKey = rs.getString("linKey");
			count++;

			addEndInfo(arrivalTime);

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void addEndInfo(String arrivalTime) {
		this.setDatArrivalTime(arrivalTime.substring(0, arrivalTime.length() - 3));
	}

	private void addStartInfo(String lineKey, String lineType, String lineNr, String departureTime, String destination,
			String platform, int count) {
		this.setDatLinId(lineKey);
		this.setDatDepartureTime(departureTime.substring(0, departureTime.length() - 3));
		this.setDatLinDestination(destination);
		this.setDatLinType(lineType);
		this.setDatPlatform(platform);
		this.setDatLinNr(lineNr);
	}

	public String getDatLinId() {
		return datLinId;
	}

	public void setDatLinId(String datLinId) {
		this.datLinId = datLinId;
	}

	public String getDatLinType() {
		return datLinType;
	}

	public void setDatLinType(String datLinType) {
		this.datLinType = datLinType;
	}

	public String getDatLinDestination() {
		return datLinDestination;
	}

	public void setDatLinDestination(String datLinDestination) {
		this.datLinDestination = datLinDestination;
	}

	public String getDatPlatform() {
		return datPlatform;
	}

	public void setDatPlatform(String datPlatform) {
		this.datPlatform = datPlatform;
	}

	public String getDatDepartureTime() {
		return datDepartureTime;
	}

	public void setDatDepartureTime(String datDepartureTime) {
		this.datDepartureTime = datDepartureTime;
	}

	public String getDatArrivalTime() {
		return datArrivalTime;
	}

	public void setDatArrivalTime(String datArrivalTime) {
		this.datArrivalTime = datArrivalTime;
	}

	public String getDatTravelTime() {
		return datTravelTime;
	}

	public void setDatTravelTime(String datTravelTime) {
		this.datTravelTime = datTravelTime;
	}

	public int getDatChanges() {
		return datChanges;
	}

	public void setDatChanges(int outChanges) {
		this.datChanges = outChanges;
	}

	public String getDatLinNr() {
		return datLinNr;
	}

	public void setDatLinNr(String datLinNr) {
		this.datLinNr = datLinNr;
	}

	
}
