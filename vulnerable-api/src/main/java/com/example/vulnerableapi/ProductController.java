package com.example.vulnerableapi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //    API4:2023 Unrestricted Resource Consumption
    @GetMapping
    ResponseEntity<List<Product>> getProducts(@RequestParam Integer size) {
        if (size == null) {
            size = 10;
        }
        return ResponseEntity.ok(productRepository.getProductsByLimit(size));
    }
}
