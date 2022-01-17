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

import com.Commandes.Boutique.entities.DetailsProduits;
import com.Commandes.Boutique.services.DetailsProduitService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path = "/api/detailsProduitController")
public class DetailsProduitController {

	@Autowired
	DetailsProduitService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<DetailsProduits> saveDetailProduit(@RequestBody DetailsProduits detailProduit) {
		ResponseEntity<DetailsProduits> savedDetailProduit = service.saveDetailProduit(detailProduit);
		return savedDetailProduit;
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<DetailsProduits>> getDetailProduit(){
		ResponseEntity<List<DetailsProduits>> detailsProduits = service.getDetailProduit();
		return detailsProduits;
	}
	
	@RequestMapping(path = "/{thisid}", method = RequestMethod.GET)
	public ResponseEntity<Optional<DetailsProduits>> getDetailProduitWithId(@PathVariable("thisid") long id){
		ResponseEntity<Optional<DetailsProduits>> detailProduit = service.getDetailProduitWithId(id);
		return detailProduit;
	}

	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.POST)
	public void removeDetailsProduitsWithId(@PathVariable("thisid") Long id) {
		service.removeDetailsProduitsWithId(id);
	}
}
