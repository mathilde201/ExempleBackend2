package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("agent")
public class Agent extends User {

	@Column(name = "matricule")
	private String matricule;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebutContat;

	@OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
	private List<Client> clients;

	@ManyToOne(fetch = FetchType.LAZY)
	private Admin admin;

	// cstr
	public Agent(int id, String nom, String prenom, String sexe, String mdp, String username, String email,
			String numTel, String matricule, Date dateDebutContat) {
		super(id, nom, prenom, sexe, mdp, username, email, numTel);
		this.matricule = matricule;
		this.dateDebutContat = dateDebutContat;
	}

	public Agent(String matricule, Date dateDebutContat) {
		super();
		this.matricule = matricule;
		this.dateDebutContat = dateDebutContat;
	}

	// getset
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Date getDateDebutContat() {
		return dateDebutContat;
	}

	public void setDateDebutContat(Date dateDebutContat) {
		this.dateDebutContat = dateDebutContat;
	}

}
