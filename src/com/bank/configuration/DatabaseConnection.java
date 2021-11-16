package com.bank.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DatabaseConnection {
	
	private static DatabaseConnection instance;
	private static Connection con = null;
	private String url = "jdbc:postgresql://localhost:5432/Bank";
	private String username = "postgres";
	private String password = "Admin";
	private static String registerDriver = "org.postgresql.Driver";
	private static final Logger logger = Logger.getLogger(DatabaseConnection.class);  

	private DatabaseConnection() {
		try {
			Class.forName(registerDriver);
			this.con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			logger.error("Error on creating database.");
			logger.error(e);
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public static DatabaseConnection getInstance() {
		try {
			if(instance == null ) {
				instance = new  DatabaseConnection();
			} else if(instance.getConnection().isClosed()) {
				instance = new  DatabaseConnection();
			}
		} catch(Exception e) {
			logger.error("Error on getting instance.");
			logger.error(e);
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		//To validate the connection.
		try {
			System.out.println(DatabaseConnection.getInstance().getConnection().getSchema());
		} catch (SQLException e) {
			logger.error("Error on creating database.");
			logger.error(e);
		
		}
	}

}
