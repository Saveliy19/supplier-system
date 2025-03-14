package com.saveliy.suppliersystem.suppliersystem.dto;
import jakarta.validation.constraints.NotBlank;

public record CreateSupplierDTO(
        @NotBlank(message = "name should be not blank")
        String name) {
}
