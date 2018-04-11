package com.wha.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBanquaire;
import com.wha.springmvc.service.AgentService;
import com.wha.springmvc.service.ClientService;

@Controller
@RestController
public class AgentRestController {

	@Autowired
	AgentService agentService;
	ClientService clientService;
	// ClientService clientService;

	/**
	 * Cette methode permet d'envoyer la liste des clients rattaché à un agent
	 * 
	 * @param idAg
	 *            : id de l'agent
	 * @return List<Client>
	 * @author wajih
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/agent/{idAgent}/clients", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> searchClient(@PathVariable("idAgent") int idAg) {

		List<Client> clients = new ArrayList<Client>();
		Agent ag = agentService.findById(idAg);
		if (ag == null) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		} else {
			clients = (List<Client>) (Object) ag.getUsers();
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);

	}
	
	//-----------------------------------------------------------------    

	
	
	/**
	 * cette permet afficher un client avec ses details
	 * 
	 * @param :agent
	 * @return List<account>
	 * @author Mathilde
	 * 
	 *//*
	
	
	
    @RequestMapping(value = "/agent/account/{idcpt}/", method = RequestMethod.GET)
    public ResponseEntity<List<CompteBanquaire>> viewDetails(@PathVariable("idAgent") int idAg) {
       
    
        
        List<CompteBanquaire> comptes = new ArrayList<CompteBanquaire>();
		Agent ag = agentService.findById(idAg);
		
		if (ag == null) {
			return new ResponseEntity<List<CompteBanquaire>>(HttpStatus.NO_CONTENT);
		} else {
			comptes = (List<CompteBanquaire>) (Object) ag.getComptes();
		}
		return new ResponseEntity<List<CompteBanquaire>>(comptes, HttpStatus.OK);

	
        
        
   
    }*/
	
//------------------- Update a client --------------------------------------------------------
    
    @RequestMapping(value = "/agent/{idagent}/{idclient}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
        System.out.println("Updating client " + id);
         
        
		Client currentClient = clientService.findById(id);
         
        if (currentClient==null) {
            System.out.println("Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
 
        currentClient.setUsername(client.getUsername());
       // currentClient.setAddress(client.getAddress());
        currentClient.setEmail(client.getEmail());
         
        clientService.updateClient(currentClient);
        return new ResponseEntity<Client>(HttpStatus.OK);
    }
 
}
    

