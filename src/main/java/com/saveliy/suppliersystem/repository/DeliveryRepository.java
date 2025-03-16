package com.saveliy.suppliersystem.repository;

import com.saveliy.suppliersystem.entity.Delivery;
import com.saveliy.suppliersystem.entity.dto.SupplierProductSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    @Query("SELECT NEW com.saveliy.suppliersystem.suppliersystem.entity.dto.SupplierProductSummary(" +
            "s.id, s.name, p.id, p.name, SUM(di.weight), SUM(di.weight * pr.price)) " +
            "FROM Delivery d " +
            "JOIN d.deliveryItems di " +
            "JOIN di.price pr " +
            "JOIN pr.product p " +
            "JOIN pr.supplier s " +
            "WHERE pr.startDate <= :endDate AND pr.endDate >= :startDate " +
            "GROUP BY s.id, s.name, p.id, p.name")
    List<SupplierProductSummary> getSupplierProductWeightsAndCosts(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
