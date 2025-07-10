package com.InventoryManagement.model.request;

import jakarta.validation.constraints.*;

public class ProductRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 100)

    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 1000)

    private String description;

    @NotNull
    @Min(value = 0)
    @Digits(integer = 10, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)

    private Double price;

    @NotNull
    @Min(value = 0)
    @Digits(integer = 10, fraction = 0)

    private Integer stockQuantity;

    public ProductRequest() {
    }

    public ProductRequest(String name, String description, double price, Integer stockQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
