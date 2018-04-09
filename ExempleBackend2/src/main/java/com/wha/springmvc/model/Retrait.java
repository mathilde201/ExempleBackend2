package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("retrait")
public class Retrait extends Transaction {

	public Retrait() {
		super();
	}

	public Retrait(double montant, String libelle, Date date, CompteBanquaire compte) {
		super(montant, libelle, date, compte);
	}

}
