package com.wha.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/*@OneToMany( fetch = FetchType.LAZY)
	@JsonIgnore 
	private List<Demande> demandes;
	*/
	
    // un utilisateur est associé a une adresse ie nous devons avoir List<adresse>adresse
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore 
	private List<Adresse> address;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore  
	private List<User> users;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "mdp")
	private String mdp;
	
	@Column(name = "username")
	private String username;
	
	private String email;
	private String numTel;
	private String sexe;

	public User() {
	}

	public User(int id, String nom, String prenom, String sexe, String mdp, String username, String email,
			String numTel) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.mdp = mdp;
		this.username = username;
		this.email = email;
		this.numTel = numTel;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	

	public List<Adresse> getAddress() {
		return address;
	}

	public void setAddress(List<Adresse> address) {
		this.address = address;
	}

	public String getSexe() {
		return sexe;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mdp=" + mdp + ", username=" + username
				+ ", email=" + email + ", numTel=" + numTel + ", sexe=" + sexe + "]";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
