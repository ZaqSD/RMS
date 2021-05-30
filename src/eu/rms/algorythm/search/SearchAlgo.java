package eu.rms.algorythm.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

import eu.rms.model.DB;
import eu.rms.model.SearchResult;
import eu.rms.model.TimResultGridObservableList;
import eu.rms.view.timetable.TimResultGrid;

public class SearchAlgo {

	private String departure;
	private String destination;
	private Time time;
	private Boolean isNow;

	public SearchAlgo(String departure, String destination) {

		Calendar cal = new GregorianCalendar();

		Search(departure, destination, new Time(new Long(System.currentTimeMillis())), true);
	}

	public SearchAlgo(String departure, String destination, int hour, int minute,
			Boolean isNow) {
        Time time = Time.valueOf(hour + ":" + minute);

		Search(departure, destination, time, isNow);
	}

	private void Search(String departure, String destination, Time time, Boolean isNow) {

		this.isNow = isNow;
		this.departure = departure;
		this.destination = destination;
		
		if(CheckStations(this.departure, this.destination)) {
			
		}
		
	}

	private boolean CheckStations(String departureCheck, String destinationCheck) {
		Boolean departure = GetStation("SELECT * FROM tStation WHERE staName = '" + departureCheck + "';");
		Boolean destination = GetStation("SELECT * FROM tStation WHERE staName = '" + destinationCheck + "';");

		if(departure && destination) {
			return true;
		}
		return false;
	}
	
	public boolean GetStation(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			rs.next();
			if (rs.getString("staName") != null) {
				return true;
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public SearchAlgo() {
		TimResultGrid timResultGrid = TimResultGridObservableList.getTable();
		timResultGrid.getChildren().clear();
		timResultGrid.setCount(0);
		SearchResult[] searchResults1 = { new SearchResult("1101", "Lausanne", "Bern") };
		SearchResult[] searchResults2 = { new SearchResult("3101", "Zürich HB", "Zürich Stadelhofen"),
				new SearchResult("3103", "Zürich Stadelhofen", "Zürich Tiefenbrunnen") };
		timResultGrid.addResults(searchResults1);
		timResultGrid.addResults(searchResults2);
	}

	public String GetStationTimetable(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			//CheckIfArrives();
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
