package com.Commandes.Boutique.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Commandes.Boutique.entities.Client;

import projections.ClientProjectionNameAndVorname;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>, JpaRepository<Client, Long> {
	
	
	//   Model standard de requete en projection
	/*
	 * @Query(
	 * select p 
	 * from Person p 
	 * where p.forename = :forename and p.surname = :surname)
User findByForenameAndSurname(@Param("surname") String lastname,@Param("forename") String firstname);
*/
	
	
	
	@Query(value = "SELECT * "
			+ "FROM Client "
			+ "WHERE nom like '%:name%'", nativeQuery = true)
	@Transactional
	public List<Client> getAllClientMitName(@Param("name") String name);
	
	@Query(value = "SELECT * "
			+ "FROM Client "
			+ "WHERE nom like '%:name%'", nativeQuery = true)
	@Transactional
	public List<Client> getAllClientMitVorame(@Param("name") String vorname);
	
	
	@Query(value = "SELECT * FROM client", nativeQuery = true)
	@Transactional
	public List<ClientProjectionNameAndVorname> getAllPersonNameAndFirstName();

}
