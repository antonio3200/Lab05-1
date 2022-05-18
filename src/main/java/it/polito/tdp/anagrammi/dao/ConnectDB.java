package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	static private final String jdbcUrl= "jdbc:mysql://localhost/dizionario?user=root&password=antonio";
	public static Connection getConnection() {
		try {
			Connection connection=DriverManager.getConnection(jdbcUrl);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection "+ jdbcUrl,e);
		}
	}

}
