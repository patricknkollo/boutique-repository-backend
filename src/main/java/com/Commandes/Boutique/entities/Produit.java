package com.Commandes.Boutique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long produitid;
	private Long familleProduitid;
	private String designation;
	private int stockInventaire;
	private int stockAlerte;
	private double prixDeVente;
	
	public Produit(Long produitid, Long familleProduitid, String designation, int stockInventaire, int stockAlerte,
			double prixDeVente) {
		super();
		this.produitid = produitid;
		this.familleProduitid = familleProduitid;
		this.designation = designation;
		this.stockInventaire = stockInventaire;
		this.stockAlerte = stockAlerte;
		this.prixDeVente = prixDeVente;
	}

	public Produit() {
		super();
	}

	public Long getProduitid() {
		return produitid;
	}

	public void setProduitid(Long produitid) {
		this.produitid = produitid;
	}

	public Long getFamilleProduitid() {
		return familleProduitid;
	}

	public void setFamilleProduitid(Long familleProduitid) {
		this.familleProduitid = familleProduitid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getStockInventaire() {
		return stockInventaire;
	}

	public void setStockInventaire(int stockInventaire) {
		this.stockInventaire = stockInventaire;
	}

	public int getStockAlerte() {
		return stockAlerte;
	}

	public void setStockAlerte(int stockAlerte) {
		this.stockAlerte = stockAlerte;
	}

	public double getPrixDeVente() {
		return prixDeVente;
	}

	public void setPrixDeVente(double prixDeVente) {
		this.prixDeVente = prixDeVente;
	}

	@Override
	public String toString() {
		return "Produit [produitid=" + produitid + ", familleProduitid=" + familleProduitid + ", designation="
				+ designation + ", stockInventaire=" + stockInventaire + ", stockAlerte=" + stockAlerte
				+ ", prixDeVente=" + prixDeVente + "]";
	}
	
}
