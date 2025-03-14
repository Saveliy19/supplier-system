package com.saveliy.suppliersystem.suppliersystem.repository;

import com.saveliy.suppliersystem.suppliersystem.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
