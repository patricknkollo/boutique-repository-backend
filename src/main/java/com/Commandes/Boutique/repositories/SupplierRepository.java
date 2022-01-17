package com.Commandes.Boutique.repositories;

import com.Commandes.Boutique.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long>, JpaRepository<Supplier, Long> {
}
