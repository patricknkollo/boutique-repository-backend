package com.Commandes.Boutique.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Commandes.Boutique.entities.DetailCommande;
import com.Commandes.Boutique.repositories.DetailCommandeRepository;

@Service
public class DetailsCommandeService {
	@Autowired
	DetailCommandeRepository repository;
	
	public ResponseEntity<DetailCommande> saveDetailCommande(DetailCommande detailsCommandes) {
		DetailCommande savedDetailsCommande = repository.save(detailsCommandes);
		return new ResponseEntity<>(savedDetailsCommande, HttpStatus.OK);
	}
	
	public ResponseEntity<List<DetailCommande>> getDetailCommandes(){
		List <DetailCommande> DetailsCommande = repository.findAll();
		return DetailsCommande != null 
				? new ResponseEntity<>(DetailsCommande, HttpStatus.OK) 
						: new  ResponseEntity<List<DetailCommande>>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Optional<DetailCommande>> getDetailCommandeWithId(long id){
		Optional<DetailCommande> DetailsCommande = repository.findById(id);
		return DetailsCommande != null 
				? new ResponseEntity<>(DetailsCommande, HttpStatus.OK) 
						: new ResponseEntity<Optional<DetailCommande>>(HttpStatus.NO_CONTENT);
	}

	public void removeDetailCommandeWithId(Long id) {
		repository.deleteById(id);
	}
}
