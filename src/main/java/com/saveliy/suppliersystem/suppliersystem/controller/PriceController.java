package com.saveliy.suppliersystem.suppliersystem.controller;

import com.saveliy.suppliersystem.suppliersystem.dto.price.CreatePriceDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.price.PriceDTO;
import com.saveliy.suppliersystem.suppliersystem.service.price.PriceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/suppliers/{supplierId}")
    public ResponseEntity<List<PriceDTO>> getSupplierPricesByDate(
            @PathVariable int supplierId,
            @RequestParam LocalDate date) {
        return ResponseEntity.ok(priceService.getSupplierPricesByDate(supplierId, date));
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<List<PriceDTO>> getProductPricesByDate(
            @PathVariable int productId,
            @RequestParam LocalDate date
    ) {
      return ResponseEntity.ok(priceService.getProductPricesByDate(productId, date));
    }
}
