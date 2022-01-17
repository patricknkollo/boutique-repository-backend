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

import com.Commandes.Boutique.entities.Produit;
import com.Commandes.Boutique.services.ProduitService;

@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping(path = "/api/ProduitController")
public class ProduitCoontroller {

	@Autowired
	ProduitService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Produit> saveProduit(@RequestBody Produit produit) {
		ResponseEntity<Produit> savedProduit = service.saveProduit(produit);
		return savedProduit;
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Produit>> getProduits(){
		ResponseEntity<List<Produit>> produits = service.getProduits();
		return produits;
	}
	
	@RequestMapping(path = "/{thisid}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Produit>> getProduitsWithId(@PathVariable("thisid") long id){
		ResponseEntity<Optional<Produit>> produit = service.getProduitsWithId(id);
		return produit;
	}

	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
	public void removeProduitWithId(@PathVariable("thisid") Long id) {
		service.removeProduitWithId(id);
	}
}
