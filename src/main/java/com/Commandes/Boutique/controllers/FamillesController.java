package com.Commandes.Boutique.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Commandes.Boutique.entities.Famille;
import com.Commandes.Boutique.services.FamilleService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path = "/api/FamillesController")
public class FamillesController {

	@Autowired
	FamilleService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Famille> saveFamilles(@RequestBody Famille famille) {
		ResponseEntity<Famille> savedClient = service.saveFamilles(famille);
		return savedClient;
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Famille>> getFamilles(){
		ResponseEntity<List<Famille>> familles = service.getFamilles();
		return familles;
	}
	
	@RequestMapping(path = "/{thisid}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Famille>> getFamillesWithId(@PathVariable("thisid") long id){
		ResponseEntity<Optional<Famille>> famille = service.getFamillesWithId(id);
		return famille;
	}

	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
	public void removeFamillesWithId(@PathVariable Long id) {
		service.removeFamillesWithId(id);
	}
}
