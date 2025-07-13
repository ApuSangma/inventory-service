package com.InventoryManagement.controller;
// Rest API CRUD

import com.InventoryManagement.model.entity.ProductBE;
import com.InventoryManagement.model.request.ProductRequest;
import com.InventoryManagement.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory") // common end-point
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProductBE> addProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductBE productBE = iProductService.addProduct(productRequest);
        return new ResponseEntity<>(productBE, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<ProductBE>> getAllProduct() {
        List<ProductBE> allProduct = iProductService.getAllProduct();
        return new ResponseEntity<>(allProduct, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductBE> getProductById(@PathVariable String id) {
        ProductBE productById = iProductService.getProductById(id);
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductBE> updateProduct(@PathVariable String id,
                                                   @Valid @RequestBody ProductRequest productRequest) {
        ProductBE productBE = iProductService.updateProduct(id, productRequest);
        return new ResponseEntity<>(productBE, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        iProductService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
