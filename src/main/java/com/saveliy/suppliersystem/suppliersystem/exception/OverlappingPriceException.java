package com.saveliy.suppliersystem.suppliersystem.exception;

import com.saveliy.suppliersystem.suppliersystem.dto.price.PriceDTO;

import java.util.List;

public class OverlappingPriceException extends RuntimeException {
    private final List<PriceDTO> overlappingPrices;

    public OverlappingPriceException(List<PriceDTO> overlappingPrices) {
        super("Price period overlaps with existing prices.");
        this.overlappingPrices = overlappingPrices;
    }

    public List<PriceDTO> getOverlappingPrices() {
        return overlappingPrices;
    }
}
