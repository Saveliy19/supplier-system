package com.saveliy.suppliersystem.dto.delivery;

import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateDeliveryDTO(
        @Positive(message = "Id should be > 0")
        int supplierId,
        List<CreateDeliveryItemDTO> deliveryItems
) {
}
