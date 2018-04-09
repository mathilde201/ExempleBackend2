package com.wha.springmvc.dao;


import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;


public class ClientDaoImpl extends AbstractDAO<Integer, Client> implements ClientDAO{

	@Override
	public Client findById(int id) {
		{
			//User u = getByKey(id);
			return getByKey(id);
		}
	}

	@Override
	public Client findByName(String name) {
		System.out.println("Name : " + name);
		try
		{
			//User u = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.username LIKE :name").setParameter("name", name).getSingleResult();
			return (Client) getEntityManager().createQuery("SELECT c FROM Client c WHERE c.username LIKE :name").setParameter("name", name).getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		persist(client);	
	}

	@Override
	public void deleteClientById(int id) {
		// TODO Auto-generated method stub
		delete((Client)getByKey(id));
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return getEntityManager().createQuery("SELECT c FROM Client c ORDER BY c.username ASC").getResultList();
	}

	@Override
	public void deleteAllClients() {
		// TODO Auto-generated method stub
		
	}
}