package com.saveliy.suppliersystem.suppliersystem.repository;

import com.saveliy.suppliersystem.suppliersystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
