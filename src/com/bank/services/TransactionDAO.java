package com.bank.services;

import java.util.List;
import java.util.Optional;

public interface TransactionDAO<T> {
	
	public  List<T> getAllTransactionByUserId(long id);
	
	public  List<T> getAllDebitTransactionByUserId(long id);
	
	public  List<T> getAllWithdrawalByUserId(long id);
	
	public Optional<T> getAccountDetail(long id);
	
	
	
	
}
