package com.Commandes.Boutique.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paiement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paiementid;
	private Long numcmdid;
	private Long modeid;
	private Timestamp datepaiement;
	private double montant;
	
	public Paiement(Long paiementid, Long numcmdid, Long modeid, Timestamp datepaiement, double montant) {
		super();
		this.paiementid = paiementid;
		this.numcmdid = numcmdid;
		this.modeid = modeid;
		this.datepaiement = datepaiement;
		this.montant = montant;
	}
	
	public Paiement() {
		super();
	}
	public Long getPaiementid() {
		return paiementid;
	}
	public void setPaiementid(Long paiementid) {
		this.paiementid = paiementid;
	}
	public Long getNumcmdid() {
		return numcmdid;
	}
	public void setNumcmdid(Long numcmdid) {
		this.numcmdid = numcmdid;
	}
	public Long getModeid() {
		return modeid;
	}
	public void setModeid(Long modeid) {
		this.modeid = modeid;
	}
	public Timestamp getDatepaiement() {
		return datepaiement;
	}
	public void setDatepaiement(Timestamp datepaiement) {
		this.datepaiement = datepaiement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "Paiement [paiementid=" + paiementid + ", numcmdid=" + numcmdid + ", modeid=" + modeid
				+ ", datepaiement=" + datepaiement + ", montant=" + montant + "]";
	}

	
}
