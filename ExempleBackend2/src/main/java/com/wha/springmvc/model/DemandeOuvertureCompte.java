package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("demandeouverturecompte")
public class DemandeOuvertureCompte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "statut")
	private String statut;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDemande;

	@OneToOne
	private Visiteur visiteur;

	@ManyToOne(fetch = FetchType.LAZY)
	private Admin admin;

	public DemandeOuvertureCompte() {
		super();
	}

	public DemandeOuvertureCompte(String statut, Date dateDemande) {
		super();
		this.statut = statut;
		this.dateDemande = dateDemande;
	}

	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

	
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

}
