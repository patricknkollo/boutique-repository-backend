package com.Commandes.Boutique.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Commandes.Boutique.entities.Commandes;
import com.Commandes.Boutique.services.CommandesService;

import projections.CommandeProjection;
import projections.CommandeProjectionClientAndDate;

@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping(path = "/api/commandescontroller")
public class CommandesController {

	@Autowired
	CommandesService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Commandes> saveCommandes(@RequestBody Commandes commandes) {
		ResponseEntity<Commandes> savedCommande = service.saveCommandes(commandes);
		return savedCommande;
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Commandes>> getCommandes(){
		ResponseEntity<List<Commandes>> commandes = service.getCommandes();
		return commandes;
	}
	
	@RequestMapping(path = "/{thisid}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Commandes>> getCommandesWithId(@PathVariable("thisid") Long id){
		ResponseEntity<Optional<Commandes>> Commande = service.getCommandesWithId(id);
		return Commande;
	}

	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
	public void removeCommandesWithId(@PathVariable("thisid") Long id) {
		service.removeCommandesWithId(id);
	}
	
	@RequestMapping(path= "/client&Cmd" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<CommandeProjection>> getProjectionClientAndCmd() {
		List<CommandeProjection> res = service.getClientAndCmd();
		return  res != null
				? new ResponseEntity<List<CommandeProjection>>(res, HttpStatus.OK)
						: new ResponseEntity<List<CommandeProjection>>(res, HttpStatus.NO_CONTENT)
							;
	}
	@RequestMapping(path = "/commande/clients&date",method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<CommandeProjectionClientAndDate>> getCmdClientAndDateOfCommande(){
		return service.getCmdClientDate();
	}
}
