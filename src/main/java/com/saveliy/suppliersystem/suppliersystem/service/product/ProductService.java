package com.saveliy.suppliersystem.suppliersystem.service.product;

import com.saveliy.suppliersystem.suppliersystem.dto.product.CreateProductDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.product.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> findAllProducts();
    public ProductDTO addProduct(CreateProductDTO product);
}
