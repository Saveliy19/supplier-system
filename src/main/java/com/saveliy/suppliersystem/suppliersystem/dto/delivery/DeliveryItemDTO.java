package com.saveliy.suppliersystem.suppliersystem.dto.delivery;

public record DeliveryItemDTO(
        int productId,
        double price,
        double weight
) {
}
