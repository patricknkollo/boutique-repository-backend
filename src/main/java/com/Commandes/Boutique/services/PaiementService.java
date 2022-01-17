package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.Paiement;
import com.Commandes.Boutique.repositories.PaiementRepository;

import projections.PaiementProjection;

@Service
public class PaiementService {

	@Autowired
	PaiementRepository repository;
	
	public ResponseEntity<Paiement> savePaiement(Paiement client) {
		Paiement savedPaiement = repository.save(client);
		return new ResponseEntity<>(savedPaiement, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Paiement>> getPaiements(){
		List <Paiement> paiements = repository.findAll();
		return paiements != null 
				? new ResponseEntity<>(paiements, HttpStatus.OK) 
						: new  ResponseEntity<List<Paiement>>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Optional<Paiement>> getPaiementsWithId(long id){
		Optional<Paiement> paiement = repository.findById(id);
		return paiement != null 
				? new ResponseEntity<>(paiement, HttpStatus.OK) 
						: new ResponseEntity<Optional<Paiement>>(HttpStatus.NO_CONTENT);
	}

	public void removePaiementWithId(Long id) {
		repository.deleteById(id);
	}
	
	public ResponseEntity<List<PaiementProjection>> getPaimentDateAndAmount(){
		
		List<PaiementProjection> res = repository.getPaiementIdDateMontant();
		
		return res != null
				? new ResponseEntity<List<PaiementProjection>>(res, HttpStatus.OK)
						: new ResponseEntity<List<PaiementProjection>>(res, HttpStatus.NO_CONTENT);
	}
}
