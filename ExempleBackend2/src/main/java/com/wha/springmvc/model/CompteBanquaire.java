package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

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
@Table(name = "comptebanquaire")
/*
 * ceci est fait deja ici car nous avons une la notion d'heritage et nous
 * precisons a chaque fois que le nom que chaque objet(comptes bancaires
 * SAD,AAD,compteremuneration )prendra au niveau de la base de données . c'est
 * pour cela que nous avons le DiscriminatorColumn(name = "TYPE_ENTITE")
 * 
 * @DiscriminatorValue("cb")
 */

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ENTITE")
@DiscriminatorValue("cb")
public class CompteBanquaire {
	// Def

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/*
	 * ici le mapped generalement est fait juste avant la definition de l'attribut
	 * qu'on veut mapper si nous regardons UML que nous avons fait au debut on
	 * constate que un client peut avoir plusieurs comptes banacaires donc au niveau
	 * de client nous avons une liste de comptes bancaires ou un set selon la
	 * preference .et le one to many sera juste avant la liste de comptes bancaires
	 * dans client
	 * 
	 * @OneToMany(mappedBy = "compteBanquaire", fetch = FetchType.LAZY) private Date
	 * dateCreation;
	 * 
	 * @OneToMany(mappedBy = "compteBanquaire", fetch = FetchType.LAZY) private
	 * double solde;
	 */
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * private Client client;
	 */

	@Column(name = "rib")
	private String rib;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;

	@Column(name = "solde")
	private double solde;

	@OneToMany(mappedBy = "comptebanquaire", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Transaction> transactions;

	public CompteBanquaire() {
	}

	public CompteBanquaire(String rib, Date dateCreation, double solde, List<Transaction> transactions) {
		this.rib = rib;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.transactions = transactions;
	}
	// getet

	public Date getDateCreation() {
		return dateCreation;
	}

	/*
	 * public Client getClient() { return client; }
	 * 
	 * public void setClient(Client client) { this.client = client; }
	 */

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
