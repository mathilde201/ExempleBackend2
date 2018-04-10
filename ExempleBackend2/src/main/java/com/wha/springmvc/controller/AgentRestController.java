package com.wha.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;
import com.wha.springmvc.service.AgentService;

@RestController
public class AgentRestController {

	@Autowired
	AgentService agentService;
	//ClientService clientService;
	
	/**
	 * Cette methode permet d'envoyer la liste des clients rattaché à un agent 
	 * @param idAg : id de l'agent
	 * @return List<Client>
	 * @author wajih
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/agent/{idAgent}/clients", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> searchClient(@PathVariable("idAgent") int idAg) {

		List<Client> clients = new ArrayList<Client>();
		Agent ag = agentService.findById(idAg);
		if(ag == null){
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
        }else {
        	clients =  (List<Client>)(Object) ag.getUsers();
        }
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}
	/*
	 * //------------------update client
	 * ------------------------------------------------
	 * 
	 * @RequestMapping(value = "/agent/{idAgent}/updateClient/{idClient}", method =
	 * RequestMethod.PUT) public ResponseEntity<Void>
	 * updateClient(@PathVariable("id") int id, @RequestBody Client client,
	 * UriComponentsBuilder ucBuilder) { System.out.println("Create client " +
	 * client + "associate to  " + id);
	 * 
	 * Agent currentCons = AgentService.findById(id);
	 * 
	 * 
	 * 
	 * 
	 * if (clientService.isClientExist(client)) {
	 * System.out.println("A Client with name " + client.getUsername() +
	 * " already exist"); return new ResponseEntity<Void>(HttpStatus.CONFLICT); }
	 * 
	 * client.setAgent(currentCons);
	 * 
	 * 
	 * clientService.saveClient(client); HttpHeaders headers = new HttpHeaders();
	 * headers.setLocation(ucBuilder.path("/agent/{id}").buildAndExpand(client.getId
	 * ()).toUri()); return new ResponseEntity<Void>(headers, HttpStatus.CREATED); }
	 */

	// ------------------- Update client
	// --------------------------------------------------------

	/*@RequestMapping(value = "/agent/{idAgent}/client/{idClient}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateClient(@PathVariable("idAgent") Long idAgent,
			@PathVariable("idClient") Long idClient, @RequestBody Client client) {
		System.out.println("Updating Client " + idClient);

		Client currentcli = clientService.findById(idClient);
		Agent currentagent = agentService.findById(idAgent.intValue());

		if (currentcli == null || currentagent == null) {
			System.out.println("Client with id " + idClient + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		client.setId(currentcli.getId());
		currentcli.setAgent(currentagent);
		clientService.updateClient(currentcli);
		return new ResponseEntity<Client>(currentcli, HttpStatus.OK);
	}*/

	/*
	 * //-------------------------------validateRequest
	 * ------------------------------------------------
	 * 
	 * @RequestMapping(value = "/agent/{idAgent}/validation/", method =
	 * RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<Demande> getDemande(@PathVariable("id") long id) {
	 * System.out.println("Fetching Demande with id " + id); Demande demande =
	 * DemandeService.findById(id); if (demande == null) {
	 * System.out.println("Demande with id " + id + " not found"); return new
	 * ResponseEntity<Demande>(HttpStatus.NOT_FOUND); }
	 * 
	 * 
	 * 
	 * return new ResponseEntity<Demande>(demande, HttpStatus.OK); }
	 * 
	 * 
	 * //-------------------Create a
	 * agent--------------------------------------------------------
	 * 
	 * @RequestMapping(value = "/agent/", method = RequestMethod.POST) public
	 * ResponseEntity<Void> createAgent(@RequestBody Agent agent,
	 * UriComponentsBuilder ucBuilder) { System.out.println("Creating User " +
	 * agent.getUsername());
	 * 
	 * if (agentService.isagentExist(agent)) {
	 * System.out.println("A agent with name " + agent.getUsername() +
	 * " already exist"); return new ResponseEntity<Void>(HttpStatus.CONFLICT); }
	 * 
	 * 
	 * 
	 * agentService.saveAgent(agent);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setLocation(ucBuilder.path("/agent/{id}").buildAndExpand(agent.getId(
	 * )).toUri()); return new ResponseEntity<Void>(headers, HttpStatus.CREATED); }
	 * 
	 * 
	 * //-------------------Retrieve Single
	 * User--------------------------------------------------------
	 * 
	 * @RequestMapping(value = "/agent/{id}", method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Agent>
	 * getAgent(@PathVariable("id") long id) {
	 * System.out.println("Fetching Agent with id " + id); Agent agent =
	 * agentService.findById(id); if (agent == null) {
	 * System.out.println("User with id " + id + " not found"); return new
	 * ResponseEntity<Agent>(HttpStatus.NOT_FOUND); } return new
	 * ResponseEntity<Agent>(agent, HttpStatus.OK); }
	 * 
	 */

}
