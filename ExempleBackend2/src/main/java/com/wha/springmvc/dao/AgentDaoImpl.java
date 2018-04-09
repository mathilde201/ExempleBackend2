package com.wha.springmvc.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.User;

@Repository("agentDao")
public class AgentDaoImpl extends AbstractDAO<Integer, Agent> implements AgentDAO{

	@Override
	public Agent findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public Agent findByName(String name) {
		System.out.println("Name : " + name);
		try
		{
			//User u = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.username LIKE :name").setParameter("name", name).getSingleResult();
			return (Agent) getEntityManager().createQuery("SELECT ag FROM Agent ag WHERE ag.username LIKE :name").setParameter("name", name).getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	@Override
	public void save(Agent agent) {
		// TODO Auto-generated method stub
		persist(agent);	
	}

	@Override
	public void deleteAgentById(int id) {
		// TODO Auto-generated method stub
		delete((Agent)getByKey(id));
	}

	@Override
	public List<Agent> findAllAgents() {
		// TODO Auto-generated method stub
		return getEntityManager().createQuery("SELECT ag FROM Agent ag ORDER BY ag.username ASC").getResultList();
	}

	@Override
	public void deleteAllAgents() {
		// TODO Auto-generated method stub
		
	}

}
