package com.wha.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

//import com.wha.springmvc.model.User;
import com.wha.springmvc.model.Visiteur;
import com.wha.springmvc.service.VisiteurService;

@RestController
public class VisiteurController
{
@Autowired
	VisiteurService visiteurService;

    /**
     * List all the visitors
     * @param none
     * @return List<Visiteur>
     * @author Alex
     */
  //-------------------------- Display all visitors --------------------------//
    
    @RequestMapping(value = "/visiteur", method = RequestMethod.GET)
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Visiteur>>listAllVisiteurs()
    {
        List<Visiteur> visiteurs = visiteurService.findAllVisiteurs();
        return new ResponseEntity<List<Visiteur>>(visiteurs, HttpStatus.OK);
    }
    
	//ne marche pas encore
//-------------------------- Create visitor --------------------------//
/**
 *  Creation of a visitor
 *  No existance check yet
 * @param visiteur
 * @param ucBuilder
 * @return
 * @author Alex
 */
    /*
@RequestMapping(value = "/visiteur", method = RequestMethod.POST)
//@CrossOrigin(origins = "http://localhost:4200")
public ResponseEntity<Void> createVisiteur(@RequestBody Visiteur visiteur, UriComponentsBuilder ucBuilder)
{
    System.out.println("Creating User " + visiteur.getPrenom());
    
    if (VisiteurService.isUserExist(visiteur))
    {
        System.out.println("A User with name " + user.getUsername() + " already exist");
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
    
    visiteur = new Visiteur();
    visiteurService.save(visiteur);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/visiteur/{id}").buildAndExpand(visiteur.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
}
*/
    
    
}
