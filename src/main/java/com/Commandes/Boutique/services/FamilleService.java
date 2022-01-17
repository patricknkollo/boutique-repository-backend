package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.Famille;
import com.Commandes.Boutique.repositories.FamilleRepository;

@Service
public class FamilleService {

	@Autowired
	FamilleRepository repository;
	
	public ResponseEntity<Famille> saveFamilles(Famille famille) {
		Famille savedClient = repository.save(famille);
		return new ResponseEntity<>(savedClient, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Famille>> getFamilles(){
		List <Famille> familles = repository.findAll();
		return familles != null 
				? new ResponseEntity<>(familles, HttpStatus.OK) 
						: new  ResponseEntity<List<Famille>>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Optional<Famille>> getFamillesWithId(long id){
		Optional<Famille> famille = repository.findById(id);
		return famille != null 
				? new ResponseEntity<>(famille, HttpStatus.OK) 
						: new ResponseEntity<Optional<Famille>>(HttpStatus.NO_CONTENT);
	}

	public void removeFamillesWithId(Long id) {
		repository.deleteById(id);
	}
}
