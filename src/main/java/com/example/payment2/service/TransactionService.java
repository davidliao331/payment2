package com.example.payment2.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.payment2.entity.Transaction;

public interface TransactionService {
	public List<Transaction> getAllTransaction();
	
	public List<Transaction> getIdTransaction(int UserId);
	
	public List<Transaction> getUserDateTransaction(int userId, LocalDateTime date, int days);
	
	public List<Transaction> getDateTransaction(LocalDateTime date, int days);
}
