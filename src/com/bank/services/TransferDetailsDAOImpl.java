package com.bank.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import com.bank.configuration.DatabaseConnection;
import com.bank.models.TransferDetails;

public class TransferDetailsDAOImpl implements OperationsDAO<TransferDetails>, TransactionDAO<TransferDetails> {

	DatabaseConnection connection = DatabaseConnection.getInstance();
	Statement statement = null;
	ResultSet resultSet = null; 
	
	private static final Logger logger = Logger.getLogger(TransferDetailsDAOImpl.class); 
	
	@Override
	public List<TransferDetails> getAllTransactionByUserId(long id) {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transaction_details where  transaction_details.user_id ="+id+" " );
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
			logger.error("Error on get getAllTransactionByUserId.");
			logger.error(e);
         }
         return null;
	}

	@Override
	public List<TransferDetails> getAllDebitTransactionByUserId(long id) {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transaction_details where  transaction_details.user_id ="+id+" and "
	         				+ " transaction_details.user_id ='debit'" );
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
			logger.error("Error on getAllDebitTransactionByUserId.");
			logger.error(e);
         }
         return null;
	}

	@Override
	public List<TransferDetails> getAllWithdrawalByUserId(long id) {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transaction_details where  transaction_details.user_id ="+id+" and "
	         				+ " transaction_details.user_id ='withdraw'" );
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
			logger.error("Error on getAllWithdrawalByUserId.");
			logger.error(e);
         }
         return null;
	}


	@Override
	public boolean save(TransferDetails t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TransferDetails t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TransferDetails t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TransferDetails> getAll() {
		List<TransferDetails> transferDetailsList = new ArrayList<TransferDetails>();
		try {
			 statement = connection.getConnection().createStatement();
	         resultSet = statement.executeQuery( "SELECT transaction_ref_id, router_number, from_account,"
	         		+ " to_account, amount, transfer_type, date_time, user_id "
	         		+ "	FROM finance.transaction_details " );
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
			logger.error("Error on get getAllTransactionByUserId.");
			logger.error(e);
         }
         return null;
	}

	@Override
	public Optional<TransferDetails> getRecord(long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void closeStatementAndResultset() throws SQLException {
		if(statement != null && !statement.isClosed())
			statement.close();
		if(resultSet != null && !resultSet.isClosed())
			resultSet.close();
	}

}
