package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("versement")
public class Versement extends Transaction {

	public Versement() {
		super();
	}

	public Versement(double montant, String libelle, Date date, CompteBanquaire compte) {
		super(montant, libelle, date, compte);

	}
}
