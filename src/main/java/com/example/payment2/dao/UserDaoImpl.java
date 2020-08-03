package com.example.payment2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment2.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> getAllUser() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		List<User> res = new ArrayList<>();
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		res = theQuery.getResultList();
		
		return res;
	}

	@Override
	public User findByUserName(String userName) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		
		theQuery.setParameter("uName", userName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public User findByUserId(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("from User where id=:uId", User.class);
		
		theQuery.setParameter("uId", userId);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void deleteUser(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from User where id=:uId"); 
		theQuery.setParameter("uId", userId);
		theQuery.executeUpdate();		
	}

    
	
}
