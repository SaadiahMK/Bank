package com.bank.models;

import java.util.Date;

public class AccountsWithdrawals {
	
	private long transactionRefId;
	private long userID;
	private long accountBalance;
	private long amount;
	private Date dateTime;
	
	public long getTransactionRefID() {
		return this.transactionRefId;
	}
	
	public void setTransactionRefID(long transactionRefId) {
		this.transactionRefId = transactionRefId;
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
	
	public long getAmount() {
		return this.amount;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public Date getDateTime() {
		return this.dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
