package com.bank.services;

import java.util.List;

public interface TransactionDAO<T> {
	
	public  List<T> getAllTransactionByUserId(long id);
	
	public  List<T> getAllDebitTransactionByUserId(long id);
	
	public  List<T> getAllWithdrawalByUserId(long id);
	
}
