package com.saveliy.suppliersystem.suppliersystem.controller;

import com.saveliy.suppliersystem.suppliersystem.dto.price.CreatePriceDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.price.PriceDTO;
import com.saveliy.suppliersystem.suppliersystem.service.price.PriceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping
    public ResponseEntity<PriceDTO> createPrice(@Valid @RequestBody CreatePriceDTO priceDTO) {
        return ResponseEntity.ok(priceService.createPrice(priceDTO));
    }
}
