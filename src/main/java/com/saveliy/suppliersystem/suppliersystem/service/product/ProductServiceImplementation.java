package com.saveliy.suppliersystem.suppliersystem.service.product;

import com.saveliy.suppliersystem.suppliersystem.dto.product.CreateProductDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.product.ProductDTO;
import com.saveliy.suppliersystem.suppliersystem.mapper.ProductMapper;
import com.saveliy.suppliersystem.suppliersystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    @Transactional
    public List<ProductDTO> findAllProducts() {
        return ProductMapper.INSTANCE.ProductListToProductDTOList(
                productRepository.findAll()
        );
    }

    @Override
    @Transactional
    public ProductDTO addProduct(CreateProductDTO product) {
        return ProductMapper.INSTANCE.ProductToProductDTO(
                productRepository.saveAndFlush(
                        ProductMapper.INSTANCE.CreateProductDTOtoProduct(product)
                )
        );
    }
}
