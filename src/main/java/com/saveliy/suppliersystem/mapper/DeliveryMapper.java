package com.saveliy.suppliersystem.mapper;

import com.saveliy.suppliersystem.dto.delivery.DeliveryDTO;
import com.saveliy.suppliersystem.dto.delivery.DeliveryItemDTO;
import com.saveliy.suppliersystem.entity.Delivery;
import com.saveliy.suppliersystem.entity.DeliveryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    DeliveryDTO DeliverytoDeliveryDTO(Delivery delivery);

    @Mapping(source = "price.price", target = "price")
    @Mapping(source = "price.product.id", target = "productId")
    DeliveryItemDTO DeliveryItemToDeliveryItemDTO(DeliveryItem deliveryItem);

    List<DeliveryItemDTO> toDeliveryItemDTOList(List<DeliveryItem> deliveryItems);
}
