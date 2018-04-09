package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("demandedechangementprofil")
public class DemandeChangementProfil extends Demande {

	public DemandeChangementProfil(Date date, String statut) {
		super(date, statut);
	}

	public void DemandeChangementCompte() {
	}

}
