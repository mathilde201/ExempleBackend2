package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("demandenotification")
public class DemandeNotification extends Demande {
	public DemandeNotification(Date date, String statut) {
		super(date, statut);

	}

	public DemandeNotification() {

	}
}
