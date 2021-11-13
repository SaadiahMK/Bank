package com.bank.models;

import java.util.Date;

public class UserDetails extends AccountDetails {
	
	public UserDetails(long userID, long routerNumber, String firstname, 
			String lastname, String address, Date dateofbirth, long contact,
			String accountType, long accountNumber, String email, String proofOfID,
			long emergencyContact, String password, String userType, Date dateTime,
			String status) {
	
			this.userID = userID;
			this.routerNumber = routerNumber;
			this.firstname = firstname;
			this.lastname = lastname;
			this.address = address;
			this.dateofbirth = dateofbirth;
			this.contact = contact;
			this.accountType = accountType;
			this.accountNumber = accountNumber;
			this.email = email;
			this.proofOfID = proofOfID;
			this.emergencyContact = emergencyContact;
			this.password = password;
			this.userType = userType;
			this.dateTime = dateTime;
			this.status = status;
	}
	
	public UserDetails() {
		super();
	}
	
	private long userID;
	private long routerNumber;
	private String firstname;
	private String lastname;
	private String address;
	private Date dateofbirth;
	private long contact;
	private String accountType;
	private long accountNumber;
	private String email;
	private String proofOfID;
	private long emergencyContact;
	private String password;
	private String userType;
	private Date dateTime;
	private String status;
	
	public long getUserID() {
		return this.userID;
	}
	
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public long getRouterNumber() {
		return this.routerNumber;
	}

	public void setRouterNumber(long routerNumber) {
		this.routerNumber = routerNumber;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public void setLasttName(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getDateOfBirth() {
		return this.dateofbirth;
	}
	
	public void setDateOfBirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public long getContact() {
		return this.contact;
	}
	
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public String getAccountType() {
		return this.accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProofOfID() {
		return this.proofOfID;
	}
	
	public void setProofOfID(String proofOfID) {
		this.proofOfID = proofOfID;
	}
	
	public long getEmergencyContact() {
		return this.emergencyContact;
	}
	
	public void setEmergencyContact(long emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserType() {
		return this.userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public Date getDateTime() {
		return this.dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
