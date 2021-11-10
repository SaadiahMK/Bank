package com.bank.configuration;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static DatabaseConnection instance;
	private static Connection con = null;
	private String url = "jdbc:postgresql://localhost:5432/Bank";
	private String username = "postgres";
	private String password = "Admin";
	private static String registerDriver = "org.postgresql.Driver";
	
	private DatabaseConnection() {
		try {
			Class.forName(registerDriver);
			this.con = DriverManager.getConnection(url, username, password);
			
			DatabaseMetaData meta = con.getMetaData();
			
			System.out.println(meta.getDatabaseProductName());
			
			con.close();	
			
		} catch (Exception e) {
			System.out.println(e);
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
			e.printStackTrace();
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		//To validate the connection.
		try {
			System.out.println(DatabaseConnection.getInstance().getConnection().getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
