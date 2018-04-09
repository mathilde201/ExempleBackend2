package com.wha.springmvc.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("compteRemuneration")
public class CompteRemunerateur extends CompteBanquaire {

	@Column(name = "tauxInteretAnnuel")
	private double tauxInteretAnnuel;

	public CompteRemunerateur() {
		super();
	}

	public CompteRemunerateur(double tauxInteretAnnuel) {
		super();
		this.tauxInteretAnnuel = tauxInteretAnnuel;
	}

	// getset
	public double getTauxInteretAnnuel() {
		return tauxInteretAnnuel;
	}

	public void setTauxInteretAnnuel(double tauxInteretAnnuel) {
		this.tauxInteretAnnuel = tauxInteretAnnuel;
	}

}
