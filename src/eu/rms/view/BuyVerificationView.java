package eu.rms.view;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import eu.rms.model.DB;
import eu.rms.model.SearchResult;
import eu.rms.model.Subtitle;
import eu.rms.model.Title;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuyVerificationView extends GridPane {
	
	private String prename;
	private String name;
	private Date bday;
	private String gender;
	
	public BuyVerificationView(SearchResult[] searchResults, String prename, String name, LocalDate birthday, String gender) {
		
		//Prepare Data for DB
		Date date = Date.valueOf(birthday);
		
		this.setPrename(prename);
		this.setName(name);
		this.setBday(date);
		if(gender.equals("Female")) {
			this.setGender("0");
		}else {
			this.setGender("1");
		}
		
		for (SearchResult searchResult : searchResults) {
			
			int linId = Integer.parseInt(searchResult.getLinId());
			
			int response = AddDB("INSERT INTO tTicket (linId, perGen, perPrename, perName, perBday) VALUES ('" + linId + "','" + this.getGender() + "','" + this.getPrename() + "','" + this.getName() + "','" + this.getBday() + "');");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(response == 1) {
				UpdateSuccess();
			} else {
				UpdateFailed();
			}
		}
		
	}

	private void UpdateSuccess() {

		GridPane responseBox = new GridPane();

		responseBox.add(new Title("✔ Puchase successfull"), 0, 0);
		responseBox.add(new Subtitle("Have a great trip!"), 0, 1);
		//responseBox.getStyleClass().add("box-success");

		this.getChildren().clear();
		this.add(responseBox, 0, 0);
		
	}

	private void UpdateFailed() {

		GridPane responseBox = new GridPane();

		responseBox.add(new Title("✘ Puchase failed"), 0, 0);
		responseBox.add(new Subtitle("Please try again later"), 0, 1);
		//responseBox.getStyleClass().add("box-failed");

		this.getChildren().clear();
		this.add(responseBox, 0, 0);
		
	}
	
	public int AddDB(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(string);
			
			stmt.close();
			conn.close();
			
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public String getPrename() {
		return prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
