package com.saveliy.suppliersystem.suppliersystem.dto.report;

import com.saveliy.suppliersystem.suppliersystem.dto.supplier.SupplierDTO;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReportDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<SupplierReportDTO> suppliers;


}
