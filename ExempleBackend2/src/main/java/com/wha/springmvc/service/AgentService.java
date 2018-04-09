package com.wha.springmvc.service;

import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.User;

public interface AgentService {

	public Agent findById(long id);

	public Agent findByName(String name);

	public boolean isagentExist(Agent agent);

	public void saveAgent(Agent agent);

	

	
	
}
