package com.wha.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Demande;
import com.wha.springmvc.model.User;
import com.wha.springmvc.service.ClientService;
import com.wha.springmvc.service.UserService;



@RestController
public class ClientRestController {

	

    @Autowired
    ClientService clientService;
	//------------------- Update a client --------------------------------------------------------
    
    @RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
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
 
    




 	//-------------------------------validateRequest ------------------------------------------------

@RequestMapping(value = "/agent/{idAgent}/validation/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Demande> getDemande(@PathVariable("id") long id) {
    System.out.println("Fetching Demande with id " + id);
    Demande demande = DemandeService.findById(id);
    if (demande == null) {
        System.out.println("Demande with id " + id + " not found");
        return new ResponseEntity<Demande>(HttpStatus.NOT_FOUND);
    }
    
    
   
    return new ResponseEntity<Demande>(demande, HttpStatus.OK);
}


//-------------------Create a client--------------------------------------------------------

@RequestMapping(value = "/client/", method = RequestMethod.POST)
public ResponseEntity<Void> createClient(@RequestBody Client client, UriComponentsBuilder ucBuilder) {
    System.out.println("Creating User " + client.getUsername());

    if (clientService.isClientExist(client)) {
        System.out.println("A agent with name " + client.getUsername() + " already exist");
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    clientService.saveClient(client);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/agent/{id}").buildAndExpand(client.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
}


//-------------------Retrieve Single User--------------------------------------------------------
 
@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Client> getAgent(@PathVariable("id") long id) {
    System.out.println("Fetching Agent with id " + id);
    Client client = clientService.findById(id);
    if (client == null) {
        System.out.println("User with id " + id + " not found");
        return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Client>(client, HttpStatus.OK);
}


}
