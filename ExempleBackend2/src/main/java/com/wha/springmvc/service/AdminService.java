package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Admin;



public interface AdminService {
	
	Admin findById(long id);
	
	Admin findByName(String name);
	
	void saveAdmin(Admin admin);
	
	void updateAdmin(Admin admin);
	
	void deleteAdminById(long id);

	List<Admin> findAllAdmins(); 
	
	void deleteAllAdmins();
	
	public boolean isUserExist(Admin admin);
	
}
