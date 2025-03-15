package com.saveliy.suppliersystem.suppliersystem.mapper;

import com.saveliy.suppliersystem.suppliersystem.dto.price.CreatePriceDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.price.PriceDTO;
import com.saveliy.suppliersystem.suppliersystem.entity.Price;
import com.saveliy.suppliersystem.suppliersystem.entity.Product;
import com.saveliy.suppliersystem.suppliersystem.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(target = "supplier", source = "supplierId")
    @Mapping(target = "product", source = "productId")
    Price CreatePriceDTOtoPrice(CreatePriceDTO priceDTO);

    @Mapping(target = "supplierId", source = "supplier.id")
    @Mapping(target = "productId", source = "product.id")
    PriceDTO PriceToPriceDTO(Price price);

    List<PriceDTO> PriceListToPriceDTOList(List<Price> prices);

    default Supplier mapSupplier(int supplierId) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierId);
        return supplier;
    }

    default Product mapProduct(int productId) {
        Product product = new Product();
        product.setId(productId);
        return product;
    }
}
