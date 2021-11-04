package com.bank.models;

public class Bank {
	
	public Bank(String name, String address, long routerNumber) {
		this.name = name;
		this.address = address;
		this.routerNumber = routerNumber;
	}
		
	private String name;
	private String address;
	private long routerNumber;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getRouterNumber() {
		return this.routerNumber;
	}

	public void setRouterNumber(long routerNumber) {
		this.routerNumber = routerNumber;
	}
}
