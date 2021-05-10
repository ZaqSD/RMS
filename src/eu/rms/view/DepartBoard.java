package eu.rms.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import eu.rms.model.DB;
import eu.rms.model.LineObservableList;
import eu.rms.model.Logo;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class DepartBoard extends GridPane {

	private Boolean isFilled = false;
	private String station = "";

	public DepartBoard() {
		super();

		// 0 - LineIcon
		// 1 - DepartureTime
		// 2 - Destination
		// 3 - Stops
		// 4 - Platform

		this.setVgap(20);
		this.setHgap(10);

		Load();

	}

	public Boolean getIsFilled() {
		return isFilled;
	}

	public void setIsFilled(Boolean isFilled) {
		this.isFilled = isFilled;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public void Reload(String station) {

		this.setStation(station);
		this.getChildren().clear();
		Load();
	}

	private void Load() {

		GetDB("SELECT a.timTimeOnDeparture, a.timPlatform, b.staName, c.linType, c.linNr, c.linKey, c.linDestination FROM tStation b JOIN tStationTimetable a ON b.staKey=a.staId JOIN tLine c ON a.linId=c.linKey WHERE staName = '"
				+ this.getStation()
				+ "' AND a.timTimeOnDeparture IS NOT null ORDER BY a.timTimeOnDeparture ASC LIMIT 10;");
	}

	public String GetDB(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			int count = 0;
			while (rs.next()) {
				String departureTime = rs.getString("timTimeOnDeparture");
				String platform = rs.getString("timPlatform");
				String lineType = rs.getString("linType");
				String lineNr = rs.getString("linNr");
				String destination = rs.getString("linDestination");
				String lineKey = rs.getString("linKey");
				count++;

				this.addLine(lineKey, lineType, lineNr, departureTime, destination, platform, count);

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void addLine(String lineKey, String lineType, String lineNr, String departureTime, String destination,
			String platform, int count) {

		String lineName = lineType;

		if (lineNr != null) {
			lineName = lineName + "-" + lineNr;
		}

		this.add(new Label(), 0, 0);
		this.add(new Label("Departure"), 1, 0);
		this.add(new Label("Destinations"), 2, 0);
		this.add(new Label(), 3, 0);
		this.add(new Label("Platform"), 4, 0);

		this.add(
				new ImgView(new Image(Logo.class
						.getResourceAsStream("../ressources/img/line/product-" + lineName.toLowerCase() + ".png"))),
				0, count);

		this.add(new Label(departureTime.substring(0, departureTime.length() - 3)), 1, count);
		this.add(new Label(destination), 2, count);
		this.add(new Label(platform), 4, count);
	}

}
