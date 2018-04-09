package com.wha.springmvc.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.wha.springmvc.model.Admin;
import com.wha.springmvc.model.User;


public class AdminDaoImpl extends AbstractDAO<Integer, Admin> implements AdminDAO {

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public Admin findByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Name : " + name);
		try
		{
			//User u = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.username LIKE :name").setParameter("name", name).getSingleResult();
			return (Admin) getEntityManager().createQuery("SELECT a FROM Admin a WHERE a.username LIKE :name").setParameter("name", name).getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		persist(admin);	
	}

	@Override
	public void deleteAdminById(int id) {
		// TODO Auto-generated method stub
		delete((Admin)getByKey(id));
	}

	@Override
	public List<Admin> findAllAdmins() {
		// TODO Auto-generated method stub
		return getEntityManager().createQuery("SELECT a FROM Admin a ORDER BY a.username ASC").getResultList();
	}

	@Override
	public void deleteAllAdmins() {
		// TODO Auto-generated method stub
		
	}

}
