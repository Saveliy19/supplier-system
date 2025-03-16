package com.saveliy.suppliersystem.service.supplier;

import com.saveliy.suppliersystem.dto.supplier.CreateSupplierDTO;
import com.saveliy.suppliersystem.dto.supplier.SupplierDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class SupplierServiceImplementationTest {

    @Autowired
    private SupplierService supplierService;

    @Test
    void addSupplier() {
        List<SupplierDTO> suppliersBefore = supplierService.getAllSuppliers();
        SupplierDTO newSupplier = supplierService.addSupplier(new CreateSupplierDTO("New Supplier"));
        List<SupplierDTO> suppliersAfter = supplierService.getAllSuppliers();
        assertNotNull(newSupplier);
        assertEquals(newSupplier.name(), "New Supplier");
        assertEquals(suppliersBefore.size() + 1, suppliersAfter.size());
    }

    @Test
    void getAllSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllSuppliers();
        assertNotNull(suppliers);
        assertTrue(suppliers.size() >= 0);
    }
}