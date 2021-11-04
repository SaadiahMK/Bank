package com.bank.test;

import java.util.Date;

import com.bank.models.Bank;
import com.bank.models.UserDetails;

public class Dummy {
	
	public static void main(String[] args) {
		 Bank bank = new Bank("Citi Bank","43-87 Manhattan NY 10003",
				 32000065);
		 System.out.println(bank.getAddress());
		 
		 UserDetails userdetails = new UserDetails(1001, 32000065,"William", "Collen", "32 Dawson Street Brookly NY 13400", new Date(),
				 9173450001l, "Current Account",1083925890l,"william_99@gmail.com", "Passport", 9173450833l, "Large3!", 
				 "Customer", new Date(), "Approve");
		 System.out.println(userdetails.getAccountNumber());
		 
		 
	}

}
