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

import com.Commandes.Boutique.entities.Client;
import com.Commandes.Boutique.services.ClientService;

import projections.ClientProjectionNameAndVorname;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path = "/api/clientdata")
public class ClientController {

	@Autowired
	ClientService service;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Client> saveClient(@RequestBody Client client) {
		ResponseEntity<Client> savedClient = service.saveClient(client);
		return savedClient;
	}

	@RequestMapping(path = "/save/normal", method = RequestMethod.POST)
	public Client saveClientNormal(@RequestBody Client client) {
		Client savedClient = service.saveClientNormal(client);
		return savedClient;
	}
	
	@RequestMapping(path = "/allclients", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClients(){
		ResponseEntity<List <Client>> clients = service.getClients();
		return clients;
	}

	@RequestMapping(path = "/allclients/normal", method = RequestMethod.GET)
	public @ResponseBody List<Client> getClientsNormal(){
		List <Client> clients = service.getClientsNormal();
		return clients;
	}

	@RequestMapping(path = "/client/id/{clientid}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Optional<Client>> getClientsWithId(@PathVariable("clientid") Long id){
		ResponseEntity<Optional<Client>> client = service.getClientsWithId(id);
		return client;
	}
	@RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
	public ResponseEntity<Optional<Client>> removeClientWithId(@PathVariable("thisid") Long id) {
		Optional<Client> respClient = service.deleteClientWithId(id);
		ResponseEntity<Optional<Client>> responseEntity = new ResponseEntity<>(respClient, HttpStatus.OK);
		return  responseEntity;
	}
	
	@RequestMapping(path = "/client/name/{thisname}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Client>> getClientsWithName(@PathVariable("thisname") String name){
		List<Client> clientsWithName = service.getClientsWithName(name);
		return new ResponseEntity<>(clientsWithName, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/client/nom&prenom" , method = RequestMethod.GET )
	public @ResponseBody ResponseEntity<List<ClientProjectionNameAndVorname>> getNameAndFirstnameClient() {
		List<ClientProjectionNameAndVorname> res = service.getAllClientNameAndFirstname();
		return new ResponseEntity<List<ClientProjectionNameAndVorname>>(res, HttpStatus.OK);
	}
}
