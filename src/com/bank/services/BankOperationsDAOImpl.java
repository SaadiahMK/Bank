package com.bank.services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.bank.configuration.DatabaseConnection;
import com.bank.main.Execution;
import com.bank.models.Bank;

public class BankOperationsDAOImpl implements OperationsDAO<Bank> {

	DatabaseConnection connection = DatabaseConnection.getInstance();
	Statement statement = null;
	ResultSet resultSet = null; 
	
	private static final Logger logger = Logger.getLogger(BankOperationsDAOImpl.class);  
		
	@Override
	public boolean save(Bank t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bank t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Bank t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Bank> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Bank> getRecord(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
