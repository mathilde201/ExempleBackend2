package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

public interface ClientDAO {
	Client findById(int id);

	Client findByName(String name);

	void save(Client client);

	void deleteClientById(int id);

	List<Client> findAllClients();

	void deleteAllClients();

}
