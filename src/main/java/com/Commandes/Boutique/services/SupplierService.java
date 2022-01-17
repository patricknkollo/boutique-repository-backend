package com.Commandes.Boutique.services;

import com.Commandes.Boutique.entities.Supplier;
import com.Commandes.Boutique.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

  @Autowired
  SupplierRepository repository;

  public Supplier saveSupplier(Supplier supplier){
    Supplier result = repository.save(supplier);
    return  result;
  }

  public List<Supplier> getAllSupplier(){
    List<Supplier> suppliers = repository.findAll();
    return suppliers;
  }

  public Optional<Supplier> getSpecificSupplier(Long id){
    Optional<Supplier> optSupplier = repository.findById(id);
    return optSupplier;
  }

  public Optional<Supplier> deleteSupplier(Long id){
    Optional<Supplier> optSupplier = repository.findById(id);
    repository.deleteById(id);
    return optSupplier;
  }
}
