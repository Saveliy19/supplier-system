package com.saveliy.suppliersystem.suppliersystem.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProductDTO(
        @NotBlank(message = "Product name should be not blank")
        String name
) {
}
