package com.saveliy.suppliersystem.suppliersystem.dto.price;

import java.time.LocalDate;

public record PriceDTO(
        int id,
        double price,
        LocalDate startDate,
        LocalDate endDate,
        int supplierId,
        int productId) {
}
