package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.Client;
import com.Commandes.Boutique.repositories.ClientRepository;

import projections.ClientProjectionNameAndVorname;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;

	public ResponseEntity<Client> saveClient(Client client) {
		Client savedClient = repository.save(client);
		return new ResponseEntity<>(savedClient, HttpStatus.OK);
	}

	public Client saveClientNormal(Client client) {
		Client savedClient = repository.save(client);
		return savedClient;
	}
	
	public ResponseEntity<List<Client>> getClients(){
		List <Client> clients = repository.findAll();
		return clients != null 
				? new ResponseEntity<>(clients, HttpStatus.OK) 
						: new  ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
	}

	public List<Client> getClientsNormal(){
		List <Client> clients = repository.findAll();
		return clients;
	}
	
	public ResponseEntity<Optional<Client>> getClientsWithId(long id){
		Optional<Client> client = repository.findById(id);
		return client != null 
				? new ResponseEntity<>(client, HttpStatus.OK) 
						: new ResponseEntity<Optional<Client>>(HttpStatus.NO_CONTENT);
	}

	public Optional<Client> deleteClientWithId(Long id) {
		Optional<Client> client = repository.findById(id);
		repository.deleteById(id);
		return client;
	}
	
	public List<Client> getClientsWithName(String name){
		List<Client> clientsWithName = repository.getAllClientMitName(name);
		return clientsWithName;
	}
	
	public List<ClientProjectionNameAndVorname> getAllClientNameAndFirstname(){
		List<ClientProjectionNameAndVorname> ListClientVornameUndName = repository.getAllPersonNameAndFirstName();
		return ListClientVornameUndName;
	}

	public Optional<Client> updateClient(Client client , Long id){
		Optional<Client> clientTemp = repository.findById(id);

		if(clientTemp.isPresent()){
			clientTemp.get().setNom(client.getNom());
			clientTemp.get().setEmail(client.getEmail());
			clientTemp.get().setNumero(client.getNumero());
			clientTemp.get().setPays(client.getPays());
			clientTemp.get().setVille(client.getVille());
			clientTemp.get().setPostCode(client.getPostCode());
			clientTemp.get().setRue(client.getRue());
			clientTemp.get().setPrenom(client.getPrenom());
			clientTemp.get().setPhone(client.getPhone());
			repository.save(clientTemp.get());

			return clientTemp;

		}
		return Optional.empty();
	}

	public List<String> getAllClientFromStadt(String ville){
		return repository.findAll().stream()
				   .filter(client -> client.getVille().equals(ville))
				   .map(Client::getNom)
				   .collect(Collectors.toList());
	}
}
