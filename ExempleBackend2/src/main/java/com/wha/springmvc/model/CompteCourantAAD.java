package com.wha.springmvc.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// AAD = "avec autorisation de découvert"
@Entity
@DiscriminatorValue("comptebancaire")
public class CompteCourantAAD extends CompteBanquaire

{

	@Column(name = "montantDecouvert")
	private double montantDecouvert;

	// cstr
	public CompteCourantAAD() {
		super();
	}

	public CompteCourantAAD(double montantDecouvert) {
		super();
		this.montantDecouvert = montantDecouvert;
	}

	// getset
	public double getMontantDecouvert() {
		return montantDecouvert;
	}

	public void setMontantDecouvert(double montantDecouvert) {
		this.montantDecouvert = montantDecouvert;
	}

}
