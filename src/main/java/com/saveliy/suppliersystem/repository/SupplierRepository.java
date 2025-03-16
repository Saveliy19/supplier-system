package com.saveliy.suppliersystem.repository;

import com.saveliy.suppliersystem.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
