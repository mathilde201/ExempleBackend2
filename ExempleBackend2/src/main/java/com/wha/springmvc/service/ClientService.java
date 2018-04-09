package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;


public interface ClientService {

	

	public Client findById(long id);

	

	

	public void saveClient(Client client);


	Client findByName(String name);


	public boolean isClientExist(Client client);





	void updateClient(Client currentClient);

	
}
