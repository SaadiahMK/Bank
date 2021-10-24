package com.bank.models;

import java.util.Date;

public class TransferDetails {
	
	private long transactionRefId;
	private long routerNumber;
	private long fromAccount;
	private long toAccount;
	private long amount;
	private String transferType;
	private Date dateTime;

	public long getTransactionRefID() {
		return this.transactionRefId;
	}
	
	public void setTransactionRefID(long transactionRefId) {
		this.transactionRefId = transactionRefId;
	}
	
	public long getRouterNumber() {
		return this.routerNumber;
	}

	public void setRouterNumber(long routerNumber) {
		this.routerNumber = routerNumber;
	}
	
	public long getFromAccount() {
		return this.fromAccount;
	}
	
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	
	public long getToAccount() {
		return this.toAccount;
	}
	
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public long getAmount() {
		return this.amount;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public String getTransferType() {
		return this.transferType;
	}
	
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	
	public Date getDateTime() {
		return this.dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
