package com.bank.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.bank.configuration.DatabaseConnection;
import com.bank.models.AccountDetails;
import com.bank.models.UserDetails;

public class UserOperationDAOImpl implements OperationsDAO<UserDetails> {

	DatabaseConnection connection = DatabaseConnection.getInstance();
	Statement statement = null;
		ResultSet resultSet = null; 
	
	private static final Logger logger = Logger.getLogger(UserOperationDAOImpl.class);  
		
		
	@Override
	public boolean save(UserDetails userDetails) {
		try {
			 statement = connection.getConnection().createStatement();
			 String sql = "insert into finance.user_details (First_Name, Last_Name, Address, Date_Of_Birth, Contact, Account_Type, Account_Number, Email,\r\n"
			 		+ "Proof_Of_Identification, Emergency_Contact, password, user_id, user_type, status, date_time, Router_Number)\r\n"
			 		+ "values('"+userDetails.getFirstName()+"', '"+userDetails.getLastName()+"', '"+userDetails.getAddress()+"', '"+userDetails.getDateOfBirth()+"', "+userDetails.getContact()+", '"+userDetails.getAccountType()+"', \r\n"
			 		+ ""+userDetails.getAccountNumber()+", '"+userDetails.getEmail()+"', '"+userDetails.getProofOfID()+"', "+userDetails.getEmergencyContact()+", '"+userDetails.getPassword()+"',"
			 				+ " "+userDetails.getUserID()+", '"+userDetails.getUserType()+"', '"+userDetails.getStatus()+"', now(), "+userDetails.getRouterNumber()+" );";
			 statement.executeUpdate(sql);
			 AccountDetails ac = new AccountDetails();
			 ac.setAccountBalance(0);
			 ac.setAccountNumber(userDetails.getAccountNumber());
			 ac.setUserID(userDetails.getUserID());
			 addAccountDetailsRecord(ac);
			 logger.info("Created new user");
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on creating user.");
			logger.error(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserDetails userDetails) {
		try {
			statement = connection.getConnection().createStatement();
			 String sql = "UPDATE finance.user_details\r\n"
			 		+ "	SET first_name='"+userDetails.getFirstName()+"', last_name='"+userDetails.getLastName()+"', "
			 				+ "address='"+userDetails.getAddress()+"', date_of_birth='"+userDetails.getDateOfBirth()+"',"
			 						+ " contact="+userDetails.getContact()+", email='"+userDetails.getEmail()+"', "
			 								+ "account_type='"+userDetails.getAccountType()+"',"
			 										+ " proof_of_identification='"+userDetails.getProofOfID()+"', emergency_contact='"+userDetails.getEmergencyContact()+"',"
			 												+ " password='"+userDetails.getPassword()+"' \r\n"
			 								
			 		+ "	WHERE user_details.user_id = "+userDetails.getUserID()+" ";
			 statement.executeUpdate(sql);
			 logger.info("Updated user details");
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on updating user details.");
			logger.error(e);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(UserDetails userDetails) {
		try {
			 deleteAccountDetails(userDetails);
			 
			statement = connection.getConnection().createStatement();
			 String sql = "DELETE FROM finance.user_details "	 								
			 		+ "	WHERE user_details.user_id = "+userDetails.getUserID()+" ";
			 statement.executeUpdate(sql);
			 logger.info("Deleted user details");
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on deleting the user record.");
			logger.error(e);
			return false;
		}
		return true;
	}
	
	private boolean deleteAccountDetails(UserDetails userDetails) {
		try {
			statement = connection.getConnection().createStatement();
			 String sql = "DELETE FROM finance.accounts_details "	 								
			 		+ "	WHERE accounts_details.user_id = "+userDetails.getUserID()+" ";
			 statement.executeUpdate(sql);
			 logger.info("Deleted account details");
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on deleting the deleteAccountDetails record.");
			logger.error(e);
			return false;
		}
		
		return true;
	}


	@Override
	public List<UserDetails> getAll() {
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT ud.user_id, ud.router_number, ud.first_name, ud.last_name, ud.address, ud.date_of_birth, ud.contact,ud.email, \r\n"
	         		+ "ud.account_type, ud.account_number, ud.proof_of_identification, ud.emergency_contact, ud.password, ud.user_type, ud.status, ud.date_time,\r\n"
	         		+ "ad.account_number,ad.account_balance\r\n"
	         		+ "	FROM finance.user_details ud join finance.accounts_details ad on \r\n"
	         		+ "	ud.user_id=ad.user_id" );
	         while ( resultSet.next() ) {
	        	 UserDetails userDetails = new UserDetails();
	        	 userDetails.setUserID(resultSet.getInt("user_id"));
	        	 userDetails.setRouterNumber(resultSet.getInt("router_number"));
	        	 userDetails.setFirstName(resultSet.getString("first_name"));
	        	 userDetails.setLastName(resultSet.getString("last_name"));
	        	 userDetails.setAddress(resultSet.getString("address"));
	        	 userDetails.setDateOfBirth(resultSet.getDate("date_of_birth"));
	        	 userDetails.setContact(resultSet.getLong("contact"));
	        	 userDetails.setEmail(resultSet.getString("email"));
	        	 userDetails.setAccountType(resultSet.getString("account_type"));
	        	 userDetails.setAccountBalance(resultSet.getLong("account_balance"));
	        	 userDetails.setProofOfID(resultSet.getString("proof_of_identification"));
	        	 userDetails.setEmergencyContact(resultSet.getLong("emergency_contact"));
	        	 userDetails.setPassword(resultSet.getString("password"));
	        	 userDetails.setStatus(resultSet.getString("status"));
	        	 userDetails.setAccountNumber(resultSet.getLong("account_number"));
	        	 userDetails.setUserType(resultSet.getString("user_type"));
	        	 userDetailsList.add(userDetails);
	         }
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on getting all the records.");
			logger.error(e);
			return null;
         }
		
		for(UserDetails ud:userDetailsList) {
		
			logger.info(" User Id: "+ ud.getUserID() + " User Account number: "+ud.getAccountNumber()+ " User account balance: "+ud.getAccountBalance());
			
			
		}
         return userDetailsList;
	}

	@Override
	public Optional<UserDetails> getRecord(long userId) {
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT ud.user_id, ud.router_number, ud.first_name, ud.last_name, ud.address, ud.date_of_birth, ud.contact,ud.email, \r\n"
	         		+ "ud.account_type, ud.account_number, ud.proof_of_identification, ud.emergency_contact, ud.password, ud.user_type, ud.status, ud.date_time,\r\n"
	         		+ "ad.account_number,ad.account_balance\r\n"
	         		+ "	FROM finance.user_details ud join finance.accounts_details ad on \r\n"
	         		+ "	ud.user_id=ad.user_id where ad.user_id = "+userId+"" );
	         while ( resultSet.next() ) {
	        	 UserDetails userDetails = new UserDetails();
	        	 userDetails.setUserID(resultSet.getInt("user_id"));
	        	 userDetails.setRouterNumber(resultSet.getInt("router_number"));
	        	 userDetails.setFirstName(resultSet.getString("first_name"));
	        	 userDetails.setLastName(resultSet.getString("last_name"));
	        	 userDetails.setAddress(resultSet.getString("address"));
	        	 userDetails.setDateOfBirth(resultSet.getDate("date_of_birth"));
	        	 userDetails.setContact(resultSet.getInt("contact"));
	        	 userDetails.setEmail(resultSet.getString("email"));
	        	 userDetails.setAccountType(resultSet.getString("account_type"));
	        	 userDetails.setAccountBalance(resultSet.getInt("contact"));
	        	 userDetails.setProofOfID(resultSet.getString("proof_of_identification"));
	        	 userDetails.setEmergencyContact(resultSet.getInt("emergency_contact"));
	        	 userDetails.setPassword(resultSet.getString("password"));
	        	 userDetails.setStatus(resultSet.getString("status"));
	        	 userDetails.setAccountNumber(resultSet.getInt("account_number"));
	        	 userDetails.setUserType(resultSet.getString("user_type"));
				 closeStatementAndResultset();
				 return Optional.of(userDetails);
	         }
		} catch (Exception e) {
			logger.error("Error on getting record.");
			logger.error(e);
			return null;
         }
         return null;
	}
	
	private boolean addAccountDetailsRecord(AccountDetails ac) {
		try {
			statement = connection.getConnection().createStatement();
			 String sql = "INSERT INTO finance.accounts_details (\r\n"
			 		+ "	account_number, user_id, account_balance) \r\n"
			 		+ "	VALUES ("+ac.getAccountNumber()+", "+ac.getUserID()+", "+ac.getAccountBalance()+") ";
			 statement.executeUpdate(sql);
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on adding account details.");
			logger.error(e);
			return false;
		}
		
		return true;
	}
	
	private void closeStatementAndResultset() throws SQLException {
		if(statement != null && !statement.isClosed())
			statement.close();
		if(resultSet != null && !resultSet.isClosed())
			resultSet.close();
	}
	
	public static void main(String args[]) {
		
		UserOperationDAOImpl userImpl = new UserOperationDAOImpl();
		UserDetails userDetails = new UserDetails();
		userDetails.setUserID(10001);
		userDetails.setRouterNumber(32000065);
		userDetails.setFirstName("Paul");
		userDetails.setLastName("Dsouza");
		userDetails.setAddress("76-11 47th Ave Elmhurst NY 11373");
		userDetails.setDateOfBirth(new Date("01/11/2000"));
		userDetails.setContact(9293345560l);
		userDetails.setEmail("paul_445@gmail.com");
		userDetails.setAccountType("Saving Account");
		userDetails.setAccountNumber(System.currentTimeMillis());
		userDetails.setProofOfID("Telephone Bill");
		userDetails.setEmergencyContact(9295330001l);
		userDetails.setPassword("Pussy443?");
		userDetails.setUserType("Client");
		userDetails.setStatus("Inactive");
				
		//userImpl.save(userDetails);
		//userImpl.delete(userDetails);
		//userImpl.update(userDetails);
		
		userImpl.getAll();
		
		
	}

	
	

}
