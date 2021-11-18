package com.bank.main;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.bank.configuration.DatabaseConnection;
import com.bank.models.LoginDetails;
import com.bank.models.Menu;
import com.bank.models.UserDetails;
import com.bank.services.ExecutionService;

public class Execution extends ExecutionService {
	

	DatabaseConnection connection = DatabaseConnection.getInstance();
	Statement statement = null;
	ResultSet resultSet = null; 
	
	private static final Logger logger = Logger.getLogger(Execution.class);  
		
	
	public void startOperations(int menuId) {
		ExecutionService execService = new ExecutionService();
		Scanner scan = new Scanner(System.in);

		if(menuId == Menu.CREATE_BANK.getMenuId() || menuId == Menu.LOGIN.getMenuId() ) {
			logger.info("Please enter your user name and password. ");
			logger.info("Enter your user id : ");
			try {
				LoginDetails loginDetails = new LoginDetails();
				loginDetails.setUserID(scan.nextInt());
				logger.info("Enter your password : ");
				loginDetails.setPassword(scan.next());
				
				if(execService.validUser(loginDetails)) {
					logger.info("Welcome to the dashboard.");
				} else {
					logger.info("Wrong input added. Good bye");
				}				
				
				
			} catch(Exception e) {
				logger.info("Please enter valid inputs.");

			}
			

		} else { // Register a new account
			logger.info("Welcome to new user. Please enter following details to create a new account.");
			UserDetails userDetails = new UserDetails();
			
		}
		
	}
	
	public static void main(String[] args) {
		Execution exe = new Execution();
		
		Scanner scan = new Scanner(System.in);
		logger.info("Choose Menu : ");

		logger.info(Menu.CREATE_BANK.getMenuId() +" - "+ Menu.CREATE_BANK.getMenuName());
		logger.info(Menu.REGISTER_ACCOUNT.getMenuId() +" - "+ Menu.REGISTER_ACCOUNT.getMenuName());
		logger.info(Menu.LOGIN.getMenuId() +" - "+ Menu.LOGIN.getMenuName());

		System.out.println();
		logger.info("Please enter your menu id : ");

		int menuId = scan.nextInt();
		if(Menu.CREATE_BANK.getMenuId() == menuId) {
			logger.info("You have selected the menu: " + Menu.CREATE_BANK.getMenuName());
		} else if(Menu.REGISTER_ACCOUNT.getMenuId() == menuId) {
			logger.info("You have selected the menu: " + Menu.REGISTER_ACCOUNT.getMenuName());
		} else if (Menu.LOGIN.getMenuId() == menuId) {
			logger.info("You have selected the menu: " + Menu.LOGIN.getMenuName());
		} else {
			logger.info(" Invalid Menu type. Good bye.");
			return;	
		}
		
		exe.startOperations(menuId);
					
		
	}
		
			
}


