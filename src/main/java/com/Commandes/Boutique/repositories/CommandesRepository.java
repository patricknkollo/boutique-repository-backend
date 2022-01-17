package com.Commandes.Boutique.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.Commandes;

import projections.CommandeProjection;
import projections.CommandeProjectionClientAndDate;

import javax.transaction.Transactional;

@Repository
public interface CommandesRepository extends CrudRepository<Commandes, Long>, JpaRepository<Commandes, Long> {

	@Query(value = "SELECT * FROM commandes" , nativeQuery = true)
	@Transactional
	List<CommandeProjection> getCommandAndClientIdsFromDB();

	@Query(value = "SELECT * FROM commandes" , nativeQuery = true)
	@Transactional
	public List<CommandeProjectionClientAndDate> getAllCmdWithClientAndDate();
}
