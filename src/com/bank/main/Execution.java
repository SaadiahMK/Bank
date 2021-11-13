package com.bank.main;

import java.util.Scanner;

import com.bank.models.Menu;
import com.bank.services.ExecutionService;

public class Execution extends ExecutionService {
	
	public void startOperations(int menuId) {
		ExecutionService execService = new ExecutionService();
		Scanner scan = new Scanner(System.in);

		if(menuId == Menu.CREATE_BANK.getMenuId() || menuId == Menu.LOGIN.getMenuId() ) {
			System.out.println("Please enter your user name and password. ");
			System.out.println("Enter your user id : ");
			int userId = scan.nextInt();
			System.out.println("Enter your password : ");
			String password = scan.next();

			
			System.out.println("success --> " + userId+ "  "+ password);

		} else { // Register a new account
			System.out.println("Welcome to new user. Please enter following details to create a new account.");
		}
		
	}
	
	public static void main(String[] args) {
		Execution exe = new Execution();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Choose Menu : ");

		System.out.println(Menu.CREATE_BANK.getMenuId() +" - "+ Menu.CREATE_BANK.getMenuName());
		System.out.println(Menu.REGISTER_ACCOUNT.getMenuId() +" - "+ Menu.REGISTER_ACCOUNT.getMenuName());
		System.out.println(Menu.LOGIN.getMenuId() +" - "+ Menu.LOGIN.getMenuName());

		System.out.println();
		System.out.print("Please enter your menu id : ");

		int menuId = scan.nextInt();
		if(Menu.CREATE_BANK.getMenuId() == menuId) {
			System.out.println("You have selected the menu: " + Menu.CREATE_BANK.getMenuName());
		} else if(Menu.REGISTER_ACCOUNT.getMenuId() == menuId) {
			System.out.println("You have selected the menu: " + Menu.REGISTER_ACCOUNT.getMenuName());
		} else if (Menu.LOGIN.getMenuId() == menuId) {
			System.out.println("You have selected the menu: " + Menu.LOGIN.getMenuName());
		} else {
			System.out.println(" Invalid Menu type. Good bye.");
			return;	
		}
		
		exe.startOperations(menuId);
		
		
			
		
	}
		
			
}


