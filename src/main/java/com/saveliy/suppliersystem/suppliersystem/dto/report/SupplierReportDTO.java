package com.saveliy.suppliersystem.suppliersystem.dto.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SupplierReportDTO {
    private int id;
    private String name;
    private double totalWeight;
    private double totalPrice;
    private List<ProductReportDTO> products;

}
