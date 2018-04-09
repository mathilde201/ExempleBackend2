package com.wha.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.AgentDAO;
import com.wha.springmvc.dao.ClientDAO;
import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Client;



@Service("agentService")
@Transactional
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentDAO dao;

	public Agent findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	

	@Override
	public boolean isagentExist(Agent agent) {
		// TODO Auto-generated method stub
		return findByName(agent.getUsername())!=null;
	}

	


	@Override
	public void saveAgent(Agent agent) {
		// TODO Auto-generated method stub
		dao.save(agent);
	}



	@Override
	public Agent findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Agent findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
