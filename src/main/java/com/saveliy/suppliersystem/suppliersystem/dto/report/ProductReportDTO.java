package com.saveliy.suppliersystem.suppliersystem.dto.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductReportDTO {
    private int id;
    private String name;
    private double weight;
    private double price;

}
