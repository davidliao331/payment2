package com.example.payment2.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.example.payment2.dao.TransactionDao;
import com.example.payment2.entity.Transaction;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	@Transactional
	public List<Transaction> getAllTransaction() {
		return transactionDao.getAllTransaction();
	}

	@Override
	@Transactional
	public List<Transaction> getIdTransaction(int UserId) {
		return transactionDao.getIdTransaction(UserId);
	}

	@Override
	@Transactional
	public List<Transaction> getUserDateTransaction(int userId, LocalDateTime date, int days) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Transaction> getDateTransaction(LocalDateTime date, int days) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	@Autowired
    ApplicationContext appContext;
	
	private List<Transaction> transactionList = new ArrayList<>();
	private ObjectMapper mapper = new ObjectMapper();
	private Transaction[] transactions;
	public void init() {
		transactionList = new ArrayList<>();
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		
		try {
			File userFile = appContext.getResource("classpath:data/transaction.json").getFile();
			transactions = mapper.readValue( userFile, Transaction[].class);
			transactionList = Arrays.asList(transactions);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Transaction> getAllTransaction() {
		init();
		return transactionList;
	}

	@Override
	public List<Transaction> getIdTransaction(int UserId) {
		init();
		List<Transaction> res = transactionList.stream()
													.filter(t -> t.getUserId() == UserId)
													.collect(Collectors.toList());
		return res;
	}
	
	@Override
	public List<Transaction> getUserDateTransaction(int userId, LocalDateTime startDate, int days) {
		init();
		
		LocalDateTime endDate = startDate.plusDays(days);
		List<Transaction> res = transactionList.stream()
											   .filter(t -> t.getUserId() == userId
											   			 && t.getCreatedTime().isAfter(startDate)
												         && t.getCreatedTime().isBefore(endDate))
											   .collect(Collectors.toList());
		return res;
	}
	
	@Override
	public List<Transaction> getDateTransaction(LocalDateTime startDate, int days) {
		init();
		LocalDateTime endDate = startDate.plusDays(days);
		List<Transaction> res = transactionList.stream()
											   .filter(t -> t.getCreatedTime().isAfter(startDate)
													     && t.getCreatedTime().isBefore(endDate))
											   .collect(Collectors.toList());
		return res;
	}
	*/
}
