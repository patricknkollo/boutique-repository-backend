package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.DetailsProduits;
import com.Commandes.Boutique.repositories.DetailsProduitsRepository;

@Service
public class DetailsProduitService {

	@Autowired
	DetailsProduitsRepository repository;
	
	public ResponseEntity<DetailsProduits> saveDetailProduit(DetailsProduits detailProduit) {
		DetailsProduits savedDetailProduit = repository.save(detailProduit);
		return new ResponseEntity<>(savedDetailProduit, HttpStatus.OK);
	}
	
	public ResponseEntity<List<DetailsProduits>> getDetailProduit(){
		List <DetailsProduits> detailsProduits = repository.findAll();
		return detailsProduits != null 
				? new ResponseEntity<>(detailsProduits, HttpStatus.OK) 
						: new  ResponseEntity<List<DetailsProduits>>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Optional<DetailsProduits>> getDetailProduitWithId(long id){
		Optional<DetailsProduits> detailProduit = repository.findById(id);
		return detailProduit != null 
				? new ResponseEntity<>(detailProduit, HttpStatus.OK) 
						: new ResponseEntity<Optional<DetailsProduits>>(HttpStatus.NO_CONTENT);
	}

	public void removeDetailsProduitsWithId(Long id) {
		repository.deleteById(id);
	}
}
