package com.Commandes.Boutique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DetailCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lignecmdid;
	private Long numcmdid;
	private Long produitid;
	private int quantite_sortie;
	private double prix_unitaire_sortie;
	private double prix_vente_total;
	
	public DetailCommande(Long lignecmdid, Long numcmdid, Long produitid, int quantite_sortie,
			double prix_unitaire_sortie, double prix_vente_total) {
		super();
		this.lignecmdid = lignecmdid;
		this.numcmdid = numcmdid;
		this.produitid = produitid;
		this.quantite_sortie = quantite_sortie;
		this.prix_unitaire_sortie = prix_unitaire_sortie;
		this.prix_vente_total = prix_vente_total;
	}

	public DetailCommande() {
		super();
	}

	public Long getLignecmdid() {
		return lignecmdid;
	}

	public void setLignecmdid(Long lignecmdid) {
		this.lignecmdid = lignecmdid;
	}

	public Long getNumcmdid() {
		return numcmdid;
	}

	public void setNumcmdid(Long numcmdid) {
		this.numcmdid = numcmdid;
	}

	public Long getProduitid() {
		return produitid;
	}

	public void setProduitid(Long produitid) {
		this.produitid = produitid;
	}

	public int getQuantite_sortie() {
		return quantite_sortie;
	}

	public void setQuantite_sortie(int quantite_sortie) {
		this.quantite_sortie = quantite_sortie;
	}

	public double getPrix_unitaire_sortie() {
		return prix_unitaire_sortie;
	}

	public void setPrix_unitaire_sortie(double prix_unitaire_sortie) {
		this.prix_unitaire_sortie = prix_unitaire_sortie;
	}

	public double getPrix_vente_total() {
		return prix_vente_total;
	}

	public void setPrix_vente_total(double prix_vente_total) {
		this.prix_vente_total = prix_vente_total;
	}

	@Override
	public String toString() {
		return "DetailCommande [lignecmdid=" + lignecmdid + ", numcmdid=" + numcmdid + ", produitid=" + produitid
				+ ", quantite_sortie=" + quantite_sortie + ", prix_unitaire_sortie=" + prix_unitaire_sortie
				+ ", prix_vente_total=" + prix_vente_total + "]";
	}
	
	
}
