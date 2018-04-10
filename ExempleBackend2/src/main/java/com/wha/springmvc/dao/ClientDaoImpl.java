package com.wha.springmvc.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

@Repository("clientDao")
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
		return getEntityManager().createQuery("SELECT c FROM Client as c ORDER BY c.username ASC").getResultList();
	}

	@Override
	public void deleteAllClients() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAllAttachedClients(int idAg) {
		List<Client> clients = new ArrayList<Client>();
		clients =  getEntityManager().createQuery("SELECT c FROM Client as c where c.agent.id = :idagent")
		.setParameter("idagent", idAg)
		.getResultList();
		return clients;
		
	}
}