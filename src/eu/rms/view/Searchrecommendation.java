package eu.rms.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.rms.model.DB;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Searchrecommendation extends GridPane {

	public Searchrecommendation(String value) {
		super();
		Label recommendations = new Label("Recommendations: ");
		recommendations.setStyle("-fx-font-weight: 700; -fx-text-size: 16px;");
		this.add(recommendations, 0, 0);
		GetDB("SELECT * FROM tStation WHERE staName LIKE '" + value + "%' LIMIT 3");
	}

	public String GetDB(String string) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB.getConnection(), DB.getUser(), DB.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);

			int count = 0;
			
			rs.next();

			while (rs.next()){
				count++;
				Button station = new Button(rs.getString("staName") + "  ");
				station.getStyleClass().add("searchresult");
				this.add(station, count, 0);
			}

			count++;

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
