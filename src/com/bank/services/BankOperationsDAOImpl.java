package com.bank.services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import com.bank.configuration.DatabaseConnection;
import com.bank.models.Bank;

public class BankOperationsDAOImpl implements OperationsDAO<Bank> {

	DatabaseConnection connection = DatabaseConnection.getInstance();
	Statement statement = null;
	ResultSet resultSet = null; 
	
	private static final Logger logger = Logger.getLogger(BankOperationsDAOImpl.class);  
		
	@Override
	public boolean save(Bank bank) {
		try {
			 statement = connection.getConnection().createStatement();
			 String sql = "INSERT INTO finance.bank( "
			 		+ "	router_number, name, address ) VALUES "
			 		+ " ("+bank.getRouterNumber()+", '"+bank.getName()+"', '"+bank.getAddress()+"') " ;
			 statement.executeUpdate(sql);
			 
			 logger.info("Created bank.");
		} catch (Exception e) {
			logger.error("Error on creating bank.");
			logger.error(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Bank bank) {
		try {
			 statement = connection.getConnection().createStatement();
			 String sql = " UPDATE finance.bank SET "
			 		+ "  name='"+bank.getName()+"', address='"+bank.getAddress()+"'  WHERE bank.router_number = '"+bank.getRouterNumber()+"' ";
			 statement.executeUpdate(sql);
			 
			 logger.info("Updated bank.");
		} catch (Exception e) {
			logger.error("Error on updating bank.");
			logger.error(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Bank bank) {
		try {
			 statement = connection.getConnection().createStatement();
			 String sql = " DELETE FROM finance.bank WHERE bank.router_number = '"+bank.getRouterNumber()+"' ";
			 		statement.executeUpdate(sql);
			 
			 logger.info("Updated bank.");
		} catch (Exception e) {
			logger.error("Error on updating bank.");
			logger.error(e);
			return false;
		}
		return true;
	}

	@Override
	public List<Bank> getAll() {
		//SELECT router_number, name, address FROM finance.bank;
		List<Bank> bankList = new ArrayList<Bank>();
		try {
			 statement = connection.getConnection().createStatement();
			 resultSet = statement.executeQuery( "SELECT router_number, name, address FROM finance.bank");
			 while ( resultSet.next() ) {
				 Bank bank = new Bank(resultSet.getString("name"), 
						 resultSet.getString("address"), resultSet.getLong("router_number"));
				 
				 bankList.add(bank);
			 }
		} catch (Exception e) {
			logger.error("Error on getAll.");
			logger.error(e);
			return null;
		}
		return bankList;
	}

	@Override
	public Optional<Bank> getRecord(long routerNumber) {
		Bank bank = null;
		try {
			 statement = connection.getConnection().createStatement();
			 resultSet = statement.executeQuery( "SELECT router_number, name, address FROM finance.bank "
			 		+ " where bank.router_number = "+routerNumber);
			 while ( resultSet.next() ) {
				 bank = new Bank(resultSet.getString("name"), 
						 resultSet.getString("address"), resultSet.getLong("router_number"));
				 
			 }
		} catch (Exception e) {
			logger.error("Error on getRecord.");
			logger.error(e);
			return null;
		}
		return Optional.of(bank);
	}

}
