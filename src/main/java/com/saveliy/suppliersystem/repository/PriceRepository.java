package com.saveliy.suppliersystem.repository;

import com.saveliy.suppliersystem.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    @Query("select p from Price p where p.product.id = :productId and p.supplier.id = :supplierId " +
    "AND ((p.startDate between :startDate and :endDate) or (p.endDate between :startDate and :endDate))")
    List<Price> findOverlappingPrices(int productId, int supplierId, LocalDate startDate, LocalDate endDate);

    @Query("SELECT p FROM Price p WHERE p.supplier.id = :supplierId " +
            "AND :date BETWEEN p.startDate AND p.endDate")
    List<Price> findAllBySupplierIdAndDateBetween(int supplierId, LocalDate date);


    @Query("SELECT p FROM Price p WHERE p.product.id = :productId " +
            "AND :date BETWEEN p.startDate AND p.endDate")
    List<Price> findAllByProductIdAndDateBetween(int productId, LocalDate date);

    @Query("SELECT p FROM Price p WHERE p.product.id = :productId AND p.supplier.id = :supplierId AND :date BETWEEN p.startDate AND p.endDate")
    Price findByProductIdAndSupplierIdAndDate(int productId, int supplierId, LocalDate date);



}

