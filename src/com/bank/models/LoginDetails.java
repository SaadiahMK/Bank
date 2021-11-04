package com.bank.models;

import java.util.Date;

public class LoginDetails {
	
	public void LoginDetails(long userID, String password, Date lastLoginTime) {
		this.userID = userID;
		this.password = password;
		this.lastLoginTime = lastLoginTime;
	}
	
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