package com.saveliy.suppliersystem.repository;

import com.saveliy.suppliersystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
