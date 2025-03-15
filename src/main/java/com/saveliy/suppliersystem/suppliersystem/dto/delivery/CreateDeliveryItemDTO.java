package com.saveliy.suppliersystem.suppliersystem.dto.delivery;

import jakarta.validation.constraints.Positive;

public record CreateDeliveryItemDTO(
        @Positive(message = "Id should be > 0") int productId,
        @Positive(message = "Weight should be > 0") double weight
) {
}
