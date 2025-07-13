package com.InventoryManagement.repository;

import com.InventoryManagement.model.entity.SupplierBE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISupplierRepository extends MongoRepository<SupplierBE, String> {

    // MongoRepository provides CRUD methods.

    Optional<SupplierBE> findByName(String name);
}
