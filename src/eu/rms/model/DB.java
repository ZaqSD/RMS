package eu.rms.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class DB {

	private static final String connection = "jdbc:mysql://localhost/RMS_APP?useSSL=false&allowPublicKeyRetrieval=true";
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
