package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.UserDAO;
import com.wha.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO dao;
	
	/*
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}
	 */
	public List<User> findAllUsers()
	{
		return dao.findAllUsers();
	}
	
	public User findByName(String name) {
		return dao.findByName(name);
	}
	
	public void saveUser(User user)
	{
		dao.save(user);
	}

	public void updateUser(User user)
	{
		User entity = dao.findById((int)user.getId());
		if(entity != null)
		{
			entity.setUsername(user.getUsername());
			entity.setAddress(user.getAddress());
			entity.setEmail(user.getEmail());
		}
		dao.save(entity);
	}


	public boolean isUserExist(User user)
	{
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers()
	{
		dao.deleteAllusers();
	}


	@Override
	public User findById(long id)
	{
		
		return dao.findById((int)id);
	}


	@Override
	public void deleteUserById(long id)
	{
		dao.deleteUserById((int)id);		
	}

}
