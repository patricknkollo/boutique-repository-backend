package com.Commandes.Boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.DetailCommande;

@Repository
public interface DetailCommandeRepository extends CrudRepository<DetailCommande, Long> , JpaRepository<DetailCommande, Long> {

}
