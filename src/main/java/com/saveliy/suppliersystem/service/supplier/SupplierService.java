package com.saveliy.suppliersystem.service.supplier;

import com.saveliy.suppliersystem.dto.supplier.CreateSupplierDTO;
import com.saveliy.suppliersystem.dto.supplier.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO addSupplier(CreateSupplierDTO supplierDTO);
    List<SupplierDTO> getAllSuppliers();
}
