package com.example.payment2.service;

import java.util.List;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.payment2.entity.User;
import com.example.payment2.user.CrmUser;

public interface UserService extends UserDetailsService{
	
	public List<User> getAllUser();
	
	public User findByUserName(String userName);
	
	public void save(CrmUser crmUser);
	//public User getIdUser(int id);

	public User getUser(int userId);

	public void saveUpdate(CrmUser theCrmUser);

	public void deleteUser(int userId);
}
