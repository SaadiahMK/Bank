package com.bank.services;

import java.util.List;

import java.util.Optional;

import com.bank.models.TransferDetails;

public class TransferDetailsDAOImpl implements OperationsDAO<TransferDetails>, TransactionDAO<TransferDetails> {

	@Override
	public List<TransferDetails> getAllTransactionByUserId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferDetails> getAllDebitTransactionByUserId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferDetails> getAllWithdrawalByUserId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TransferDetails> getAccountDetail(long id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TransferDetails> getRecord(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
