package com.bank.main;

import java.util.Scanner;

import com.bank.models.Menu;

public class Execution {
	
	public static void main(String[] args) {
		Execution exe = new Execution();
		
		System.out.println("Welcome to Citi Bank");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select your Menu");
		
		for (Menu menu: Menu.values()  ) {
			System.out.println(menu.getMenuId() + " " + menu.getMenuName());
		}
		
		int menuId = scan.nextInt();
		System.out.println("You have selected the MenuId: " + menuId);
		
		scan.close();
	}
		
			
}


