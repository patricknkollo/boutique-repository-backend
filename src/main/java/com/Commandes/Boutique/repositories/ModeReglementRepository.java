package com.Commandes.Boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.ModeReglement;

@Repository
public interface ModeReglementRepository extends CrudRepository<ModeReglement, Long>, JpaRepository<ModeReglement, Long>{

}
