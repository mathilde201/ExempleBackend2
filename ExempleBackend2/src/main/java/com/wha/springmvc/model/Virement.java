package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("virement")
public class Virement extends Transaction {
	
	@Column(name="numeroCompte")
	private String numeroCompte;

	public Virement() {
		super();

	}

	public Virement(double montant, String libelle, Date date, CompteBanquaire comptebanquaire, String numeroCompte) {
		super(montant, libelle, date, comptebanquaire);
		this.numeroCompte = numeroCompte;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	// getset

}
