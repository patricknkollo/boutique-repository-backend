package com.Commandes.Boutique.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.Commandes.Boutique.entities.DetailCommande;
import com.Commandes.Boutique.services.DetailsCommandeService;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path = "/api/detailcommande")
public class DetailCommandeController {

	@Autowired
	DetailsCommandeService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<DetailCommande> saveDetailCommande(@RequestBody DetailCommande detailsCommandes) {
		ResponseEntity<DetailCommande> savedDetailsCommande = service.saveDetailCommande(detailsCommandes);
		return savedDetailsCommande;
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<DetailCommande>> getDetailCommandes(){
		ResponseEntity<List<DetailCommande>> DetailsCommande = service.getDetailCommandes();
		return DetailsCommande;
	}
	
	@RequestMapping(path = "/{thisid}", method = RequestMethod.GET)
	public ResponseEntity<Optional<DetailCommande>> getDetailCommandeWithId(@PathVariable("thisid") long id){
		ResponseEntity<Optional<DetailCommande>> DetailsCommande = service.getDetailCommandeWithId(id);
		return DetailsCommande;
	}

	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
	public void removeDetailCommandeWithId(@PathVariable("thisid") Long id) {
		service.removeDetailCommandeWithId(id);
	}
}
