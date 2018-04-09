package com.wha.springmvc.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("adresse")
public class Adresse {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "numRue")
	private int numRue;

	@Column(name = "rue")
	private String rue;

	@Column(name = "codePostale")
	private String codePostal;

	@Column(name = "ville")
	private String ville;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	// getset
	public int getNumRue() {
		return numRue;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	// cstr
	public Adresse() {
		super();
	}

	public Adresse(int noRue, String rue, String codePostal, String ville) {
		super();
		this.numRue = noRue;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

}
