package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// SAD = "sans autorisation de découvert" 
@Entity
@DiscriminatorValue("comptecourantSAD")
public class CompteCoutantSAD extends CompteBanquaire {

	public CompteCoutantSAD() {
		super();
	}

}
