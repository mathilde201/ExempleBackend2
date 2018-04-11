package com.wha.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("client")
public class Client extends User {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "nbEnfant")
	private int nbEnfant;

	@Column(name = "matrimonial")
	private String matrimonial;
	
	@Column (name="cb")
	private String Comptebanquaire;

	//@ManyToOne(fetch = FetchType.LAZY)
	//private Agent agent;

	@OneToMany
	@JsonIgnore 
	private List<CompteBanquaire> comptes;

	// cstr
	public Client(int id, String nom, String prenom, String sexe, String mdp, String username, String email,
			String numTel, int nbEnfant, String matrimonial, List<CompteBanquaire> comptes) {

		super(id, nom, prenom, sexe, mdp, username, email, numTel);
		this.nbEnfant = nbEnfant;
		this.matrimonial = matrimonial;
		this.comptes = comptes;

	}

	public Client(int nbEnfant, String matrimonial, List<CompteBanquaire> comptes) {
		super();
		this.nbEnfant = nbEnfant;
		this.matrimonial = matrimonial;
		this.comptes = comptes;
	}

	public String getCompteBanquaire() {
		return Comptebanquaire;
	}

	public void setCompteBanquaire(String compteBanquaire) {
		Comptebanquaire = compteBanquaire;
	}

	// getset
	public int getNbEnfant() {
		return nbEnfant;
	}

	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	public String getMatrimonial() {
		return matrimonial;
	}

	public void setMatrimonial(String matrimonial) {
		this.matrimonial = matrimonial;
	}

	/*public Agent getAgent() {
		return agent;
	}
	

	public void setAgent(Agent agent) {
		this.agent = agent;
	}*/

	public List<CompteBanquaire> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteBanquaire> comptes) {
		this.comptes = comptes;
	}

}
