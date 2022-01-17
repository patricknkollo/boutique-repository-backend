package com.Commandes.Boutique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long familleProduitid;
	private String intitule;
	
	public Famille(Long familleProduitid, String intitule) {
		super();
		this.familleProduitid = familleProduitid;
		this.intitule = intitule;
	}

	public Famille() {
		super();
	}

	public Long getFamilleProduitid() {
		return familleProduitid;
	}

	public void setFamilleProduitid(Long familleProduitid) {
		this.familleProduitid = familleProduitid;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Override
	public String toString() {
		return "Familles [familleProduitid=" + familleProduitid + ", intitule=" + intitule + "]";
	}
	
	
	
}
