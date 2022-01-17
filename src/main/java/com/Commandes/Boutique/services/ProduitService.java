package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.Produit;
import com.Commandes.Boutique.repositories.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	ProduitRepository repository;
	
	public ResponseEntity<Produit> saveProduit(Produit produit) {
		Produit savedProduit = repository.save(produit);
		return new ResponseEntity<>(savedProduit, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Produit>> getProduits(){
		List <Produit> produits = repository.findAll();
		return produits != null 
				? new ResponseEntity<>(produits, HttpStatus.OK) 
						: new  ResponseEntity<List<Produit>>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Optional<Produit>> getProduitsWithId(long id){
		Optional<Produit> produit = repository.findById(id);
		return produit != null 
				? new ResponseEntity<>(produit, HttpStatus.OK) 
						: new ResponseEntity<Optional<Produit>>(HttpStatus.NO_CONTENT);
	}

	public void removeProduitWithId(Long id) {
		repository.deleteById(id);
	}
}
