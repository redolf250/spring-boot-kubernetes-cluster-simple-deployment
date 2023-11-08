package com.redolf.kubernetes.service;

import com.redolf.kubernetes.model.Product;
import com.redolf.kubernetes.repository.ProductRepository;
import com.redolf.kubernetes.requests.ProductRequest;
import com.redolf.kubernetes.response.Message;
import com.redolf.kubernetes.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public ResponseEntity<Product> saveProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .productPrice(productRequest.getProductPrice())
                .build();
        repository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    public ResponseEntity<?> findProductById(int productId) {
        Optional<Product> product = repository.findById(productId);
        if(product.isPresent()) {
            ProductResponse productResponse = ProductResponse.builder()
                    .productId(product.get().getProductId())
                    .productName(product.get().getProductName())
                    .productDescription(product.get().getProductDescription())
                    .productPrice(product.get().getProductPrice())
                    .build();
            return new ResponseEntity<>(productResponse,HttpStatus.FOUND);
        }else {
            Message message = Message.builder()
                    .productId(productId)
                    .statusCode(( HttpStatus.NOT_FOUND).value())
                    .dateStamp(new Date())
                    .body("Oops! product not found")
                    .build();
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<?> deleteProductById(int productId) {
        Optional<Product> product = repository.findById(productId);
        if(product.isPresent()) {
            repository.deleteById(product.get().getProductId());
            Message message = Message.builder()
                    .productId(productId)
                    .statusCode((HttpStatus.FOUND).value())
                    .dateStamp(new Date())
                    .body("Product removed from storage")
                    .build();
            return new ResponseEntity<>(message,HttpStatus.FOUND);
        }else {
            Message message = Message.builder()
                    .productId(productId)
                    .statusCode((HttpStatus.NOT_FOUND).value())
                    .dateStamp(new Date())
                    .body("Oops! product not found")
                    .build();
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> findAllProducts() {
        List<Product> products =repository.findAll();
        if(products.size()>0){
            List<ProductResponse> responses=products.stream()
                    .map(this::mapProductToProductResponse)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(responses,HttpStatus.OK);
        }else {
            Message message = Message.builder()
                    .statusCode((HttpStatus.NOT_FOUND).value())
                    .dateStamp(new Date())
                    .body("Oops! no products found")
                    .build();
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }
    private ProductResponse mapProductToProductResponse(Product product){
        ProductResponse response = ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .build();
        return response;
    }
}
