package com.wha.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.ClientDAO;
import com.wha.springmvc.model.Client;


@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	
	@Autowired
	private ClientDAO clientDao;

	@Override
	public Client findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClientExist(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateClient(Client currentClient) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
