package com.saveliy.suppliersystem.dto.price;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CreatePriceDTO(
        @Positive(message = "Price must be greater than zero")
        double price,
        @FutureOrPresent(message = "Start date must be today or in the future")
        LocalDate startDate,
        @Future(message = "End date must be in the future")
        LocalDate endDate,
        int supplierId,
        int productId) {
}
