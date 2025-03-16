package com.saveliy.suppliersystem.controller;

import com.saveliy.suppliersystem.dto.supplier.CreateSupplierDTO;
import com.saveliy.suppliersystem.dto.supplier.SupplierDTO;
import com.saveliy.suppliersystem.service.supplier.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody CreateSupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.addSupplier(supplierDTO));
    }
}
