package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transaction")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ENTITE")
@DiscriminatorValue("transaction")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "montant")
	private double montant;

	@Column(name = "libelle")
	private String libelle;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY)
	private CompteBanquaire comptebanquaire;

	public Transaction(double montant, String libelle, Date date, CompteBanquaire comptebanquaire) {
		super();
		this.montant = montant;
		this.libelle = libelle;
		this.date = date;
		this.comptebanquaire = comptebanquaire;
	}

	public Transaction() {
		super();
	}

	// getset

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public CompteBanquaire getComptebanquaire() {
		return comptebanquaire;
	}

	public void setComptebanquaire(CompteBanquaire comptebanquaire) {
		this.comptebanquaire = comptebanquaire;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompteBanquaire getCompte() {
		return comptebanquaire;
	}

	public void setCompte(CompteBanquaire compte) {
		this.comptebanquaire = compte;
	}

}
