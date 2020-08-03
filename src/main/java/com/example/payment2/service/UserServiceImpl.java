package com.example.payment2.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.payment2.dao.RoleDao;
import com.example.payment2.dao.UserDao;
import com.example.payment2.entity.Role;
import com.example.payment2.entity.User;
import com.example.payment2.user.CrmUser;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());

		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));
		user.setCreatedTime(LocalDateTime.now());
		 // save user in the database
		userDao.save(user);
		
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDao.findByUserId(userId);
	}

	@Override
	@Transactional
	public void saveUpdate(CrmUser theCrmUser) {
		User user = userDao.findByUserName(theCrmUser.getUserName());
		user.setPassword(passwordEncoder.encode(theCrmUser.getPassword()));
		user.setEmail(theCrmUser.getEmail());
		
		userDao.save(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}
	
}
