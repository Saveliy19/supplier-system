package com.saveliy.suppliersystem.dto.delivery;

public record DeliveryItemDTO(
        int productId,
        double price,
        double weight
) {
}
