package com.bank.models;

import java.util.Date;

public class AccountDetails extends TransactionDetails{
	
	public AccountDetails(long transactionRefId, long userID, 
			long accountBalance, long amount, Date dateTime, 
			String transactionType, long accountNumber) {
		setTransactionRefID(transactionRefId);
		this.userID = userID;
		this.accountBalance = accountBalance;
		setAmount(amount);
		setDateTime(dateTime);
		setTransactionType(transactionType);
		this.accountNumber = accountNumber;
		this.userID = userID;
		this.accountBalance = accountBalance;
	}
	
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
