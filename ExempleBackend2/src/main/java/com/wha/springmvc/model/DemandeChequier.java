package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("demandechequier")
public class DemandeChequier extends Demande {

	public DemandeChequier(Date date, String statut) {
		super(date, statut);
	}

	public DemandeChequier() {
	}

}
