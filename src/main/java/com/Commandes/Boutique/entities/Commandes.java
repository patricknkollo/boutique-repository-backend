package com.Commandes.Boutique.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commandes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCMDid;
	
	private Long clientid;
	private Timestamp datecmd;
	private String etatcmd;
	public Commandes(Long numCMDid, Long clientid, Timestamp datecmd, String etatcmd) {
		super();
		this.numCMDid = numCMDid;
		this.clientid = clientid;
		this.datecmd = datecmd;
		this.etatcmd = etatcmd;
	}
	public Commandes() {
		super();
	}
	public Long getNumCMDid() {
		return numCMDid;
	}
	public void setNumCMDid(Long numCMDid) {
		this.numCMDid = numCMDid;
	}
	public Long getCliendid() {
		return clientid;
	}
	public void setCliendid(Long cliendid) {
		this.clientid = cliendid;
	}
	public Timestamp getDatecmd() {
		return datecmd;
	}
	public void setDatecmd(Timestamp datecmd) {
		this.datecmd = datecmd;
	}
	public String getEtatcmd() {
		return etatcmd;
	}
	public void setEtatcmd(String etatcmd) {
		this.etatcmd = etatcmd;
	}
	@Override
	public String toString() {
		return "Commandes [numCMDid=" + numCMDid + ", cliendid=" + clientid + ", datecmd=" + datecmd + ", etatcmd="
				+ etatcmd + "]";
	}
	
	
}
