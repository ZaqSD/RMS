package eu.rms.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DB {

	private static final String connection = "jdbc:mysql://localhost/RMS_APP?useSSL=false&allowPublicKryRetrieva=true";
	private static final String user = "root";
	private static final String password = "";
	
	public static String getConnection() {
		return connection;
	}


	public static String getUser() {
		return user;
	}


	public static String getPassword() {
		return password;
	}

	public ResultSet Do(String string) {
		Connection conn;
		try {
			conn = DriverManager .getConnection(connection, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string);
			stmt.close();
			conn.close();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DB() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			/*
			while (rs.next()) {
				String salShort = rs.getString("salSHort");
				String addPrename = rs.getString("addPrename");
				String addName = rs.getString("addName");
				
				data.add(new Address(salShort, addPrename, addName));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
