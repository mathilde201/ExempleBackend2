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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "demande")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_DEMANDE")

public class Demande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;*/

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "statut")
	private String statut;

	public Demande(Date date, String statut) {
		this.date = date;
		this.statut = statut;
	}

	public Demande() {
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	

	

}
