package com.saveliy.suppliersystem.suppliersystem.service;

import com.saveliy.suppliersystem.suppliersystem.dto.CreateSupplierDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO addSupplier(CreateSupplierDTO supplierDTO);
    List<SupplierDTO> getAllSuppliers();
}
