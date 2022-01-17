package com.Commandes.Boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.DetailsProduits;

@Repository
public interface DetailsProduitsRepository extends CrudRepository<DetailsProduits, Long>, JpaRepository<DetailsProduits,Long>{

}
