package com.bank.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import com.bank.configuration.DatabaseConnection;
import com.bank.models.AccountDetails;
import com.bank.models.TransferDetails;

public class TransferDetailsDAOImpl implements OperationsDAO<TransferDetails> {

	DatabaseConnection connection = DatabaseConnection.getInstance();
	Statement statement = null;
	ResultSet resultSet = null; 
	
	private static final Logger logger = Logger.getLogger(TransferDetailsDAOImpl.class); 
	
	public List<TransferDetails> getAllTransactionByUserId(long userId) {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transfer_details where  transfer_details.user_id ="+userId+" " );
	         while ( resultSet.next() ) {
	        	 TransferDetails transferDetails = new TransferDetails();
	        	 transferDetails.setTransactionRefID(resultSet.getInt("transaction_ref_id"));
	        	 transferDetails.setRouterNumber(resultSet.getInt("router_number"));
	        	 transferDetails.setFromAccount(resultSet.getInt("from_account"));
	        	 transferDetails.setTransferType(resultSet.getString("transfer_type"));
	        	 transferDetails.setDateTime(resultSet.getDate("date_time"));
	        	 transferDetails.setAmount(resultSet.getInt("amount"));
	        	 transferDetails.setToAccount(resultSet.getInt("to_account"));
	        	 transferDetails.setUserId(resultSet.getInt("user_id"));
				 closeStatementAndResultset();
				 return transferDetailsList;
	         }
		} catch (Exception e) {
			logger.error("Error on get getAllTransactionByUserId.");
			logger.error(e);
         }
         return null;
	}

	public List<TransferDetails> getAllDebitTransactionByUserId(long userId) {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transfer_details where  transfer_details.user_id ="+userId+" " );
	         while ( resultSet.next() ) {
	        	 TransferDetails transferDetails = new TransferDetails();
	        	 transferDetails.setTransactionRefID(resultSet.getInt("transaction_ref_id"));
	        	 transferDetails.setRouterNumber(resultSet.getInt("router_number"));
	        	 transferDetails.setFromAccount(resultSet.getInt("from_account"));
	        	 transferDetails.setTransferType(resultSet.getString("transfer_type"));
	        	 transferDetails.setDateTime(resultSet.getDate("date_time"));
	        	 transferDetails.setAmount(resultSet.getInt("amount"));
	        	 transferDetails.setToAccount(resultSet.getInt("to_account"));
	        	 transferDetails.setUserId(userId);
				 closeStatementAndResultset();
				 return transferDetailsList;
	         }
		} catch (Exception e) {
			logger.error("Error on getAllDebitTransactionByUserId.");
			logger.error(e);
         }
         return null;
	}

	public List<TransferDetails> getAllWithdrawalByUserId(long userId) {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transfer_details where  transfer_details.user_id ="+userId );
	         while ( resultSet.next() ) {
	        	 TransferDetails transferDetails = new TransferDetails();
	        	 transferDetails.setTransactionRefID(resultSet.getInt("transaction_ref_id"));
	        	 transferDetails.setRouterNumber(resultSet.getInt("router_number"));
	        	 transferDetails.setFromAccount(resultSet.getInt("from_account"));
	        	 transferDetails.setTransferType(resultSet.getString("transfer_type"));
	        	 transferDetails.setDateTime(resultSet.getDate("date_time"));
	        	 transferDetails.setAmount(resultSet.getInt("amount"));
	        	 transferDetails.setToAccount(resultSet.getInt("to_account"));
	        	 transferDetails.setUserId(userId);
				 closeStatementAndResultset();
				 return transferDetailsList;
	         }
		} catch (Exception e) {
			logger.error("Error on getAllWithdrawalByUserId.");
			logger.error(e);
         }
         return null;
	}


	@Override
	public boolean save(TransferDetails td) {
		try {
			statement = connection.getConnection().createStatement();
			
			 String sql = "";
			 if(td.getTransferType().equals("ATM") || td.getTransferType().equals("Withdrawal") ) {
			 sql = "INSERT INTO finance.transfer_details ("
			 		+ "	transaction_ref_id, router_number, from_account, to_account, transfer_type, date_time, user_id, account_balance, amount) "
			 		+ "	VALUES ("+td.getTransactionRefID()+", "
			 				+ ""+td.getRouterNumber()+", "+td.getFromAccount()+", "+td.getToAccount()+", "
			 						+ " '"+td.getTransferType()+"', now(), "+td.getUserId()+", "
			 								+ " ((select account_balance from finance.accounts_details where user_id = "+td.getUserId()+") - "+td.getAmount()+"),  "+td.getAmount()+" ) ";
			 } else {
				 sql = "INSERT INTO finance.transfer_details ("
					 		+ "	transaction_ref_id, router_number, from_account, to_account, transfer_type, date_time, user_id, account_balance,amount) "
					 		+ "	VALUES ("+td.getTransactionRefID()+", "
					 				+ ""+td.getRouterNumber()+", "+td.getFromAccount()+", "+td.getToAccount()+", "
					 						+ " '"+td.getTransferType()+"', now(), "+td.getUserId()+", "
					 								+ "( (select account_balance from finance.accounts_details where user_id = "+td.getUserId()+") + "+td.getAmount()+" ),  "+td.getAmount()+") ";	 
			 }
			 
			 statement.executeUpdate(sql);
			 logger.info("Transaction updated successfully.");
			 AccountDetails ac = new AccountDetails();
			 ac.setUserId(td.getUserId());
			 updateAccountBalance(ac);
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on inserting transaction details.");
			logger.error(e);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(TransferDetails td) {
		try {
			statement = connection.getConnection().createStatement();
			 String sql = "UPDATE finance.transfer_details "
			 		+ "	SET router_number="+td.getRouterNumber()+", "
			 				+ "from_account="+td.getFromAccount()+", to_account= "+td.getToAccount()+","
			 						+ " amount= "+td.getAmount()+", "
			 		+ " transfer_type='"+td.getTransferType()+", date_time= now()  "
			 								
			 		+ "	WHERE transfer_details.user_id = "+td.getUserId()+" and transfer_details.transaction_ref_id = "+td.getTransactionRefID()+" ";
			 statement.executeUpdate(sql);
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on updating transaction details.");
			logger.error(e);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(TransferDetails td) {
		try {
			statement = connection.getConnection().createStatement();
			 String sql = " DELETE FROM finance.transfer_details where"
			 		+ "	WHERE transfer_details.user_id = "+td.getUserId()+" ";
			 statement.executeUpdate(sql);
			 logger.info("Transaction deleted successfully.");
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on deleting transfer details.");
			logger.error(e);
			return false;
		}
		return true;
	}
	
	private boolean updateAccountBalance(AccountDetails ac) {
		try {
			statement = connection.getConnection().createStatement();
			 String sql = "update finance.accounts_details "
			 		+ "set account_balance = (select account_balance from finance.transfer_details where user_id = "+ac.getUserId()+" order by date_time desc limit 1) "
			 		+ "where user_id = "+ac.getUserId()+" ";
			 statement.executeUpdate(sql);
			 logger.info("Updated Account balance for the user "+ac.getUserId());
			 closeStatementAndResultset();
		} catch (Exception e) {
			logger.error("Error on adding account details.");
			logger.error(e);
			return false;
		}
		
		return true;
	}

	@Override
	public List<TransferDetails> getAll() {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transfer_details " );
	         while ( resultSet.next() ) {
	        	 TransferDetails transferDetails = new TransferDetails();
	        	 transferDetails.setTransactionRefID(resultSet.getInt("transaction_ref_id"));
	        	 transferDetails.setRouterNumber(resultSet.getInt("router_number"));
	        	 transferDetails.setFromAccount(resultSet.getInt("from_account"));
	        	 transferDetails.setTransferType(resultSet.getString("transfer_type"));
	        	 transferDetails.setDateTime(resultSet.getDate("date_time"));
	        	 transferDetails.setAmount(resultSet.getInt("amount"));
	        	 transferDetails.setToAccount(resultSet.getInt("to_account"));

				 closeStatementAndResultset();
				 return transferDetailsList;
	         }
		} catch (Exception e) {
			logger.error("Error on getAll records.");
			logger.error(e);
         }
         return null;
	}

	@Override
	public Optional<TransferDetails> getRecord(long userId) {

		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transfer_details" );
	         while ( resultSet.next() ) {
	        	 TransferDetails transferDetails = new TransferDetails();

	        	 transferDetails.setTransactionRefID(resultSet.getInt("transaction_ref_id"));
	        	 transferDetails.setRouterNumber(resultSet.getInt("router_number"));
	        	 transferDetails.setFromAccount(resultSet.getInt("from_account"));
	        	 transferDetails.setTransferType(resultSet.getString("transfer_type"));
	        	 transferDetails.setDateTime(resultSet.getDate("date_time"));
	        	 transferDetails.setAmount(resultSet.getInt("amount"));
	        	 transferDetails.setToAccount(resultSet.getInt("to_account"));

				 closeStatementAndResultset();
				 return Optional.of(transferDetails);
	         }
		} catch (Exception e) {
			logger.error("Error on getAll records.");
			logger.error(e);
         }
         return null;
	
		
	}
	
	private void closeStatementAndResultset() throws SQLException {
		if(statement != null && !statement.isClosed())
			statement.close();
		if(resultSet != null && !resultSet.isClosed())
			resultSet.close();
	}
	
	public static void main(String a[]) {
		TransferDetailsDAOImpl tdImpl = new TransferDetailsDAOImpl();
		TransferDetails transferdetails = new TransferDetails();
		transferdetails.setTransactionRefID(104);
		transferdetails.setRouterNumber(22000097);
		transferdetails.setFromAccount(2022004860);
		transferdetails.setToAccount(0);
		transferdetails.setAmount(500);
		transferdetails.setTransferType("Withdrawal");
		transferdetails.setUserId(1001);
		tdImpl.save(transferdetails);
		//tdImpl.update(transferdetails);
		
	}

}
