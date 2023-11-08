package com.redolf.kubernetes.controller;

import com.redolf.kubernetes.model.Product;
import com.redolf.kubernetes.requests.ProductRequest;
import com.redolf.kubernetes.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    @PostMapping("/create")
    private ResponseEntity<Product> savedProduct(@RequestBody @Valid ProductRequest productRequest) {
        return service.saveProduct(productRequest);
    }

    @GetMapping("/find/{productId}")
    private ResponseEntity<?> findProductById(@PathVariable(value = "productId", required = true) int productId) {
        return service.findProductById(productId);
    }

    @DeleteMapping("/delete/{productId}")
    private ResponseEntity<?> deleteProductById(@PathVariable(value = "productId", required = true) int productId) {
        return service.deleteProductById(productId);
    }

    @GetMapping("/list")
    private ResponseEntity<?> findAllProduct() {
        return service.findAllProducts();
    }
}
