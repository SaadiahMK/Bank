package com.bank.models;

public class AccountDetails {
	
	private long accountNumber;
	private long userID;
	private long accountBalance;
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public long getUserID() {
		return this.userID;
	}
	
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public long getAccountBalance() {
		return this.accountBalance;
	}
	
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
}
