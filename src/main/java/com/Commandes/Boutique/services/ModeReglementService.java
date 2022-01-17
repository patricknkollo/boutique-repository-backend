package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.ModeReglement;
import com.Commandes.Boutique.repositories.ModeReglementRepository;

@Service
public class ModeReglementService {

	@Autowired
	ModeReglementRepository repository;
	
	public ResponseEntity<ModeReglement> saveModeReglement(ModeReglement modeReglement) {
		ModeReglement savedModeReglement = repository.save(modeReglement);
		return new ResponseEntity<>(savedModeReglement, HttpStatus.OK);
	}
	
	public ResponseEntity<List<ModeReglement>> getModeReglement(){
		List <ModeReglement> modeReglements = repository.findAll();
		return modeReglements != null 
				? new ResponseEntity<>(modeReglements, HttpStatus.OK) 
						: new  ResponseEntity<List<ModeReglement>>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Optional<ModeReglement>> getModeReglementWithId(long id){
		Optional<ModeReglement> modeOptional = repository.findById(id);
		return modeOptional != null 
				? new ResponseEntity<>(modeOptional, HttpStatus.OK) 
						: new ResponseEntity<Optional<ModeReglement>>(HttpStatus.NO_CONTENT);
	}

	public void removeModeReglementWithId(Long id) {
		repository.deleteById(id);
	}
}
