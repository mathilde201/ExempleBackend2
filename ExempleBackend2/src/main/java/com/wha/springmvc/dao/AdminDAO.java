package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Admin;


public interface  AdminDAO {
	
	Admin findById(int id);

	Admin findByName(String name);

	void save( Admin admin );

	void deleteAdminById(int id);

	List<Admin> findAllAdmins();

	void deleteAllAdmins();

}
