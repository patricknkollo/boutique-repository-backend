package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.Commandes;
import com.Commandes.Boutique.repositories.CommandesRepository;

import projections.CommandeProjection;
import projections.CommandeProjectionClientAndDate;

@Service
public class CommandesService {

	@Autowired
	CommandesRepository repository;
	
	public ResponseEntity<Commandes> saveCommandes(Commandes commandes) {
		Commandes savedClient = repository.save(commandes);
		return new ResponseEntity<>(savedClient, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Commandes>> getCommandes(){
		List <Commandes> commandes = repository.findAll();
		return commandes != null 
				? new ResponseEntity<>(commandes, HttpStatus.OK) 
						: new  ResponseEntity<List<Commandes>>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Optional<Commandes>> getCommandesWithId(long id){
		Optional<Commandes> Commande = repository.findById(id);
		return Commande != null 
				? new ResponseEntity<>(Commande, HttpStatus.OK) 
						: new ResponseEntity<Optional<Commandes>>(HttpStatus.NO_CONTENT);
	}

	public void removeCommandesWithId(Long id) {
		repository.deleteById(id);
	}
	
	public List<CommandeProjection> getClientAndCmd(){
		return repository.getCommandAndClientIdsFromDB();
	}

	public ResponseEntity<List<CommandeProjectionClientAndDate>> getCmdClientDate(){
		List<CommandeProjectionClientAndDate> commandes = repository.getAllCmdWithClientAndDate();
		ResponseEntity<List<CommandeProjectionClientAndDate>> responseEntity = new ResponseEntity<List<CommandeProjectionClientAndDate>>(commandes, HttpStatus.OK);
		return responseEntity;
	}
}
