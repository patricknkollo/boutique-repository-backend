package com.Commandes.Boutique.controllers;

import com.Commandes.Boutique.entities.Supplier;
import com.Commandes.Boutique.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path = "/api/controler/supplier")
public class SupplierController {

  @Autowired
  SupplierService service;

  @RequestMapping(path = "/save", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<Supplier> saveSupplierInController(@RequestBody Supplier supplier){
    Supplier savedSupplier = service.saveSupplier(supplier);
    ResponseEntity<Supplier> responseEntity = new ResponseEntity<>(savedSupplier, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(path = "/all/suppliers", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<Supplier>> getAllSupplierController(){
    List<Supplier> suppliers = service.getAllSupplier();
    ResponseEntity<List<Supplier>> responseEntity = new ResponseEntity<>(suppliers, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(path ="/supplier/{thisid}", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<Optional<Supplier>> getSupplierByIdInController(@PathVariable("thisid") Long id){
    Optional<Supplier> supplier = service.getSpecificSupplier(id);
    ResponseEntity<Optional<Supplier>> responseEntity = new ResponseEntity<>(supplier, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(path ="/delete/supplier/{thisid}",  method = RequestMethod.DELETE)
  public Optional<Supplier> deleteSupplierWithIdController(@PathVariable Long id){
    Optional<Supplier> deletedSupplier = service.deleteSupplier(id);
    return  deletedSupplier;
  }

  @RequestMapping(path ="/update/supplier/{thisid}",  method = RequestMethod.PUT)
  public Optional<Supplier> updateSupplierWithIdController(@PathVariable Long id, @RequestBody Supplier supplier){
    Optional<Supplier> deletedSupplier = service.deleteSupplier(id);
    return  deletedSupplier;
  }
}
