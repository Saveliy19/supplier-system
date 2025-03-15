package com.saveliy.suppliersystem.suppliersystem.controller;

import com.saveliy.suppliersystem.suppliersystem.dto.product.CreateProductDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.product.ProductDTO;
import com.saveliy.suppliersystem.suppliersystem.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody CreateProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDTO));
    }
}
