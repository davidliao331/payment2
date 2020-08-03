package com.example.payment2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment2.entity.Transaction;
import com.example.payment2.entity.User;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Transaction> getAllTransaction() {
		Session currentSession = entityManager.unwrap(Session.class);

		List<Transaction> res = new ArrayList<>();
		Query<Transaction> theQuery = currentSession.createQuery("from Transaction", Transaction.class);
		res = theQuery.getResultList();
		
		return res;
	}


	@Override
	public List<Transaction> getIdTransaction(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println("hi");
		List<Transaction> res = new ArrayList<>();
		Query<Transaction> theQuery = currentSession.createQuery("from Transaction where userId=:uId", Transaction.class);
		theQuery.setParameter("uId", id);
		res = theQuery.getResultList();

		return res;
	}

}
