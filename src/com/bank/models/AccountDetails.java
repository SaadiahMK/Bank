package com.bank.models;

import java.util.Date;

public class AccountDetails extends TransferDetails{
	
	public AccountDetails(long transactionRefId, long userID, 
			long accountBalance, long amount, Date dateTime, 
			String transactionType, long accountNumber) {
		setTransactionRefID(transactionRefId);
		setAmount(amount);
		setDateTime(dateTime);
		setTransferType(transactionType);
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	
	public AccountDetails() {
		
	}

	private long accountNumber;
	private long accountBalance;
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public long getAccountBalance() {
		return this.accountBalance;
	}
	
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
}
