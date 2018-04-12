package com.wha.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {

	@Column(name = "matricule")
	private String matricule;

	//@OneToMany
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<DemandeOuvertureCompte> ouverturecomptes;

	/*@OneToMany
	@JoinColumn(name = "idAdmin")
	private List<Agent> agents;*/
	
	public Admin() {
		super();
		
	}

	// cstr
	public Admin(int id, String nom, String prenom, String sexe, String mdp, String username, String email,
			String numTel, String matricule) {
		super(id, nom, prenom, sexe, mdp, username, email, numTel);
		this.matricule = matricule;
	}
	
	public Admin(String matricule) {
		super();
		this.matricule = matricule;
	}

	// getset
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public List<DemandeOuvertureCompte> getOuverturecomptes() {
		return ouverturecomptes;
	}

	public void setOuverturecomptes(List<DemandeOuvertureCompte> ouverturecomptes) {
		this.ouverturecomptes = ouverturecomptes;
	}

	/*public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}*/

	

}
