package com.InventoryManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
@Data// lombok: Generates getters, setters, toString etc.
@NoArgsConstructor // lombok: generates a no-argument constructor
@AllArgsConstructor // lombok : generate a constructor with all arguments
public class SupplierBE {

    @Id
    private String id; // mongoDB use Strings for IDs by default
    @Indexed(unique = true) // creates a uniques index on the name.
    private String name;
    private String contactPerson;
    private String email;
    private String phone;
    private String address;
}

