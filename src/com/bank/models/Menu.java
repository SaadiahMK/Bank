package com.bank.models;

public enum Menu {
	
	CREATE_BANK(1, "Create Bank"),
	REGISTER_ACCOUNT(2, "Registeration of Bank Account"),
	LOGIN(3, "Login userID"),
	USER_DETAILS(4, "User Details"),
	ACCOUNT_VIEW(5, "View Account Balance"),
	ACCOUNT_HISTORY(6, "Account Transaction Details"),
	ACCOUNT_DEPOSIT(7, "Account Deposit Details"),
	ACCOUNT_WITHDRAWAL(8, "Account Withdrawal Details"),
	ACCOUNT_TRANSFER(9, "Account Transfer Details"),
	LOGOUT(10, "Logout userID");
	
	private int menuId;
	private String menuName;
	
	Menu(int menuId, String menuName) {
		this.menuId = menuId;
		this.menuName = menuName;
	}

	public int getMenuId() {
		return menuId;
	} 
	
	public String getMenuName() {
		return menuName;
	}
	
	
	
}
