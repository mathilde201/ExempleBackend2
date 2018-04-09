package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Agent;

public interface AgentDAO {
	
	Agent findById(int id);

	Agent findByName(String name);

	void save( Agent agent );

	void deleteAgentById(int id);

	List<Agent> findAllAgents();

	void deleteAllAgents();

}
