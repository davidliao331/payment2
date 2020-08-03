package com.example.payment2.dao;

import java.util.List;

import com.example.payment2.entity.User;

public interface UserDao {
	
	public List<User> getAllUser();
	
	public User findByUserName(String userName);
	
	public void save(User user);

	public User findByUserId(int userId);

	public void deleteUser(int userId);
	
}
