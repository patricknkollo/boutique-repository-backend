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

import com.Commandes.Boutique.entities.ModeReglement;
import com.Commandes.Boutique.services.ModeReglementService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path="/api/ModeReglementController")
public class ModeReglementController {

	@Autowired
	ModeReglementService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<ModeReglement> saveModeReglement(@RequestBody ModeReglement modeReglement) {
		ResponseEntity<ModeReglement> savedModeReglement = service.saveModeReglement(modeReglement);
		return savedModeReglement;
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<ModeReglement>> getModeReglement(){
		ResponseEntity<List<ModeReglement>> modeReglements = service.getModeReglement();
		return modeReglements;
	}
	
	@RequestMapping(path = "/{thisid}", method = RequestMethod.GET)
	public ResponseEntity<Optional<ModeReglement>> getModeReglementWithId(@PathVariable("thisid") long id){
		ResponseEntity<Optional<ModeReglement>> modeOptional = service.getModeReglementWithId(id);
		return modeOptional;
	}

	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
	public void removeModeReglementWithId(@PathVariable("thisid") Long id) {
		service.removeModeReglementWithId(id);
	}
}
