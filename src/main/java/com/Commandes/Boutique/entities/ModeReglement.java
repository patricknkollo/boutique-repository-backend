package com.Commandes.Boutique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModeReglement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long modeid;
	private String description;
	
	public ModeReglement(Long modeid, String description) {
		super();
		this.modeid = modeid;
		this.description = description;
	}

	public ModeReglement() {
		super();
	}

	public Long getModeid() {
		return modeid;
	}

	public void setModeid(Long modeid) {
		this.modeid = modeid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ModeReglement [modeid=" + modeid + ", description=" + description + "]";
	}
	
	
}
