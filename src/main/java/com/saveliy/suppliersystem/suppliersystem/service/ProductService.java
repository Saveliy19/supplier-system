package com.saveliy.suppliersystem.suppliersystem.service;

import com.saveliy.suppliersystem.suppliersystem.dto.CreateProductDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> findAllProducts();
    public ProductDTO addProduct(CreateProductDTO product);
}
