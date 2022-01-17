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
import org.springframework.web.bind.annotation.ResponseBody;

import com.Commandes.Boutique.entities.Paiement;
import com.Commandes.Boutique.services.PaiementService;

import projections.PaiementProjection;

@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping(path = "/api/paiementController")
public class PaiementController {

	@Autowired
	PaiementService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Paiement> savePaiement(@RequestBody Paiement client) {
		ResponseEntity<Paiement> savedPaiement = service.savePaiement(client);
		return savedPaiement;
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Paiement>> getPaiements(){
		ResponseEntity<List<Paiement>> paiements = service.getPaiements();
		return paiements;
	}
	
	@RequestMapping(path = "/{thisid}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Paiement>> getPaiementsWithId(@PathVariable("thisid") long id){
		ResponseEntity<Optional<Paiement>> paiement = service.getPaiementsWithId(id);
		return paiement;
	}

	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
	public void removePaiementWithId(Long id) {
		service.removePaiementWithId(id);
	}
	
	@RequestMapping(path="/paiement/id&amount" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<PaiementProjection>> getPaiementDateAndAmount(){
		return service.getPaimentDateAndAmount();
	}
}
