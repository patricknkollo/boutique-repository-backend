package com.Commandes.Boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.Famille;

@Repository
public interface FamilleRepository extends CrudRepository<Famille, Long>, JpaRepository<Famille, Long>{

}
