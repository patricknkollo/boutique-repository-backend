package com.Commandes.Boutique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientid;
	private String prenom;
	private String nom;
	private String rue;
	private String email;
	private String phone;
	private String ville;
	private int numero;
	private String postCode;
	private String pays;
	public Client(Long clientid, String prenom, String nom, String rue, String email, String phone, String ville,
			int numero, String postCode, String pays) {
		super();
		this.clientid = clientid;
		this.prenom = prenom;
		this.nom = nom;
		this.rue = rue;
		this.email = email;
		this.phone = phone;
		this.ville = ville;
		this.numero = numero;
		this.postCode = postCode;
		this.pays = pays;
	}
	public Client() {
		super();
	}
	public Long getClientid() {
		return clientid;
	}
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", prenom=" + prenom + ", nom=" + nom + ", rue=" + rue + ", email="
				+ email + ", phone=" + phone + ", ville=" + ville + ", numero=" + numero + ", postCode=" + postCode
				+ ", pays=" + pays + "]";
	}
	
	
}
