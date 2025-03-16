package com.saveliy.suppliersystem.service.product;

import com.saveliy.suppliersystem.dto.product.CreateProductDTO;
import com.saveliy.suppliersystem.dto.product.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> findAllProducts();
    public ProductDTO addProduct(CreateProductDTO product);
}
