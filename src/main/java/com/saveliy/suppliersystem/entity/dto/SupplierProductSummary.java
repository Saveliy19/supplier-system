package com.saveliy.suppliersystem.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SupplierProductSummary {
    private Integer supplierId;
    private String supplierName;
    private Integer productId;
    private String productName;
    private Double totalWeight;
    private Double totalCost;

    public SupplierProductSummary(
            Integer supplierId,
            String supplierName,
            Integer productId,
            String productName,
            Double totalWeight,
            Double totalCost) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productId = productId;
        this.productName = productName;
        this.totalWeight = totalWeight;
        this.totalCost = totalCost;
    }
}
