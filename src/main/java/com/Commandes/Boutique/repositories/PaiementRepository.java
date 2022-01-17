package com.Commandes.Boutique.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.Paiement;

import projections.PaiementProjection;

@Repository
public interface PaiementRepository extends CrudRepository<Paiement, Long>, JpaRepository<Paiement, Long>{
	
	@Query(value="select * from paiement" , nativeQuery = true)
	public List<PaiementProjection> getPaiementIdDateMontant();

}
