package com.example.payment2.dao;

import java.util.List;

import com.example.payment2.entity.Transaction;

public interface TransactionDao {

	public List<Transaction> getAllTransaction();
		
	public List<Transaction> getIdTransaction(int id);
	
	//public void save(Transaction transaction);
}
