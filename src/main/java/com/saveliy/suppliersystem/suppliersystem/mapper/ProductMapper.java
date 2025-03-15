package com.saveliy.suppliersystem.suppliersystem.mapper;

import com.saveliy.suppliersystem.suppliersystem.dto.CreateProductDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.ProductDTO;
import com.saveliy.suppliersystem.suppliersystem.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product CreateProductDTOtoProduct(CreateProductDTO productDTO);
    ProductDTO ProductToProductDTO(Product product);
    List<ProductDTO> ProductListToProductDTOList(List<Product> productList);
}
