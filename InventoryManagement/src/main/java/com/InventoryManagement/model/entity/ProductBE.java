package com.InventoryManagement.model.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "product")
public class ProductBE {
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String price;
    @NotNull
    private Integer stockQuantity;

    public ProductBE() {
    }

    public ProductBE(String id, String name, String description, String price, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
