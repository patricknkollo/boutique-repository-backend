package com.Commandes.Boutique.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DetailsProduits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detailProduitid;
	private Long  produitid;
	private Timestamp dateEntree;
	private int qte_entree;
	private int qte_sortie;
	
	public DetailsProduits(Long detailProduitid, Long produitid, Timestamp dateEntree, int qte_entree, int qte_sortie) {
		super();
		this.detailProduitid = detailProduitid;
		this.produitid = produitid;
		this.dateEntree = dateEntree;
		this.qte_entree = qte_entree;
		this.qte_sortie = qte_sortie;
	}

	public DetailsProduits() {
		super();
	}

	public Long getDetailProduitid() {
		return detailProduitid;
	}

	public void setDetailProduitid(Long detailProduitid) {
		this.detailProduitid = detailProduitid;
	}

	public Long getProduitid() {
		return produitid;
	}

	public void setProduitid(Long produitid) {
		this.produitid = produitid;
	}

	public Timestamp getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Timestamp dateEntree) {
		this.dateEntree = dateEntree;
	}

	public int getQte_entree() {
		return qte_entree;
	}

	public void setQte_entree(int qte_entree) {
		this.qte_entree = qte_entree;
	}

	public int getQte_sortie() {
		return qte_sortie;
	}

	public void setQte_sortie(int qte_sortie) {
		this.qte_sortie = qte_sortie;
	}

	@Override
	public String toString() {
		return "DetailsProduits [detailProduitid=" + detailProduitid + ", produitid=" + produitid + ", dateEntree="
				+ dateEntree + ", qte_entree=" + qte_entree + ", qte_sortie=" + qte_sortie + "]";
	}

	
	
}
