package com.bank.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bank.configuration.DatabaseConnection;
import com.bank.models.LoginDetails;
import com.bank.models.UserDetails;

public class ExecutionService {
	
	DatabaseConnection connection = DatabaseConnection.getInstance();
	Statement statement = null;
	ResultSet resultSet = null; 
	
	private static final Logger logger = Logger.getLogger(ExecutionService.class);  
	
	public ExecutionService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void createNewAccount(UserDetails userDetails) {
		
	}
	

	public boolean validUser(LoginDetails loginDetails) {
		boolean isValidUser = false;
		try {
			statement = connection.getConnection().createStatement();
	        resultSet = statement.executeQuery( "select * from finance.user_details where user_details.user_id = "
	        		+ " "+loginDetails.getUserID()+" and password='"+loginDetails.getPassword()+"'" );
	        while(resultSet.next()) {
	        	isValidUser = true;
	        	insertLoginLog(loginDetails);
	        }
	        closeStatementAndResultset();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error on validating user.");
			logger.error(e);
		}
		
		
		return isValidUser;
	}
	
	private void closeStatementAndResultset() throws SQLException {
		if(statement != null && !statement.isClosed())
			statement.close();
		if(resultSet != null && !resultSet.isClosed())
			resultSet.close();
	}
	
	public void insertLoginLog(LoginDetails loginDetails) {
		try {
			statement = connection.getConnection().createStatement();
			 String sql = "INSERT INTO finance.login_details(\r\n"
			 		+ "	user_id,  last_login_time_date)\r\n"
			 		+ "	VALUES ("+loginDetails.getUserID()+", now())";
			 statement.executeUpdate(sql);
			 
		} catch (Exception e) {
			logger.error("Error on inserting login details");
			logger.error(e);
		}
	}
		


}
