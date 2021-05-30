package eu.rms.view.timetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.rms.model.DB;
import eu.rms.model.IconTimetable;
import eu.rms.model.Logo;
import eu.rms.model.SearchResult;
import eu.rms.view.ImgView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class TimResultDetailInfoView extends GridPane {

	private String linId;
	private String linNr;
	private String linType;
	private String linStart;
	private String linDestination;
	private String linLineDestination;
	private String linStartPlatform;
	private String linDestinationPlatform;
	private String linStartDeparture;
	private String linDestinationArrival;

	public TimResultDetailInfoView(SearchResult searchResult) {
		super();

		this.setHgap(10);
		this.setVgap(20);
		this.getStyleClass().add("widget");

		this.setLinId(searchResult.getLinId());
		
		GetLineDB("SELECT * FROM tLine WHERE linKey = '" + searchResult.getLinId() + "';");
		GetDepartDB("SELECT * FROM tStationTimetable a JOIN tStation b ON a.staId = b.staKey WHERE a.linId = '" + searchResult.getLinId() + "' AND b.staName = '" + searchResult.getLinStart() + "';");
		GetDestinationDB("SELECT * FROM tStationTimetable a JOIN tStation b ON a.staId = b.staKey WHERE a.linId = '" + searchResult.getLinId() + "' AND b.staName = '" + searchResult.getLinEnd() + "';");

		String lineName = this.linType + "-" + this.linNr;
	
		Label labDepart = new Label(this.linStart);
		labDepart.setPrefWidth(575);
		
		this.add(
				new ImgView(new Image(Logo.class
						.getResourceAsStream("../ressources/img/line/product-" + lineName.toLowerCase() + ".png"))),
				2, 1);

		//this.add(new ImgView(IconTimetable.getLine()), 0, 0, 1, 3);
		this.add(new Label(this.linStartDeparture), 1, 0);
		this.add(labDepart, 2, 0, 2, 1);
		this.add(new Label(" " + this.linStartPlatform), 4, 0);
		this.add(new Label("➔ " + this.linLineDestination), 3, 1);
		this.add(new Label(this.linDestinationArrival), 1, 2);
		this.add(new Label(this.linDestination), 2, 2, 2, 1);
		this.add(new Label(" " + this.linDestinationPlatform), 4, 2);
	}

	public String GetLineDB(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			int count = 0;
			rs.next();

			this.setLinLineDestination(rs.getString("linDestination"));
			this.setLinId(rs.getString("linKey"));
			this.setLinType(rs.getString("linType"));
			this.setLinNr(rs.getString("linNr"));
			
			count++;

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetDepartDB(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			int count = 0;
			rs.next();

			this.setLinStart(rs.getString("staName"));
			this.setLinStartDeparture(rs.getString("timTimeOnDeparture").substring(0, rs.getString("timTimeOnDeparture").length() - 3));
			this.setLinStartPlatform(rs.getString("timPlatform"));
			
			count++;

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

			this.setLinDestination(rs.getString("staName"));
			this.setLinDestinationArrival(rs.getString("timTimeOnArrival").substring(0, rs.getString("timTimeOnArrival").length() - 3));
			this.setLinDestinationPlatform(rs.getString("timPlatform"));
			
			count++;

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLinId() {
		return linId;
	}

	public void setLinId(String linId) {
		this.linId = linId;
	}

	public String getLinType() {
		return linType;
	}

	public void setLinType(String linType) {
		this.linType = linType;
	}

	public String getLinDestination() {
		return linDestination;
	}

	public void setLinDestination(String linDestination) {
		this.linDestination = linDestination;
	}

	public String getLinStartPlatform() {
		return linStartPlatform;
	}

	public void setLinStartPlatform(String linStartPlatform) {
		this.linStartPlatform = linStartPlatform;
	}

	public String getLinDestinationPlatform() {
		return linDestinationPlatform;
	}

	public void setLinDestinationPlatform(String linDestinationPlatform) {
		this.linDestinationPlatform = linDestinationPlatform;
	}

	public String getLinNr() {
		return linNr;
	}

	public void setLinNr(String linNr) {
		this.linNr = linNr;
	}

	public String getLinStartDeparture() {
		return linStartDeparture;
	}

	public void setLinStartDeparture(String linStartDeparture) {
		this.linStartDeparture = linStartDeparture;
	}

	public String getLinDestinationArrival() {
		return linDestinationArrival;
	}

	public void setLinDestinationArrival(String linDestinationArrival) {
		this.linDestinationArrival = linDestinationArrival;
	}

	public String getLinStart() {
		return linStart;
	}

	public void setLinStart(String linStart) {
		this.linStart = linStart;
	}

	public String getLinLineDestination() {
		return linLineDestination;
	}

	public void setLinLineDestination(String linLineDestination) {
		this.linLineDestination = linLineDestination;
	}

	
}
