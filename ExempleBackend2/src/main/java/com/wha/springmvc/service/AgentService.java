package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Client;

public interface AgentService {

	public Agent findById(int id);

	public Agent findByName(String name);

	public boolean isagentExist(Agent agent);

	public void saveAgent(Agent agent);
	
	public List<Client> findClientByIdAgent(int idAg);

	

	
	
}
