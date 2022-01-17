package com.Commandes.Boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long>, JpaRepository<Produit, Long>{

}
