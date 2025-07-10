package com.InventoryManagement.repository;

import com.InventoryManagement.model.entity.UserBE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<UserBE, String> {
}
