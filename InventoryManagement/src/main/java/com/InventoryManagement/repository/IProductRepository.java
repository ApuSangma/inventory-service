package com.InventoryManagement.repository;

import com.InventoryManagement.model.entity.ProductBE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<ProductBE, String> {
}
