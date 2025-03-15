package com.saveliy.suppliersystem.suppliersystem.controller;

import com.saveliy.suppliersystem.suppliersystem.dto.delivery.CreateDeliveryDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.delivery.DeliveryDTO;
import com.saveliy.suppliersystem.suppliersystem.service.delivery.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public ResponseEntity<DeliveryDTO> createDelivery(@RequestBody CreateDeliveryDTO deliveryDTO) {
        deliveryService.validateProductsUnique(deliveryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.createDelivery(deliveryDTO));
    }
}
