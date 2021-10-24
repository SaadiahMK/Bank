package com.bank.models;

import java.util.Date;

public class LoginDetails {
	
	private long userID;
	private String password;
	private Date lastLoginTime;
	
	public long getUserID() {
		return this.userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}